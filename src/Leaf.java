import java.util.ArrayList;

// Leaf.java Class
// 
//
// The Leaf Class extends Cell.java, it is one of the cells in the simulation
// The Leaf cell produces 1 energy per tick for every side not bordering another cell
//


public class Leaf extends Cell{
	
	public Leaf(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void tick(ArrayList<Cell>cells) {
		int total = 7;
		if (this.energy <= 0) {
			this.alive = false;
		}
		for(int i=0;i<cells.size();i++) {
			if(cells.get(i).x - 1 == this.x) {
				total--;
			}
			if(cells.get(i).x + 1 == this.x) {
				total--;
			}
			if(cells.get(i).y + 1 == this.y) {
				total--;
			}
			if(cells.get(i).y - 1 == this.y) {
				total--;
			}
		}
		this.energy+=total;
		super.tick();
	}
}
