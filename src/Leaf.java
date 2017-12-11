import java.io.Serializable;
import java.util.ArrayList;

// Leaf.java Class
// 
//
// The Leaf Class extends Cell.java, it is one of the cells in the simulation
// The Leaf cell produces 1 energy per tick for every side not bordering another cell
//


@SuppressWarnings("serial")
public class Leaf extends Cell implements Serializable{
	
	public Leaf(int x, int y) {
		super(x, y);
		super.color = new double[] {0.403921568627451,0.8823529411764706,0.4274509803921569};
	}
	
	@Override
	public void tick(ArrayList<Cell>cells) {
		super.color =new double[] {0.403921568627451,0.8823529411764706,0.4274509803921569};
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
