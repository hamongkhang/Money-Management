package View;

import java.sql.SQLException;

import BLL.CustomerManager;
import BLL.CustomerManagerlmpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Forgotview extends Stage {

	public static Stage stage;
	CustomerManager userManagement = new CustomerManagerlmpl();
	public Forgotview() {
		GridPane g =new GridPane();
		g.setVgap(20);
		Image backs = new Image(getClass().getResourceAsStream("/back1.gif"));
		Image agrees = new Image(getClass().getResourceAsStream("/check.gif"));
		
		
		g.setPadding(new Insets(20,20,20,20));
		Label form = new Label("Get New Password");
		form.setFont(new Font("times newroman",20));
		g.add(form,0 , 0);
		Label userlb = new Label("User:");
        TextField usertx = new TextField();
		
        g.setConstraints(form, 0, 0, 3, 1, HPos.CENTER,VPos.CENTER);
		Label phonenolb = new Label("Phonenumber:");
		g.setHgap(20);
        TextField phoneno = new TextField();
        Button agree =new Button("Agree");
        agree.getStyleClass().add("agree");
        
        agree.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
			
			
				if(userManagement.checkForgin(usertx.getText(), phoneno.getText())){
					close();
					new newpassword(usertx.getText());
				}else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Information are not fond!");
					alert.showAndWait();
				}
				
				
				
			}
		});
        
        
        Button back =new Button("Back");
        HBox hb =new HBox();
        back.getStyleClass().add("back");
        hb.getChildren().addAll(agree,back);
        hb.setSpacing(50);
        g.add(hb,1,3);
        g.setConstraints(hb, 1, 3,3,1,HPos.CENTER,VPos.CENTER);
        g.add(phonenolb, 0, 2);
        g.add(userlb,0,1);
        g.add(usertx,1,1);
        g.add(phoneno, 1, 2);
        back.setGraphic(new ImageView(backs));
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				close();
				
		new Login();
			
				
			}
		});
	     agree.setGraphic(new ImageView(agrees));
		Scene s = new Scene(g);
		s.getStylesheets().add("Stylesheets.css");
		setTitle("Forgot password");
		setScene(s);
		show();
	}

	

}
