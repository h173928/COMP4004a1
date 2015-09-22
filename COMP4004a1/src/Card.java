
public class Card {
	String rank;
	String suit;
	Card(String s, int n){
		if(n == 0){
			rank = "Ace";
		}else if(n == 1){
			rank = "Two";
		}else if(n == 2){
			rank = "Three";
		}else if(n == 3){
			rank = "Four";
		}else if(n == 4){
			rank = "Five";
		}else if(n == 5){
			rank = "Six";
		}else if(n == 6){
			rank = "Seven";
		}else if(n == 7){
			rank = "Eight";
		}else if(n == 8){
			rank = "Nine";
		}else if(n == 9){
			rank = "Ten";
		}else if(n == 10){
			rank = "Jack";
		}else if(n == 11){
			rank = "Queen";
		}else if(n == 12){
			rank = "King";
		}
		suit = s;
	}
	public String toString(){
		return rank + suit;
	}
}
