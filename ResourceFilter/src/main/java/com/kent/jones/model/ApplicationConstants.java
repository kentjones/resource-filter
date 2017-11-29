package com.kent.jones.model;

public class ApplicationConstants
{

	
	public enum Status
	{
		True(true, "true") ,
		False(false, "false");
		
		private final boolean value;
		private final String  name;
		
		Status(boolean value , String name)
		{
			this.value = value;
			this.name = name;
		}
		public boolean booleanValue()
		{
			return value;
		}
		@Override
		public String toString()
		{
			return name;
		}
	}
}
