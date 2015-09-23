import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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
		//tests splitting input string into id and cards and sort from largest to smallest
		//also test high hand case
		Hand hand = new Hand("DY AceHearts TwoDiamonds ThreeSpades FourClubs FiveHearts");
		System.out.println(hand.cards);

		int[] x = {14, 5, 4, 3, 2};
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals("DY", hand.id);

		assertEquals(10, hand.hand);
	}

	@Test
	public void testPair(){
		//tests pair function

		int[] x = {14, 5, 4, 3};
		Hand hand = new Hand("DY AceHearts AceDiamonds ThreeSpades FourClubs FiveHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(9, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));

		hand = new Hand("DY ThreeSpades AceDiamonds FourClubs AceHearts FiveHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(9, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}

	@Test
	public void testThreeOfAKind(){
		//tests threeOfAKind function

		int[] x = {3, 14, 5};
		Hand hand = new Hand("DY ThreeHearts FiveDiamonds ThreeSpades ThreeClubs AceHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(7, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
		
		x = new int[] {10, 12, 11};
		hand = new Hand("DY TenHearts JackDiamonds TenSpades TenClubs QueenHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(7, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}

	@Test
	public void testFourOfAKind(){
		//tests threeOfAKind function

		int[] x = {3};
		Hand hand = new Hand("DY ThreeHearts AceDiamonds ThreeSpades ThreeClubs ThreeHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(3, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
		
		x = new int[] {2};
		hand = new Hand("DY ThreeHearts TwoDiamonds TwoSpades TwoClubs TwoHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(3, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}

	@Test
	public void testFullHouse(){
		//tests threeOfAKind function

		int[] x = {14};
		Hand hand = new Hand("DY AceHearts AceDiamonds ThreeSpades ThreeClubs AceHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(4, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
		
		x = new int[] {2};
		hand = new Hand("DY ThreeHearts TwoDiamonds ThreeSpades TwoClubs TwoHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(4, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
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
