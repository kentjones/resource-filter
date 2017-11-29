package com.kent.jones.model;

import java.util.Map;

public interface User
{

	String 	getFirstName();
	String 	getLastName();
	
	int 	getUserId();
	
	String getResourcesToString();
	Map<String, String> getResources();
	void	setResource(Map<String, String> resources);
	
}
