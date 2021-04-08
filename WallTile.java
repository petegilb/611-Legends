//Peter Gilbert
//CS611 Legends
//March 2021
//tile that is not walkable or able to be passed through
public class WallTile extends LegTile{
    private final String DEFAULT_ICON = "#";
    //default constructor
    //set the wall tiles icon to a # so it represents a wall
    public WallTile(){
        super();
        isWalkable = false;
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
