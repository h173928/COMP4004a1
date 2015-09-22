import static org.junit.Assert.*;

import org.junit.Test;


public class Test_Suite1 {

	@Test
	public void test() {
		//Deck d = new Deck();
		Card c = new Card("Diamond", 1);
		System.out.println(c.toString());
		assertEquals("TwoDiamond", c.toString());//testing Card class;
	}

}
