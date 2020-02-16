import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DialogBox {

	public static void property( int balance, String player_name, PropertyTile property ) {			
		//if( property.getCategory() == "RAILROAD") { return; }
		
		Stage window = new Stage();	
		Pane property_l = new Pane();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle( "Unpurchased Property" );
		window.setMinWidth(350);
		window.setMinHeight(500);
		
		property_l.setMinWidth(350);
		property_l.setMinHeight(500);
		property_l.setPrefWidth(350);
		property_l.setPrefHeight(350);
		
		Label property_name = new Label( property.getName() );
		property_name.setLayoutX(70);
		property_name.setLayoutY(55);
		property_name.setPrefWidth(250);
		property_name.setPrefHeight(35);
		property_name.setContentDisplay( ContentDisplay.CENTER );
		property_name.setTextAlignment( TextAlignment.CENTER );
		property_name.setFont( new Font("Franklin Gothic Medium", 24) );		
		
		Rectangle border = new Rectangle();		
		border.setFill( Color.WHITE );
		border.setHeight(335);
		border.setWidth(325);
		border.setLayoutX(15);
		border.setLayoutY(15);
		border.setStroke( Color.BLACK );
		border.setStrokeWidth(1.75);
		property_l.getChildren().add(border);
		
		Rectangle header = new Rectangle();
		switch( property.getCategory() ) {
		case "INDIGO":
			header.setFill( Color.INDIGO );
			property_name.setTextFill( Color.WHITE );
			break;
		case "TEAL":
			header.setFill( Color.SKYBLUE );
			property_name.setTextFill( Color.BLACK );
			break;
		case "PURPLE":
			header.setFill( Color.DARKORCHID );
			property_name.setTextFill( Color.BLACK );
			break;
		case "ORANGE":
			header.setFill( Color.ORANGE );
			property_name.setTextFill( Color.BLACK );
			break;
		case "RED":
			header.setFill( Color.RED );
			property_name.setTextFill( Color.BLACK );
			break;
		case "YELLOW":
			header.setFill( Color.YELLOW );
			property_name.setTextFill( Color.BLACK );
			break;
		case "GREEN":
			header.setFill( Color.GREEN );
			property_name.setTextFill( Color.BLACK );
			break;
		case "BLUE":
			header.setFill( Color.BLUE );
			property_name.setTextFill( Color.WHITE );
			break;
		default:
			header.setFill( Color.WHITE );
			property_name.setTextFill( Color.BLACK );
			break;
		}
		header.setHeight(75);
		header.setWidth(300);
		header.setLayoutX(25);
		header.setLayoutY(25);
		header.setStroke( Color.BLACK );
		header.setStrokeWidth(2.5);
		property_l.getChildren().add(header);
		property_l.getChildren().add(property_name);
		
		Label title = new Label("T I T L E   D E E D");
		title.setLayoutX(130);
		title.setLayoutY(40);
		title.setContentDisplay( ContentDisplay.CENTER );
		title.setFont( new Font("Franklin Gothic Medium", 12) );
		property_l.getChildren().add(title);


		Label rent = new Label( "RENT" );
		rent.setLayoutX(135);
		rent.setLayoutY(105);
		rent.setFont( new Font("System", 20));
		property_l.getChildren().add(rent);

		Label house_1 = new Label( "With 1 House" );
		house_1.setLayoutX(45);
		house_1.setLayoutY(135);
		house_1.setFont( new Font("System", 20));
		property_l.getChildren().add(house_1);

		Label house_2 = new Label( "With 2 Houses" );
		house_2.setLayoutX(45);
		house_2.setLayoutY(165);
		house_2.setFont( new Font("System", 20));
		property_l.getChildren().add(house_2);

		Label house_3 = new Label( "With 3 Houses" );
		house_3.setLayoutX(45);
		house_3.setLayoutY(195);
		house_3.setFont( new Font("System", 20));
		property_l.getChildren().add(house_3);

		Label house_4 = new Label( "With 4 Houses" );
		house_4.setLayoutX(45);
		house_4.setLayoutY(225);
		house_4.setFont( new Font("System", 20));
		property_l.getChildren().add(house_4);
	
		Label rent_0 = new Label( "$" + Integer.toString(property.getRent(0) )  );
		rent_0.setLayoutX(200);
		rent_0.setLayoutY(105);
		rent_0.setFont( new Font("System", 20));
		property_l.getChildren().add(rent_0);

		Label rent_1 = new Label( "$  " + Integer.toString(property.getRent(1)) + "." );
		rent_1.setLayoutX(235);
		rent_1.setLayoutY(135);
		rent_1.setContentDisplay( ContentDisplay.RIGHT );
		rent_1.setFont( new Font("System", 20));
		property_l.getChildren().add(rent_1);

		Label rent_2 = new Label( "  " + Integer.toString(property.getRent(2)) + "." );
		rent_2.setLayoutX(235);
		rent_2.setLayoutY(165);
		rent_2.setContentDisplay( ContentDisplay.RIGHT );
		rent_2.setFont( new Font("System", 20));
		property_l.getChildren().add(rent_2);

		Label rent_3 = new Label( "  " + Integer.toString(property.getRent(3)) + "." );
		rent_3.setLayoutX(235);
		rent_3.setLayoutY(195);
		rent_3.setContentDisplay( ContentDisplay.RIGHT );
		rent_3.setFont( new Font("System", 20));
		property_l.getChildren().add(rent_3);

		Label rent_4 = new Label( "  " + Integer.toString(property.getRent(4)) + "." );
		rent_4.setLayoutX(235);
		rent_4.setLayoutY(225);
		rent_4.setContentDisplay( ContentDisplay.RIGHT );
		rent_4.setFont( new Font("System", 20));
		property_l.getChildren().add(rent_4);

		Label hotel = new Label( "With HOTEL  " + Integer.toString(property.getRent(5)) );
		hotel.setLayoutX(100);
		hotel.setLayoutY(255);
		hotel.setContentDisplay( ContentDisplay.RIGHT );
		hotel.setFont( new Font("System", 20));
		property_l.getChildren().add(hotel);

		Label mortgage_value = new Label( "Mortgage Value " + Integer.toString(property.getPrice()/2 ) );
		mortgage_value.setLayoutX(85);
		mortgage_value.setLayoutY(290);
		mortgage_value.setContentDisplay( ContentDisplay.RIGHT );
		mortgage_value.setFont( new Font("System", 20));
		property_l.getChildren().add(mortgage_value);

		Label house_price = new Label( "Houses cost " + Integer.toString(property.getHousePrice() ) );
		house_price.setLayoutX(100);
		house_price.setLayoutY(310);
		house_price.setContentDisplay( ContentDisplay.RIGHT );
		house_price.setFont( new Font("System", 20));
		property_l.getChildren().add(house_price);

		Label name_display = new Label( player_name + "'s Balance: ");
		name_display.setLayoutX(50);
		name_display.setLayoutY(355);
		name_display.setFont( new Font("System", 14));
		property_l.getChildren().add(name_display);

		Label balance_display = new Label( Integer.toString(balance) );
		balance_display.setLayoutX(195);
		balance_display.setLayoutY(355);
		balance_display.setContentDisplay( ContentDisplay.RIGHT );
		balance_display.setFont( new Font("System", 14));
		property_l.getChildren().add(balance_display);

		Button purchase = new Button("Purchase");
		purchase.setLayoutX(90);
		purchase.setLayoutY(400);
		// on press
		property_l.getChildren().add(purchase);

		Button auction = new Button("Auction");
		auction.setLayoutX(210);
		auction.setLayoutY(400);
		// on press
		property_l.getChildren().add(auction);

		Scene property_s = new Scene( property_l, 350, 500 );
		
		window.setScene( property_s );
		window.showAndWait();
		
	}
	
	public static void event( int balance, String player_name, EventTile event, Game game ) {
		Stage window = new Stage();	
		VBox event_l = new VBox();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle( event.getDescription() );
		window.setMinWidth(350);
		window.setMinHeight(200);
	
		event_l.setMinWidth(350);
		event_l.setMinHeight(200);
		event_l.setPrefWidth(350);
		event_l.setPrefHeight(200);

		Button accept = new Button("OK");
		accept.setOnAction( e -> window.close() );
		
		Label description;
		EventCard card;
		
		switch ( event.getDescription() ) {
		case "Community Chest":
			card = game.drawCommunityChest();
			description = new Label('"' + card.getDescription() + '"');
			break;
		case "Chance":
			card = game.drawChance();
			description = new Label('"' + card.getDescription() + '"');
			break;
		/*
		case "Jail":
			break;
		case "Income Tax":
			break;
		case "Luxary Tax":
			break;
		case "Free Parking":
			description = new Label( '"' + event.getDescription() + '"');
			break;
		case "GO":
			break;
		*/
		default:
			description = new Label( '"' + event.getDescription() + '"');
			break;
		}
		
		event_l.getChildren().add(accept);
		event_l.getChildren().add(description);
		
		event_l.setSpacing(20);
		
		event_l.setAlignment(Pos.CENTER);

		Scene event_s = new Scene( event_l, 350, 200 );
		
		window.setScene( event_s );
		window.showAndWait();		
		
	}
	
	public static void auction() {
		
	}

	public static void jailed() {
		
	}
}
