
public class EventCard {
	private String description;
	private int times_drawn;
	private int price;
	private int special_event; 
	private boolean held_status;
	private int target_tile;
	
	//Event	 constructor
	public EventCard( String description, int times_drawn, int price, int special_event, boolean held_status, int target_tile ) {
		this.description = description;
		this.times_drawn = times_drawn;
		this.price = price;
		this.special_event = special_event;
		this.held_status = held_status;
		this.target_tile = target_tile;
	}

	//Event getters
	public String getDescription() { return description; }
	public int getTimesDrawn() { return times_drawn; }
	public int getPrice() { return price; }
	public int getSpecialEvent() { return special_event; }
	public boolean getHeldStatus()  { return held_status; }
	public int getTargetTile() { return target_tile; }
	
	//Event setters
	public void setDescription( String description ) { this.description = description; }
	public void setTimesDrawn( int times_drawn ) { this.times_drawn = times_drawn; }
	public void setPrice( int price ) { this.price = price; }
	public void setSpecialEvent( int special_event ) { this.special_event = special_event; } 
	public void setHeldStatus( boolean held_status ) { this.held_status = held_status; }
	public void setTargetTile( int target_tile ) { this.target_tile = target_tile; }
}
