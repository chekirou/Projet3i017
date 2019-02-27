package tests;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import Services.Message;

public class testDeleteMessage {
	@Test
	public void test()
	{
		System.out.println(Message.deleteMessage("curls", "60A1342F48CB6D10E0677BCD05A45702", "5c758d89ab971354993b2017"));
	}
}
