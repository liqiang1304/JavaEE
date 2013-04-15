package edu.tongji.javaee.exam.model;

import java.io.Serializable;

public class TestArea implements Serializable {
	private int key=0;
	private String testArea;
	private String description; 
	private String imageFile;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getTestArea() {
		return testArea;
	}
	public void setTestArea(String testArea) {
		this.testArea = testArea;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public TestArea() {
		// TODO Auto-generated constructor stub
	}

}
