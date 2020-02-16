
public class EventTile {
	private String description;
	private int price;
	
	public EventTile( String description, int price ) {
		this.description = description;
		this.price = price;
	}

	//EventTile getters
	public String getDescription() { return description; }
	public int getPrice() { return price; }
	
	//EventTile setters
	public void setDescription( String description) { this.description = description; }
	public void setPrice( int price ) { this.price = price; }
}
