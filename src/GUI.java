import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//GUI.java Class
//
//
// The GUI class extends application and is where the program is run frun
// It renders a representation of the simulation to the screen for the viewer and allowes the user to interact with the simulation

//TODO - editor mode graphics
//	  



public class GUI extends Application{
	Simulator sim;
	double x,y = 0;
	Label info;
	BorderPane pane;
	GridPane grid;
	GridPane editor;
	String eCell;
	HBox bottom = new HBox();
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
	
	Pane simPane = new Pane();
	
	Button cellButton = new Button();
	Button leafButton = new Button();
	Button disButton = new Button();
	
	Button playButton = new Button();
	
	Rectangle tc;
	
	
	public GUI(){	
		sim = new Simulator();
		file.getItems().addAll(loadState,saveState,loadOrganism,saveOrganism);
		editMenu.getItems().addAll(edit);
		menu.getMenus().addAll(file,editMenu);
		
		pane = new BorderPane();
		
		pane.setTop(menu);
		
		cellButton.setStyle("-fx-base: #82c3d2;" + square);
		leafButton.setStyle("-fx-base: #67e16d;" + square);
		disButton.setStyle("-fx-base: #ad6756;" + square);
		
		playButton.setStyle("-fx-base: #67e16d;" + square);
		
		bottom.getChildren().addAll(txt,playButton);
		pane.setBottom(bottom);
		
		grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(cellButton,0,0);
		grid.add(leafButton,0,1);
		grid.add(disButton,1,0);
		grid.setAlignment(Pos.CENTER);
		grid.setVisible(false);
		
		pane.setLeft(grid);
		pane.setCenter(simPane);
		
		editor = new GridPane();
		editor.setGridLinesVisible(true);
		
		info = new Label();
		info.setLayoutX(0);
		info.setLayoutY(0);
		info.setText("test");
		info.setVisible(true);		
		
		sim.loadState();
		sim.loadorg("Default");
		
	}
	
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(pane,1000,500);
		stage.setScene(scene);
		stage.setTitle("CellSim");
		loadState.setOnAction(e -> {sim.status = 0;sim.loadState(txt.getText());});
		saveState.setOnAction(e -> {sim.status = 0;sim.saveState(txt.getText());});
		loadOrganism.setOnAction(e -> {sim.status = 0;sim.loadorg(txt.getText());});
		saveOrganism.setOnAction(e -> {sim.status = 0;sim.saveorg(txt.getText());});
		edit.setOnAction(e -> {sim.changeState();System.out.println(sim.status); this.editor();});
		
		info.setOnMouseMoved(e -> {x = e.getX(); y = e.getY(); info.setLayoutX(x); info.setLayoutY(y);});
		
		cellButton.setOnAction(e -> {eCell = "cell";});
		cellButton.setOnMouseEntered(e -> {info.setVisible(true);info.setText("testing testing 123!");info.setStyle("-fx-base: #82c3d2;");});
		leafButton.setOnAction(e -> {eCell = "leaf";});
		disButton.setOnAction(e -> {eCell = "dis";});
		playButton.setOnAction(e -> {if (sim.status <= 0) {sim.status = 1;} else {sim.status = 0;}});
		
		new AnimationTimer() {
			public void handle(long currentNanotime) {
				if (sim.status == 1) {
					simPane.getChildren().clear();;
					sim.tick();
					for(int i = 0;i<sim.organisms.size();i++) {
						for(int j = 0; j<sim.organisms.get(i).cells.size();j++) {
							tc = new Rectangle((sim.organisms.get(i).cells.get(j).x * 20)-10,(sim.organisms.get(i).cells.get(j).y * 20)-10,20,20);
							Color tmp = new Color(sim.organisms.get(i).cells.get(j).color[0],sim.organisms.get(i).cells.get(j).color[1],sim.organisms.get(i).cells.get(j).color[2],1);
		
							tc.setFill(tmp);
							
							simPane.getChildren().add(tc);
							
						}											
					}
				}
				
			}
		}.start();
		
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
