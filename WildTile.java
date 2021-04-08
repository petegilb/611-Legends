//Peter Gilbert
//CS611 Legends
//March 2021
//wilderness tile for Legends
public class WildTile extends LegTile{
    private final String DEFAULT_ICON = " ";
    //default constructor
    //set the wildnerness tile to just a space to show you can go there.
    public WildTile(){
        super();
        tileIcon = " ";
    }
    public String getIcon(){
        return DEFAULT_ICON;
    }
    //reset back to default
    public void resetIcon(){
        tileIcon = DEFAULT_ICON;
    }

}
