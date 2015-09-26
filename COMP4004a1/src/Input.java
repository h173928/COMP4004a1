import java.util.ArrayList;
import java.util.Scanner;


public class Input {
	Input(){
		
	}
	public int promptNum(){
		int n = 1;
	    System.out.println("Please input number of players from 2~4 or 0 to exit:");
	    Scanner in = new Scanner(System.in);
	    if(in.hasNextInt()){
		    n = in.nextInt();
	    }
	    while(n < 2 || n > 4 ){
	    	if(n == 0){
	    		System.exit(0);
	    	}
	    	in.nextLine();
	    	System.out.println("Invalid input, please enter 2~4:");
		    if(in.hasNextInt()){
			    n = in.nextInt();
		    }
	    }
		return n;
	}

	public String promptplayer(ArrayList<Hand> players){
		boolean valid = false;
		boolean format = false;
		String str = null;
	    Scanner in = new Scanner(System.in);
		while(valid == false){
			System.out.println("Please enter player information: ");
			str = in.nextLine();
			String[] elements = str.split(" ");
			if(elements.length == 6){
				for(int i = 0; i < players.size(); i++){// check for id uniqueness
					if(elements[0].equals(players.get(i).id)){
						System.out.println("id already in use");
					}
				}//id is valid
				for(int i = 1; i < 6; i++){
					if(!validateCardName(elements[i])){
						System.out.println("Incorrect card format");
						format = false;
						break;
					} else if(i == 5){
						format = true;
					}
				}//cards are all in right format
				if(uniqueCards(elements, players) && format == true){
					System.out.println("cards are all unique");
					valid = true;
				}//cards are all unique
			} else {
				System.out.println("wrong number of strings");
			}
		}
		System.out.println("player checks out");
		return str;
	}
	public boolean uniqueCards(String[] str, ArrayList<Hand> players){
		//first check the new set of cards
		int pos = 1;
		while(pos < str.length - 1){
			for(int i = pos + 1; i < str.length; i++){
				if(str[pos] == str[i]){
					System.out.println("Duplicate in hand");
					return false;//duplicate cards within hand
				}
			}
			pos += 1;
		}
		for(int i = 0; i < players.size(); i++){
			for(int j = 1; j < str.length; j++){
				for(int k = 0; k < players.get(i).cards.size(); k++){
					if(str[j].equals(players.get(i).cards.get(k).toString())){
						System.out.println("Card already in game");
						return false;//card used more than once in game
					}
				}
			}
		}
		System.out.println("cards are unique");
		return true;
	}
	
	public boolean validateCardName(String str){// check to see of card is in right format
		String rank = null;
		String suit = null;
		boolean validRank = false;
		boolean validSuit = false;
		for(int i=str.length()-1; i>=0; i--) {
	        if(Character.isUpperCase(str.charAt(i))) {
	            rank = str.substring(0, i);
	            suit = str.substring(i, str.length());
	            break;
	        }
	    }
		if(rank == null || suit == null){//one of either is not set to a value
			return false;
		}
		if(rank.equals("Ace")){
			validRank = true;
		}else if(rank.equals("Two")){
			validRank = true;
		}else if(rank.equals("Three")){
			validRank = true;
		}else if(rank.equals("Four")){
			validRank = true;
		}else if(rank.equals("Five")){
			validRank = true;
		}else if(rank.equals("Six")){
			validRank = true;
		}else if(rank.equals("Seven")){
			validRank = true;
		}else if(rank.equals("Eight")){
			validRank = true;
		}else if(rank.equals("Nine")){
			validRank = true;
		}else if(rank.equals("Ten")){
			validRank = true;
		}else if(rank.equals("Jack")){
			validRank = true;
		}else if(rank.equals("Queen")){
			validRank = true;
		}else if(rank.equals("King")){
			validRank = true;
		}
		if(!validRank){//rank is not valid
			return false;
		}
		
		if(suit.equals("Hearts")){
			validSuit = true;
		}else if(suit.equals("Clubs")){
			validSuit = true;
		}else if(suit.equals("Diamonds")){
			validSuit = true;
		}else if(suit.equals("Spades")){
			validSuit = true;
		}
		if(!validSuit){//rank is not valid
			return false;
		}
		
		return true;//passes all test, valid format
	}
}
