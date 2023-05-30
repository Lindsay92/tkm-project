package co.simplon.tkm.dtos;

import java.time.LocalDateTime;

public interface ActivityDetailView {
	
	String getName();
	
	String getDescription();
	
	String getImageUrl();
	
	String getLocation();
	
	String getLinkUrl();
	
	LocalDateTime getCreatedAt();

}
