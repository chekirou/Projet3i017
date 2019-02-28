package tests;

import org.junit.Test;

import Services.Message;

public class testAddMess {
	@Test
	public void test()
	{
		System.out.println(Message.addMessage("rebecca", "8D1B17A2FE1222004BE0B9899F720631", "je suis tres heureuse d'etre ici"));
		System.out.println(Message.addMessage("rebecca", "8D1B17A2FE1222004BE0B9899F720631", "parmis vous ce soir"));
		System.out.println(Message.addMessage("rebecca", "8D1B17A2FE1222004BE0B9899F720631", "pour la 80 eme ceremonie des hunger games"));
		
	}
}
