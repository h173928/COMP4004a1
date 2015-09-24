import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
	String id;
	ArrayList<Card> cards = new ArrayList<Card>(5);
	//Card[] cards = new Card[5];
	ArrayList<Integer> determines = new ArrayList<Integer>();//determines winner when two hands are similar ie. two flushes
	int hand; //Royal flush is 1, straight flush is 2 and so on
	Hand(String s){
		String[] elements = s.split(" ");
		id = elements[0];
		for(int i = 1; i < 6; i++){
			cards.add(new Card(elements[i]));
		}
		sort();
		for(int i = 0; i < 5; i++){
			determines.add(cards.get(i).getRank());
		}
		if(pair()){
			
		}else{
			for(int i = 0; i < cards.size(); i++){
				determines.add(cards.get(i).getRank());
			}
			hand = 10;
		}
	}
	public void sort(){//sort from large to small
		ArrayDeque c = new ArrayDeque<Card>();
		int size = 5;
		while(size != 0){
			int i = 0;
			for(int j = 1; j < size; j++){
				if (cards.get(i).getRank() < cards.get(j).getRank()){
					i = j;
				}
				if (j == size - 1 ){
					c.addLast(cards.get(i));
					cards.remove(i);
				}
			}
			size = size - 1;
		}
		//add the last cart
		c.addLast(cards.get(0));
		cards.remove(0);
		//re-populate cards
		while( c.size() != 0){
			cards.add((Card)c.removeFirst());
		}
		return;
	}
	public boolean pair(){

		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 5; j++){
				if (cards.get(i).getRank() == cards.get(j).getRank()){

					determines = new ArrayList<Integer>();
					hand = 9;
					determines.add(cards.get(i).getRank());
					//populate determines array full
					if(twoPairs()){
						return true;
					} 
					ArrayList<Card> c = new ArrayList<Card>(5);
					for(int k = 0; k < 5; k++){
						if(cards.get(k).getRank() != determines.get(0)){
							determines.add(cards.get(k).getRank());
						}
					}
					
					return true;
				}
			}
		}
		return false;
	}
	

	public boolean threeOfAKind(){
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 4; j++){//since cards are sorted by rank, they should be one after another
				if (cards.get(i).getRank() == cards.get(j).getRank() && 
						cards.get(i).getRank() == cards.get(j + 1).getRank()){

					determines = new ArrayList<Integer>();
					determines.add(cards.get(i).getRank());
					if(fourOfAKind()){
						return true;
					}else if(fullHouse()){
						return true;
					}
					hand = 7;

					//populate determines array full
					ArrayList<Card> c = new ArrayList<Card>(5);
					for(int k = 0; k < 5; k++){
						if(cards.get(k).getRank() != determines.get(0)){
							determines.add(cards.get(k).getRank());
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean fourOfAKind(){
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 3; j++){//since cards are sorted by rank, they should be one after another
				if (cards.get(i).getRank() == cards.get(j).getRank() && 
						cards.get(i).getRank() == cards.get(j + 1).getRank() &&
						cards.get(i).getRank() == cards.get(j + 2).getRank()){
					
					
					determines = new ArrayList<Integer>();
					hand = 3;
					determines.add(cards.get(i).getRank());
					return true;
				}
			}
		}
		return false;
	}
	public boolean fullHouse(){
		ArrayList<Card> c = new ArrayList<Card>(5);
		for(int k = 0; k < 5; k++){
			if(cards.get(k).getRank() != determines.get(0)){
				c.add(cards.get(k));
			}
		}
		if(c.get(1).getRank() == c.get(0).getRank()){
			hand = 4;
			return true;
		}
		return false;
	}
	public boolean twoPairs(){
		ArrayList<Card> c = new ArrayList<Card>();
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i).getRank() != determines.get(0)){
				c.add(cards.get(i));
			}
		}
		if(c.size() < 3){//three of a kind or above
			threeOfAKind();
			return true;
		}
		for(int i = 0; i < 2; i++){
			for(int j = i + 1; j < 3; j++){
				if (c.get(i).getRank() == c.get(j).getRank()){
					hand = 8;
					determines.add(c.get(i).getRank());
					if(threeOfAKind()){
						return true;
					}
					//populate determines array full
					ArrayList<Card> h = new ArrayList<Card>();
					for(int k = 0; k < 3; k++){
						if(c.get(k).getRank() != determines.get(1)){
							determines.add(c.get(k).getRank());
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	

}
