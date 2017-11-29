import java.util.ArrayList;

//Simulator Class
//Manages the simulation of the organisms 

//TODO - finish tick() and methods for reading/writing individual organisms
//TODO - write methods for the editor state that the GUI can call

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
	public void saveorg(Organism temp, String name){
		io.saveorg(temp, name);		
	}
	
	

}
