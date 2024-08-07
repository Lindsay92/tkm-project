package co.simplon.tkm.configurations;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.auth0.jwt.algorithms.Algorithm;

import co.simplon.tkm.utils.AccountHelper;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
	
		@Value("${tkm.cors.enabled}")
		private boolean corsEnabled;
		
	 	@Value("${tkm.auth.rounds}")
	    private int rounds;
	 	
	    @Value("${tkm.auth.issuer}")
	    private String issuer;
	    
	    @Value("${tkm.auth.secret}")
	    private String secret;
	    
	    @Value("${tkm.auth.tokenExpiration}")
	    private long tokenExpiration;

	    @Bean
	    AccountHelper authHelper() {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		PasswordEncoder encoder = new BCryptPasswordEncoder(
			rounds);

		return new AccountHelper.Builder().algorithm(algorithm)
			.passwordEncoder(encoder).issuer(issuer)
			.expiration(tokenExpiration).build();
	    }
	    
	    @Bean
	    SecurityFilterChain securityFilterChain(
		    HttpSecurity http) throws Exception {
	    	http.cors(corsCutomizer())
	        .csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorize -> authorize
			.requestMatchers(
				"/sign-in", 
				"/sign-up",
				"/",
				"/activities",
				"/activities/{id}/detail")
			.permitAll()
			.requestMatchers(
				"/user/all/favorite",
				"/delete/{activityId}"
				) 
			.hasAuthority("ROLE_USER")
			.requestMatchers(
				"/{id}/for-update",
				"/for-edit",
				"/{id}/for-delete",
				"/{id}/for-change"
				)
			.hasAuthority("ROLE_ADMIN").anyRequest()
			.authenticated())
	        .oauth2ResourceServer((
	                oauth2ResourceServer) -> oauth2ResourceServer
	                    .jwt(Customizer
	                        .withDefaults()));
		return http.build();
	    }
	    
	    private Customizer<CorsConfigurer<HttpSecurity>> corsCutomizer() {
	    	return corsEnabled ? Customizer.withDefaults()
	    			: cors -> cors.disable();
	    }

	    @Bean
	    JwtAuthenticationConverter authenticationConverter() {
		JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
		authoritiesConverter.setAuthoritiesClaimName("role");
		JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
		authenticationConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
		
		return authenticationConverter;
	    }

	    @Bean
	    JwtDecoder jwtDecoder() throws Exception {
		SecretKeySpec key = new SecretKeySpec(
			secret.getBytes(), "HmacSHA256");
		return NimbusJwtDecoder.withSecretKey(key).build();
	    }
	    
}
