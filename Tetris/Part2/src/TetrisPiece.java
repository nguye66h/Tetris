/**
* Abstract class that describes briefly a Tetromino piece and its behaviors
* @author Haimi Nguyen
* @Date 3/8/17
*/
public abstract class TetrisPiece{
	
	/**
	* 3 dimensional array maintaining which squares are filled 
	* first dimension is rotation (index 0: 0 degrees, 
	* index 1: 90 degrees, index 2: 180 degrees, index 3: 270 degrees) 
	* second and third dimensions create 4x4 grid with true values indicating filled squares
	*/
	protected boolean[][][] filledSquares;

	/** Maintains the current rotation. */
	protected int pieceRotation = 0;

	/** Constructor, sets piece rotation at 0 */
	public TetrisPiece(){
		pieceRotation = 0;
	}

	/** Rotate the piece counter-clockwise by 90 degrees. */
	public void rotateCW(){
		if (pieceRotation <= 270){
			pieceRotation = pieceRotation + 90;
		}
		else{
			pieceRotation = (pieceRotation + 90) - 360;
		}
	}

	/** Rotate the piece counter-clockwise by 90 degrees. */
	public void rotateCCW(){
		if (pieceRotation > 90){
			pieceRotation = pieceRotation - 90;
		}
		else{
			pieceRotation = 360 + (pieceRotation - 90);
		}
	}

	/** Get the rotation of this piece.
	* @return 0, 90, 180, or 270 degrees.
	*/
	public int getPieceRotation(){
		return pieceRotation;
	}

	/**
	* Checks if there is a TetrisBlock at the (row, col) position 
	* for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
	* @param rot the TetrisPiece rotation value (should be 0, 90, 180, or 270)
	* @param row the row within the TetrisPiece 4x4 grid
	* @param col the col within the TetrisPiece 4x4 grid
	* @return true if there is a block in the position for that rotation
	*/
	public boolean isFilled(int rot, int row, int col){
		switch(rot){
			case 0:
				return filledSquares[0][row][col];
				
			case 90:
				return filledSquares[1][row][col];
				
			case 180:
				return filledSquares[2][row][col];
				
			case 270:
				return filledSquares[3][row][col];
				
			default:
				return filledSquares[0][row][col];
				
		}
	}
}