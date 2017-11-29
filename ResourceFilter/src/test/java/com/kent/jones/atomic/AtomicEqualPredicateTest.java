package com.kent.jones.atomic;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kent.jones.model.Resource;
import com.kent.jones.model.ResourceAttribute;
import com.kent.jones.model.User;
import com.kent.jones.predicate.EqualPredicate;

public class AtomicEqualPredicateTest
{
	Map<String, String> map = new HashMap<>();
	
	static List<User> allUsers;
	
	List<User> selected;

	@Test
	public void singleEqualsTest()
	{
		Resource ra = new ResourceAttribute("role", "clerk");

//		System.out.format("Equals: Key=%s Value=%s %n", ra.getName() , ra.getValue());
		
		selected = allUsers.stream().filter(new EqualPredicate(ra)).collect(Collectors.toList());
		assertTrue(!selected.isEmpty());
		
//		LoadResources.print(selected);
	}
	@Test
	public void singleEqualsNegateTest()
	{
		Resource ra = new ResourceAttribute("role", "clerk");

//		System.out.format("%n Negate Equals: Key=%s Value=%s %n", ra.getName() , ra.getValue());
		
		selected = allUsers.stream().filter(new EqualPredicate(ra).negate()).collect(Collectors.toList());
		assertTrue(!selected.isEmpty());
		
//		LoadResources.print(selected);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		allUsers = LoadResources.getUsers();
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
