package View;

import BLL.CustomerManager;
import BLL.CustomerManagerlmpl;
import BLL.EmployeeManagerImpl;
import BLL.IEmployeeManager;
import Dao.UserDao;
import Dao.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;;

public class Login extends Stage {
	public static boolean stateLogin = false;

	CustomerManager userManagement = new CustomerManagerlmpl();
	UserDao userd = new UserDaoImpl();
	IEmployeeManager ep = new EmployeeManagerImpl();
	int caps = 0;

	public Login() {

		Image clears = new Image(getClass().getResourceAsStream("/cut.png"));
		Image logins = new Image(getClass().getResourceAsStream("/login.png"));
		Image backs = new Image(getClass().getResourceAsStream("/back1.gif"));
		// Image forgots = new Image(getClass().getResourceAsStream("/confim.png"));
		Image user = new Image(getClass().getResourceAsStream("/user1.png"));
		Image pass = new Image(getClass().getResourceAsStream("/key1" + ".png"));
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setHgap(10);
		grid.setVgap(10);

		Label userLogin = new Label("User Login");
		userLogin.setFont(new Font("Times New Roman", 23));

		GridPane.setConstraints(userLogin, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);
		grid.add(userLogin, 0, 0);

		HBox h1 = new HBox();
		ImageView viewim = new ImageView(user);
		TextField txUsername = new TextField();
		h1.getChildren().addAll(viewim, txUsername);
		h1.setAlignment(Pos.CENTER);
		grid.add(h1, 0, 1);
		txUsername.setPrefWidth(230);
		HBox h2 = new HBox();
		ImageView image = new ImageView(pass);

		h2.setAlignment(Pos.CENTER);
		grid.add(h2, 0, 2);
		PasswordField pw = new PasswordField();
		h2.getChildren().addAll(image, pw);
		pw.setPrefWidth(230);
		Label cap = new Label("");
		
		pw.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ev) {
				if (ev.getCode()==KeyCode.ENTER) {
					if (userManagement.checkLogin(txUsername.getText(), pw.getText())) {
						close();
						new Customerview(userd.getNameByUsername(txUsername.getText()).getFirstname(),
								txUsername.getText());
					}  else if (userManagement.checkBankerLogin(txUsername.getText(), pw.getText())) {
						close();
						new Employeeview(userd.getEnameByUsername(txUsername.getText()));
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("Username or Password is wrong!");
						alert.showAndWait();
					}
					System.out.println("q");
				}
				
		
		else if (ev.getCode() == KeyCode.CAPS) {
				caps=caps+1;
				if(caps%2!=0) {
					
					cap.setTextFill(Color.RED);
					cap.setText("Caps lock is on! ");
				}
				else {
					cap.setText("");
				}
			}

			}

		});

		grid.add(cap, 0, 6);
		grid.setConstraints(cap, 0, 6, 2, 1, HPos.CENTER, VPos.CENTER);
		
		txUsername.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.CAPS) {
					caps = caps + 1;
					if (caps % 2 != 0) {

						cap.setTextFill(Color.RED);
						cap.setText("Caps lock is on! ");
					} else {
						cap.setText("");
					}

				}
			}

		});
		HBox hbox = new HBox();
		hbox.setSpacing(20);

		grid.add(hbox, 0, 3);

		Button login = new Button("Login");
		grid.add(login, 0, 3);
		GridPane.setConstraints(login, 0, 3, 2, 1, HPos.CENTER, VPos.TOP);
		login.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				if (userManagement.checkLogin(txUsername.getText(), pw.getText())) {
					close();
					new Customerview(userd.getNameByUsername(txUsername.getText()).getFirstname(),
							txUsername.getText());

				} 
//					 if (userManagement.checkAdminLogin(txUsername.getText(), pw.getText()))
//					 { close(); System.out.println("Ad NEk!"); }
					 else if (userManagement.checkBankerLogin(txUsername.getText(), pw.getText())) {
					close();
					new Employeeview(userd.getEnameByUsername(txUsername.getText()));
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Username or Password is wrong!");
					alert.showAndWait();
				}
			}

		});
		Button clear = new Button("Delete");
		hbox.getChildren().addAll(login, clear);
		hbox.setAlignment(Pos.CENTER);
		Label label = new Label("--------------------");
		grid.add(label, 0, 4);
		GridPane.setConstraints(label, 0, 4, 2, 1, HPos.CENTER, VPos.TOP);

//grid.add(clear, 0, 5);
//GridPane.setConstraints(clear, 0, 5,2,1,HPos.CENTER,VPos.TOP);
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				txUsername.setText("");
				pw.setText("");
			}
		});

		clear.setGraphic(new ImageView(clears));
		Label enter = new Label("Please enter your name and password!");

		grid.add(enter, 0, 5);
		GridPane.setConstraints(enter, 0, 5, 2, 1, HPos.CENTER, VPos.TOP);
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				close();
				Stage home2 = new Home();
				home2.show();

			}
		});
		grid.add(back, 0, 6);

		Label fogot = new Label("Forgot Password?");
		fogot.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				close();
				new Forgotview();
				;

			}

		});

//		fogot.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				close();
//				forgot.createAndShowGUI();
//				;
//
//			}
//		});

// hbox.getChildren().addAll(login, clear);
		grid.add(fogot, 0, 6);
		GridPane.setConstraints(fogot, 0, 6, 2, 1, HPos.RIGHT, VPos.TOP);

		login.setGraphic(new ImageView(logins));
		back.setGraphic(new ImageView(backs));
		// fogot.setGraphic(new ImageView(forgots));

		Scene scene = new Scene(grid);

		scene.getStylesheets().add("Stylesheets.css");
		grid.getStyleClass().add("grid");
		txUsername.getStyleClass().add("txUsername");
		pw.getStyleClass().add("pw");
		back.getStyleClass().add("back");

		// fogot.getStyleClass().add("fogot");
		login.getStyleClass().add("login");
		clear.getStyleClass().add("clear");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/interview.png")));

		this.setTitle("Login");

		this.setScene(scene);
		this.show();

	}

}
