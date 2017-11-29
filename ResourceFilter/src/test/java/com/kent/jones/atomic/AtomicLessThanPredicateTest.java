package com.kent.jones.atomic;

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

import com.kent.jones.model.Resource;
import com.kent.jones.model.ResourceAttribute;
import com.kent.jones.model.User;

import com.kent.jones.predicate.LessPredicate;

public class AtomicLessThanPredicateTest
{
	Map<String, String> map = new HashMap<>();
	List<User> users = new ArrayList<>();

	@Test
	public void singleEqualsTest()
	{
		Resource ra = new ResourceAttribute("age", "30");
		
		users = LoadResources.getUsers().stream().filter(new LessPredicate(ra)).collect(Collectors.toList());
		assertTrue("did not find any resources greater than 30" ,!users.isEmpty());
		
//		System.out.format("Less Than: Key=%s Value=%s %n", ra.getName() , ra.getValue());
//		for(User user : users)
//		{
//			System.out.format("%s %s (%s) %n", user.getFirstName() , user.getLastName(), user.getResourcesToString());
//		}
	}
	@Test
	public void singleEqualsNegateTest()
	{
		Resource ra = new ResourceAttribute("age", "30");
		
		users = LoadResources.getUsers().stream().filter(new LessPredicate(ra).negate()).collect(Collectors.toList());
		assertTrue(!users.isEmpty());
		
//		System.out.format("%n Negate Less Than: Key=%s Value=%s %n", ra.getName() , ra.getValue());
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
