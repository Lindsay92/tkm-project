package co.simplon.tkm.dtos;

public class Credentials {
	
	private String firstName;
	private String lastName;
	private String email;
    private String password;
//  private List<String> roles;

    public Credentials() {
		super();
		// TODO Auto-generated constructor stub
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
