package co.simplon.tkm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.tkm.dtos.AccountView;
import co.simplon.tkm.entities.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{
	
	AccountView getByEmail(String email); 
	//id or email unique
	//change from Account to AcountView
	
	Boolean existsByEmailIgnoreCase(String string);

}
