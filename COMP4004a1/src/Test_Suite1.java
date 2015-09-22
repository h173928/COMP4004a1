import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.sun.media.jfxmedia.events.NewFrameEvent;


public class Test_Suite1 {

	@Test
	public void testCard() {
		
		Card c = new Card("Diamond", 1);
		System.out.println(c.toString());
		assertEquals("TwoDiamond", c.toString());//testing Card class;
	}
	
	@Test
	public void testDeck(){
		Deck d = new Deck();
		Set<String> deck = new HashSet<String>();
		//hashset only keeps unique values so repeats are ignored
		for(int i = 0; i < 52; i++){
			deck.add(d.deck.pop().toString());
		}
		System.out.println(deck);
		assertEquals(52, deck.size(), 0);//make sure all cards are unique
	}
}
