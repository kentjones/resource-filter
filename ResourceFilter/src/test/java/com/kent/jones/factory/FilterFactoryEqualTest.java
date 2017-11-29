package com.kent.jones.factory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.kent.jones.predicate.EqualPredicate;

public class FilterFactoryEqualTest
{
	Map<String, String> map = new HashMap<>();
	List<User> users = new ArrayList<>();

	@Test
	public void singleEqualsTest()
	{
		Resource ra = new ResourceAttribute("role", "clerk");

//		System.out.format("Equals: Key=%s Value=%s %n", ra.getName() , ra.getValue());
		
		users = LoadResources.getUsers().stream().filter(new EqualPredicate(ra)).collect(Collectors.toList());
		assertTrue(!users.isEmpty());
		
		for(User user : users)
		{
			System.out.format("%s %s (%s) %n", user.getFirstName() , user.getLastName(), user.getResourcesToString());
		}
	}
	@Test
	public void singleEqualsNegateTest()
	{
		Resource ra = new ResourceAttribute("role", "clerk");

//		System.out.format("%n Negate Equals: Key=%s Value=%s %n", ra.getName() , ra.getValue());
		
		users = LoadResources.getUsers().stream().filter(new EqualPredicate(ra).negate()).collect(Collectors.toList());
		assertTrue(!users.isEmpty());
		
//		for(User user : users)
//		{
//			System.out.format("%s %s (%s) %n", user.getFirstName() , user.getLastName(), user.getResourcesToString());
//		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{}

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
