import static org.junit.Assert.*;

import java.util.ArrayList;
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
		//System.out.println(hand.cards);

		int[] x = {14, 6, 4, 3, 2};
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals("DY", hand.id);
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		assertEquals(10, hand.getHand());
	}

	@Test
	public void testHandToString(){
		//tests the toString function in Hand
		Hand hand = new Hand("DY AceHearts TwoDiamonds ThreeSpades FourClubs SixHearts");
		assertEquals("DY AceHearts SixHearts FourClubs ThreeSpades TwoDiamonds Ranked 100", hand.toString());
		
		hand = new Hand("Din AceSpades TwoDiamonds TwoClubs KingHearts KingHearts");
		assertEquals("Din AceSpades KingHearts KingHearts TwoDiamonds TwoClubs Ranked 100", hand.toString());
		
	}
	
	@Test
	public void testPair(){
		//tests pair function

		int[] x = {14, 5, 4, 3};
		Hand hand = new Hand("DY AceHearts AceDiamonds ThreeSpades FourClubs FiveHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(9, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));

		hand = new Hand("DY ThreeSpades AceDiamonds FourClubs AceHearts FiveHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(9, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
	}

	@Test
	public void testThreeOfAKind(){
		//tests threeOfAKind function

		int[] x = {3, 14, 5};
		Hand hand = new Hand("DY ThreeHearts FiveDiamonds ThreeSpades ThreeClubs AceHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(7, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
		
		x = new int[] {10, 12, 11};
		hand = new Hand("DY TenHearts JackDiamonds TenSpades TenClubs QueenHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(7, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
	}

	@Test
	public void testFourOfAKind(){
		//tests threeOfAKind function

		int[] x = {3};
		Hand hand = new Hand("DY ThreeHearts AceDiamonds ThreeSpades ThreeClubs ThreeHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(3, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
		
		x = new int[] {2};
		hand = new Hand("DY ThreeHearts TwoDiamonds TwoSpades TwoClubs TwoHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(3, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
	}

	@Test
	public void testFullHouse(){
		//tests threeOfAKind function

		int[] x = {14};
		Hand hand = new Hand("DY AceHearts AceDiamonds ThreeSpades ThreeClubs AceHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(4, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
		
		x = new int[] {2};
		hand = new Hand("DY ThreeHearts TwoDiamonds ThreeSpades TwoClubs TwoHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(4, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
	}
	
	@Test
	public void testTwoPair(){
		//tests twoPairs function

		int[] x = {14, 13, 2};
		Hand hand = new Hand("DY TwoHearts KingDiamonds AceSpades KingClubs AceHearts");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(8, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));

		x = new int[] {13, 2, 14};
		hand = new Hand("DY AceSpades TwoDiamonds TwoClubs KingHearts KingHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(8, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
		
		x = new int[] {7, 6, 4};
		hand = new Hand("Dwight SixDiamonds SixClubs SevenClubs SevenHearts FourSpades");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(8, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
	}
	
	@Test
	public void testFlush(){
		//tests flush() function

		int[] x = {14, 13, 10, 8, 2};
		Hand hand = new Hand("DY TwoDiamonds EightDiamonds TenDiamonds KingDiamonds AceDiamonds");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(5, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));

		x = new int[] {13, 11, 10, 8, 6};
		hand = new Hand("DY KingHearts SixHearts TenHearts JackHearts EightHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(5, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
	}
	@Test
	public void testStraight(){
		//tests straight function

		int[] x = {5};
		Hand hand = new Hand("DY TwoDiamonds FiveDiamonds AceHearts ThreeDiamonds FourDiamonds");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(6, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));

		x = new int[] {14};
		hand = new Hand("DY KingClubs TenHearts QueenHearts JackHearts AceHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(6, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));
	}

	@Test
	public void testStraightFlush(){
		//tests straightFlush function

		int[] x = {5};//straight flush
		Hand hand = new Hand("DY TwoDiamonds FiveDiamonds AceDiamonds ThreeDiamonds FourDiamonds");
		Integer[] y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(2, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
		//System.out.println(Arrays.toString(y));

		x = new int[] {14};//royal flush
		hand = new Hand("DY KingHearts TenHearts QueenHearts JackHearts AceHearts");
		y = hand.determines.toArray(new Integer[hand.determines.size()]);
		assertEquals(1, hand.getHand());
		assertEquals(Arrays.toString(x), Arrays.toString(y));
	}
	//to run the following two tests, comment out what is in Game:game()*************
	/*@Test
	public void testGame(){
		Game g = new Game();
		g.addPlayer("James TwoSpades JackSpades AceDiamonds ThreeDiamonds FourDiamonds");
		g.addPlayer("Din KingHearts TenHearts QueenHearts JackHearts AceHearts");
		g.sort();
		assertEquals("Din AceHearts KingHearts QueenHearts JackHearts TenHearts Ranked 1" ,g.getPlayer(0).toString());
		assertEquals("James", g.getPlayer(1).id);
		g.addPlayer("DY TwoDiamonds FiveDiamonds AceDiamonds ThreeDiamonds FourDiamonds");
		g.sort();
		assertEquals("DY AceDiamonds FiveDiamonds FourDiamonds ThreeDiamonds TwoDiamonds Ranked 2" ,g.getPlayer(1).toString());
		assertEquals("Din AceHearts KingHearts QueenHearts JackHearts TenHearts Ranked 1" ,g.getPlayer(0).toString());
		assertEquals("James", g.getPlayer(2).id);
		
		g.addPlayer("Philip TwoSpades JackHearts AceDiamonds TwoDiamonds FourDiamonds");
		g.result();
		assertEquals("Philip", g.getPlayer(2).id);
		assertEquals("James", g.getPlayer(3).id);
		
	}
	
	@Test
	public void testSameHands(){
		Game g = new Game();
		g.addPlayer("Dwight SevenClubs SevenHearts SixDiamonds SixClubs FourSpadess");
		g.addPlayer("Din SevenSpades SevenDiamonds SixHearts SixSpades FiveClubs");
		g.sort();
		assertEquals("Din SevenSpades SevenDiamonds SixHearts SixSpades FiveClubs Ranked 1" ,g.getPlayer(0).toString());
		assertEquals("Dwight", g.getPlayer(1).id);
		g.addPlayer("DY FourDiamonds FourHearts AceDiamonds ThreeDiamonds FiveDiamonds");
		g.addPlayer("James TwoDiamonds TwoHearts AceDiamonds ThreeDiamonds FiveDiamonds");
		g.sort();
		assertEquals("DY", g.getPlayer(2).id);
		assertEquals("James", g.getPlayer(3).id);
		
		g = new Game();
		g.addPlayer("Dwight SevenClubs SevenHearts SixDiamonds SixClubs FourSpades");
		g.addPlayer("Din SevenSpades SevenDiamonds FiveClubs FourHearts FourDiamonds");
		g.sort();
		assertEquals("Din", g.getPlayer(1).id);
		assertEquals("Dwight", g.getPlayer(0).id);
		
	}*/
	
	@Test
	public void testValidation(){//tests uniqueCards and validateCardName functions
		//tests card to see if card format is correct
		Input in = new Input();
		assertEquals(false, in.validateCardName("owkaasdf"));
		assertEquals(false, in.validateCardName("QowLaasdf"));
		assertEquals(false, in.validateCardName("wSaasdL"));
		assertEquals(false, in.validateCardName("oAceHearts"));
		assertEquals(false, in.validateCardName("AceHeartS"));
		assertEquals(false, in.validateCardName("KingKingClubs"));
		assertEquals(true, in.validateCardName("KingClubs"));
		//check for reuse of cards
		ArrayList<Hand> players = new ArrayList<Hand>();
		players.add(new Hand("Philip TwoSpades JackHearts AceDiamonds TwoDiamonds FourDiamonds"));
		players.add(new Hand("Din AceHearts KingHearts QueenHearts JackHearts TenHearts"));
		String[] str = {"Dy", "AceHearts", "KingHearts", "QueenHearts", "JackHearts", "TenHearts"};
		assertEquals(false, in.uniqueCards(str, players));
		String[] str2 = {"Dy", "KingSpades", "QueenSpades", "AceHearts", "TenSpades", "JackSpades"};
		assertEquals(false, in.uniqueCards(str2, players));
		String[] str3 = {"Dy", "SixHearts", "SevenHearts", "AceDiamonds", "TenDiamonds", "JackClubs"};
		assertEquals(false, in.uniqueCards(str3, players));
		//check for reuse of id
		String[] str4 = {"Din", "SixHearts", "SevenHearts", "AceDiamonds", "TenDiamonds", "JackClubs"};
		assertEquals(false, in.uniqueId(str4, players));
		String[] str5 = {"Philip", "SixHearts", "SevenHearts", "AceDiamonds", "TenDiamonds", "JackClubs"};
		assertEquals(false, in.uniqueId(str5, players));
	}

}
