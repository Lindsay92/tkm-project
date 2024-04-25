package co.simplon.tkm.services;

import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.tkm.dtos.LikeView;
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
	private final ActivityRepository activityRepository;
	
	public LikeServiceImpl(LikeRepository likeRepository, AccountRepository accountRepository,
			ActivityRepository activityRepository) {
		this.likeRepository = likeRepository;
		this.accountRepository = accountRepository;
		this.activityRepository = activityRepository;
	}
	
	@Override
	@Transactional
	public void like(Long activityId, Long accountId) {
	    Activity activity = activityRepository.getReferenceById(activityId);
	    Account account = accountRepository.getReferenceById(accountId);

	    Like like = new Like();
	    like.setAccount(account);
	    like.setActivity(activity);

	    likeRepository.save(like);
	}
	
	@Transactional
	public void deleteByActivityIdAndAccountId(Long activityId, Long accountId) {
	    likeRepository.deleteByActivityIdAndAccountId(activityId, accountId);
	}

	@Override
	public Set<LikeView> getAll() {
		String context = SecurityContextHolder.getContext().getAuthentication().getName();
		Long userId = Long.valueOf(context);
		
		return likeRepository.findByAccountId(userId);
		
	}
	
}
