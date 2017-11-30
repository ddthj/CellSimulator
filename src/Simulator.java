import java.util.ArrayList;

//Simulator.java Class
//
//
// The Simulator Class is used to handle all the organisms that could be in a simulation
// This class is also what the GUI eventhandlers point to so that the user can control the program


public class Simulator {
	
	public int status = 0; //Paused/Playing/Editing, 0,1,-1 respectively 
	public ArrayList<Organism> organisms;
	public Organism editing;
	IO io = new IO();
	
	
	
	public void tick() {
		ArrayList<Organism> temp = new ArrayList<Organism>();
		for(int i = 0; i < this.organisms.size(); i++){
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
}
