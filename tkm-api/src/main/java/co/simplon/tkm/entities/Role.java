package co.simplon.tkm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "roles")
public class Role extends AbstractEntity {
	
	@Column(name = "code_role")
	private String codeRole;
	
	@Column(name = "role_name")
	private String roleName;

	public Role() {
		super();
	}

	public String getCodeRole() {
		return codeRole;
	}

	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [codeRole=" + codeRole + ", roleName=" + roleName + "]";
	}
	
}
