package com.virtualBook.exception;

public class UserResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	String fieldValue;
	
	public UserResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldValue() {
		return fieldValue;
	}
	
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	

}
