//Peter Gilbert
//CS611 Legends
//March 2021
//default class for RPG like games -> extends BoardGame
public class RPGGame extends BoardGame{
    //variables
    private RPGBoard board;
    
    //move options
    protected final String moveUP = "W";
    protected final String moveLEFT = "A";
    protected final String moveDOWN = "S";
    protected final String moveRIGHT = "D";
    protected final String showInfo = "I";
    protected final String quitGame = "Q";
    protected final String showInv = "E";
    protected final String showMap = "M";

    //default constructor
    public RPGGame(){
        board = new RPGBoard();
    }


}
