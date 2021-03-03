
package View;
	

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		
		Stage home = new Home();
		home.show();

	}
	public static void main(String[] args) {
		launch(args);
		
	}

	
	
}

