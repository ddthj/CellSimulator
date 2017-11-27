import java.sql.Array;


//Organism Class
//Holds information about the organism for the Simulation to manipulate

//TODO - finish tick() method


public class Organism {
	public Array[][] cells; //cells in an organism are organized in a grid made of a 2D array
	public int x,y,vx,vy; //x and y coordinates, and velocities
	public int size; //used for collision detection
	public boolean alive = true;
	public String name;
	public boolean transparent; //used to turn off collision detection, may be removed
	
	public Organism(int x, int y,Array[][] cells,String name) {
		this.cells = cells;
		this.x = x;
		this.y = y;
		this.name = name;
		this.vx = 0;
		this.vy = 0;	//organisms start at rest
	}
	
	public void tick() {
		this.x += this.vx;
		this.y += this.vy;
		
		for(int i = 0; i<this.cells.length;i++) {
			for(int j = 0; j< this.cells.length;j++) {
				//TODO tick every cell in this array
				//this.cells[i][j].tick();
				
			}
		}
		
	}

}
