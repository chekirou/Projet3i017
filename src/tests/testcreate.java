package tests;

import org.junit.Test;

import Services.Message;
import Services.User;

public class testcreate {
	@Test
	public void test()
	{
		System.out.println(User.createUser("merkel", "angela", "german", "cdu", "F", "1952-09-15", "angela@germany.de"));
	}
}
