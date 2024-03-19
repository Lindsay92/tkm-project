package co.simplon.tkm.services;

import org.springframework.stereotype.Service;

import co.simplon.tkm.entities.Account;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.entities.Like;
import co.simplon.tkm.repositories.AccountRepository;
import co.simplon.tkm.repositories.ActivityRepository;
import co.simplon.tkm.repositories.LikeRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService {

	private final LikeRepository likeRepository;
	private final AccountRepository accountRepository;
	private final ActivityRepository activities;
	
	public LikeServiceImpl(LikeRepository likeRepository, AccountRepository accountRepository,
			ActivityRepository activities) {
		this.likeRepository = likeRepository;
		this.accountRepository = accountRepository;
		this.activities = activities;
	}
	
	@Override
	@Transactional
	public void like(Long activityId, Long accountId) {
	    Activity activity = activities.getReferenceById(activityId);
	    Account account = accountRepository.getReferenceById(accountId);

	    Like like = new Like();
	    like.setAccount(account);
	    like.setActivity(activity);

	    likeRepository.save(like);
	}

}
