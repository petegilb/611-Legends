//Peter Gilbert
//CS611 Legends
//March 2021
//this class is meant to be used as a tile for Legends
//the types of tiles will extend this class
public class LegTile extends RPGTile{
    protected String tileIcon;
    //default constructor
    public LegTile(){
        super();
        tileIcon = "";
    }

    //make the toString Method for a tile represent its type of tile with one letter
    @Override
    public String toString(){
        return tileIcon;
    }

	public String getTileIcon() {
		return tileIcon;
	}

	public void setTileIcon(String tileIcon) {
		this.tileIcon = tileIcon;
	}
}
