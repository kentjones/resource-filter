package com.kent.jones.atomic;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kent.jones.model.User;

public class LoadResourceTest
{
	Map<String, String> map = new HashMap<>();
	
	static List<User> users;

	@Test
	public void userTest()
	{
		assertTrue(!users.isEmpty());
	}
	@Test
	public void mapTest()
	{
		
		for(User user : users)
		{
			System.out.println(user.toString());
			assertTrue(!user.getResources().isEmpty());
		}
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

	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

}
