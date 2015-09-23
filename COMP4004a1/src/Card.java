
public class Card {
	String rank;
	String suit;
	Card(String s){
		for(int i=s.length()-1; i>=0; i--) {
	        if(Character.isUpperCase(s.charAt(i))) {
	            rank = s.substring(0, i);
	            suit = s.substring(i, s.length());
	            break;
	        }
	    }
	}
	public String toString(){
		return rank + suit;
	}
	
	public int getRank(){

		if(rank.equals("Ace")){
			return 14;
		}else if(rank.equals("Two")){
			return 2;
		}else if(rank.equals("Three")){
			return 3;
		}else if(rank.equals("Four")){
			return 4;
		}else if(rank.equals("Five")){
			return 5;
		}else if(rank.equals("Six")){
			return 6;
		}else if(rank.equals("Seven")){
			return 7;
		}else if(rank.equals("Eight")){
			return 8;
		}else if(rank.equals("Nine")){
			return 9;
		}else if(rank.equals("Ten")){
			return 10;
		}else if(rank.equals("Jack")){
			return 11;
		}else if(rank.equals("Queen")){
			return 12;
		}else{
			return 13;
		}
	}
}
