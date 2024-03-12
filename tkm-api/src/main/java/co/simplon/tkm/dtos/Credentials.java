package co.simplon.tkm.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Credentials {
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z-éàâèêôûîç'’ ]+$")
	private String firstName;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z-éàâèêôûîç'’ ]+$")
	private String lastName;
	
	@NotBlank
	@Email
	@Pattern(regexp = "[a-zA-Z0-9-_]{1,}@[a-zA-Z0-9-_]{1,}.[a-zA-Z]{1,}")
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@||%||!||*])(?!.* ).{8,42}")
    private String password;

    public Credentials() {
		super();
	}
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


//    public List<String> getRoles() {
//	return roles;
//    }
//
//    public void setRoles(List<String> roles) {
//	this.roles = roles;
//    }

	@Override
	public String toString() {
		return "Credentials [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password={protected}"
				+ "]";
	}

}
