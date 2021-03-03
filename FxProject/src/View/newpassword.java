package View;

import BLL.CustomerManager;
import BLL.CustomerManagerlmpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class newpassword extends Stage {
UserDao user =new UserDaoImpl();
CustomerManager userManagement = new CustomerManagerlmpl();
	public newpassword(String username) {
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(20);
		grid.setPadding(new Insets(20, 20, 20, 20));

		Label getnewpasslb = new Label("Get new Password");
		grid.add(getnewpasslb, 0, 0);
		grid.setConstraints(getnewpasslb, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER);

		Label enternewplb = new Label("Enter new Password:");
		grid.add(enternewplb, 0, 1);
		Label confirn = new Label("Confim Password:");
		grid.add(confirn, 0, 2);
		PasswordField enterpf = new PasswordField();
		grid.add(enterpf, 1, 1);
		PasswordField confirmpf = new PasswordField();
		grid.add(confirmpf, 1, 2);
		
		Button agreebt =new Button("Agree");
		
		grid.add(agreebt, 1, 3);
		
		agreebt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				user.updatePassword(username, enterpf.getText());
				
				if (userManagement.checkLogin(username,enterpf.getText())) {
					close();
					
					new Customerview(user.getNameByUsername(username).getFirstname(),username);
				
				} else if (userManagement.checkAdminLogin(username, enterpf.getText())) {
					System.out.println("Ad NEk!");
				} else if (userManagement.checkBankerLogin(username,enterpf.getText())) {
					System.out.println("BAnker nek!!!");
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Username or Password is wrong!");
					alert.showAndWait();
				}
			}
				
			
		});

		Scene s = new Scene(grid);
		setScene(s);
		show();

	}

}
