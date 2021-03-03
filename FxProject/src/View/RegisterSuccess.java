package View;

import java.util.Optional;

import BLL.CustomerManager;
import BLL.CustomerManagerlmpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class RegisterSuccess extends Stage {
	CustomerManager userManagement = new CustomerManagerlmpl();

	public RegisterSuccess(String username, String password) {
		Image backs = new Image(getClass().getResourceAsStream("/back1.gif"));
		Image logins = new Image(getClass().getResourceAsStream("/login.png"));
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 20, 20, 20));

		Label regist = new Label("                         Successful                           ");
		grid.add(regist, 0, 0);
		regist.setFont(new Font("time news roman", 15));

		Button back = new Button("Back ");
		back.setFont(new Font("time new roman", 12));
		
		GridPane.setConstraints(back, 0, 7, 2, 1, HPos.LEFT, VPos.TOP);
		back.setGraphic(new ImageView(backs));
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				close();

				Stage home2 = new Home();
				home2.show();

			}
		});

		back.setStyle("-fx-background-color:#fb9dd2;");
		grid.add(back, 0, 7);

		Button Login = new Button("Login");
		Login.setGraphic(new ImageView(logins));
		Login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// TODO Auto-generated method stub
				if (userManagement.checkLogin(username, password)) {
					close();
					new Customerview(username, password);

				}/* else if (userManagement.checkAdminLogin(username, password)) {
					System.out.println("Ad NEk!");
				}*/ else if (userManagement.checkBankerLogin(username, password)) {
					new Employeeview(username);
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Username or Password is wrong!");
					alert.showAndWait();
				}
			}

		});
		grid.add(Login, 1, 7);
		Login.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
				close();
				new Login();
				;

			}
		});

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

		Image money = new Image(getClass().getResourceAsStream("/tich.png"));
		ImageView viewim = new ImageView(money);
		GridPane.setConstraints(viewim, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(viewim, 0, 2);

		Scene scene = new Scene(grid);
		this.setScene(scene);
	scene.getStylesheets().add("Stylesheets.css");
		Login.getStyleClass().add("login");

		setTitle("sign up");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/heart.png")));
		this.show();
	}

}
