package View;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Home extends Stage {

	public Home() {
		BorderPane border = new BorderPane();

		GridPane grid = new GridPane();
		Image home = new Image(getClass().getResourceAsStream("/home1.png"));
		Image Imuser = new Image(getClass().getResourceAsStream("/user.png"));
		Image a = new Image(getClass().getResourceAsStream("/home.png"));
		Image money = new Image(getClass().getResourceAsStream("/5.jpg"));

		grid.setVgap(20);
		grid.setHgap(20);
		grid.setPadding(new Insets(20, 20, 20, 20));
		// grid.setPadding(new Insets(10, 15, 10, 30));
		Label form = new Label("LOAN MANAGEMENT SYSTEM ");
		form.setFont(new Font("times new roman", 50));
		form.setTextFill(Color.web("#0076a3"));
		Reflection r = new Reflection();

		r.setFraction(1);
		form.setEffect(r);

		grid.setVgap(20);
		grid.setHgap(20);

		Label contact = new Label("Contact us");
		contact.setFont(new Font("times newroman", 20));
		contact.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				close();
				new Contactus();

			}
		});

		Label Homeb = new Label("Home");
		Homeb.setFont(new Font("times newroman", 20));
		Homeb.setGraphic(new ImageView(home));

		Homeb.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				border.setCenter(grid);

			}
		});
		Label abusb = new Label("About us");
		abusb.setFont(new Font("times newroman", 20));
		abusb.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Aboutus a = new Aboutus();
				StackPane stack = new StackPane();
				ImageView b = new ImageView(money);
				b.setFitWidth(1400);
				b.setFitHeight(787);

				stack.getChildren().addAll(b, a);

				border.setCenter(stack);

			}
		});

		MenuBar mb = new MenuBar();
		Menu user = new Menu();
		user.setGraphic(new ImageView(Imuser));

		CheckMenuItem signin = new CheckMenuItem("Login");

		signin.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				close();
				new Login();

			}
		});

		CheckMenuItem signUp = new CheckMenuItem("Sign up");

		signUp.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				close();
				new Sign_upview();
			}
		});

		mb.getMenus().add(user);

		user.getItems().addAll(signin, signUp);
		VBox vbox = new VBox();
		HBox hb = new HBox();
		hb.getChildren().addAll(Homeb, abusb, contact, mb);
		hb.setSpacing(30);
		border.setTop(vbox);
		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent windowEvent) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

				} else {
					windowEvent.consume();
				}
			}
		});
		ImageView view1 = new ImageView(a);
		view1.setFitHeight(400);
		view1.setFitWidth(1400);
		vbox.getChildren().addAll(view1, hb);
		grid.add(form, 0, 0);

		Image i1 = new Image(getClass().getResourceAsStream("/caytien.png"));
		ImageView viewim = new ImageView(i1);
		viewim.setFitHeight(200);
		viewim.setFitWidth(500);

		grid.add(viewim, 1, 1);

		border.setCenter(grid);

		Scene scene = new Scene(border);
		scene.getStylesheets().add("Stylesheets.css");
		grid.getStyleClass().add("grid");
		hb.getStyleClass().add("hb");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/3.png")));
		this.setScene(scene);

	}

}
