/**
*	TetrisModel is the model for Tetris
*	It shows the logic of the game.
*/
public class TetrisModel{

	private int numLinesCleared;
	private int numTetrisesCleared;

	/**
	* Move the Tetris piece to the left 
	* Piece cannot move beyond the borders.
	*/
	public void moveLeft(){

	}

	/**
	* Move the Tetris piece to the right
	* Piece cannot move beyond the borders.
	*/
	public void moveRight(){

	}

	/**
	* Move the Tetris piece down
	* Piece cannot move beyond the borders.
	*/
	public void moveDown(){

	}

	/**
	* Clear lines that are filled. Create a case for when
	* a tetris is cleared.
	*/
	public void clearLine(){

	}

	/**
	* rotate the current Tetris piece clockwise
	*/
	public void rotateClockwise(){

	}

	/**
	* rotate the current Tetris piece anti-clockwise
	*/
	public void rotateAntiClockwise(){

	}

	/**
	* return the number of lines that have been cleared
	*/
	public int getNumLinesCleared(){
		return 0;
	}

	/**
	* return the number of tetrises that have been cleared
	*/
	public int getNumTetrisesCleared(){
		return 0;
	}

	/**
	* choose a random TetrisPiece and make them appear on console
	*/
	public TetroPiece RandomStart(){
		return null;
	}
}