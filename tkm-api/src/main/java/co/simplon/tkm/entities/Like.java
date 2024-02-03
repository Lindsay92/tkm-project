package co.simplon.tkm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like extends AbstractEntity {
	
	@JoinColumn(name = "account_id")
	@ManyToMany
	private Account account;
	
	@Column(name = "activity_id")
	@ManyToMany
	private Activity activity;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Like [account=" + account + ", activity=" + activity + "]";
	}
	

}
