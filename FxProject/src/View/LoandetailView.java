package View;

import Dto.UserDto;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class LoandetailView extends GridPane {

	public LoandetailView(UserDto a) {
		
		setPadding(new Insets(10, 10, 10, 10));
		setHgap(20);
		setVgap(20);
		Label employeeDetail = new Label("Loan Detail");
		employeeDetail.setFont(new Font("Times new roman", 23));
		add(employeeDetail, 0, 0, 2, 1);

		Label lbCode = new Label("Code");
		add(lbCode, 0, 1);

		TextField txCode = new TextField("" + a.getId());
		txCode.setPrefWidth(230);
		add(txCode, 1, 1);

		Label lbFirstName = new Label("First Name");
		add(lbFirstName, 0, 2);

		TextField txFirstName = new TextField(a.getFirstname());
		add(txFirstName, 1, 2);

		Label lbLastName = new Label("Last Name");
		add(lbLastName, 0, 3);

		TextField txLastName = new TextField(a.getLastname());
		add(txLastName, 1, 3);

		Label lbLA = new Label("Loan amount");
		add(lbLA, 0, 4);

		TextField txLA = new TextField("" + a.getLoanamout());
		add(txLA, 1, 4);

	}

}
