package co.simplon.tkm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends AbstractEntity {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
    private String password;
//    private List<String> roles;

    public Account() {
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
		return "Accounts [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password={protected}"
				+ "]";
	}

}