package View;

import java.util.Optional;

import BLL.CustomerManager;
import BLL.CustomerManagerlmpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Resetpassword extends Stage {
	CustomerManager user = new CustomerManagerlmpl();
	UserDao users = new UserDaoImpl();

	public Resetpassword(String username) {
		Image reset = new Image(getClass().getResourceAsStream("/reset.ico"));
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(10);
		grid.setVgap(10);
		Label oldpass = new Label("Enter old password");
		PasswordField pfoldpass = new PasswordField();
		grid.add(oldpass, 0, 0);
		grid.add(pfoldpass, 1, 0);
		Label newpass = new Label("Enter new password");
		PasswordField pfnewpass = new PasswordField();
		grid.add(newpass, 0, 1);
		grid.add(pfnewpass, 1, 1);
		Label confirm = new Label("Confirm Password");
		PasswordField pfconfirm = new PasswordField();
		grid.add(confirm, 0, 2);
		grid.add(pfconfirm, 1, 2);
		Button Resetpass = new Button("Reset");
		grid.add(Resetpass, 0, 3);
		Resetpass.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				if (user.checkLogin(username, pfoldpass.getText())) {

					if (newpass.getText().equals(confirm.getText())) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("Confirm failse!");
						alert.showAndWait();
					} else {
						users.updatePassword(username, pfnewpass.getText());
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("Done!");
						alert.showAndWait();
						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							close();
						}
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Password is wrong!");
					alert.showAndWait();
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

					}

				}
			}

		});
		Scene s = new Scene(grid);
		Resetpass.setGraphic(new ImageView(reset));
		s.getStylesheets().add("Stylesheets.css");
		grid.getStyleClass().add("grid");
		Resetpass.getStyleClass().add("login");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/interview.png")));

		this.setTitle("Regest Password");
		setScene(s);
		show();

	}

}
