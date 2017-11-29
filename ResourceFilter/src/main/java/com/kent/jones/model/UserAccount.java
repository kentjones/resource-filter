package com.kent.jones.model;

import java.util.Arrays;
import java.util.Map;

public class UserAccount implements User
{
	private Map<String, String> resources;
	
	private int userId;
	
	private String firstName;
	private String lastName;
	
	public UserAccount(int userId, String firstName ,String lastName ,Map<String, String> resources)
	{
		this.resources = resources;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.resources = resources;
	}
	@Override
	public int getUserId()
	{
		return userId;
	}
	@Override
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String value)
	{
		this.firstName = value;
	}
	@Override
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String value)
	{
		this.lastName = value;
	}
	/**
	 * Not implementing Resource because the exercise calls for a Map. 
	 */
	@Override
	public Map<String, String> getResources()
	{
		return resources;
	}
	@Override
	public void setResource(Map<String, String> resources)
	{
		this.resources = resources;
	}
	@Override
	public String getResourcesToString()
	{
		return Arrays.toString(getResources().entrySet().toArray());
	}
	@Override
	public String toString()
	{
		return String.format("%s %s (%d) {%s}", getFirstName(), getLastName(), getUserId() ,getResourcesToString());
	}
}
