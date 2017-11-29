package com.kent.jones.filter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.kent.jones.model.User;

/**
 * 
 * @author kbjones
 *
 */
public class FilterResource implements ResourceAccess
{

	@Override
	public List<User> filterUsersByResource(List<User> users, Predicate<User> predicate) throws IllegalArgumentException
	{
		if(users == null || predicate == null) throw new IllegalArgumentException("Both input values are required.");
		
		return users.stream().filter(predicate).collect(Collectors.toList());
	}

	@Override
	public Map<String, String> filterResources(Map<String, String> resources, Predicate<Map.Entry<String, String>> predicate) throws IllegalArgumentException
	{
		if(resources == null || predicate == null) throw new IllegalArgumentException("Both input values are required.");

		return  resources.entrySet().stream().filter(predicate).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}

}
