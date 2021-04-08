//Peter Gilbert
//CS611 Legends
//March 2021
//the board for Legends -> extends RPGBoard
import java.util.Random;
public class LegBoard extends RPGBoard{
    //default party location
    private final int defaultPartyLocX = 0;
    private final int defaultPartyLocY = 0;
    private final String playerIcon = "P";

    //last player location
    private int lastX;
    private int lastY;

    //number of tile types currently in Legends = 3
    private final int NUM_TYPES = 3;

    //default constructor
    public LegBoard(){
        board = new LegTile[DEFAULT_SIZE][DEFAULT_SIZE];
        initBoard();
    }
    public LegBoard(int row, int col){
        board = new LegTile[row][col];
        lastX = defaultPartyLocX;
        lastY = defaultPartyLocY;
    }

    //initialize the board so that the party isn't stuck in a corner
    //around 20% non accessible, 30% market, 50% common cells
    //just regenerate the board if the party starts trapped in the corner
    public void initBoard(){
        //total tiles on the board
        int totalTiles = DEFAULT_SIZE*DEFAULT_SIZE;
        //number of market tiles is about 30 percent
        int numMarket = (int) (totalTiles * .3);
        //number of walls is around 20 percent
        int numWalls = (int) (totalTiles * .2);
        //wilderness tiles are calculated from the remainder
        int remaining = totalTiles - numMarket - numWalls;
        //now as we go through the whole board we can take a random number of 1-3 and place the tiles accordingly
        //if it's a 3 or 4 then it's a wild tile so that the top is not mostly markets and walls
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[0].length; y++){
                //the party will always start on a blank tile
                if(x==defaultPartyLocX && y==defaultPartyLocY){
                    board[x][y] = new WildTile();
                    remaining--;
                }
                //otherwise generate it randomly
                else{
                    Random rand = new Random();
                    int tileNum = rand.nextInt(NUM_TYPES+1) + 1;
                    //if it equals 1 then it's a market tile, and so on...
                    if(tileNum == 1 && numMarket > 0){
                        board[x][y] = new MarketTile();
                        numMarket--;
                    }
                    else if(tileNum == 2 && numWalls > 0){
                        board[x][y] = new WallTile();
                        numWalls--;
                    }
                    else if((tileNum == 4 || tileNum == 3) && remaining > 0){
                        board[x][y] = new WildTile();
                        remaining--;
                    }
                    else if(numWalls > 0){
                        board[x][y] = new WallTile();
                        numWalls--;
                    }
                    else if(numMarket > 0){
                        board[x][y] = new MarketTile();
                        numMarket--;
                    }
                    else{
                        board[x][y] = new WildTile();
                        remaining--;
                    }
                }
            }
        }
        //if the player has no where to go
        //generate a new board
        if(!(checkRoute(defaultPartyLocX, defaultPartyLocY))){
            initBoard();
        }
        updatePlayer(defaultPartyLocX, defaultPartyLocY);
    }

    //method to check if the party has a route they would be able to go
    //return true if they can go, otherwise return false
    public boolean checkRoute(int x, int y){
        //check the four adjacent tiles to the player
        if(x-1 >= 0 && board[x-1][y]!=null && ((LegTile)board[x-1][y]).isWalkable == true){
            return true;
        }
        else if(y-1 >= 0 && board[x][y-1]!=null && ((LegTile)board[x][y-1]).isWalkable == true){
            return true;
        }
        else if(x+1 < DEFAULT_SIZE && board[x+1][y]!=null && ((LegTile)board[x+1][y]).isWalkable == true){
            return true;
        }
        else if(y+1 < DEFAULT_SIZE && board[x][y+1]!=null && ((LegTile)board[x][y+1]).isWalkable == true){
            return true;
        }

        return false;
    }

    //check if the party is able to go to that tile
    public boolean canGo(int x, int y){
        if(x>=0 && x<board.length && y>=0 && y<board[0].length && ((LegTile)board[x][y]).isWalkable){
            return true;
        }
        System.out.println("Can't go there!");
        return false;
    }

    //updates the Party's position on the map
    public void updatePlayer(int x, int y){
        //change back to the original icon
        if(board[lastX][lastY] instanceof WallTile){
            ((WallTile)board[lastX][lastY]).resetIcon();
        }
        else if(board[lastX][lastY] instanceof WildTile){
            ((WildTile)board[lastX][lastY]).resetIcon();
        }
        else{
            ((MarketTile)board[lastX][lastY]).resetIcon();
        }

        ((LegTile)board[x][y]).setTileIcon(playerIcon);
        //update latest location
        lastX = x;
        lastY = y;
    }

}
