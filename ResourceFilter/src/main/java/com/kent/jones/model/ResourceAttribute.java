package com.kent.jones.model;

import com.kent.jones.model.ApplicationConstants.Status;

/**
 * A single resource
 * @author kbjones
 *
 */
public class ResourceAttribute implements Resource
{
	String name;
	String value;
	
	
	public ResourceAttribute(String name, String value)
	{
		this.name = name;
		this.value = value;
	}
	public ResourceAttribute(String name, Status value)
	{
		this.name = name;
		this.value = value.toString();
	}
	@Override
	public String getName()
	{
		return name;
	}
	@Override
	public void setName(String name)
	{
		this.name = name;
	}
	@Override
	public String getValue()
	{
		return value;
	}
	@Override
	public void setValue(String value)
	{
		this.value = value;
	}
}
