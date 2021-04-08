//Peter Gilbert
//CS611 Legends
//March 2021
//this class is the base class for a game
public class Game{
    protected boolean isOver;
    //default constructor
    public Game(){
        isOver = false;
    }
    //default method to play the game
    //keeps going until the game is over
    public void playGame(){
        while(isOver == false){
        }
        System.out.println("Game is Over!");
    }

    //getters/setters
    public boolean getIsOver(){
        return isOver;
    }
    public void setIsOver(boolean isOver){
        this.isOver = isOver;
    }

}
