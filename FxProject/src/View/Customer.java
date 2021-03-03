package View;

import Dao.UserDao;
import Dto.UserDto;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.User;


public class Customer extends GridPane {
	
	public Customer(UserDto a) {
		
		setPadding(new Insets(20,20,20,20));
		setHgap(20);
		setVgap(20);
	Label employeeDetail = new Label("Customer Detail");
	employeeDetail.setFont(new Font("Times new roman", 23));
	 add(employeeDetail, 0, 0);

	Label lbCode = new Label("Code");
	 add(lbCode, 0, 1);

	TextField txCode = new TextField(""+a.getId());
	txCode.setPrefWidth(200);
	 add(txCode, 1, 1);

	Label lbFirstName = new Label("First Name");
	 add(lbFirstName, 2, 1);

	TextField txFirstName = new TextField(a.getFirstname());
	 add(txFirstName, 3, 1);
	 txFirstName.setPrefWidth(200);
	Label lbLastName = new Label("Last Name");
	 add(lbLastName, 0, 2);

	TextField txLastName = new TextField(a.getLastname());
	 add(txLastName, 1, 2);

	Label lbBirthday = new Label("Bithday");
	 add(lbBirthday, 2, 2);

	TextField txBirthday = new TextField(a.getBirthday());
	 add(txBirthday, 3, 2);

	Label lbPhone = new Label("Phone Number");
	 add(lbPhone, 0, 3);

	TextField txPhone = new TextField(a.getPhoneNumber());
	 add(txPhone, 1, 3);

	Label lbGender = new Label("Gender");
	 add(lbGender, 2, 3);

	TextField txGender = new TextField(a.getGender());
	 add(txGender, 3, 3);



	Label lbAddress = new Label("Address");
	 add(lbAddress, 0, 4);

	TextField txAddress = new TextField(a.getAddress());
	 add(txAddress, 1, 4);



	}

}
