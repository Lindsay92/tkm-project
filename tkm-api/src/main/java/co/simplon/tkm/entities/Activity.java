package co.simplon.tkm.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="likes",
	joinColumns = @JoinColumn(name = "activity_id"),
	inverseJoinColumns = @JoinColumn(name = "account_id"))
//	@ManyToMany(mappedBy = "favoriteActivities")
	private Set<Account> likedByAccount = new HashSet<>();
	
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
	

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Activity)) {
			return false;
		}
		Activity other = (Activity) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Activity [name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", location=" + location + ", linkUrl=" + linkUrl + ", createdAt=" + createdAt + "]";
	}

	
	

}
