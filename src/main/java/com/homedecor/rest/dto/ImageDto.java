package com.homedecor.rest.dto;

import java.util.ResourceBundle;

public class ImageDto {

	private Long id;
	private String imageName;
	private String imagePath;
	private String label;
	
	private Boolean status;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("messages_en");
	String urlPath = resourceBundle.getString("label.urlPath");
	
	public ImageDto(){
		
	}

	public ImageDto(Long id, String imageName, String imagePath, String label,
					Boolean status) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.imagePath =urlPath+""+imagePath;
		this.label = label;
		
		this.status = status;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
