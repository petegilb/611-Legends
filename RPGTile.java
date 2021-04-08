//Peter Gilbert
//CS611 Legends
//March 2021
//this class is meant to be used as a tile for RPG games
public class RPGTile extends Tile{
    //variables
    protected boolean isWalkable;
    //default constructor
    public RPGTile(){
        super();
        isWalkable = true;
    }
    //allows to set if the tile is walkable or not
    public RPGTile(boolean isWalkable){
        super();
        this.isWalkable = isWalkable;
    }

    //getters/setters
    public boolean getWalkable(){
        return isWalkable;
    }
    public void setWalkable(boolean walk){
        isWalkable = walk;
    }


}
