package com.kent.jones.predicate;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import com.kent.jones.model.User;

public class RegularExpressionPredicate implements Predicate<User>
{
	
	private Pattern pattern;
	
	public RegularExpressionPredicate(String pattern)
	{
		this.pattern = Pattern.compile(pattern);
	}
	@Override
	public boolean test(User input)
	{
		return pattern.matcher(input.getResourcesToString()).find();
	}
}
