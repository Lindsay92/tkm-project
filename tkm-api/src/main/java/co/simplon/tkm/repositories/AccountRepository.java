package co.simplon.tkm.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.tkm.dtos.AccountAdminView;
import co.simplon.tkm.entities.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{
	
	AccountAdminView getByEmail(String email); 
	//id or email unique
	//change from Account to AcountView
	
	Boolean existsByEmailIgnoreCase(String string);

	Collection<AccountAdminView> findAllAccountsBy();
	
}
