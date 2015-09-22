import java.util.Arrays;
public class Deck {
	Card[] cards = new Card[52];
	Deck(){
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				cards[i*13 + j] = new Card(suits[i], j);
			}
		}
	}
	public String toString(){
		return Arrays.toString(cards);
	}
	/*public Card draw(){
		return cards[0];
	}*/
}
