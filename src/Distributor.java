import java.util.ArrayList;

//Distributor.java Class
//
//
//The Distributor Class extends Cell.java, it is one of the cells in the simulation
//The Distributor cell distributes energy evenly across neighboring cells
//

public class Distributor extends Cell{
	public Distributor(int x, int y) {
		super(x, y);
	}
	@Override
	public void tick(ArrayList<Cell>cells) {
		int sum = 0 + this.energy;
		int num = 1;
		
		int extra = 0;
	
		if (this.energy <= 0) {
			this.alive = false;
		}
		//First pass find out the total energy of all cells surrounding the distributor (and how many cells are there)
		for(int i=0;i<cells.size();i++) {
			if(cells.get(i).x - 1 == this.x) {
				sum += cells.get(i).energy;
				num++;
			}
			if(cells.get(i).x + 1 == this.x) {
				sum += cells.get(i).energy;
				num++;
			}
			if(cells.get(i).y + 1 == this.y) {
				sum += cells.get(i).energy;
				num++;
			}
			if(cells.get(i).y - 1 == this.y) {
				sum += cells.get(i).energy;
				num++;
			}
		}
		
		int average = (int) sum / num; //Now we have the average energy of all the cells around us (including us)
		
		//second pass is going to remove extra energy from the cells that are above the average
		if (this.energy > average) {
			extra += (average - this.energy);
			this.energy -= (average - this.energy);
		}
		for(int i=0;i<cells.size();i++) {
			if(cells.get(i).x - 1 == this.x) {
				if (cells.get(i).energy > average) {
					extra += (average - cells.get(i).energy);
					cells.get(i).energy -= (average - cells.get(i).energy);
				}
			}
			if(cells.get(i).x + 1 == this.x) {
				if (cells.get(i).energy > average) {
					extra += (average - cells.get(i).energy);
					cells.get(i).energy -= (average - cells.get(i).energy);
				}
			}
			if(cells.get(i).y + 1 == this.y) {
				if (cells.get(i).energy > average) {
					extra += (average - cells.get(i).energy);
					cells.get(i).energy -= (average - cells.get(i).energy);
				}
			}
			if(cells.get(i).y - 1 == this.y) {
				if (cells.get(i).energy > average) {
					extra += (average - cells.get(i).energy);
					cells.get(i).energy -= (average - cells.get(i).energy);
				}
			}
		}
		
		//third pass adds the extra energy back to the cells that are below average until there is no extra energy left
		while (extra > 0) {
			for(int i=0;i<cells.size();i++) {
				if(cells.get(i).x - 1 == this.x && extra > 0) {
					if (cells.get(i).energy < average) {
						extra -= 1;
						cells.get(i).energy += 1;
					}
				}
				if(cells.get(i).x + 1 == this.x && extra > 0) {
					if (cells.get(i).energy < average) {
						extra -= 1;
						cells.get(i).energy += 1;
					}
				}
				if(cells.get(i).y + 1 == this.y && extra > 0) {
					if (cells.get(i).energy < average) {
						extra -= 1;
						cells.get(i).energy += 1;
					}
				}
				if(cells.get(i).y - 1 == this.y && extra > 0) {
					if (cells.get(i).energy < average) {
						extra -= 1;
						cells.get(i).energy += 1;
					}
				}
			}
		}
		
		super.tick();
	}

}
