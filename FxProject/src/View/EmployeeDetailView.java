package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.User;

public class EmployeeDetailView extends Stage {

	public EmployeeDetailView(User employee) {

		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));

		Label employeeDetail = new Label("Customer Detail");
		employeeDetail.setFont(new Font("Times new roman", 23));
		grid.add(employeeDetail, 0, 0, 2, 1);

		Label lbCode = new Label("ID");
		grid.add(lbCode, 0, 1);

		TextField txCode = new TextField(""+employee.getId());
		txCode.setPrefWidth(230);
		grid.add(txCode, 1, 1);

		Label lbFirstName = new Label("First Name");
		grid.add(lbFirstName, 0, 2);

		TextField txFirstName = new TextField(employee.getFirstName());
		grid.add(txFirstName, 1, 2);

		Label lbLastName = new Label("Last Name");
		grid.add(lbLastName, 0, 3);

		TextField txLastName = new TextField(employee.getLastName());
		grid.add(txLastName, 1, 3);

		Label lbBirthday = new Label("Bithday");
		grid.add(lbBirthday, 0, 4);

		TextField txBirthday = new TextField(employee.getDateOfBirth());
		grid.add(txBirthday, 1, 4);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 5);

		TextField txPhone = new TextField(employee.getPhoneNumber());
		grid.add(txPhone, 1, 5);

		Label lbGender = new Label("Gender");
		grid.add(lbGender, 0, 6);

		TextField txGender = new TextField(employee.getGender());
		grid.add(txGender, 1, 6);

		Label lbSalary = new Label("Salary");
		grid.add(lbSalary, 0, 7);

		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 0, 8);

		TextField txAddress = new TextField(employee.getAddress());
		grid.add(txAddress, 1, 8);

		Scene scene = new Scene(grid);

		this.setTitle("Employee Detail");
		this.setScene(scene);
	}
}
