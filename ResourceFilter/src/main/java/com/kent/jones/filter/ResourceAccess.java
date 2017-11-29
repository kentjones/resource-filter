package com.kent.jones.filter;


import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.kent.jones.model.User;

/**
 * Interface for providing Resource Access properties for a user. 
 * @author kent.jones@startmail.com
 * @version 0.1
 */
public interface ResourceAccess
{
	
	/**
	 *  Use a funcational interface to filter users resource.
	 * @param users 
	 *          List of users
	 * @param predicate
	 *         Funcational Interface to filter resources 
	 * @return a List of Users (based on the predicate) or an empty list.
	 * @throws IllegalArgumentException
	 *				If users or predicate is null
	 */
	List<User> filterUsersByResource(List<User> users, Predicate<User> predicate) throws IllegalArgumentException;

	/**
	 *  Use a funcational interface to filter resources.
	 * @param resources 
	 *          Map of resources
	 * @param predicate
	 *         Funcational Interface to filter resources 
	 * @return 
	 * 			a Map of resources filtered by the input predicate or an empty list.
	 * @throws IllegalArgumentException
	 *				If resources or predicate is null
	 */
	Map<String, String> filterResources(Map<String, String> resources, Predicate<Map.Entry<String, String>> predicate) throws IllegalArgumentException;
	
}
