package View;

import java.util.Optional;

import BLL.EmployeeManagerImpl;
import BLL.IEmployeeManager;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
import Dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import model.User;

public class EmployeeManagementView extends VBox {

	private IEmployeeManager employeeManager = new EmployeeManagerImpl();
	UserDao user = new UserDaoImpl();

	public EmployeeManagementView(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(12, 12, 12, 12));

		Label lbCode = new Label("ID");
		lbCode.setTextFill(javafx.scene.paint.Color.BLACK);
		lbCode.setFont(new Font("Time news roman", 15));

		grid.add(lbCode, 0, 0);

		TextField txCode = new TextField();
		txCode.setPrefWidth(230);
		grid.add(txCode, 1, 0);

		Label lbFirstName = new Label("First Name:");
		grid.add(lbFirstName, 2, 0);
		lbFirstName.setTextFill(javafx.scene.paint.Color.BLACK);
		lbFirstName.setFont(new Font("Time news roman", 15));

		TextField txFirstName = new TextField();
		txFirstName.setPrefWidth(230);
		grid.add(txFirstName, 3, 0);

		Label lbLastName = new Label("Last Name");
		grid.add(lbLastName, 0, 1);
		lbLastName.setTextFill(javafx.scene.paint.Color.BLACK);
		lbLastName.setFont(new Font("Time news roman", 15));

		TextField txLastName = new TextField();
		grid.add(txLastName, 1, 1);

		Label lbDateOfBirth = new Label("Date Of Birth");
		grid.add(lbDateOfBirth, 2, 1);
		lbDateOfBirth.setTextFill(javafx.scene.paint.Color.BLACK);
		lbDateOfBirth.setFont(new Font("Time news roman", 15));

		DatePicker dateOfBirth = new DatePicker();
		dateOfBirth.setPrefWidth(txFirstName.getPrefWidth());
		grid.add(dateOfBirth, 3, 1);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 2);
		lbPhone.setTextFill(javafx.scene.paint.Color.BLACK);
		lbPhone.setFont(new Font("Time news roman", 15));

		TextField txPhone = new TextField();
		grid.add(txPhone, 1, 2);

		Label lbGender = new Label("Gender");
		grid.add(lbGender, 0, 3);
		lbGender.setTextFill(javafx.scene.paint.Color.BLACK);
		lbGender.setFont(new Font("Time news roman", 15));

		ToggleGroup toggle = new ToggleGroup();

		RadioButton rdMale = new RadioButton("Male");
		rdMale.setToggleGroup(toggle);
		rdMale.setTextFill(javafx.scene.paint.Color.BLACK);
		rdMale.setFont(new Font("Time news roman", 15));

		RadioButton rdFemale = new RadioButton("Female");
		rdFemale.setToggleGroup(toggle);
		rdFemale.setTextFill(javafx.scene.paint.Color.BLACK);
		rdFemale.setFont(new Font("Time news roman", 15));

		HBox genderHBox = new HBox();
		genderHBox.setSpacing(15);
		genderHBox.getChildren().addAll(rdMale, rdFemale);
		grid.add(genderHBox, 1, 3);

		// Label lbSalary = new Label("Salary");
		// grid.add(lbSalary, 0, 3);

		// TextField txSalary = new TextField();
		// grid.add(txSalary, 1, 3);

		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 2, 2);
		lbAddress.setTextFill(javafx.scene.paint.Color.BLACK);
		lbAddress.setFont(new Font("Time news roman", 15));

		TextField txAddress = new TextField();
		grid.add(txAddress, 3, 2);

		// Image imgSearch = new Image(getClass().getResourceAsStream("/search.png"));
		// Image imgAdd = new Image(getClass().getResourceAsStream("/add.png"));
		// Image imgUpdate = new Image(getClass().getResourceAsStream("/update.png"));
		// Image imgDetail = new Image(getClass().getResourceAsStream("/detail.png"));

		Button search = new Button("Search");
		// search.setGraphic(new ImageView(imgSearch));

		Button remove = new Button("Remove");
		// insert.setGraphic(new ImageView(imgAdd));

		Button update = new Button("Update");
		// update.setGraphic(new ImageView(imgUpdate));

		Button detail = new Button("Detail");
		// detail.setGraphic(new ImageView(imgDetail));

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 0));
		hbox.getChildren().addAll(search, remove, update, detail);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 5, 4, 1);

		TableView<User> table = new TableView<>();
		table.setEditable(false);
		table.setPrefHeight(250);

		TableColumn<User, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//		idCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User, Integer>>() {
//
//			@Override
//			public void handle(CellEditEvent<User, Integer> event) {
//				// TODO Auto-generated method stub
//				Integer newValue = event.getNewValue();
//				int row = event.getTablePosition().getRow();
//				event.getTableView().getItems().get(row).setId(newValue);
//				;
//
//			}
//		});

		TableColumn<User, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
//			@Override
//			public void handle(CellEditEvent<User, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setFirstName(newValue);
//			}
//
//		});

		TableColumn<User, String> lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
//			@Override
//			public void handle(CellEditEvent<User, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setLastName(newValue);
//			}
//
//		});

		TableColumn<User, String> dateOfBirthCol = new TableColumn<>("Date of Birth");
		dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
		dateOfBirthCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		dateOfBirthCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
//			@Override
//			public void handle(CellEditEvent<User, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setDateOfBirth(newValue);
//			}
//
//		});

		TableColumn<User, String> phoneNumberCol = new TableColumn<>("Phone Number");
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		phoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		phoneNumberCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
//			@Override
//			public void handle(CellEditEvent<User, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setPhoneNumber(newValue);
//			}
//
//		});

		TableColumn<User, String> genderCol = new TableColumn<>("gender");
		genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
		genderCol.setCellFactory(TextFieldTableCell.forTableColumn());
		genderCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
			@Override
			public void handle(CellEditEvent<User, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setGender(newValue);
			}

		});

		TableColumn<User, String> addressCol = new TableColumn<>("Address");
		addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
		addressCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
			@Override
			public void handle(CellEditEvent<User, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAddress(newValue);
			}

		});
		TableColumn<User, String> loanCol = new TableColumn<>("Loan Amount");
		loanCol.setCellValueFactory(new PropertyValueFactory<>("la"));
		loanCol.setCellFactory(TextFieldTableCell.forTableColumn());
		loanCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
			@Override
			public void handle(CellEditEvent<User, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAddress(newValue);
			}

		});

		table.getColumns().addAll(idCol, firstNameCol, lastNameCol, dateOfBirthCol, phoneNumberCol, genderCol,
				addressCol, loanCol);
		ObservableList<User> data = FXCollections.observableArrayList(employeeManager.getAllEmployees());

		table.setItems(data);

		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				User employee = table.getSelectionModel().getSelectedItem();
				if (employee == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Details");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage employeeDetailStage = new EmployeeDetailView(employee);

					employeeDetailStage.initModality(Modality.WINDOW_MODAL);
					employeeDetailStage.initOwner(primaryStage);
					employeeDetailStage.showAndWait();
				}

			}
		});

		TextField txsearch = new TextField();

		// FilteredList<Employee> filterData = new FilteredList<>(data, e -> true);

		HBox Hbn = new HBox();
		Hbn.getChildren().addAll(search, txsearch);
		remove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm");
				alert.setHeaderText(null);
				alert.setContentText("Delete this accout?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					User employee = table.getSelectionModel().getSelectedItem();

					if (employee == null) {
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setHeaderText(null);
						alert1.setTitle("Customer Remove");
						alert1.setContentText("Please select a row in the table");
						alert1.showAndWait();
					} else {

						int username = employee.getId();

						user.deleteUser("" + username);

						ObservableList<User> data = FXCollections.observableArrayList(employeeManager.getAllEmployees());

						table.setItems(data);


					}
				}

			}
		});

		this.setSpacing(20);
		update.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				User employee = table.getSelectionModel().getSelectedItem();
				if (employee == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Update");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage updateEmployeeStage = new EmployeeUpdateView(employee);
					updateEmployeeStage.initModality(Modality.WINDOW_MODAL);
					updateEmployeeStage.initOwner(primaryStage);
					updateEmployeeStage.showAndWait();
					table.setItems(FXCollections.observableArrayList(employeeManager.getAllEmployees()));
				}
			}
		});
		EmployeeDao ep = new EmployeeDaoImpl();

		search.setOnAction(new EventHandler<ActionEvent>() {
			User users = new User();

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				users.setFirstName(txsearch.getText());
				if (user != null) {
					table.setItems(FXCollections.observableArrayList(ep.search(users)));
					
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Search");
					alert.setContentText("Please Type the name that you want to search");
					alert.showAndWait();
					

				}
			}
		});
		txsearch.setPromptText("Search by name here!");
		Hbn.setAlignment(Pos.CENTER);
		Hbn.setSpacing(20);

		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().addAll(grid, table, Hbn);
	}
}
