package edu.jsp_banking_app_Service;

public class ResourcesAlreadyExistsException  extends RuntimeException {
	
		public ResourcesAlreadyExistsException(String fieldName) {
			super(fieldName + "Already Exsist!!!");
		}

}
