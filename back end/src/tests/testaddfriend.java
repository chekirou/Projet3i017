package tests;

import org.junit.Test;

import Services.Friend;
import Services.Message;


public class testaddfriend {
	@Test
	public void test()
	{
		System.out.println(Friend.addFriend("rebecca", "8D1B17A2FE1222004BE0B9899F720631", "donald"));
	}

}
