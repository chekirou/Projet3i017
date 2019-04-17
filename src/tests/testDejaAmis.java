package tests;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import Services.Message;

public class testDejaAmis {
	@Test
	public void test()
	{
		System.out.println( Tools.FriendTools.dejaAmis("rleygonie","german"));
	}
}