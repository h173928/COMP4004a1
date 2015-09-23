import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;



public class Test_Suite1 {

	@Test
	public void testCard() {
		
		Card c = new Card("AceDiamond");
		//System.out.println(c.toString());
		assertEquals("Ace", c.rank);
		assertEquals("Diamond", c.suit);//testing Card class;
	}
	
	@Test
	public void testHand(){
		Hand hand = new Hand("DY AceHearts TwoDiamonds ThreeSpades FourClubs FiveHearts");
		assertEquals("AceHearts", hand.cards[0].toString());
		assertEquals("TwoDiamonds", hand.cards[1].toString());
		assertEquals("ThreeSpades", hand.cards[2].toString());
		assertEquals("FourClubs", hand.cards[3].toString());
		assertEquals("FiveHearts", hand.cards[4].toString());
		assertEquals("DY", hand.id);
	}
	/*@Test
	public void testDeck(){
		Deck d = new Deck();
		Set<String> deck = new HashSet<String>();
		//hashset only keeps unique values so repeats are ignored
		for(int i = 0; i < 52; i++){
			deck.add(d.deck.pop().toString());
		}
		System.out.println(deck);
		assertEquals(52, deck.size(), 0);//make sure all cards are unique
	}*/
}
