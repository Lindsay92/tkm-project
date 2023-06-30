package co.simplon.tkm.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.tkm.customValidation.FileSize;
import co.simplon.tkm.customValidation.FileType;

public class ActivityCreateDto {
	
	@NotBlank
	@Size(max = 250)
	private String name;
	
	@NotBlank
	@Size(max = 1000)
	private String description;
	
	@NotNull
	@FileSize
	@FileType
	private MultipartFile imageUrl;
	
	@NotBlank
	@Size(max = 100)
	private String location;
	
	@NotBlank
	private String linkUrl;
		
	
	public ActivityCreateDto() {
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

	public MultipartFile getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(MultipartFile imageUrl) {
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
