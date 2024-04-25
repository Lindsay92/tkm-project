package co.simplon.tkm.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like extends AbstractEntity {
	
	@ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

	public Like() {
		// Required no-arg constructor
	}

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
	public int hashCode() {
		return Objects.hash(account, activity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Like)) {
			return false;
		}
		Like other = (Like) obj;
		return Objects.equals(account, other.account) 
				&& Objects.equals(activity, other.activity);
	}

	@Override
	public String toString() {
		return "Like [account=" + account + ", activity=" + activity + "]";
	}    
    
}
