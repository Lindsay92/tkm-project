package co.simplon.tkm.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


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
	
	//one role to many users
	//many users to one role
	@JoinColumn(name = "role_id")
	@ManyToOne
	private Role role;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name ="likes",
//	joinColumns = @JoinColumn(name = "account_id"),
//	inverseJoinColumns = @JoinColumn(name = "activity_id"))
	@ManyToMany(mappedBy = "likedByAccount")
	private Set<Activity> favoriteActivities = new HashSet<>();
	//association à la cle primaire d'activity

    public Account() {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public Set<Activity> getFavoriteActivities() {
		return favoriteActivities;
	}

	public void setFavoriteActivities(Set<Activity> favoriteActivities) {
		this.favoriteActivities = favoriteActivities;
	}

	@Override
	public String toString() {
		return "Account [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", role=" + role + "]";
	}

}
