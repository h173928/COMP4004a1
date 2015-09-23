import java.util.ArrayDeque;
import java.util.ArrayList;

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

					//populate determines array full
					if(twoPairs()){
						return true;
					} else if(threeOfAKind()){
						return true;
					}

					determines = new ArrayList<Integer>();
					hand = 9;
					determines.add(cards.get(i).getRank());
					ArrayList<Card> c = new ArrayList<Card>(5);
					for(int k = 0; k < 5; k++){
						if(cards.get(k).getRank() != determines.get(0)){
							c.add(cards.get(k));
						}
					}
					
					sortDet(c);
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
							c.add(cards.get(k));
						}
					}
					sortDet(c);
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
		return false;
		/*for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 5; j++){
				if (cards.get(i).getRank() == cards.get(j).getRank()){
					determines = new ArrayList<Integer>();
					hand = 9;
					determines.add(cards.get(i).getRank());

					//populate determines array full
					ArrayList<Card> c = new ArrayList<Card>(5);
					for(int k = 0; k < 5; k++){
						if(cards.get(k).getRank() != determines.get(0)){
							c.add(cards.get(k));
						}
					}
					sortDet(c);
					return true;
				}
			}
		}
		return false;*/
	}
	
	//for sorting determine ranks by what is looked at first for 1 pair and three of a kind
	public void sortDet(ArrayList<Card> c){
		while(c.size() != 1){
			int i = 0;
			for(int j = 1; j < c.size(); j++){
				if (c.get(i).getRank() < c.get(j).getRank()){
					i = j;
				}
				if (j == c.size() - 1){
					determines.add(c.get(i).getRank());
					c.remove(i);
				}
			}
		}
		//add the last cart
		determines.add(c.get(0).getRank());
		return;
	}
}
