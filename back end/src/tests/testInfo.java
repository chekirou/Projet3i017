package tests;

import org.junit.Test;

import Services.Friend;
import Services.Message;
import Tools.UserTools;


public class testInfo {
	@Test
	public void test()
	{
		System.out.println(UserTools.InfoUsers("german"));
		System.out.println(UserTools.StatsUser("german"));
		
	}

}
