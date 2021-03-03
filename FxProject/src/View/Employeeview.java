package View;

import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class Employeeview extends Stage {

	public Employeeview(String user) {
		
	Image title= new Image(getClass().getResourceAsStream("/arrow.png"));
		BorderPane bor = new BorderPane();

		bor.getStyleClass().add("text");

		Text FormAdmin = new 	Text("         Welcome back "+user);
		FormAdmin.setId("fancytext");
		FormAdmin.setFont(Font.font("Helvetica", FontPosture.ITALIC, 25));
	

		
		GridPane grid =new GridPane();
		Text t1 = new Text("");
		t1.setId("fancytext");

		Text t = new Text("Welcome");
		t.setId("fancytext");
		bor.setCenter(t);
		t1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
		t.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
		grid.add(t1, 1, 2);
		grid.add(t, 0, 0);
		
		
		Label from = new Label("WelCome Back " + user + "");
		from.setFont(new Font("times new roman",30));

		Label home = new Label("Home");
		home.setFont(new Font("times new roman",20));
		Label customer = new Label("Customer detail");
		customer.setFont(new Font("times new roman",20));
		Label loan = new Label("Loan detail");
		loan.setFont(new Font("times new roman",20));
		Label Emi = new Label("");
		 Emi.setFont(new Font("times new roman",20));
		Label recive = new Label("");
		recive.setFont(new Font("times new roman",20));
		Label term = new Label("                     ");

		ImageView Im = new ImageView(title);

		HBox hb = new HBox();
		hb.getChildren().addAll(term,home, customer, loan, Emi, recive);
		
		hb.setSpacing(20);
		
		VBox vb2=new VBox();
		
		
		loan.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				VBox a= new Checkloan();
				bor.setCenter(a);
			}
		});
		
		
		
		home.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(grid);
			

			}
		});
		

		
		this.getIcons().add(new Image(getClass().getResourceAsStream("/user (1).png")));
		VBox vb= new VBox();
		vb2.getChildren().addAll(FormAdmin,hb);
		bor.setTop(vb2);

		EmployeeManagementView a = new EmployeeManagementView(this);
		vb.getChildren().add(a);
		//bor.setCenter(vb);
		
		bor.setCenter(grid);
		
		
		
		customer.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(vb);
				
			}
		});
		ListView<String> list = new ListView<String>();
		list.setPrefWidth(100);
		Label out=new Label("Logout");
		ObservableList<String> items = FXCollections.observableArrayList("Admin","Logout");
		list.setItems(items);
		
		
		list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				
					System.out.println("value: " + newValue);
					if ("0".equals(newValue.toString())) {
					bor.setCenter(vb);
				a.setVisible(true);
					System.out.println("visable");
					} 
					if ("1".equals(newValue.toString())) {
						
						
						
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Logout");
							alert.setGraphic(new ImageView(title));
							alert.setHeaderText(null);
							alert.setContentText("Do you want to logout?");
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								
								
								Stage Home=new Home();
								Home.show();
								close();

							}
						
				
					
			
					//vbox1.setVisible(true);
					} 
			}
			

		});
	
		
		bor.setLeft(list);
		
	

		Scene s = new Scene(bor,1000,600);

		s.getStylesheets().add("Stylesheets.css");
		
	//	s.getStylesheets().add("text.css");
		this.setTitle("QN Bank ");
		this.setScene(s);
		this.show();
	

		}
	}
