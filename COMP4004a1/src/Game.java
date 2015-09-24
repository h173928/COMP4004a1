import java.util.ArrayList;
public class Game {
	private ArrayList<Hand> players = new ArrayList<Hand>();
	private int numPlayer;
	Game(){
		
	}
	public void setNum(int n){
		numPlayer = n;
	}
	public void addPlayer(String str){
		players.add(new Hand(str));
	}
	public void sort(){//sort players by how good their hand is
		System.out.println("here");
		ArrayList<Hand> temp = players;
		players = new ArrayList<Hand>();
		int x = 0;
		while(temp.size() > 1){
			for(int i = 0; i < temp.size(); i++){
				if(temp.get(x).getHand() > temp.get(i).getHand()){
					x = i;
				}
			}
			players.add(temp.get(x));
			temp.remove(x);
			x = 0;
		}
		players.add(temp.get(0));
		System.out.println(temp.size());
	}
	public Hand getPlayer(int i){
		return players.get(i);
	}
	/*public void result(){
		for(int i = 0; i < players.size(); i++){
			System.out.println(players.get(i).toString());
			System.out.println("Ranked "+ i);
		}
	}*/
}
