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
		System.out.println(Message.deleteMessage("rebecca", "187C119D3286999D01AB7D8867912432", "5c780cf0a3c6af041172e394"));
	}
}
