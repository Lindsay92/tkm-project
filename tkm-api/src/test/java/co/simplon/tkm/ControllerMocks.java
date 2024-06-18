package co.simplon.tkm;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import co.simplon.tkm.controllers.AccountController;
import co.simplon.tkm.controllers.ActivityController;
import co.simplon.tkm.controllers.LikeController;

@TestConfiguration
class ControllerMocks {

    @Bean
    AccountController accountController() {
    	return Mockito.mock(AccountController.class);
    }

    @Bean
    ActivityController activityController() {
    	return Mockito.mock(ActivityController.class);
    }
    
    @Bean
    LikeController likeController() {
    	return Mockito.mock(LikeController.class);
    }
}