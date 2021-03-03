package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.User;

public class EmployeeUpdateView extends Stage {
	String gt = null;

	public EmployeeUpdateView(User employee) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));

		Label lbInfo = new Label("Employee Update");
		grid.add(lbInfo, 0, 0, 2, 1);

		Label lbId = new Label("ID");
		grid.add(lbId, 0, 1);

		TextField txId = new TextField(employee.getId().toString());
		txId.setPrefWidth(230);
		grid.add(txId, 1, 1);

		Label lbFirstName = new Label("First Name");
		grid.add(lbFirstName, 0, 2);

		TextField txFirstName = new TextField(employee.getFirstName());
		txFirstName.setPrefWidth(230);
		grid.add(txFirstName, 1, 2);

		Label lbLastName = new Label("Last Name");
		grid.add(lbLastName, 0, 3);

		TextField txLastName = new TextField(employee.getLastName());
		grid.add(txLastName, 1, 3);

		Label lbBirthday = new Label("Bithday");
		grid.add(lbBirthday, 0, 4);

		TextField dateOfBirth = new TextField(employee.getDateOfBirth());
		// dateOfBirth.set(employee.getDateOfBirth());
		grid.add(dateOfBirth, 1, 4);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 5);

		TextField txPhone = new TextField(employee.getPhoneNumber());
		grid.add(txPhone, 1, 5);

		Label lbGender = new Label("Gender");
		grid.add(lbGender, 0, 6);

		ToggleGroup toggleGroup = new ToggleGroup();

		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(toggleGroup);

		RadioButton female = new RadioButton("Female");
		female.setToggleGroup(toggleGroup);

		male.setSelected(true);

		male.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if (male.isSelected() == true) {
					gt = "Male";

				}

			}
		});
		female.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if (female.isSelected() == true) {
					gt = "Female";

				}
			}
		});

		HBox hbGender = new HBox();
		hbGender.setSpacing(15);
		hbGender.getChildren().addAll(male, female);
		grid.add(hbGender, 1, 6);

		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 0, 8);

		TextField txAddress = new TextField(employee.getAddress());
		grid.add(txAddress, 1, 8);

		Button update = new Button("Update");

		update.setOnAction(new EventHandler<ActionEvent>() {

			EmployeeDao ep = new EmployeeDaoImpl();

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				User user = new User(txId.getText(), txFirstName.getText(), txLastName.getText(), dateOfBirth.getText(),
						txPhone.getText(), gt, txAddress.getText());
				ep.updateUser(user);
				
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Update");
				alert.setHeaderText(null);
				alert.setContentText("Done!");
				alert.showAndWait();
				
			}
		});

		Button clear = new Button("Clear");

		HBox hbox = new HBox();
		hbox.setSpacing(25);
		hbox.getChildren().addAll(update, clear);
		grid.add(hbox, 1, 9);

		Scene scene = new Scene(grid);

		this.setTitle("Employee Update");
		this.setScene(scene);
	}

}
