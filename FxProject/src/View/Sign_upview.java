package View;

import Dao.UserDaoImpl;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

import Dto.UserDto;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Sign_upview extends Stage {
//	String user = "JavaFX2";
//	 String pw = "password";
//	 String checkUser, checkPw;

	String gt;

	public Sign_upview() {
		Image backs = new Image(getClass().getResourceAsStream("/back.gif"));
		Image agrees = new Image(getClass().getResourceAsStream("/back1.gif"));
		//Image back = new Image(getClass().getResourceAsStream("/back.gif"));
		
		GridPane g = new GridPane();
		g.setPadding(new Insets(20, 20, 20, 20));
		g.setVgap(10);
		g.setHgap(10);

		Label sigup = new Label("Sign Up");
		sigup.setAlignment(Pos.BASELINE_CENTER);
		sigup.setFont(new Font("time news roman", 22));
		GridPane.setConstraints(sigup, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		Button login = new Button("Login");
		login.setStyle("-fx-text-fill:#00baff;");
		GridPane.setConstraints(login, 1, 0, 1, 1, HPos.RIGHT, VPos.CENTER);
		g.getChildren().addAll(sigup, login);
		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				close();
				Stage sign = new Login();
				sign.show();

			}
		});

		Label signup = new Label("Sign Up");
		Label firtname = new Label("First name(");
		TextField txfirtname = new TextField();
		txfirtname.setPromptText("Enter Firt Name");
		txfirtname.setPrefWidth(200);
		g.add(txfirtname, 0, 2);

		Label lfirt = new Label("*");
		lfirt.setTextFill(Color.RED);

		Label l1 = new Label(")");

		HBox hbox = new HBox();
		hbox.getChildren().addAll(firtname, lfirt,l1);
		g.add(hbox, 0, 1);

		Label lastname = new Label("Last Name(");
		TextField txlastname = new TextField();
		txlastname.setPromptText("Enter Last Name");
		txlastname.setPrefWidth(200);
		g.add(txlastname, 1, 2);
		Label lastnames = new Label("*");
		lastnames.setTextFill(Color.RED);

		Label l2 = new Label(")");

		HBox last = new HBox();
		last.getChildren().addAll(lastname, lastnames,l2);
		g.add(last, 1, 1);

		Label phone = new Label("Phone(");
		TextField txphone = new TextField();
		txphone.setPromptText("Enter Phone");
		g.add(txphone, 0, 4);
		Label phon = new Label("*");
		phon.setTextFill(Color.RED);
		Label l3 = new Label(")");
		HBox phones = new HBox();
		phones.getChildren().addAll(phone, phon,l3);
		g.add(phones, 0, 3);

		Label birthday = new Label("Birthday(");


		Label birth  = new Label("*");
		birth .setTextFill(Color.RED);
		Label l10 = new Label(")");
		HBox day = new HBox();
		day.getChildren().addAll(birthday,birth,l10);
		g.add(day, 1, 3);
		DatePicker txbirthday = new DatePicker();
		txbirthday.setPromptText("Enter Birthday");
		txbirthday.setPrefWidth(200);
		g.add(txbirthday, 1, 4);


		txphone.setOnKeyPressed(new EventHandler<KeyEvent>() {
		public void handle(KeyEvent keyEvent) {
		try {
		Double.valueOf(keyEvent.getText());
		} catch (NumberFormatException ex) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Please input the number");
		alert.showAndWait();
		}
		}
		});

		Label idcard = new Label("ID Card(");
		TextField txidcard = new TextField();
		txidcard.setPromptText("Enter ID Card");
		g.add(txidcard, 0, 6, 2, 1);
		txidcard.getStyleClass().add("c");
		Label idca = new Label("*");
		idca.setTextFill(Color.RED);
		Label l4 = new Label(")");
		HBox id = new HBox();
		id.getChildren().addAll(idcard, idca,l4);
		g.add(id, 0, 5);
		
		Label email = new Label("Email(");
		TextField txemail = new TextField();
		GridPane.setConstraints(txemail, 0, 8, 2, 1);
		txemail.setPromptText("Enter Email");
		g.add(txemail, 0, 8);
		Label emai = new Label("*");
		emai.setTextFill(Color.RED);

		Label l5 = new Label(")");
		HBox e = new HBox();
		e.getChildren().addAll(email, emai,l5);
		g.add(e, 0, 7);

		Label gender = new Label("Gender(");
		g.add(gender, 0, 9);

		Label der = new Label("*");
		der.setTextFill(Color.RED);
		Label l11 = new Label(")");
		HBox de = new HBox();
		de.getChildren().addAll(gender,der,l11);
		g.add(de, 0,9);
		ToggleGroup group = new ToggleGroup();
		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(group);
		RadioButton Fmale = new RadioButton("Fmale");
		Fmale.setToggleGroup(group);
		HBox gende = new HBox();
		gende.setSpacing(10);
		gende.getChildren().addAll(male, Fmale);
		g.add(gende, 0, 10);

		Label City = new Label("City(");
		TextField txcity = new TextField();
		txcity.setPromptText("Enter City");
		g.add(txcity, 0, 12);
		Label citys = new Label("*");
		citys.setTextFill(Color.RED);
		Label l6 = new Label(")");
		HBox thanhpho = new HBox();
		thanhpho.getChildren().addAll(City, citys,l6);
		g.add(thanhpho, 0, 11);

		Label country = new Label("Country(");
		Label coun = new Label("*");
		coun.setTextFill(Color.RED);
		Label l7 = new Label(")");
		HBox countr = new HBox();
		countr.getChildren().addAll(country,coun,l7);
		g.add(countr, 1, 11);

		ObservableList<String> cities = FXCollections.observableArrayList();
		ComboBox<String> txcountry = new ComboBox<String>(cities);

		String[] locales1 = Locale.getISOCountries();
		for (String countrylist : locales1) {
		Locale obj = new Locale("", countrylist);
		
		
		
		String[] city = { obj.getDisplayCountry() };
		
		
		
		for (int x = 0; x < city.length; x++) {
		cities.add(obj.getDisplayCountry());
		}
		}
		txcountry.setItems(cities);
		txcountry.setPrefWidth(200);
		g.add(txcountry, 1, 12);
		male.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if (male.isSelected() == true) {
					gt = "Male";

				}

			}
		});
		Fmale.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if (Fmale.isSelected() == true) {
					gt = "Female";

				}
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

		Button back = new Button("Back ");

		
		back.setFont(new Font("time new roman", 12));
		GridPane.setConstraints(back, 0, 14, 2, 1, HPos.LEFT, VPos.TOP);
		back.setStyle("-fx-background-color:#fb9dd2;");
		back.setGraphic(new ImageView(agrees));
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				close();

				Stage home2 = new Home();
				home2.show();

			}
		});
		g.add(back, 0, 14);
		
		Button next = new Button(" Next ");
		
		next.setFont(new Font("time new roman", 12));
		next.setGraphic(new ImageView(backs));

		next.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				if(male.isSelected() == false &&  Fmale.isSelected() == false) {

				}

				if (txlastname.getText().equals("") || txfirtname.getText().equals("") || txemail.getText().equals("")
				|| txphone.getText().equals("") || txphone.getText().equals("") || txcity.getText().equals("")
				|| txcountry.getSelectionModel().getSelectedItem().equals("")
				|| txbirthday.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yy")).equals("") || (male.isSelected() == false &&  Fmale.isSelected() == false)) {

				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText(null);
				alert.setContentText("Please filled out all required field!");
				alert.showAndWait();
				} else {
				close();
				new createaccount(txfirtname.getText(), txlastname.getText(), txphone.getText(), txcity.getText(),
							gt, txbirthday.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yy")));

				}

			}
		});

		g.add(next, 1, 14);
		GridPane.setConstraints(next, 0, 14, 2, 1, HPos.RIGHT, VPos.TOP);
		
		next.setStyle("-fx-background-color:#00baff;");
		Label chu1 = new Label("Temrs of you and Privacy Policy ");
		chu1.setFont(new Font("time new roman", 10));
		GridPane.setConstraints(chu1, 0, 15, 2, 1);
		g.add(chu1, 0,15);

		Scene scene = new Scene(g);
		scene.getStylesheets().add("Stylesheets.css");
		g.getStyleClass().add("g");

		setTitle("sign up");
		getIcons().add(new Image(getClass().getResourceAsStream("/interview.png")));
		setScene(scene);
		show();

	}
}
