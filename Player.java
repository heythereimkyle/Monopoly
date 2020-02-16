
public class Player {
	private String name; 
	private int balance;
	private int previous_position = 0;
	private int position = 0;
	private boolean jail_status;
	private EventCard[] jail_pass = new EventCard [2];
	
	//order -- most likely not necessary, will follow list order
	//piece -- might be necessary in rendering sprite based on turn
	//Property PropertyList = newProperty   ?? might not be necessary, just edit the property class

	//Player constructor 
	public Player( String name, int balance , int position, boolean jail_status, EventCard[] jail_pass ) {
		this.name = name;
		this.balance = balance;
		this.position = position;
		this.jail_status = jail_status;
		this.jail_pass = jail_pass;
	}

	//Player getters
	public String getName() { return name; } 
	public int getBalance() { return balance; }
	public int getPreviousPosition() { return previous_position; }
	public int getPosition() { return position; } 
	public boolean getJailStatus() { return jail_status; } 
	public EventCard[] getJailPass() { return jail_pass; } 
	
	//Player setters 
	public void setName( String name ) { this.name = name; }
	public void setBalance( int balance ) { this.balance = balance; }
	public void setJailStatus( boolean jail_status ) { this.jail_status = jail_status; }
	public void setJailPass( EventCard[] jail_pass ) { this.jail_pass = jail_pass; }
	public void setPosition( int position ) {
		this.previous_position = this.position;
		this.position = position;
		
		//check to see if player made it around the board
		if( this.position > 40) { 
			this.position = this.position - 40;
		}
	}	
}
