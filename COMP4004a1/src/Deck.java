import java.util.*;
public class Deck {
	ArrayDeque deck = new ArrayDeque<Card>();
	Deck(){
		Card[] cards = new Card[52];
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				cards[i*13 + j] = new Card(suits[i], j);
			}
		}
		shuffleDeck(cards);//randomize the deck
		
		for(int i = 0; i < 52; i++){
			deck.add(cards[i]);			
		}
	}
	public String toString(){
		return Arrays.toString(deck.toArray());
	}
	static void shuffleDeck(Card[] ar){
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Card a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	}
	/*public Card draw(){
		return cards[0];
	}*/
}
