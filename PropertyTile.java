
public class PropertyTile {
	private Player owner;
	private int[] rent = new int [6];
	private int houses;
	private int house_price;
	private String name;
	private int price;
	private boolean mortgage_status;
	private String category;
	
	//Property constructor
	public PropertyTile( Player owner, int[] rent, int houses, String name, int price, boolean mortgage_status, String category, int house_price ) {
		this.owner = owner;
		this.rent = rent;
		this.houses = houses;
		this.name = name;
		this.price = price;
		this.mortgage_status = mortgage_status;
		this.category = category;
		this.house_price = house_price;
	}

	//Property getter
	public Player getOwner() { return owner; }
	public int getRent() { return rent[houses]; }
	public int getRent( int index ) { return rent[index]; }
	public int getHouses() { return houses; }
	public int getHousePrice() { return house_price; }
	public String getName() { return name; }
	public int getPrice() { return price; }
	public boolean getMortgateStatus() { return mortgage_status; }
	public String getCategory() { return category; }
	
	//Property setter
	public void setOwner( Player owner ) { this.owner = owner; }
	public void setRent( int rent[] ) { this.rent = rent; }
	public void setHouses( int houses ) { this.houses = houses; }
	public void setHousePrice( int house_price ) { this.house_price = house_price; }
	public void setName( String name ) { this.name = name; }
	public void setPrice( int price ) { this.price = price; }
	public void setMortgageStatus( boolean mortgage_status ) { this.mortgage_status = mortgage_status; }
	public void setCategory( String category ) { this.category = category; }
}
