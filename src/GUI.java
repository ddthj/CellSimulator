import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//GUI Class
//Renders a representation of the simulation to the screen for the viewer

//TODO - get stuff to render

public class GUI extends Application{
	private Pane pane;	
	
	public GUI(){
		pane = new Pane();
		Simulator sim = new Simulator();
		sim.loadState(); //loads the default state
		
	}
	
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(pane,1000,500);
		stage.setScene(scene);
		stage.setTitle("CellSim");
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(); // just opens up a blank pane right now
	}

}
