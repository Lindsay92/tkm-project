package co.simplon.tkm.entities;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(codeRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		return Objects.equals(codeRole, other.codeRole);
	}

	@Override
	public String toString() {
		return "Role [codeRole=" + codeRole + ", roleName=" + roleName + "]";
	}
	
}
