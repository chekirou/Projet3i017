package tests;

import org.junit.Test;

import Services.Message;
import Services.User;

public class testlogin {
@Test
	
	public void test()
	{
		System.out.println(User.login("curls", "monsieuur", false));
	}
}
