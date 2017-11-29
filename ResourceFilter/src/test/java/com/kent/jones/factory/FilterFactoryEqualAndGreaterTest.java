package com.kent.jones.factory;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kent.jones.atomic.LoadResources;
import com.kent.jones.model.Resource;
import com.kent.jones.model.ResourceAttribute;
import com.kent.jones.model.User;
import com.kent.jones.predicate.FilterFactory;

public class FilterFactoryEqualAndGreaterTest
{
	Map<String, String> map = new HashMap<>();
	static List<User> users;

	@Test
	public void combineEqualAndGreaterTest()
	{
		Resource role = new ResourceAttribute("role", "clerk");
		Resource age  = new ResourceAttribute("age", "10");
		
		Predicate<User> equalGreater = FilterFactory.getAndPerdicate(FilterFactory.getPropertyValueIsEqualPerdicate(role), FilterFactory.getPropertyValueIsGreaterPerdicate(age));
		
		List<User> selected  = users.stream().filter( equalGreater).collect(Collectors.toList());

		assertTrue(!selected.isEmpty());

		LoadResources.print(selected);
		
	}
	@Test
	public void negateEqualAndGreaterTest()
	{
		Resource role = new ResourceAttribute("role", "clerk");
		Resource age  = new ResourceAttribute("age", "10");

		System.out.format("Negate  Equals: Key=%s Value=%s and %n", role.getName() , role.getValue());
		System.out.format("Negate  Greaters: Key=%s Value=%s %n", age.getName() , age.getValue());

		Predicate<User> notEqualGreater = FilterFactory.getAndPerdicate(FilterFactory.getNegatePerdicate(FilterFactory.getPropertyValueIsEqualPerdicate(role)), FilterFactory.getNegatePerdicate(FilterFactory.getPropertyValueIsGreaterPerdicate(age)));
		
		List<User> selected  = users.stream().filter(notEqualGreater).collect(Collectors.toList());
		assertTrue(!selected.isEmpty());
		
		LoadResources.print(selected);

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
