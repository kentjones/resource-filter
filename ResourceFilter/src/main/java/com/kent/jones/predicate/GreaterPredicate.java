package com.kent.jones.predicate;

import java.util.function.Predicate;

import com.kent.jones.model.Resource;
import com.kent.jones.model.User;

/**
 * A User Resource predicate - check (Integer) value is greater than resource value 
 * @author kbjones
 *
 */
public class GreaterPredicate implements Predicate<User>
{
	private Resource resource;
	
	private Predicate<User> isProperty;
	
	public GreaterPredicate(Resource resource)
	{
		this.resource = resource;
		this.isProperty = FilterFactory.getPropertyIsEqualPerdicate(resource);
	}
	@Override
	public boolean test(User user)
	{
		if(isProperty.test(user))
		{
			// normally i would use a 3rd party utility package to convert strings to integers. 
			try {
				if(Integer.valueOf(user.getResources().get(resource.getName())).intValue() > Integer.valueOf(resource.getValue()).intValue())
				{
					return true;
				} else {
					return false;
				}
			} 
			catch (Exception e)
			{
				return false;
			}
		}
		return false;
	}
}
