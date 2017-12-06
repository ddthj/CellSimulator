import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
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
	double x,y = 0;
	Label info;
	BorderPane pane;
	GridPane grid;
	GridPane editor;
	String eCell;
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
	TextField txt = new TextField("Default");
	String square = "-fx-min-width: 30px; " + "-fx-min-height: 30px; " + "-fx-max-width: 30px; " + "-fx-max-height: 30px;";
	
	Button cellButton = new Button();
	Button leafButton = new Button();
	Button disButton = new Button();
	
	
	public GUI(){		
		file.getItems().addAll(loadState,saveState,loadOrganism,saveOrganism);
		editMenu.getItems().addAll(edit);
		menu.getMenus().addAll(file,editMenu);
		
		pane = new BorderPane();
		pane.setBottom(txt);
		pane.setTop(menu);
		
		cellButton.setStyle("-fx-base: #82c3d2;" + square);
		leafButton.setStyle("-fx-base: #67e16d;" + square);
		disButton.setStyle("-fx-base: #ad6756;" + square);
		
		grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(cellButton,0,0);
		grid.add(leafButton,0,1);
		grid.add(disButton,1,0);
		grid.setAlignment(Pos.CENTER);
		grid.setVisible(false);
		
		pane.setLeft(grid);
		
		editor = new GridPane();
		editor.setGridLinesVisible(true);
		
		info = new Label();
		info.setLayoutX(0);
		info.setLayoutY(0);
		info.setText("test");
		info.setVisible(true);		
		
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
		edit.setOnAction(e -> {sim.changeState();System.out.println(sim.status); this.editor();});
		
		info.setOnMouseMoved(e -> {x = e.getX(); y = e.getY(); info.setLayoutX(x); info.setLayoutY(y);});
		
		cellButton.setOnAction(e -> {eCell = "cell";});
		cellButton.setOnMouseEntered(e -> {info.setVisible(true);info.setText("testing testing 123!");info.setStyle("-fx-base: #82c3d2;");});
		leafButton.setOnAction(e -> {eCell = "leaf";});
		disButton.setOnAction(e -> {eCell = "dis";});
		
		stage.setScene(scene);
		stage.show();	
	}
	public static void main(String[] args) {
		launch(); // just opens up a blank pane right now
	}
	
	public void editor(){
		if (sim.status == -1){
			grid.setVisible(true);
			editor.setVisible(true);
		}
		else{
			editor.setVisible(false);
			grid.setVisible(false);
			eCell = null;
		}
	}
}
