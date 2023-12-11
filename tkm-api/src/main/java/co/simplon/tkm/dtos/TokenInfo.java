package co.simplon.tkm.dtos;

public class TokenInfo {
	
	private String token;
	private String role;
	private String firstName;
	
    public TokenInfo() {
    	super();
    }

    public String getToken() {
    	return token;
    }

    public void setToken(String token) {
    	this.token = token;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "TokenInfo [token=" + token + ", role=" + role + ", firstName=" + firstName + "]";
	}
}
