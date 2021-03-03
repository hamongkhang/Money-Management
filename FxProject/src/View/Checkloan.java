package View;

import Dao.loan;
import Dao.loanimpl;
import Dto.LDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import model.Loan;

public class Checkloan extends VBox {
	public Checkloan() {

		TableView<LDto> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		

		TableColumn<LDto, String> usernamCol = new TableColumn<>("Username");
		usernamCol.setCellValueFactory(new PropertyValueFactory<>("usern"));
//		usernamCol.setCellFactory(TextFieldTableCell.forTableColumn());
//
//			@Override
//			public void handle(CellEditEvent<Loan, String> t) {
//				String newValue = t.getNewValue();
//				int row		usernamCol.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() { = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setUsern(newValue);
//			}
//
//		});

		TableColumn<LDto, String> firstNameCol = new TableColumn<>("First name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() {
//			@Override
//			public void handle(CellEditEvent<Loan, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setFirstname(newValue);
//			}
//
//		});

		TableColumn<LDto, String> loana = new TableColumn<>("Loan Amount");
		loana.setCellValueFactory(new PropertyValueFactory<>("loana"));
		// dateOfBirthCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		loana.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() {
//			@Override
//			public void handle(CellEditEvent<Loan, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setLoana(newValue);
//			}
//
//		});

		TableColumn<LDto, String> id = new TableColumn<>("ID Card");
		id.setCellValueFactory(new PropertyValueFactory<>("idcard"));
		id.setCellFactory(TextFieldTableCell.forTableColumn());
	/*	id.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() {
			@Override
			public void handle(CellEditEvent<Loan, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setIdcard(newValue);
			}

		});*/

		TableColumn<LDto, String> limits = new TableColumn<>("Limit");
		limits.setCellValueFactory(new PropertyValueFactory<>("limit"));
		limits.setCellFactory(TextFieldTableCell.forTableColumn());
//		limits.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() {
//			@Override
//			public void handle(CellEditEvent<Loan, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setLimit(newValue);
//			}
//
//		});

		TableColumn<LDto, String> thechap = new TableColumn<>("Recemal");
		thechap.setCellValueFactory(new PropertyValueFactory<>("thechap"));
		thechap.setCellFactory(TextFieldTableCell.forTableColumn());
//		thechap.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() {
//			@Override
//			public void handle(CellEditEvent<Loan, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setThechap(newValue);
//			}
//
//		});

		TableColumn<LDto, String> type = new TableColumn<>("Type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		type.setCellFactory(TextFieldTableCell.forTableColumn());
//		type.setOnEditCommit(new EventHandler<CellEditEvent<Loan, String>>() {
//			@Override
//			public void handle(CellEditEvent<Loan, String> t) {
//				String newValue = t.getNewValue();
//				int row = t.getTablePosition().getRow();
//				t.getTableView().getItems().get(row).setType(newValue);
//			}
//
//		});

		loan lmanager = new loanimpl();

	    table.getColumns().addAll(id, firstNameCol,limits, loana, thechap, type);
		ObservableList<LDto> data = FXCollections.observableArrayList(lmanager.getAllUsers());

		table.setItems(data);
		;
		
		
		
		getChildren().add(table);
	}

}
