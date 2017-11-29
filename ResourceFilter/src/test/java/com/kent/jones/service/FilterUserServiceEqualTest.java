package com.kent.jones.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kent.jones.atomic.LoadResources;
import com.kent.jones.filter.FilterResource;
import com.kent.jones.model.ApplicationConstants.Status;
import com.kent.jones.model.ResourceAttribute;
import com.kent.jones.model.User;
import com.kent.jones.predicate.FilterFactory;

public class FilterUserServiceEqualTest
{
	Map<String, String> map = new HashMap<>();
	static List<User> users;

	@Test
	public void propertyIsPresent()
	{
		Predicate<User> predicate = FilterFactory.getPropertyIsEqualPerdicate(new ResourceAttribute("role", "clerk"));
		
		List<User> selected  = new FilterResource().filterUsersByResource(users ,predicate);

		assertTrue(!selected.isEmpty());
	}
	public void propertyIsBoolean()
	{
		Predicate<User> predicate = FilterFactory.getPropertyValueIsEqualPerdicate(new ResourceAttribute("foosBallPlayer", Status.True));
		
		List<User> selected  = new FilterResource().filterUsersByResource(users ,predicate);

		assertTrue(!selected.isEmpty());
	}
	public void propertyIsEqual()
	{
		Predicate<User> predicate = FilterFactory.getPropertyValueIsEqualPerdicate(new ResourceAttribute("role", "clerk"));
		
		List<User> selected  = new FilterResource().filterUsersByResource(users ,predicate);

		assertTrue(!selected.isEmpty());
	}
	public void propertyIsLess()
	{
		Predicate<User> predicate = FilterFactory.getPropertyValueIsLessPerdicate(new ResourceAttribute("age", "99"));
		
		List<User> selected  = new FilterResource().filterUsersByResource(users ,predicate);

		assertTrue(!selected.isEmpty());
	}
	public void propertyIsGreater()
	{
		Predicate<User> predicate = FilterFactory.getPropertyValueIsGreaterPerdicate(new ResourceAttribute("age", "7"));
		
		List<User> selected  = new FilterResource().filterUsersByResource(users ,predicate);

		assertTrue(!selected.isEmpty());
	}
	@Test
	public void matchReqularExpression()
	{
		Predicate<User> predicate = FilterFactory.getReqularExpressionPerdicate("\\bfoosBallPlayer=false\\b");
		
		List<User> selected  = new FilterResource().filterUsersByResource(users ,predicate);

		assertTrue(!selected.isEmpty());
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		users = LoadResources.getUsers();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		users = null;
	}

}
