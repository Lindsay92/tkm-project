package co.simplon.tkm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.tkm.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account getByEmail(String email); //id or email unique

}
