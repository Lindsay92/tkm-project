package co.simplon.tkm.services;

public interface LikeService {

	void like(Long activityId, Long accountId);

//	void delete(Long activityId, Long accountId);

	void deleteByActivityIdAndAccountId(Long activityId, Long accountId);

}
