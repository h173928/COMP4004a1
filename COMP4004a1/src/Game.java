import java.util.ArrayList;
public class Game {
	private ArrayList<Hand> players = new ArrayList<Hand>();
	private int numPlayer;
	private Input input = new Input();
	Game(){
		while(true){
			numPlayer = input.promptNum();
			for(int i = 0; i < numPlayer; i++){
				players.add(new Hand(input.promptplayer(players)));
			}
			result();
			players = new ArrayList<Hand>();
		}
	}
	public void setNum(int n){
		numPlayer = n;
	}
	public void addPlayer(String str){
		players.add(new Hand(str));
	}
	public void sort(){//sort players by how good their hand is
		ArrayList<Hand> temp = players;
		players = new ArrayList<Hand>();
		int x = 0;
		while(temp.size() >= 1){
			for(int i = 0; i < temp.size(); i++){
				if(temp.get(x).getHand() > temp.get(i).getHand()){
					x = i;
				}else if (temp.get(x).getHand() == temp.get(i).getHand()){
					for(int j = 0; j < temp.get(x).determines.size(); j++){
						if(temp.get(x).determines.get(j) < temp.get(i).determines.get(j)){
							x = i;
							break;
						}else if(temp.get(x).determines.get(j) > temp.get(i).determines.get(j)){
							break;
						}
					}
				}
			}
			//check for ties
			if(players.size() > 0 && players.get(players.size() - 1).getHand() == temp.get(x).getHand()
					&& players.get(players.size() - 1).determines.size() == temp.get(x).determines.size()){
				for(int i = 0; i < temp.get(x).determines.size(); i++){
					if(players.get(players.size() - 1).determines.get(i) == temp.get(x).determines.get(i)){
						temp.get(x).rank = players.get(players.size() - 1).rank;
					} else {
						temp.get(x).rank = players.size() + 1;
					}
				}
			} else {
				temp.get(x).rank = players.size() + 1;
			}
			players.add(temp.get(x));
			temp.remove(x);
			x = 0;
		}
		//check for ties
		/*
		if(players.size() > 0 && players.get(players.size() - 1).getHand() == temp.get(0).getHand()
				&& players.get(players.size() - 1).determines.size() == temp.get(0).determines.size()){
			for(int i = 0; i < temp.get(0).determines.size(); i++){
				if(players.get(players.size() - 1).determines.get(i) == temp.get(0).determines.get(i)){
					temp.get(0).rank = players.get(players.size() - 1).rank;
				} else {
					temp.get(0).rank = players.size() + 1;
				}
			}
		} else {
			temp.get(0).rank = players.size() + 1;
		}
		players.add(temp.get(0));*/
	}
	public Hand getPlayer(int i){
		return players.get(i);
	}
	public void result(){
		sort();
		for(int i = 0; i < players.size(); i++){
			System.out.println(players.get(i).toString());
		}
	}
}
