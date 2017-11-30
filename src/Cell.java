import java.util.ArrayList;



//Cell.java Class
//
//
// The Cell is the basic building block used in every organism
// A default cell is always at the center of every organism, if the default cell dies the entire organism dies
// The default cell is also used as a structure cell as outlined in 7.12 of the user story

public class Cell {
	public int energy = 100;
	public int consumption = 3;
	public boolean input;
	public boolean output;
	public boolean alive;
	public int x,y; //the offset from the center cell in an organism
	
	public Cell(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public void tick(ArrayList<Cell> cells) {
		this.energy-=this.consumption;
	}
	public void tick() {
		this.energy-=this.consumption;
	}
}
