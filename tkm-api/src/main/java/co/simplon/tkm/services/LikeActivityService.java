package co.simplon.tkm.services;

import java.util.Collection;

import co.simplon.tkm.dtos.LikeActivityView;

public interface LikeActivityService {

//	void saveFavorite(Long activityId, Long accountId);

	LikeActivityView saveFavorite(Long id);

	void saveFavorite(Long activity_id, Long account_id);

	Collection<LikeActivityView> getAll();


}
