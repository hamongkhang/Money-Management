package View;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import BLL.CustomerManager;
import BLL.CustomerManagerlmpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
import Dao.loan;
import Dao.loanimpl;
import Dto.LDto;
import Dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Loan;

public class MakeLoan extends Stage {
	CustomerManager userManagement = new CustomerManagerlmpl();
	UserDao userd = new UserDaoImpl();
	final Spinner<Integer> spinner = new Spinner<Integer>();

	public MakeLoan(String username) {
		GridPane grid = new GridPane();
		int initialValue = 3;
		Image clears = new Image(getClass().getResourceAsStream("/cut.png"));
		Image logins = new Image(getClass().getResourceAsStream("/login.png"));

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(10);
		grid.setVgap(10);

		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5,
				initialValue);

		spinner.setValueFactory(valueFactory);
		grid.add(spinner, 3, 1);

		Label funame = new Label("Full Name");
		TextField fn = new TextField();
		grid.add(funame, 0, 0);
		grid.add(fn, 1, 0);

		Label tloan = new Label("Type Loan");
		grid.add(tloan, 0, 1);

		HBox x = new HBox();
		Text ly = new Text("Less than one billion VND");
		Label i = new Label("*");
		i.setTextFill(Color.RED);
		x.getChildren().addAll(i, ly);

		grid.add(x, 1, 3);

		Label IDcard = new Label("ID Card");
		TextField idc = new TextField();

		grid.add(IDcard, 2, 0);
		grid.add(idc, 3, 0);

		ObservableList<String> cities = FXCollections.observableArrayList("Business loan", "Person loan");
		ComboBox<String> tl = new ComboBox<String>(cities);

		grid.add(tl, 1, 1);

		Label loana = new Label("Loan Amount:");
		grid.add(loana, 0, 2);

		TextField la = new TextField();
		grid.add(la, 1, 2);

		Label renewal = new Label("Renewal");
		grid.add(renewal, 2, 1);
		Label lbthechap = new Label("Collateral");
		TextField txthechap = new TextField();
		grid.add(lbthechap, 2, 2);
		grid.add(txthechap, 3, 2);
		// TextField txrenewal = new TextField();
		// grid.add(txrenewal, 1, 1);

		HBox hbox = new HBox();
		Button ok = new Button("OK");
		hbox.setSpacing(20);

		Button cancle = new Button("Delete");
		cancle.getStyleClass().add("back");
		cancle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				fn.setText("");
				la.setText("");
				txthechap.setText("");

			}
		});
		hbox.getChildren().addAll(ok, cancle);
		grid.add(hbox, 1, 6);

		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setAlignment(Pos.CENTER);
		ok.getStyleClass().add("login");

		ok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				UserDto name = userd.getUserByUsername(username);
				if (fn.getText().equals("") || la.getText().equals("") || idc.getText().equals("")
						|| tl.getSelectionModel().getSelectedItem().equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Please filled out all required field!");
					alert.showAndWait();
				} else if (fn.getText().equals(name.getFirstname())) {
					Alert alert1 = new Alert(AlertType.CONFIRMATION);
					alert1.setTitle("Thank you");

					alert1.setHeaderText(null);
					alert1.setContentText(
							"Your request has been sent.\r\n" + "Please wait for feedback from bank staff");
					Optional<ButtonType> result = alert1.showAndWait();
					String spinners = String.valueOf(spinner.getValue().toString());
					loan l = new loanimpl();
					String type = tl.getSelectionModel().getSelectedItem();
					LDto ls = new LDto(username, fn.getText(), type, spinners, la.getText(), idc.getText(),
							txthechap.getText());

					if (result.get() == ButtonType.OK) {

						l.addloan(ls, username);
						close();
					}
				} else {

					Alert alert1 = new Alert(AlertType.CONFIRMATION);
					alert1.setTitle("Warning");

					alert1.setHeaderText(null);
					alert1.setContentText("firstname don't exits!");
					alert1.showAndWait();
				}

		
			}

		});

		Scene s = new Scene(grid);
		ok.setGraphic(new ImageView(logins));
		cancle.setGraphic(new ImageView(clears));

		s.getStylesheets().add("Stylesheets.css");
		grid.getStyleClass().add("grid");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/interview.png")));

		this.setTitle("Make a Loan");
		setScene(s);
		show();

	}
}
