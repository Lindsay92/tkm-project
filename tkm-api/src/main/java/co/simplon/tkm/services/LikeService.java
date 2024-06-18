package co.simplon.tkm.services;

import java.util.Collection;

import co.simplon.tkm.dtos.LikeView;

public interface LikeService {

	void like(Long activityId, Long accountId);

	void deleteByActivityIdAndAccountId(Long activityId, Long accountId);

	Collection<LikeView> getAll();

}
