package co.simplon.tkm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplon.tkm.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role getReferenceByCodeRole(String name);

}
