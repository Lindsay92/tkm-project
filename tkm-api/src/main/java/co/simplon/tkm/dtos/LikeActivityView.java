package co.simplon.tkm.dtos;

import co.simplon.tkm.entities.Account;
import co.simplon.tkm.entities.Activity;

public interface LikeActivityView {
	
	Activity getActivity();
	
	Account getAccount();

}
