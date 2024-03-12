package co.simplon.tkm.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "activities")
public class Activity extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "link_url")
	private String linkUrl;
	
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	
//	@JoinTable(name ="likes",
//	joinColumns = @JoinColumn(name = "activity_id"),
//	inverseJoinColumns = @JoinColumn(name = "account_id"))
	@ManyToMany(mappedBy = "favoriteActivities")
//	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Account> likedByAccounts = new HashSet<>();
	
	public Activity() {
		//Required no-argument constructor
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
//	public Set<Account> getLikedByAccounts() {
//		return likedByAccounts;
//	}
//
//	public void setLikedByAccounts(Set<Account> likedByAccounts) {
//		this.likedByAccounts = likedByAccounts;
//	}

	@Override
	public String toString() {
		return "Activity [name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", location=" + location + ", linkUrl=" + linkUrl + ", createdAt=" + createdAt + "]";
	}
	

}
