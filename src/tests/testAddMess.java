package tests;

import org.junit.Test;

import Services.Message;

public class testAddMess {
	@Test
	public void test()
	{
		System.out.println(Message.addMessage("curls", "A133388558077699C64CA378CB133497", "hallo"));
	}
}
