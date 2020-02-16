import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Display extends Application {
	
	Game game;
	
  	Player player1, player2, player3, player4, player5, player6;
	Player[] players = new Player[7];
	
	Stage window;
	Scene title_s, creation_s, board_s;
	Button launch_b, start_b, build_b, sell_b, mortgage_b, redeem_b, trade_b, roll_b, end_b;
	Label player1_bal, player2_bal, player3_bal, player4_bal, player5_bal, player6_bal;
	Label player1_displayname, player2_displayname, player3_displayname, player4_displayname, player5_displayname, player6_displayname;
	RadioButton player1_turn, player2_turn, player3_turn, player4_turn, player5_turn, player6_turn;
	TextArea dice1_display, dice2_display;
	
	ToggleGroup turn_display = new ToggleGroup();
	Circle player1_icon, player2_icon, player3_icon, player4_icon, player5_icon, player6_icon;
	
	int player_index;
	int times_rolled = 1;
	int default_balance = 1500;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override 
	public void start( Stage primaryStage ) throws Exception {	
		window = primaryStage;
		window.setTitle("Monopoly");

		//     Title Screen Scene
		Pane title_l = new Pane();
		try {
			Image image = new Image("file:title.png");
			ImageView iv = new ImageView();
			iv.setImage(image);
			title_l.getChildren().add(iv);
			
		} catch(Exception e) {  };
		
		// Launch Button
		launch_b = new Button("Start!");
		launch_b.setOnAction(e -> window.setScene(creation_s));
		launch_b.setLayoutX(540);
		launch_b.setLayoutY(495);		
		title_l.getChildren().add(launch_b);

		title_s = new Scene( title_l, 1080, 810 );
		
		//Game Creation Scene
		Pane creation_l = new Pane();
		try {
			Image image = new Image("file:creation.png");
			ImageView iv = new ImageView();
			iv.setImage(image);
			creation_l.getChildren().add(iv);
			
		} catch(Exception e) { }

		// Player1 Name Field
		TextArea player1_name = new TextArea();
		player1_name.setMaxSize(310, 50);
		player1_name.setLayoutX(65);
		player1_name.setLayoutY(215);
		creation_l.getChildren().add(player1_name);
		
		//Player2 Name Field
		TextArea player2_name = new TextArea();
		player2_name.setMaxSize(310, 50);
		player2_name.setLayoutX(600);
		player2_name.setLayoutY(215);
		creation_l.getChildren().add(player2_name);
		
		//Player3 Name Field
		TextArea player3_name = new TextArea();
		player3_name.setMaxSize(310, 50);
		player3_name.setLayoutX(65);
		player3_name.setLayoutY(380);
		creation_l.getChildren().add(player3_name);
		
		//Player4 Name Field
		TextArea player4_name = new TextArea();
		player4_name.setMaxSize(310, 50);
		player4_name.setLayoutX(600);
		player4_name.setLayoutY(380);
		creation_l.getChildren().add(player4_name);
		
		//Player5 Name Field
		TextArea player5_name = new TextArea();
		player5_name.setMaxSize(310, 50);
		player5_name.setLayoutX(65);
		player5_name.setLayoutY(550);
		creation_l.getChildren().add(player5_name);
		
		//Player6 Name Field
		TextArea player6_name = new TextArea();
		player6_name.setMaxSize(310, 50);
		player6_name.setLayoutX(600);
		player6_name.setLayoutY(550);
		creation_l.getChildren().add(player6_name);
		
		//Player1 Toggle
		CheckBox player1_enable = new CheckBox("Enable Player 1");
		player1_enable.setLayoutX(65);
		player1_enable.setLayoutY(245);
		creation_l.getChildren().add(player1_enable);
		
		//Player2 Toggle
		CheckBox player2_enable = new CheckBox("Enable Player 2");
		player2_enable.setLayoutX(600);
		player2_enable.setLayoutY(245);
		creation_l.getChildren().add(player2_enable);
		
		//Player3 Toggle
		CheckBox player3_enable = new CheckBox("Enable Player 3");
		player3_enable.setLayoutX(65);
		player3_enable.setLayoutY(410);
		creation_l.getChildren().add(player3_enable);
		
		//Player4 Toggle
		CheckBox player4_enable = new CheckBox("Enable Player 4");
		player4_enable.setLayoutX(600);
		player4_enable.setLayoutY(410);
		creation_l.getChildren().add(player4_enable);
		
		//Player5 Toggle
		CheckBox player5_enable = new CheckBox("Enable Player 5");
		player5_enable.setLayoutX(65);
		player5_enable.setLayoutY(580);
		creation_l.getChildren().add(player5_enable);
		
		//Player6 Toggle
		CheckBox player6_enable = new CheckBox("Enable Player 6");
		player6_enable.setLayoutX(600);
		player6_enable.setLayoutY(580);
		creation_l.getChildren().add(player6_enable);		

		// Start Game Button
		start_b = new Button("Start Game");
		start_b.setOnAction(e -> {
			int playercount = 0;
			
			boolean player1_select = player1_enable.isSelected();
			boolean player2_select = player2_enable.isSelected();
			boolean player3_select = player3_enable.isSelected();
			boolean player4_select = player4_enable.isSelected();
			boolean player5_select = player5_enable.isSelected();
			boolean player6_select = player6_enable.isSelected();
			
			if( player1_select ) {
				player1 = new Player( player1_name.getText(), default_balance, 0, false, null);
				players[1] = player1;
				playercount++;
			}
			if( player2_select ) {
				player2 = new Player( player2_name.getText(), default_balance, 0, false, null);
				players[2] = player2;
				playercount++;
			}
			if( player3_select ) {
				player3 = new Player( player3_name.getText(), default_balance, 0, false, null);
				players[3] = player3;
				playercount++;
			}
			if( player4_select ) {
				player4 = new Player( player4_name.getText(), default_balance, 0, false, null);
				players[4] = player4;
				playercount++;
			}
			if( player5_select ) {
				player5 = new Player( player5_name.getText(), default_balance, 0, false, null);
				players[5] = player5;
				playercount++;
			}
			if( player6_select ) {
				player6 = new Player( player6_name.getText(), default_balance, 0, false, null);
				players[6] = player6;
				playercount++;
			}
			
			//resize player array
			Player[] resize = new Player[playercount+1];
			resize[0] = players[0];
			int j = 1;
			
			for( int i = 1; i <= 6; i++ ) {
				if( players[i] != null ) {
					resize[j] = players[i];
					j++;
				}
			}
			
			players = resize;
			
			if( playercount >= 2 ) { 
				game = new Game ( players );
				displayBoard();
			}
			else { 
				System.out.println("Add more players to start a game!"); 
			}
		}); // check to make sure parameters are correct
		start_b.setLayoutX(540);
		start_b.setLayoutY(700);
		creation_l.getChildren().add(start_b);
		
		creation_s = new Scene( creation_l, 1080, 810 );		
		
		//Initial Display
		window.setScene(title_s);
		window.show();
	}
	
	public void displayBoard() {
		game.setUpBoard();
		
		
		// Board Scene
		Pane board_l = new Pane();
		try {
			Image image = new Image("file:board.png");
			ImageView iv = new ImageView();
			iv.setImage(image);
			iv.setPreserveRatio(true);
			iv.setFitWidth(1080);
			iv.setFitHeight(810);
			board_l.getChildren().add(iv);
			
		} catch(Exception e) { }		
		
		// Player 1 and 2 display
		if( players.length-1 >= 2) {
			player1_displayname = new Label( game.players[1].getName() );
			player1_displayname.setLayoutX(850);
			player1_displayname.setLayoutY(300);
			board_l.getChildren().add(player1_displayname);
			
			player1_bal = new Label( Integer.toString( game.players[1].getBalance()) );
			player1_bal.setLayoutX(850);
			player1_bal.setLayoutY(320);
			board_l.getChildren().add(player1_bal);
			
			player1_turn = new RadioButton("");
			player1_turn.setToggleGroup(turn_display);
			player1_turn.setLayoutX(820);
			player1_turn.setLayoutY(300);
			player1_turn.setDisable(true);
			player1_turn.setSelected(true);
			player1_turn.setStyle("-fx-opacity: 1");
			board_l.getChildren().add(player1_turn);
			
			player1_icon = new Circle();
			player1_icon.setFill(Color.BLUE);
			player1_icon.setRadius(5);
			player1_icon.setLayoutX(720);
			player1_icon.setLayoutY(745);
			board_l.getChildren().add(player1_icon);
			
			player2_displayname = new Label( game.players[2].getName()) ;
			player2_displayname.setLayoutX(850);
			player2_displayname.setLayoutY(350);
			board_l.getChildren().add(player2_displayname);
			
			player2_bal = new Label( Integer.toString( game.players[2].getBalance()) );
			player2_bal.setLayoutX(850);
			player2_bal.setLayoutY(370);
			board_l.getChildren().add(player2_bal);
			
			player2_turn = new RadioButton("");
			player2_turn.setToggleGroup(turn_display);
			player2_turn.setLayoutX(820);
			player2_turn.setLayoutY(350);
			player2_turn.setDisable(true);
			player2_turn.setStyle("-fx-opacity: 1");
			board_l.getChildren().add(player2_turn);
			
			player2_icon = new Circle();
			player2_icon.setFill(Color.RED);
			player2_icon.setRadius(5);
			player2_icon.setLayoutX(730);
			player2_icon.setLayoutY(745);
			board_l.getChildren().add(player2_icon);
		}
		
		// Player 3 Display
		if( players.length-1 >= 3) {
			player3_displayname = new Label( game.players[3].getName()) ;
			player3_displayname.setLayoutX(850);
			player3_displayname.setLayoutY(400);
			board_l.getChildren().add(player3_displayname);
			
			player3_bal = new Label( Integer.toString( game.players[3].getBalance()) );
			player3_bal.setLayoutX(850);
			player3_bal.setLayoutY(420);
			board_l.getChildren().add(player3_bal);
			
			player3_turn = new RadioButton("");
			player3_turn.setToggleGroup(turn_display);
			player3_turn.setLayoutX(820);
			player3_turn.setLayoutY(400);
			player3_turn.setDisable(true);
			player3_turn.setStyle("-fx-opacity: 1");
			board_l.getChildren().add(player3_turn);
			
			player3_icon = new Circle();
			player3_icon.setFill(Color.GREEN);
			player3_icon.setRadius(5);
			player3_icon.setLayoutX(720);
			player3_icon.setLayoutY(755);
			board_l.getChildren().add(player3_icon);
		}
		
		// Player 4 Display
		if( players.length-1 >= 4) {
			player4_displayname = new Label( game.players[4].getName()) ;
			player4_displayname.setLayoutX(850);
			player4_displayname.setLayoutY(450);
			board_l.getChildren().add(player4_displayname);
			
			player4_bal = new Label( Integer.toString( game.players[4].getBalance()) );
			player4_bal.setLayoutX(850);
			player4_bal.setLayoutY(470);
			board_l.getChildren().add(player4_bal);
			
			player4_turn = new RadioButton("");
			player4_turn.setToggleGroup(turn_display);
			player4_turn.setLayoutX(820);
			player4_turn.setLayoutY(450);
			player4_turn.setDisable(true);
			player4_turn.setStyle("-fx-opacity: 1");
			board_l.getChildren().add(player4_turn);
			
			player4_icon = new Circle();
			player4_icon.setFill(Color.YELLOW);
			player4_icon.setRadius(5);
			player4_icon.setLayoutX(730);
			player4_icon.setLayoutY(755);
			board_l.getChildren().add(player4_icon);
		}

		// Player 5 Display
		if( players.length-1 >= 5) {
			player5_displayname = new Label( game.players[5].getName()) ;
			player5_displayname.setLayoutX(850);
			player5_displayname.setLayoutY(500);
			board_l.getChildren().add(player5_displayname);
			
			player5_bal = new Label( Integer.toString( game.players[5].getBalance()) );
			player5_bal.setLayoutX(850);
			player5_bal.setLayoutY(520);
			board_l.getChildren().add(player5_bal);
			
			player5_turn = new RadioButton("");
			player5_turn.setToggleGroup(turn_display);
			player5_turn.setLayoutX(820);
			player5_turn.setLayoutY(500);
			player5_turn.setDisable(true);
			player5_turn.setStyle("-fx-opacity: 1");
			board_l.getChildren().add(player5_turn);
			
			player5_icon = new Circle();
			player5_icon.setFill(Color.PURPLE);
			player5_icon.setRadius(5);
			player5_icon.setLayoutX(720);
			player5_icon.setLayoutY(765);
			board_l.getChildren().add(player5_icon);
		}
		
		// Player 6 Display
		if( players.length-1 >= 6) {
			player6_displayname = new Label( game.players[6].getName()) ;
			player6_displayname.setLayoutX(850);
			player6_displayname.setLayoutY(550);
			board_l.getChildren().add(player6_displayname);
			
			player6_bal = new Label( Integer.toString( game.players[6].getBalance()) );
			player6_bal.setLayoutX(850);
			player6_bal.setLayoutY(570);
			board_l.getChildren().add(player6_bal);
			
			player6_turn = new RadioButton("");
			player6_turn.setToggleGroup(turn_display);
			player6_turn.setLayoutX(820);
			player6_turn.setLayoutY(550);
			player6_turn.setDisable(true);
			player6_turn.setStyle("-fx-opacity: 1");
			board_l.getChildren().add(player6_turn);
			
			player6_icon = new Circle();
			player6_icon.setFill(Color.ORANGE);
			player6_icon.setRadius(5);
			player6_icon.setLayoutX(730);
			player6_icon.setLayoutY(765);
			board_l.getChildren().add(player6_icon);
		}
		
		// Dice 1 Display
		dice1_display = new TextArea(" ");
		dice1_display.setMaxSize(8, 8);
		dice1_display.setLayoutX(850);
		dice1_display.setLayoutY(245);
		dice1_display.setEditable(false);
		//dice1_display.setDisable(true);
		//dice1_display.setStyle("-fx-opacity: 1");
		board_l.getChildren().add(dice1_display);
		
		// Dice 2 Display
		dice2_display = new TextArea(" ");
		dice2_display.setMaxSize(8, 8);
		dice2_display.setLayoutX(900);
		dice2_display.setLayoutY(245);
		dice2_display.setEditable(false);
		//dice2_display.setDisable(true);
		//dice2_display.setStyle("-fx-opacity: 1");
		board_l.getChildren().add(dice2_display);
		
		// Build House Button
		build_b = new Button("BUILD HOUSE");
		build_b.setLayoutX(850);
		build_b.setLayoutY(20);
		build_b.setOnAction(e -> window.setScene(board_s)); // build a house
		board_l.getChildren().add(build_b);

		// Sell House Button
		sell_b = new Button("SELL HOUSE");
		sell_b.setLayoutX(850);
		sell_b.setLayoutY(50);
		sell_b.setOnAction(e -> window.setScene(board_s)); // sell a house
		board_l.getChildren().add(sell_b);
		
		// Mortgage Property Button
		mortgage_b = new Button("MORTGAGE PROPERTY");
		mortgage_b.setLayoutX(850);
		mortgage_b.setLayoutY(80);
		mortgage_b.setOnAction(e -> window.setScene(board_s)); // mortgage a property
		board_l.getChildren().add(mortgage_b);
		
		// Redeem Property Button
		redeem_b = new Button("REDEEM PROPERTY");
		redeem_b.setLayoutX(850);
		redeem_b.setLayoutY(110);
		redeem_b.setOnAction(e -> window.setScene(board_s)); // redeem a property
		board_l.getChildren().add(redeem_b);

		// Trade Property Button
		trade_b = new Button("TRADE PROPERTY");
		trade_b.setLayoutX(850);
		trade_b.setLayoutY(140);
		trade_b.setOnAction(e -> window.setScene(board_s)); // trade a property
		board_l.getChildren().add(trade_b);
		
		// End Turn Button
		end_b = new Button("END TURN");
		end_b.setLayoutX(850);
		end_b.setLayoutY(200);
		end_b.setDisable( true );
		end_b.setOnAction(e -> {
			// update RadioBox before turn ends 
			//System.out.println( game.getPlayerIndex() ); 
			
			switch ( game.getPlayerIndex() ) {
			case 1: 
				player1_turn.setSelected( false );
				break;
			case 2:
				player2_turn.setSelected( false );
				break;
			case 3:
				player3_turn.setSelected( false );
				break;
			case 4: 
				player4_turn.setSelected( false );
				break;
			case 5: 
				player5_turn.setSelected( false );
				break;
			case 6: 			
				player6_turn.setSelected( false );
				break;
		}
			// end the turn
			game.endTurn();
			
			// update RadioBox after turn ends 
			switch ( game.getPlayerIndex() ) {
			case 1: 
				player1_turn.setSelected( true );
				break;
			case 2:
				player2_turn.setSelected( true );
				break;
			case 3:
				player3_turn.setSelected( true );
				break;
			case 4: 
				player4_turn.setSelected( true );
				break;
			case 5: 
				player5_turn.setSelected( true );
				break;
			case 6: 			
				player6_turn.setSelected( true );
				break;
			}
			roll_b.setDisable( false );
			end_b.setDisable( true );
			times_rolled = 1;
		} ); // end turn
		board_l.getChildren().add(end_b);
		
		// Roll Button
		roll_b = new Button("ROLL DICE");
		roll_b.setLayoutX(850);
		roll_b.setLayoutY(170);
		roll_b.setOnAction(e -> {		
			int[] dice = game.roll( 0 );
			int units_moved = dice[0] + dice[1];
			
			System.out.println("TR: " + times_rolled);
			
			dice1_display.setText( Integer.toString(dice[0]) );
			board_l.getChildren().remove(dice1_display);
			board_l.getChildren().add(dice1_display);
			
			dice2_display.setText( Integer.toString(dice[1]) );
			board_l.getChildren().remove(dice2_display);
			board_l.getChildren().add(dice2_display);
			
			switch ( game.getPlayerIndex() ) {
			case 1:
				displayMove( player1_icon, game.players[game.getPlayerIndex()].getPreviousPosition(), units_moved );
				break;
			case 2:
				displayMove( player2_icon, game.players[game.getPlayerIndex()].getPreviousPosition(), units_moved );
				break;
			case 3:
				displayMove( player3_icon, game.players[game.getPlayerIndex()].getPreviousPosition(), units_moved );
				break;
			case 4: 
				displayMove( player4_icon, game.players[game.getPlayerIndex()].getPreviousPosition(), units_moved );
				break;
			case 5:
				displayMove( player5_icon, game.players[game.getPlayerIndex()].getPreviousPosition(), units_moved );
				break;
			case 6:
				displayMove( player6_icon, game.players[game.getPlayerIndex()].getPreviousPosition(), units_moved );
				break;
			}
			
			//check for doubles
			if(dice[0] == dice[1]) {
				times_rolled++;
			}
			else {
				//disable roll button
				end_b.setDisable( false );
				roll_b.setDisable( true );
			}
				
			BoardTile current_tile = game.getBoardTile( game.players[game.getPlayerIndex()].getPosition() );

			switch ( current_tile.getTileType() ) {
			case "PROPERTY":
				DialogBox.property( game.players[game.getPlayerIndex()].getBalance(), game.players[game.getPlayerIndex()].getName(), current_tile.getPropertyTile() );
				break;
			case "EVENT":
				DialogBox.event( game.players[game.getPlayerIndex()].getBalance(), game.players[game.getPlayerIndex()].getName(), current_tile.getEventTile(), game );
				break;
			}
		
		}); 
		board_l.getChildren().add(roll_b);
		
		// set board to scene
		board_s = new Scene( board_l, 1080, 810 );		
		window.setScene(board_s);
	}

	public void displayMove ( Circle moving_player, int initial_position, int units_moved ) {
		TranslateTransition move_RL, move_DU, move_LR, move_UD;
		SequentialTransition move_icon;
		
		move_RL = new TranslateTransition( Duration.seconds(.5) , moving_player);
		move_DU = new TranslateTransition( Duration.seconds(.5) , moving_player);
		move_LR = new TranslateTransition( Duration.seconds(.5) , moving_player);
		move_UD = new TranslateTransition( Duration.seconds(.5) , moving_player);
		
		//.setDuration( Duration.seconds(.5) );
		int max_moves;
		int final_position = initial_position + units_moved;
		
		while( units_moved > 0 ) {
			//Bottom side of board - right to left
			if( initial_position < 10 ) {
				max_moves = 10 - initial_position;
				// check to see if the piece needs to move 
				if( max_moves < units_moved ) { 
					// move max spaces					
					move_RL.setByX( -(65 * max_moves) );

					units_moved = units_moved - max_moves;
					initial_position = initial_position + max_moves;					
				}
				else {					
					// move units_moved
					move_RL.setByX( -(65 * units_moved) );
										
					units_moved = units_moved - units_moved;
					initial_position = initial_position + units_moved;
				}
			}
			//Left side of board - down to up
			else if( initial_position >= 10 && initial_position < 20 ) {
				max_moves = 20 - initial_position;
				if( max_moves < units_moved) {
					// move max spaces
					move_DU.setByY( -(65 * max_moves) );
					
					units_moved = units_moved - max_moves;
					initial_position = initial_position + max_moves;
				}
				else {
					// move units_moved
					move_DU.setByY( -(65 * units_moved) );
					
					units_moved = units_moved - units_moved;
					initial_position = initial_position + units_moved;
				}
			}
			//Top side of board - left to right
			else if( initial_position >= 20 && initial_position < 30 ) {
				max_moves = 30 - initial_position;
				if( max_moves < units_moved ) {
					// move max spaces
					move_LR.setByX( 65 * max_moves );
					
					units_moved = units_moved - max_moves;
					initial_position = initial_position + max_moves;
				}
				else {
					// move units_moved
					move_LR.setByX( 65 * units_moved );
					
					units_moved = units_moved - units_moved;
					initial_position = initial_position + units_moved;
				}
			}
			//Right side of board - up to down
			else if( initial_position >= 30 && initial_position < 40 ) {
				max_moves = 40 - initial_position;
				if( max_moves < units_moved ) {
					// move max spaces
					move_UD.setByY( 65 * max_moves );
					
					units_moved = units_moved - max_moves;	
					initial_position = initial_position + max_moves- 40 ;
				}
				else {
					// move units_moved

					move_UD.setByY( (65 * units_moved) );
					
					units_moved = units_moved - units_moved;
					initial_position = initial_position + units_moved;
				}
			}
		}
		
		if( final_position <= 40 ) {
			move_icon = new SequentialTransition( move_RL, move_DU, move_LR, move_UD );
		}
		else {
			move_icon = new SequentialTransition( move_UD, move_RL, move_DU, move_LR );
		}
		move_icon.play();
	}
}