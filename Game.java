import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public Player[] players = new Player[6];
	private BoardTile[] board;
	private EventCard[] community_chest;
	private EventCard[] chance;
	
	private int communitychest_index = 0;
	private int chance_index = 0;
	
	private int player_index = 1; 
	private Player banker = new Player( "banker", -1, 0, false, null );
	
	//Game constructor
	public Game( Player[] players ) {
		this.players = players;
		players[0] = banker;
	}

	//Game getters
	public Player[] getPlayers() { return players; }
	public BoardTile getBoardTile( int index ) { return board[index]; } 
	public BoardTile[] getBoard() { return board; }
	public EventCard[] getCommunityChest() { return community_chest; }
	public EventCard[] getChance() { return chance; } 
	public int getPlayerIndex() { return player_index; }
	
	//Game setters
	public void setPlayers( Player[] players ) { this.players = players; }
	public void setBoard( BoardTile[] board ) { this.board = board; }
	public void setCommunityChest( EventCard[] community_chest ) { this.community_chest = community_chest; }
	public void setChance( EventCard[] chance ) { this.chance = chance; }
	
	
	//setUpBoard
	public void setUpBoard() { 	
		
		File board_file = new File( "board.txt" );
		board = new BoardTile[ (int) board_file.length() ];
		
		String import_text;
		String token;
		int index;
		
		//Import the board from a .txt into the BoardTile array 
		Scanner file_scanner;
		try {
			file_scanner = new Scanner( board_file );
		} catch (FileNotFoundException e) {
			return;
		}
		Scanner line_scanner; 
		
		index = 0;
		while( file_scanner.hasNextLine() ) {
			import_text = file_scanner.nextLine();
			line_scanner = new Scanner( import_text );
			line_scanner.useDelimiter("//");
			
			token = line_scanner.next();
			
			switch ( token ) {
				case "PROPERTY" :
					//retriever raw inputs from text_file
					String name = line_scanner.next();
					String category = line_scanner.next();
					int price = Integer.parseInt( line_scanner.next() );
					String rent_input = line_scanner.next();
					int house_price = Integer.parseInt( line_scanner.next() );
					
					//process rent_input
					int[] rent = new int[6]; int i = 0;
					Scanner process_rent = new Scanner( rent_input );
					process_rent.useDelimiter(",");
					while( process_rent.hasNext() ) { 
						rent[i] = Integer.parseInt( process_rent.next() );
						i++;
					}
										
					//create PropertyTile and BoardTile
					PropertyTile input_property = new PropertyTile( banker, rent, 0, name, price, false, category, house_price );
					board[index] = new BoardTile("PROPERTY", input_property, null );
					
					index++;
					break;
				
				case "EVENT" :
					String event_type = line_scanner.next();
					int event_price = Integer.parseInt( line_scanner.next() );
					EventTile input_event = new EventTile( event_type, event_price );
					board[index] = new BoardTile("EVENT", null, input_event );
				
					index++;
					break;
			}
		}		
		
		//Import decks from .txt files
		//Community Chest: 
		File community_chest_file = new File( "communitychest_deck.txt" );
		community_chest = new EventCard[ (int) community_chest_file.length() ];
		try {
			file_scanner = new Scanner( community_chest_file );
		} catch (FileNotFoundException e) {
			return;
		}
		
		index = 0;
		import_text = file_scanner.nextLine();
		while( file_scanner.hasNextLine() ) {
			import_text = file_scanner.nextLine();
			line_scanner = new Scanner( import_text );
			line_scanner.useDelimiter("//");
			
			String description = line_scanner.next();
			int price = Integer.parseInt( line_scanner.next() );
			int special_event = Integer.parseInt( line_scanner.next() );
			int target_tile = Integer.parseInt( line_scanner.next() );
			
			community_chest[index] = new EventCard( description, 0, price, special_event, false, target_tile );
		}
		
		//Chance:
		File chance_file = new File( "chance_deck.txt" );
		chance = new EventCard[ (int) community_chest_file.length() ];
		try {
			file_scanner = new Scanner( chance_file );
		} catch (FileNotFoundException e) {
			return;
		}
	
		index = 0;
		import_text = file_scanner.nextLine();
		while( file_scanner.hasNextLine() ) {
			import_text = file_scanner.nextLine();
			line_scanner = new Scanner( import_text );
			line_scanner.useDelimiter("//");
			
			String description = line_scanner.next();
			int price = Integer.parseInt( line_scanner.next() );
			int special_event = Integer.parseInt( line_scanner.next() );
			int target_tile = Integer.parseInt( line_scanner.next() );
			
			chance[index] = new EventCard( description, 0, price, special_event, false, target_tile );
		}

		file_scanner.close();
		return; 
	}
	
	//build house
	public void buildHouse( int player_input ) { 
		System.out.println("Enter a property index to build houses on");
		// check to make sure the owner is the owner and has the funds and make sure there is no hotel on the property
		if( board[player_input].getOwner() == players[player_index] && 
				board[player_input].getHouses() < 5 &&
				players[player_index].getBalance() >= board[player_input].getHousePrice() ){
			// remove the proper funds from the player
			players[player_index].setBalance( players[player_index].getBalance() - board[player_input].getHousePrice() );
			//increase the houses on the property
			board[player_input].setHouses( board[player_input].getHouses() + 1 );
		}
		else { 
			System.out.println("Couldn't complete build.");
		}		
	}
	
	//sell house
	public void sellHouse( int player_input ) {
		System.out.println("Enter a property index to sell houses on");
		// check to make sure the owner is the owner and make sure there is a house on the property
		if( board[player_input].getOwner() == players[player_index] && 
				board[player_input].getHouses() > 1 ){
			// add the proper funds to the player
			players[player_index].setBalance( players[player_index].getBalance() + board[player_input].getHousePrice()/2 );
			//decrease the houses on the property
			board[player_input].setHouses( board[player_input].getHouses() - 1 );
		}
		else {
			System.out.println("Couldn't complete sale.");
		}
	}
	
	//mortgage property
	public void mortgageProperty( int player_input ) {
		System.out.println("Enter a property index to mortgage");
		// check to make sure the owner is the owner and make sure there is no house on the property and make sure property isn't already mortgaged
		if( board[player_input].getOwner() == players[player_index] && 
				board[player_input].getHouses() == 0 &&
				board[player_input].getMortgageStatus() == false ){
			// add the proper funds to the player
			players[player_index].setBalance( players[player_index].getBalance() + board[player_input].getPrice()/2 );
			//set the mortgage status to true
			board[player_input].setMortgageStatus( true );			
		}	
	}
	
	//redeem a mortgage
	public void redeemProperty( int player_input ) {
		// check to make sure the owner is the owner and make sure property is already mortgaged
		if( board[player_input].getOwner() == players[player_index] && 
				board[player_input].getMortgageStatus() == true ){
			// add the proper funds to the player
			players[player_index].setBalance( players[player_index].getBalance() - board[player_input].getPrice()/2 );
			//set the mortgage status to true
			board[player_input].setMortgageStatus( false );			
		}
	}

	//trade a property
	public void tradeProperty() {
		
		
	}
	
	//roll -- add input arg for consecutive rolls
	public int[] roll( int times_rolled ) {
		int[] roll_result = new int[2];
		Random d6 = new Random();
		
		roll_result[0] = d6.nextInt(6) + 1;
		roll_result[1] = d6.nextInt(6) + 1;	
		
		System.out.println( "Pre: " + players[player_index].getPosition() );
		System.out.println( "Roll: " + ( roll_result[0] + roll_result[1]) );
		// if times_rolled = 2 and doubles occur, send to jail
		players[player_index].setPosition( players[player_index].getPosition() + roll_result[0] + roll_result[1] );
		System.out.println( "Post: " + players[player_index].getPosition() );
		return roll_result; 
	}
	
	public EventCard drawCommunityChest() {	return community_chest[communitychest_index++]; }
	public EventCard drawChance() { return chance[chance_index++]; }
			
	//end turn
	public void endTurn() {
		if( player_index == players.length - 1) {
			player_index = 1;
		}
		else {
			player_index++;
		}
		return;
	}
}