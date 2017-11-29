package com.kent.jones.predicate;

import java.util.Map;
import java.util.function.Predicate;

import com.kent.jones.model.Resource;
import com.kent.jones.model.User;

/**
 * Return a Predicate to be used in the Filter Resource class.<br>
 * 
 * I did not package protect the Predicates. This is an area open for a group discussion.
 * Atomic test will fail (not compile) if predicates are package protected.   
 * @author kbjones
 *
 */
public class FilterFactory
{

	private FilterFactory() {}
	
	/**
	 * 
	 * @param resource
	 * @return 
	 *     filter a resource property value 
	 * @see ResourceAccess.filterUsersByResource(); 
	 */
	public static Predicate<Map.Entry<String, String>> getPropertyValueIsEqualResourcePerdicate(Resource resource)
	{
		return new EqualResourcePredicate(resource);
	}
	public static Predicate<Map.Entry<String, String>> getNegateResourcePerdicate(Predicate<Map.Entry<String, String>> p1)
	{
		return p1.negate();
	}
	public static Predicate<User> getPropertyValueIsLessPerdicate(Resource resource)
	{
		return new LessPredicate(resource);
	}
	public static Predicate<User> getPropertyValueIsGreaterPerdicate(Resource resource)
	{
		return new GreaterPredicate(resource);
	}
	public static Predicate<User> getPropertyIsEqualPerdicate(Resource resource)
	{
		return new EqualPropertyPredicate(resource);
	}
	public static Predicate<User> getPropertyValueIsEqualPerdicate(Resource resource)
	{
		return new EqualPredicate(resource);
	}
	public static Predicate<User> getAndPerdicate(Predicate<User> p1 ,Predicate<User> p2)
	{
		return p1.and(p2);
	}
	public static Predicate<User> getOrPerdicate(Predicate<User> p1 ,Predicate<User> p2)
	{
		return p1.or(p2);
	}
	public static Predicate<User> getNegatePerdicate(Predicate<User> p1)
	{
		return p1.negate();
	}
	public static Predicate<User> getReqularExpressionPerdicate(String regex)
	{
		return new RegularExpressionPredicate(regex);
	}
}
