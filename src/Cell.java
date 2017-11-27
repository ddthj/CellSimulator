

//Cell Class
//Holds information about individual cells in an organism

public class Cell {
	public int energy = 100;
	public int consumption;
	public boolean input;
	public boolean output;
	public boolean alive;
	public int x,y; //the index of the cell in the organism
	
	public Cell(int c,int x,int y) {
		this.consumption = c;
		this.x = x;
		this.y = y;
	}
	public void tick() {
		this.energy-=this.consumption;
	}

}
