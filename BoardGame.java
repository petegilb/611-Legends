//Peter Gilbert
//CS611 Legends
//March 2021
//default class for a board game -> creates a board of tiles
public class BoardGame extends Game{
    protected Board board;

    //default constructor
    public BoardGame(){
        board = new Board();
    }

    //getters/setters
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
}
