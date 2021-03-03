package View;

import java.util.Optional;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class Cview extends Stage {

	public Cview(String name, String username) {
		UserDao user = new UserDaoImpl();
		BorderPane bor = new BorderPane();
		// Image title = new Image(getClass().getResourceAsStream("/arrow.png"));
		this.getIcons().add(new Image(getClass().getResourceAsStream("/user.png")));

		bor.setPadding(new Insets(20, 20, 20, 20));

		//

		Image home1 = new Image(getClass().getResourceAsStream("/home.png"));

		MenuBar mb = new MenuBar();
		Menu home = new Menu("Home");
		Menu customer = new Menu("Pay EMI detail");
		Menu loan = new Menu("Loan EMI detail");
		Menu Emi = new Menu("About us");
		Menu recive = new Menu("Contactus");

		mb.getMenus().addAll(home, loan, customer, Emi, recive);
		VBox vbox = new VBox();
		GridPane grid = new GridPane();
		ImageView viewim = new ImageView(home1);
		viewim.setFitWidth(800);
		viewim.setFitHeight(400);
		vbox.getChildren().addAll(viewim, mb);
		bor.setTop(vbox);
		mb.setPadding(new Insets(5, 5, 5, 5));
		grid.setHgap(20);
		grid.setVgap(20);
		bor.setPadding(new Insets(10, 10, 10,10));
	

		String family = "Helvetica";
		Text t = new Text("Welcome");
		t.setId("fancytext");
		grid.add(t, 0, 0);
		grid.setAlignment(Pos.CENTER);
		Text t1 = new Text("Customer");
		t1.setId("fancytext");
		t.setId("fancytext");

		t1.setFont(Font.font(family, FontPosture.ITALIC, 40));
		t.setFont(Font.font(family, FontPosture.ITALIC, 40));

		grid.add(t1, 1, 2);

		this.getIcons().add(new Image(getClass().getResourceAsStream("/user (1).png")));

//		Label profile = new Label("Reset Password");
//		grid.add(profile,1,4);
//		profile.setPrefWidth(100);
//		
		UserDto us = user.getUserByUsername(username);
		Customer pro = new Customer(us);

		customer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				bor.setCenter(pro);

			}
		});

		LoandetailView loand = new LoandetailView(us);

		loan.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				bor.setCenter(loand);

			}
		});
		ListView<String> list = new ListView<>();
		list.setPrefWidth(200);
		ObservableList<String> items = FXCollections.observableArrayList("Make a Loan", "Change Password", "Logout");
		list.setItems(items);

		bor.setLeft(list);
		// Label MakeLoan = new Label("Make a Loan");
		Button menu = new Button("Menu List");
		// grid.add(MakeLoan,1,3);
		// MakeLoan.setPrefWidth(100);
		VBox vb1 = new VBox();

		vb1.getChildren().addAll(menu, list);
		menu.setPrefWidth(200);
		vb1.setPadding(new Insets(5, 0, 0, 0));
		bor.setLeft(vb1);
		bor.setCenter(grid);
		Scene s = new Scene(bor,800,700);
		list.setPrefHeight(80);
		s.getStylesheets().add("Stylesheets.css");

		this.setTitle("QN Bank(Customer) ");
		this.setScene(s);
		this.show();

	}
}
