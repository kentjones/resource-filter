package com.kent.jones.predicate;

import java.util.function.Predicate;

import com.kent.jones.model.Resource;
import com.kent.jones.model.User;

public class EqualPropertyPredicate implements Predicate<User>
{
	private Resource resource;
	
	public EqualPropertyPredicate(Resource resource)
	{
		this.resource = resource;
	}
	
	@Override
	public boolean test(User user)
	{
		return user.getResources().containsKey(resource.getName());
	}
}
