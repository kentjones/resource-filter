package com.kent.jones.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kent.jones.atomic.LoadResources;
import com.kent.jones.filter.FilterResource;
import com.kent.jones.model.ResourceAttribute;
import com.kent.jones.model.User;
import com.kent.jones.predicate.FilterFactory;

public class FilterResourceServiceEqualTest
{
	Map<String, String> map = new HashMap<>();
	static List<User> users;

	@Test
	public void resourceIsEqual()
	{
		
		// grab resources from a single user
		Optional<User> optional = users.stream().findFirst();
		if(optional.isPresent())
		{
			Predicate<Map.Entry<String, String>> equal = FilterFactory.getPropertyValueIsEqualResourcePerdicate(new ResourceAttribute("firstName", optional.get().getFirstName()));
			Map<String, String> selected  = new FilterResource().filterResources(optional.get().getResources(),  equal);

			assertTrue(!selected.isEmpty());
		}
	}
	@Test
	public void negateResourceIsEqual()
	{
		
		Optional<User> optional = users.stream().findFirst();
		if(optional.isPresent())
		{
			Predicate<Map.Entry<String, String>> equal = FilterFactory.getPropertyValueIsEqualResourcePerdicate(new ResourceAttribute("lastName", optional.get().getLastName()));

			Map<String, String> selected  = new FilterResource().filterResources(optional.get().getResources(), FilterFactory.getNegateResourcePerdicate(equal));

			assertTrue(!selected.isEmpty());
		}

	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		users = LoadResources.getUsers();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{}

	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

}
