import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarReemplazarApp extends Application {

	private TextField buscarText, reemplazarText;
	private Button buscar, reemplazar, reemplazarTodo, cerrar, ayuda;
	private CheckBox box1, box2, box3, box4;


	@Override
	public void start(Stage primaryStage) throws Exception {
		//Text
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		//Buttons
		buscar = new Button("Buscar");
		reemplazar = new Button("Reemplazar");
		reemplazarTodo = new Button("Reemplazar todo");
		cerrar = new Button("Cerrar");
		ayuda = new Button("Ayuda");
		
		//Buttons sizes
		buscar.setMinWidth(110);
		reemplazar.setMinWidth(110);
		reemplazarTodo.setMinWidth(110);
		cerrar.setMinWidth(110);
		ayuda.setMinWidth(110);
		
		//GridPane
		GridPane root = new GridPane();
		
		//Aside buttons
		VBox aside = new VBox(buscar, reemplazar, reemplazarTodo, cerrar, ayuda);
		aside.setSpacing(4);
		aside.setPadding(new Insets(5, 5, 5, 5));

		//Button CheckBoxs
		box1 = new CheckBox();
		box2 = new CheckBox();
		box3 = new CheckBox();
		box4 = new CheckBox();

		HBox checkBoxTopLeft = new HBox(5, box1, new Label("Mayúsculas y minúsculas"));
		HBox checkBoxTopRight = new HBox(5, box2, new Label("Buscar hacia atrás"));
		HBox checkBoxBottomLeft = new HBox(5, box3, new Label("Expresion regular"));
		HBox checkBoxBottomRight = new HBox(5, box4, new Label("Expresion regular"));
		
	
		GridPane principal = new GridPane();
		principal.setGridLinesVisible(false);
		principal.setPadding(new Insets(5));
		principal.setHgap(5);
		principal.setVgap(5);
		principal.addRow(0, new Label("Buscar: "));
		principal.addRow(1, new Label("Reemplazar con: "));
		principal.add(reemplazarText, 1, 1, 2, 1);
		principal.add(buscarText, 1, 0, 2, 1);
	
		
		principal.add(checkBoxTopLeft, 1, 2);
		principal.add(checkBoxBottomLeft, 1, 3);
		principal.add(checkBoxTopRight, 2, 2);
		principal.add(checkBoxBottomRight, 2, 3);
		
		ColumnConstraints[] cols = { 
				new ColumnConstraints(), 
				new ColumnConstraints(), 
				new ColumnConstraints(),
				};

		principal.getColumnConstraints().setAll(cols);
		cols[0].setMinWidth(45);
		cols[0].setMaxWidth(200);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setPercentWidth(55); 
		cols[2].setPercentWidth(30); 
		
		
		BorderPane panel = new BorderPane();
		panel.setCenter(principal);
		panel.setRight(aside);
		root.add(panel, 0, 0);

		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(new Scene(root, 550, 220));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
