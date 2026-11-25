package edu.jsp_banking_app_Service;

public class ResourcesNotFoundException extends RuntimeException {

	public ResourcesNotFoundException(String resourceName, String fieldName, Object fieldValue) {

		super(resourceName + " not found with " + fieldName + " : " + fieldValue);
	}
}