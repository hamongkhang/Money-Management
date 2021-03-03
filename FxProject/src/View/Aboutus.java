package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Aboutus extends GridPane{
	public Aboutus (){
	Label a =new  Label("Welcome Banking");
	
	a.setFont(new Font("Times new roman",30));
	add(a,0,0);
	Label b =new  Label("\n\tThe bank loan management system is an interface that facilitates customers to apply for\n\t online loans and monitor the status over time.\n\tThis system provides details about customers, details of their loans, EMI details and its ratio details.\" " );
	add(b,0,3);
	b.setFont(new Font("Times new roman",22));
	a.setAlignment(Pos.CENTER);
	
	

}}
