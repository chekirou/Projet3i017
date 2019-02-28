package tests;

import org.junit.Test;

import Services.Message;
import Services.User;

public class testLogout {
@Test
	
	public void test()
	{
		System.out.println(User.logout("german", "23A5FF8463358794567A6BA3A01A294E"));
		
	}
}
