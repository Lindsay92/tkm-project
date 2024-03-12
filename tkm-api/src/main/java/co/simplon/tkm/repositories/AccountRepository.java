package co.simplon.tkm.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.tkm.entities.Account;
import co.simplon.tkm.entities.Activity;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account getByEmail(String email); //id or email unique

	Boolean existsByEmailIgnoreCase(String string);

	//Set<Activity> findAllFavoriteBy();
	Set<Account> findAccountsByFavoriteActivities_Id(Long activity_id);

}
