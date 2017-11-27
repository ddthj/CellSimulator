import java.util.ArrayList;

//Simulator Class
//Manages the simulation of the organisms 

//TODO - finish tick() and methods for reading/writing individual organisms
//TODO - write methods for the editor state that the GUI can call

public class Simulator {
	
	public int status = 0; //Paused/Playing/Editing, 0,1,-1 respectively 
	public ArrayList<Organism> organisms;
	IO io = new IO();
	
	
	
	public void tick() {
		//1 - tick organisms
		//2 - remove dead organisms
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
	
	

}
