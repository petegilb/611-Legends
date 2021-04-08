//Peter Gilbert
//CS611 Legends
//March 2021
//this class is the base board class to be extended
public class Board{
    protected Tile[][] board;
    protected final int DEFAULT_SIZE= 8;
    //default constructor
    public Board(){
        board = new Tile[DEFAULT_SIZE][DEFAULT_SIZE];
    }
    //define a board with a fixed size
    public Board(int row, int col){
        board = new Tile[row][col];
    }

    //initialize the board with all empty tiles
    public void initBoard(){
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[0].length; y++){
                board[x][y] = new Tile();
            }
        }
    }

    //method to get a specific Tile
    public Tile getTile(int x, int y){
        return board[x][y];
    }
    //method to set a specific tile
    public void setTile(int x, int y, Tile tile){
        board[x][y] = tile;
    }

    //override toString
    @Override
    public String toString(){
        String toPrint = "";
        //traverse the board and print each tile
        //each tile has a toString
        String rowString = "";
        //make a row of ---- for each tile
        for(int x=0; x<board[0].length; x++){
            rowString += "----";
        }
        //add a new line
        rowString += "\n";
        rowString = "-" + rowString;
        for(int x=0; x<board.length; x++){
            if(x!=0){
                toPrint+= "\n";
            }
            toPrint += rowString;
            for(int y=0; y<board[0].length; y++){
                toPrint += "| ";
                toPrint += board[x][y].toString();
                toPrint += " ";
                if(y==board[0].length-1){
                    toPrint += "|";
                }
            }
        }
        toPrint += "\n";
        toPrint += rowString;
        return toPrint;
    }

    //getters and setters
    public Tile[][] getBoard(){
        return board;
    }
    public void setBoard(Tile[][] board){
        this.board = board;
    }
}
