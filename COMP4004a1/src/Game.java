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
}
