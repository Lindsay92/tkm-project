package co.simplon.tkm.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import co.simplon.tkm.dtos.ActivityDetailView;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.dtos.LikeActivityView;
import co.simplon.tkm.entities.Account;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.entities.Like;
import co.simplon.tkm.repositories.AccountRepository;
import co.simplon.tkm.repositories.ActivityRepository;
import co.simplon.tkm.repositories.LikeActivityRepository;

@Service
public class LikeActivityServiceImpl implements LikeActivityService {
	
		private final LikeActivityRepository likeRepository;
		private final AccountRepository accountRepository;
		private final ActivityRepository activityRepository;
		
		public LikeActivityServiceImpl(LikeActivityRepository likeRepository, 
				AccountRepository accountRepository,
				ActivityRepository activityRepository) {
			this.likeRepository = likeRepository;
			this.accountRepository = accountRepository;
			this.activityRepository = activityRepository;
		}

		@Override
		public void saveFavorite(Long activity_id, Long account_id) {
			Activity activity = activityRepository.getReferenceById(activity_id);
			Account account = accountRepository.getReferenceById(account_id);
			
			if (activity != null && account != null) {
	            Like like = new Like();
	            like.setActivity(activity);
	            like.setAccount(account);
	            likeRepository.save(like);
	        }
		}
		
		@Override
		public Collection<LikeActivityView> getAll() {
			return likeRepository.findAllProjectedBy();
		}
		
		@Override
		public LikeActivityView saveFavorite(Long id) {
			return likeRepository.findProjectLikeById(id);
		}
		 
}
