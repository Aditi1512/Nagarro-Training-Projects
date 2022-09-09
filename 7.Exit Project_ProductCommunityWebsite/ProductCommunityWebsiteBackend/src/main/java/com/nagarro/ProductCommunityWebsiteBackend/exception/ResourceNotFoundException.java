package com.nagarro.ProductCommunityWebsiteBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is an exception class for the resources that are not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private Object fieldValue;
	private String fieldName;

	/**
	 * This method returns the not found exception if the resource is not found
	 * 
	 * @param resourceName - name of the resource
	 * @param fieldValue   - object of field
	 * @param fieldName    - field name of resource
	 */
	public ResourceNotFoundException(String resourceName, Object fieldValue, String fieldName) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
