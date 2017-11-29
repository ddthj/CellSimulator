import java.sql.Array;
import java.util.ArrayList;


//Organism Class
//Holds information about the organism for the Simulation to manipulate

//TODO - finish tick() method


public class Organism {
	public ArrayList<Cell> cells; //cells in an organism are organized in a grid made of a 2D array
	public int x,y,vx,vy; //x and y coordinates, and velocities
	public int size; //used for collision detection
	public boolean alive = true;
	public String name;
	public boolean transparent; //used to turn off collision detection, may be removed
	
	public Organism(){
		this.cells = new ArrayList<Cell>();
		this.cells.add(new Cell(10, 0, 0));
		this.x = 0;
		this.y = 0;
		this.name = "Default";
		this.vx=0;
		this.vy=0;
	}
	
	public Organism(int x, int y,ArrayList<Cell> cells,String name) {
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
		for(int i = 0; i < this.cells.size();i++){
			this.cells.get(i).tick(this.cells);
		}
		
	}
	
	public void addCell(Cell cell, int x, int y){
		for(int i = 0; i < this.cells.size();i++){
			if (this.cells.get(i).x + 1 == x || this.cells.get(i).x - 1 == x){
				//todo
			}
		}
		
	}

}
