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
import com.kent.jones.predicate.EqualPredicate;
import com.kent.jones.predicate.GreaterPredicate;

public class AtomicEqualAndGreaterPredicateTest
{
	Map<String, String> map = new HashMap<>();
	List<User> users = new ArrayList<>();

	@Test
	public void combineEqualAndGreaterTest()
	{
		Resource role = new ResourceAttribute("role", "clerk");
		Resource age  = new ResourceAttribute("age", "30");

//		System.out.format("Equals: Key=%s Value=%s and %n", role.getName() , role.getValue());
//		System.out.format("Greater: Key=%s Value=%s %n", age.getName() , age.getValue());
		
		users = LoadResources.getUsers().stream().filter(new EqualPredicate(role).and(new GreaterPredicate(age))).collect(Collectors.toList());
		assertTrue(!users.isEmpty());
		
//		for(User user : users)
//		{
//			System.out.format("%s %s (%s) %n", user.getFirstName() , user.getLastName(), user.getResourcesToString());
//		}
	}
	@Test
	public void negateEqualAndGreaterTest()
	{
		Resource role = new ResourceAttribute("role", "clerk");
		Resource age  = new ResourceAttribute("age", "30");

//		System.out.format("Negate  Equals: Key=%s Value=%s and %n", role.getName() , role.getValue());
//		System.out.format("Negate  Greaters: Key=%s Value=%s %n", age.getName() , age.getValue());
		
		users = LoadResources.getUsers().stream().filter(new EqualPredicate(role).negate().and(new GreaterPredicate(age).negate())).collect(Collectors.toList());
		assertTrue(!users.isEmpty());
//		
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
