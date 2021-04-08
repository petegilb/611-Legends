//Peter Gilbert
//CS611 Legends
//March 2021
//tile for markets and is walkable
public class MarketTile extends LegTile{
    private final String DEFAULT_ICON = "M";
    //default constructor
    //set the tileicon to M for market
    public MarketTile(){
        super();
        tileIcon = DEFAULT_ICON;
    }
    public String getIcon(){
        return DEFAULT_ICON;
    }
    //reset back to default
    public void resetIcon(){
        tileIcon = DEFAULT_ICON;
    }

}
