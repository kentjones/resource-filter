package com.kent.jones.atomic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.kent.jones.model.User;
import com.kent.jones.model.UserAccount;

public class LoadResources
{
	private static List<User> users = new ArrayList<>();
	private static Random rand = new Random(0xDEADBEEF);
	
	private static List<String> roles = Arrays.asList("administrator", "clerk", "operator","frontDesk","bottleWasher");
	
	static public List<User> getUsers()
	{
		users.add(createUser("Bert", "Jones"));
		users.add(createUser("Anthony", "Young"));
		users.add(createUser("Anbar", "Inaam"));
		users.add(createUser("Eric", "Zummanch"));
		users.add(createUser("Kathy", "King"));
		users.add(createUser("Phillip", "Volk"));
		users.add(createUser("Michael", "Jordan"));
		users.add(createUser("Marlisa", "Bah"));
		users.add(createUser("Denis", "Bryant"));
		users.add(createUser("Jared", "Burnside"));
		
		return users;
	}
	static private User createUser(String firstName ,String lastName)
	{
		return new UserAccount(rand.nextInt(1000) ,firstName, lastName, getResourceMap(firstName, lastName));
		
	}
	static private Map<String, String> getResourceMap(String firstName, String lastName)
	{
		Map<String, String> map = new HashMap<>();
				
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		
		Collections.shuffle(roles);
		map.put("role", roles.get(0));
		
		map.put("age",  Integer.valueOf(rand.nextInt(60)).toString());
		
		Boolean b = Math.random() < 0.5;
		map.put("healthCoverage", b.toString());

		b = Math.random() < 0.5;
		map.put("foosBallPlayer", b.toString());
		
		return map;
	}
	static public void print(List<User> users)
	{
		for(User user : users)
		{
			System.out.format("%s %s (%s) %n", user.getFirstName() , user.getLastName(), user.getResourcesToString());
		}
	}

}
