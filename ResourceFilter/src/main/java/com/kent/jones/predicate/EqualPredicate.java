package com.kent.jones.predicate;

import java.util.function.Predicate;

import com.kent.jones.model.Resource;
import com.kent.jones.model.User;

public class EqualPredicate implements Predicate<User>
{
	private Resource resource;
	
	private Predicate<User> isProperty;
	
	public EqualPredicate(Resource resource)
	{
		this.resource = resource;
		this.isProperty = FilterFactory.getPropertyIsEqualPerdicate(resource);
	}
	
	@Override
	public boolean test(User user)
	{
		if(isProperty.test(user))
		{
			return user.getResources().get(resource.getName()).equalsIgnoreCase(resource.getValue());
		}
		return false;
	}
}
