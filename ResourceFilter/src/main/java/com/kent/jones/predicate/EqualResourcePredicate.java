package com.kent.jones.predicate;

import java.util.Map;
import java.util.function.Predicate;

import com.kent.jones.model.Resource;

public class EqualResourcePredicate implements Predicate<Map.Entry<String, String>>
{
	private Resource resource;
	
	public EqualResourcePredicate(Resource resource)
	{
		this.resource = resource;
	}
	
	@Override
	public boolean test(Map.Entry<String, String> entry)
	{
		if(resource.getName().equals(entry.getKey()))
		{
			return resource.getValue().equalsIgnoreCase(entry.getValue());
		}
		return false;
	}
}
