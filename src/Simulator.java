import java.util.ArrayList;

//Simulator.java Class
//
//
// The Simulator Class is used to handle all the organisms that could be in a simulation
// This class is also what the GUI eventhandlers point to so that the user can control the program


public class Simulator {
	IO io;
	public Organism editing;
	public ArrayList<Organism> organisms;
	public int status;
	
	public Simulator() {
		io = new IO();
		this.status = 0; //Paused/Playing/Editing, 0,1,-1 respectively 
		this.organisms = new ArrayList<Organism>();
		this.editing = new Organism();
	}
	
	public void tick() {
		ArrayList<Organism> temp = new ArrayList<Organism>();
		for(int i = 0; i < organisms.size(); i++){
			if (this.organisms.get(i).alive == true){
				temp.add(this.organisms.get(i));
			}
		}
		for (int j = 0; j < temp.size(); j ++ ){
			temp.get(j).tick();
		}
		
		organisms = temp;
		//3 - detect collisions and adjust organism velocities	
	}
	
	
	//Methods for handling the IO for simulation states
	//The arraylist of organisms represents a simulation state
	public void loadState(String name) {
		organisms = io.read(name);
	}
	public void loadState() {
		organisms = io.read("Default");
	}
	public void saveState(String name) {
		io.write(organisms, name);
	}
	public void saveState() {
		io.write(organisms, "Default");
	}
	
	public void loadorg(String name){
		editing = io.loadorg(name);	
	}
	public void saveorg(String name){
		io.saveorg(editing, name);		
	}
	public void changeState() {
		if (this.status >= 0) {
			this.status = -1;
		}
		else {
			this.status = 0;
		}
	}
	public Organism makeOrg(int x,int y,ArrayList<Cell> cells,String name) {
		Organism t = new Organism(x,y,cells,name);
		return t;
	}
	public Organism makeOrg() {
		return new Organism();
	}
	public void addOrg() {
		organisms.add(editing);
	}
	public void addOrg(Organism t) {
		this.organisms.add(t);
	}
}