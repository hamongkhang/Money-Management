package View;

import java.util.Optional;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class Customerview extends Stage {

	public Customerview(String name, String username) {
		UserDao user = new UserDaoImpl();
		Image title = new Image(getClass().getResourceAsStream("/arrow.png"));
		this.getIcons().add(new Image(getClass().getResourceAsStream("/user.png")));
		BorderPane bor = new BorderPane();
		Image home1 = new Image(getClass().getResourceAsStream("/home.png"));
		ImageView viewim = new ImageView(home1);
		bor.setPadding(new Insets(20, 20, 20, 20));
		VBox vbox = new VBox();
		viewim.setFitWidth(800);
		viewim.setFitHeight(400);

		Label from = new Label("WelCome Back " + name + "");
		from.setFont(new Font("times new roman", 30));

		Label home = new Label("Home");
		home.setFont(new Font("times new roman", 20));
		Label customer = new Label("Customer detail");
		customer.setFont(new Font("times new roman", 20));
		Label loan = new Label("Loan detail");
		loan.setFont(new Font("times new roman", 20));
		Label Emi = new Label("EMI Caculator");
		Emi.setFont(new Font("times new roman", 20));
		Label recive = new Label("");
		recive.setFont(new Font("times new roman", 20));
		Label term = new Label("                     ");

		ImageView Im = new ImageView(title);
		
		
		loan.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
		});
		

		HBox hb = new HBox();
		hb.getChildren().addAll(term, home, customer, loan, Emi, recive);

		hb.setSpacing(20);

		vbox.getChildren().addAll(viewim, from, hb);
		GridPane grid = new GridPane();
		Text t1 = new Text("Customer");
		t1.setId("fancytext");

		Text t = new Text("Welcome");
		t.setId("fancytext");
		bor.setCenter(t);
		t1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
		t.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
		grid.add(t1, 1, 3);
		grid.add(t, 0, 0);
		bor.setCenter(grid);

		home.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				// TODO Auto-generated method stub
				bor.setCenter(grid);

			}
		});
		GridPane g2 = new GridPane();
		Label la = new Label("Loan amount");
		TextField txla = new TextField();
		Label re = new Label("Revewal");
		TextField txre = new TextField();
		Label res = new Label("Result");
		TextField txres = new TextField();
		txres.setDisable(true);
		txres.setStyle("-fx-text-inner-color: red;");
		Button ok = new Button("OK");

		g2.add(la, 0, 0);
		g2.add(txla, 1, 0);
		g2.add(re, 0, 1);
		g2.add(txre, 1, 1);
		g2.add(res, 0, 3
				);
		g2.add(txres, 1, 3);
		g2.add(ok, 1, 4);
        g2.setPadding(new Insets(20,20,20,20));
        g2.setHgap(20);
        g2.setVgap(20);
        
        ObservableList<String> cities = FXCollections.observableArrayList("Business loan", "Person loan");
		ComboBox<String> tl = new ComboBox<String>(cities);
		Label type2 = new Label("Type");
		   g2.add(type2, 0, 2);
        g2.add(tl, 1, 2);
        
		ok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String chon=tl.getSelectionModel().getSelectedItem();
				if (!"".equals(la.getText())) {
					Double a = Double.valueOf(txla.getText());
					Double b = Double.valueOf(txre.getText());
					Double c=0.0;
					if(chon.equals("Business loan")==true) {
				     c =2.2 ;
				     if(chon.equals("Person loan")==true) {
					     c =5.3 ;
						
						}
					}
					Double d = (a * (c / 100) + a) / b;
					Double x = (double) (Math.round(d) * 100)/ 100;
					txres.setText(x.toString());
					
				}

			}
		});
		
		Emi.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(g2);

			}
		});

		this.getIcons().add(new Image(getClass().getResourceAsStream("/user (1).png")));
		VBox vb = new VBox();

		EmployeeManagementView a = new EmployeeManagementView(this);
		vb.getChildren().addAll(viewim, from, hb);

		bor.setTop(vb);
		// bor.setCenter(vb);

		Button profile = new Button("Reset Password");
		profile.setPrefWidth(120);

		profile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				new Resetpassword(username);

			}
		});

		UserDto us = user.getUserByUsername(username);
		Customer pro = new Customer(us);

		customer.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Customer pro = new Customer(us);
				bor.setCenter(pro);
			}
		});

		LoandetailView loand = new LoandetailView(us);

		loan.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(loand);
			}
		});

		Button MakeLoan = new Button("Make a Loan");
		MakeLoan.setPrefWidth(120);
		MakeLoan.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MakeLoan(username);
			}
		});
		Button Logout = new Button("Logout");
		Logout.setPrefWidth(120);
		VBox vb1 = new VBox();
		vb1.getChildren().addAll(profile, MakeLoan, Logout);
		vb1.setSpacing(10);
		Logout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Logout");
				alert.setGraphic(new ImageView(title));
				alert.setHeaderText(null);
				alert.setContentText("Do you want to logout?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

					Stage Home = new Home();
					Home.show();
					close();

				}
			}
		});
		
		
		
		
		
		
		
		
		ok.setPadding(new Insets(10,10,10,10));
		bor.setCenter(grid);

		bor.setLeft(vb1);

		Scene s = new Scene(bor, 1000, 1000);
		s.getStylesheets().add("Stylesheets.css");
		g2.getStyleClass().add("g2");
		ok.getStyleClass().add("g2");
		MakeLoan.getStyleClass().add("MakeLoan");
		Logout.getStyleClass().add("Logout");
		profile.getStyleClass().add("profile");
		bor.setCenter(grid);
		
		
		

		bor.getStyleClass().add("g2");
		this.setTitle("QN Bank(Customer) ");
		this.setScene(s);
		this.show();

	}
}
