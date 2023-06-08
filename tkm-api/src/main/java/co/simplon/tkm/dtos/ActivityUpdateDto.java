package co.simplon.tkm.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ActivityUpdateDto {

	@NotBlank
	@Size(max = 250)
	private String name;
	
	@NotBlank
	@Size(max = 1000)
	private String description;
	
	@NotBlank
	private String imageUrl;
	
	@NotBlank
	@Size(max = 100)
	private String location;
	
	@NotBlank
	private String linkUrl;
		
	
	public ActivityUpdateDto() {
		super();
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
