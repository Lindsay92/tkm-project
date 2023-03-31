package co.simplon.tkm.dtos;

import javax.validation.constraints.NotEmpty;

public class ActivityCreateDto {
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String imageUrl;
	
	@NotEmpty
	private String location;
	
	@NotEmpty
	private String linkUrl;
		
	
	public ActivityCreateDto() {
		super();
		// TODO Auto-generated constructor stub
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


	@Override
	public String toString() {
		return "Activity [ name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", location=" + location + ", linkUrl=" + linkUrl + "]";
	}

}
