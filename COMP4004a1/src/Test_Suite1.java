import static org.junit.Assert.*;

import java.util.Arrays;

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
		//also test high card case
		Hand hand = new Hand("DY AceHearts TwoDiamonds ThreeSpades FourClubs SixHearts");
		System.out.println(hand.cards);

		int[] x = {14, 6, 4, 3, 2};
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals("DY", hand.id);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		assertEquals(10, hand.hand);
	}

	@Test
	public void testHandToString(){
		//tests the toString function in Hand
		Hand hand = new Hand("DY AceHearts TwoDiamonds ThreeSpades FourClubs SixHearts");
		assertEquals("DY AceHearts SixHearts FourClubs ThreeSpades TwoDiamonds", hand.toString());
		
		hand = new Hand("Din AceSpades TwoDiamonds TwoClubs KingHearts KingHearts");
		assertEquals("Din AceSpades KingHearts KingHearts TwoDiamonds TwoClubs", hand.toString());
		
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
	
	@Test
	public void testTwoPair(){
		//tests pair function

		int[] x = {14, 13, 2};
		Hand hand = new Hand("DY TwoHearts KingDiamonds AceSpades KingClubs AceHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(8, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));

		x = new int[] {13, 2, 14};
		hand = new Hand("DY AceSpades TwoDiamonds TwoClubs KingHearts KingHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(8, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}
	
	@Test
	public void testFlush(){
		//tests pair function

		int[] x = {14, 13, 10, 8, 2};
		Hand hand = new Hand("DY TwoDiamonds EightDiamonds TenDiamonds KingDiamonds AceDiamonds");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(5, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));

		x = new int[] {13, 11, 10, 8, 6};
		hand = new Hand("DY KingHearts SixHearts TenHearts JackHearts EightHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(5, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}
	@Test
	public void testStraight(){
		//tests pair function

		int[] x = {5};
		Hand hand = new Hand("DY TwoDiamonds FiveDiamonds AceHearts ThreeDiamonds FourDiamonds");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(6, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));

		x = new int[] {14};
		hand = new Hand("DY KingClubs TenHearts QueenHearts JackHearts AceHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(6, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}

	@Test
	public void testStraightFlush(){
		//tests pair function

		int[] x = {5};//straight flush
		Hand hand = new Hand("DY TwoDiamonds FiveDiamonds AceDiamonds ThreeDiamonds FourDiamonds");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(2, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));

		x = new int[] {14};//royal flush
		hand = new Hand("DY KingHearts TenHearts QueenHearts JackHearts AceHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(1, hand.hand);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		System.out.println(Arrays.toString(y));
	}

	/*@Test
	public void testGame(){
		Game g = new Game();
		g.addPlayer("Din KingHearts TenHearts QueenHearts JackHearts AceHearts");
		g.addPlayer("DY TwoDiamonds FiveDiamonds AceDiamonds ThreeDiamonds FourDiamonds");
	}*/
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
