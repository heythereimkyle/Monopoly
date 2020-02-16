
public class BoardTile {
	private String tile_type;
	private PropertyTile property;
	private EventTile event;
	
	public BoardTile( String tile_type, PropertyTile property, EventTile event ) {
		this.tile_type = tile_type;
		this.property = property;
		this.event = event; 
	}

	//BoardTile getters
	public String getTileType() { return tile_type; }
	public PropertyTile getPropertyTile() { return property; }
	public EventTile getEventTile() { return event; }
	public Player getOwner() { return property.getOwner(); }
	public int getHousePrice() { return property.getHousePrice(); }
	public int getHouses() { return property.getHouses(); }
	public int getPrice() { return property.getPrice(); }
	public boolean getMortgageStatus() { return property.getMortgateStatus(); }
	
	//BoardTile setters
	public void setTileType( String tile_type ) { this.tile_type = tile_type; }
	public void setPropertyTile( PropertyTile property ) { this.property = property; }
	public void setEventTile( EventTile event ) { this.event = event; }
	public void setHouses( int houses ) { property.setHouses( houses ); };
	public void setMortgageStatus( boolean mortgage_status ) { property.setMortgageStatus( mortgage_status ); }
	
}
