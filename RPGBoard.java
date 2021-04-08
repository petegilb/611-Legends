//Peter Gilbert
//CS611 Legends
//March 2021
//this class is meant to be used as the board for RPG-like games
public class RPGBoard extends Board{
    //default constructor now using RPGTiles
    //default size is set in board
    public RPGBoard(){
        board = new RPGTile[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    //initialize the board with all empty rpgtiles
    public void initBoard(){
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[0].length; y++){
                board[x][y] = new RPGTile();
            }
        }
    }

    //getters and setters
    public RPGTile[][] getBoard(){
        return (RPGTile[][]) board;
    }
    public void setBoard(RPGTile[][] board){
        this.board = board;
    }

}
