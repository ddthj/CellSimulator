import java.sql.Array;
import java.util.ArrayList;


//Organism.java Class
//
//
// The Organism class holds all the variables that the simulation needs to simulate the Organism
// The Organism is made of multiple cells that interact to produce more energy than they consume
// All the cells in an Organism are updated when the Organism.tick() method is called



public class Organism {
	public ArrayList<Cell> cells; //cells in an organism are organized in a grid made of a 2D array
	public int x,y,vx,vy; //x and y coordinates, and velocities
	public int size; //used for collision detection
	public boolean alive = true;
	public String name;
	public boolean transparent; //used to turn off collision detection, may be removed
	
	public Organism(){
		this.cells = new ArrayList<Cell>();
		this.cells.add(new Cell(0, 0));
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
	
	//updates all cells, and kills the organism if the host/main cell is dead
	public void tick() {
		this.x += this.vx;
		this.y += this.vy;
		for(int i = 0; i < this.cells.size();i++){
			this.cells.get(i).tick(this.cells);
			if (this.cells.get(i).x == 0 && this.cells.get(i).y == 0 && this.cells.get(i).alive == false ) {
				this.alive = false;
			}
		}
		
	}
	
	public void addCell(Cell cell, int x, int y){
		boolean flag = false;
		for(int i = 0; i < this.cells.size();i++){
			if (this.cells.get(i).x + 1 == x || this.cells.get(i).x - 1 == x || this.cells.get(i).y - 1 == y || this.cells.get(i).y + 1 == y){
				flag = true;
			}
		}
		if (flag) {
			this.cells.add(cell);
		}
		
	}
	
	public void removeCell(int x, int y) {
		//TODO
		//This method will only allow a cell to be removed if no other cells rely on it as a structure to the host cell
	}

}
