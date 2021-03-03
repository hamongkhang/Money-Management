package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Contactus extends Stage {
	public Contactus() {
		BorderPane bor = new BorderPane();

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 15, 10, 30));
		grid.setHgap(15);
		grid.setVgap(5);

		Button backs = new Button("Back");

		bor.setTop(backs);

		backs.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				close();
				
				
				Stage home2 = new Home();
				home2.show();


			}
		});
		backs.setStyle("-fx-background-color:#fb9dd2;");
		Label userLogin = new Label("Contact: 0966624800");

		userLogin.setFont(new Font("Times New Roman", 20));

		GridPane.setConstraints(userLogin, 0, 1, 3, 1, HPos.CENTER, VPos.CENTER);
		grid.add(userLogin, 0, 1, 2, 1);
		Image money = new Image(getClass().getResourceAsStream("/6.png"));
		ImageView viewim = new ImageView(money);
		
		grid.add(viewim, 0, 2);
		bor.setCenter(grid);
		Scene scene = new Scene(bor, 300, 300);
		this.setScene(scene);
		this.setTitle("Contact us ");
		this.getIcons().add(new Image(getClass().getResourceAsStream("/heart.png")));

		this.show();
	}
}
