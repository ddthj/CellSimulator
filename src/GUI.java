import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//GUI.java Class
//
//
// The GUI class extends application and is where the program is run frun
// It renders a representation of the simulation to the screen for the viewer and allowes the user to interact with the simulation

//TODO - editor mode graphics and buttons
//	   - play/pause buttons in sim mode
//


public class GUI extends Application{
	BorderPane pane;
	VBox center = new VBox();
	Simulator sim = new Simulator();
	MenuBar menu = new MenuBar();
	Menu file = new Menu("File");
	Menu editMenu = new Menu("Edit");
	MenuItem loadState = new MenuItem("Load State");
	MenuItem saveState = new MenuItem("Save State");
	MenuItem loadOrganism = new MenuItem("Load Organism");
	MenuItem saveOrganism = new MenuItem("Save Organism");
	MenuItem edit = new MenuItem("Editor Mode");
	TextField txt = new TextField();
	
	public GUI(){
		
		
		file.getItems().addAll(loadState,saveState,loadOrganism,saveOrganism);
		editMenu.getItems().addAll(edit);
		menu.getMenus().addAll(file,editMenu);
		
		pane = new BorderPane();
		pane.setBottom(txt);
		pane.setTop(menu);
		//sim.loadState(); //loads the default state, which currently throws an error (that is caught) since there is no file for the default state
	}
	
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(pane,1000,500);
		stage.setScene(scene);
		stage.setTitle("CellSim");
		loadState.setOnAction(e -> {sim.loadState(txt.getText());});
		saveState.setOnAction(e -> {sim.saveState(txt.getText());});
		loadOrganism.setOnAction(e -> {sim.loadorg(txt.getText());});
		saveOrganism.setOnAction(e -> {sim.saveorg(txt.getText());});
		edit.setOnAction(e -> {sim.changeState();System.out.println(sim.status);});
		
		stage.setScene(scene);
		stage.show();	
	}
	public static void main(String[] args) {
		launch(); // just opens up a blank pane right now
	}
}
