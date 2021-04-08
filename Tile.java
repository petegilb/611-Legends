//Peter Gilbert
//CS611 Legends
//March 2021
//this class is the base tile class to be extended
public class Tile{
    protected String contents;
    //default constructor
    public Tile(){
        contents = "";
    }
    //set contents on create
    public Tile(String str){
        contents = str;
    }

    //overriding toString
    @Override
    public String toString(){
        return contents;
    }

    //getters/setters
    public String getContents(){
        return contents;
    }
    public void setContents(String contents){
        this.contents = contents;
    }
}
