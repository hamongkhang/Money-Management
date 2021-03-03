package View;

import java.util.Optional;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Dto.UserDto;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class createaccount extends Stage {

	UserDao usert = new UserDaoImpl();
	Image backs = new Image(getClass().getResourceAsStream("/back.gif"));
	Image agrees = new Image(getClass().getResourceAsStream("/back1.gif"));
	public createaccount(String firstname, String lastname, String phone, String city, String gt, String birthday) {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 20, 20, 20));

		Label regist = new Label("Create your account");
		grid.add(regist, 0, 0);
		regist.setFont(new Font("time news roman", 23));
		Label username = new Label("UserName");
		TextField txusername = new TextField();
		txusername.setPromptText("Enter UserName");
		grid.add(txusername, 0, 2);
		Label user = new Label("(*)");
		user.setTextFill(Color.RED);
		HBox dangnhap = new HBox();
		dangnhap.getChildren().addAll(username, user);
		grid.add(dangnhap, 0, 1);

		Label password = new Label("Creat Password");
		PasswordField txpassword = new PasswordField();
		txpassword.setPromptText("Enter Creat Password");
		grid.add(txpassword, 0, 4);
		Label pass = new Label("(*)");
		pass.setTextFill(Color.RED);
		HBox word = new HBox();
		word.getChildren().addAll(password, pass);
		grid.add(word, 0, 3);

		Label ConfirmPassword = new Label("Confirm Password");
		PasswordField TxConfirmPassword = new PasswordField();
		GridPane.setConstraints(TxConfirmPassword, 0, 6, 2, 1);
		// TxConfirmPassword.setPrefWidth(300);
		TxConfirmPassword.setPromptText("Enter Confirm Password");
		grid.add(TxConfirmPassword, 0, 6);
		Label confim = new Label("(*)");
		confim.setTextFill(Color.RED);
		HBox confimpass = new HBox();
		confimpass.getChildren().addAll(ConfirmPassword, confim);
		grid.add(confimpass, 0, 5);
		Button back = new Button("Back ");
		back.setFont(new Font("time new roman", 12));
		
		GridPane.setConstraints(back, 0, 7, 2, 1, HPos.LEFT, VPos.TOP);
		
		
		back.setGraphic(new ImageView(agrees));
		back.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub

				close();

				Stage home2 = new Home();
				home2.show();

			}
		});

		back.setStyle("-fx-background-color:#fb9dd2;");
		grid.add(back, 0, 7);
		Button next = new Button(" Next ");
		
		next.setFont(new Font("time new roman", 12));
		next.setGraphic(new ImageView(backs));

		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (txusername.getText().equals("") || txpassword.getText().equals("")
						|| TxConfirmPassword.getText().equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Please filled out all required field!");
					alert.showAndWait();

				} else if (usert.getUserByUsername(txusername.getText()) != null||txusername.getText().equals("nhi")) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Username was exits!");
					alert.showAndWait();

				} else if (txpassword.getText().equals(TxConfirmPassword.getText()) == false) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Confirm password fail!");
					alert.showAndWait();
				} else {
					// TODO Auto-generated method stub
					UserDto user = new UserDto(firstname, lastname, txusername.getText(), txpassword.getText(), phone,
							city, gt, birthday);
					UserDaoImpl a = new UserDaoImpl();
					a.insertUser(user);
					close();
					new RegisterSuccess(txusername.getText(), txpassword.getText());

				}

			}
		});
		
		
		
		

		grid.add(next, 1, 7);
		GridPane.setConstraints(next, 0, 7, 2, 1, HPos.RIGHT, VPos.TOP);
		next.setStyle("-fx-background-color:#00baff;");
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

		Scene scene = new Scene(grid);
		this.setScene(scene);
		scene.getStylesheets().add("Stylesheets.css");
		grid.getStyleClass().add("g");

		setTitle("sign up");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/heart.png")));
		this.show();
	}

}
