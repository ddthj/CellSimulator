import java.io.Serializable;
import java.util.ArrayList;
//Cell.java Class
//
//
// The Cell is the basic building block used in every organism
// A default cell is always at the center of every organism, if the default cell dies the entire organism dies
// The default cell is also used as a structure cell as outlined in 7.12 of the user stories

@SuppressWarnings("serial")
public class Cell implements Serializable{
	public int energy = 100;
	public int consumption = 3;
	public boolean input;
	public boolean output;
	public boolean alive;
	public int x,y; //the offset from the center cell in an organism
	public double[] color = {0.5098039215686275,0.7647058823529412,0.8235294117647059};
	
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
