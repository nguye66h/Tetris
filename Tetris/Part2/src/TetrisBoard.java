import java.lang.*;

/** The model class of the Tetris game, controling the logic of the game.
* @author Haimi Nguyen
* @date 3/8/17
*/
public class TetrisBoard{
	/** constant stores number of columns of board */
	public final static int NUM_COLS = 10;

	/** constant stores number of rows of board */
	public final static int NUM_ROWS = 18;

	private int numCols = NUM_COLS;
	private int numRows = NUM_ROWS;

	/** stores boolean values for the board */
	private boolean[][] blockMatrix;
	private TetrisPiece currentPiece;

	/** number of lines formed */
	private int numLines;

	/** number of Tetrises formed */
	private int numTetris;

	/**
	* position of current (falling) piece 
	* currentPieceGridPosition[0] stores the current row 
	* currentPieceGridPosition[1] stores the current column
	*/
	private int[] currentPieceGridPosition;

	/** Constructor sets up the board. */
	public TetrisBoard(){
		initCurrentGP();

		addNewPiece();

		initBoard();
	}

	/**
	* Initialize an int array of length two 
	* to keep track of the grid position of the current piece (row, col)
	*/
	private void initCurrentGP(){
		currentPieceGridPosition = new int[2];
	}

	/**
	* Initialize the 2D board array to have all false values
	**/
	private void initBoard(){
		blockMatrix = new boolean[NUM_ROWS][NUM_COLS];
		for (int i = 0; i < NUM_ROWS; i++){
			for (int j = 0; j < NUM_COLS; j++){
				blockMatrix[i][j] = false;
			}
		}
	}

	/**
	* Update the board array to reflect the newly landed piece's filled squares 
	* using the currentGridPosition values and the currentPiece's rotation value.
	*/
	public void landPiece(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if(currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)){		// if there is a block
					blockMatrix[currentPieceGridPosition[0]+i][currentPieceGridPosition[1]+j] = true;	// then embed the block to board
				}
			}
			
		}

	}

	/** Check if moving left is valid. 
	* @return true if valid move was performed
	*/
	public boolean moveLeft(){
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1] - 1)){ // get piece if moved left
			currentPieceGridPosition[1] = currentPieceGridPosition[1] - 1;	// move current position to left
			return true;
		}
		else{
			return false;
		}
	}

	/** Check if moving right is valid. 
	* @return true if valid move was performed
	*/
	public boolean moveRight(){
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1] + 1)){	// get piece of moved right
			currentPieceGridPosition[1] = currentPieceGridPosition[1] + 1;	// move current position to right
			return true;
		}
		else{
			return false;
		}
	}

	/** Check if moving down is valid. */
	public boolean moveDown(){
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0] + 1, currentPieceGridPosition[1])){
			currentPieceGridPosition[0] = currentPieceGridPosition[0] + 1;
			return true;
		}
		else{				// if cannot move down
			landPiece();		
			numberOfFormedLines();		
			addNewPiece();
			return false;
			
		}
	}

	/** Check if rotating clockwise is valid. 
	* @return true if valid move was performed
	*/
	public boolean rotateCW(){
		if(currentPiece.getPieceRotation() <= 270){
			if (validMove(currentPiece, currentPiece.getPieceRotation() + 90, currentPieceGridPosition[0], currentPieceGridPosition[1])){
				currentPiece.rotateCW();
				return true;
			}
			else{
				return false;
			}
		}
		else if (validMove(currentPiece, currentPiece.getPieceRotation() + 90 - 360, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			currentPiece.rotateCW();
			return true;
		}
		else{
			return false;
		}
		
	}

	/** Check if rotating counter-clockwise is valid. 
	* @return true if valid move was performed
	*/
	public boolean rotateCCW(){
		if(currentPiece.getPieceRotation() <= 90){
			if (validMove(currentPiece, 360 + (currentPiece.getPieceRotation() - 90), currentPieceGridPosition[0], currentPieceGridPosition[1])){
				currentPiece.rotateCCW();
				return true;
			}
			else{
				return false;
			}
		}
		else if(validMove(currentPiece, currentPiece.getPieceRotation() - 90, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			currentPiece.rotateCCW();
			return true;
		}
		else{
			return false;
		}

	}

	/** Checks if placing the piece at grid position (row, col) 
	* with the rotation rot (values can be 0, 90, 180, 270) 
	* would cause a collision (i.e., if there would be a block on an already-filled grid square). 
	* @param piece  
	* @param rot 
	* @param gridRow
	* @param gridCol
	* @return true if there would be a collision
	*/
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol){
		
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if(piece.isFilled(rot, i, j) && hasBlock(gridRow + i, gridCol + j)){
					return true;
				}
			}
		
		
			
		}
		return false;
	}

	/**
	* Checks if placing the piece at grid position (row, col) 
	* with the rotation rot (values can be 0, 90, 180, 270) 
	* would cause an out of bounds condition 
	* (i.e., if there would be a block falling off the board).
	* @param piece  
	* @param rot 
	* @param gridRow
	* @param gridCol
	* @return true if there would be a bounding error
	*/
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol){
		
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if (piece.isFilled(rot, i, j) && (gridRow + i < 0 || gridRow + i >= NUM_ROWS ||
					gridCol + j < 0 || gridCol + j >= NUM_COLS)){
					return true;
				}
			}
			
		}

		return false;

		
	}

	/** Checks if placing the piece at grid position (row, col) 
	* with the rotation rot (values can be 0, 90, 180, 270) 
	* is a valid move. 
	* @param piece  
	* @param rot 
	* @param gridRow
	* @param gridCol
	* @return true if no collision or bounding error
	*/
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol){
		if (!detectOutOfBounds(piece, rot, gridRow, gridCol) && !detectCollision(piece, rot, gridRow, gridCol)){
			return true;
		}
		
		else{
			return false;
		}
		
	}

	/** Check if there is a block in the row and column. 
	* @param row
	* @param col
	* @return true if there is a block
	*/
	public boolean hasBlock(int row, int col){
		return blockMatrix[row][col];
	}

	/**
	* Add a new random Tetris piece to the board at grid position (0, 3).
	*/
	public void addNewPiece(){
		int ran = (int)(Math.random()*7);
		TetrisPiece newPiece;
		switch(ran){
			case 0: newPiece = new TetrisL1();
					break;
			case 1: newPiece = new TetrisL2();
					break;
			case 2: newPiece = new TetrisS1();
					break;
			case 3: newPiece = new TetrisS2();
					break;
			case 4: newPiece = new TetrisSquare();
					break;
			case 5: newPiece = new TetrisStick();
					break;
			default: newPiece = new TetrisT();
					break;
			
		}

		currentPiece = newPiece;
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;
	}

	

	/** Detect and remove any lines formed. 
	* @return the total number found.
	*/
	public void numberOfFormedLines(){
		int sum = 0;
		for (int i = 0; i < NUM_ROWS; i++){
			if (fullLine(i)){
				removeLine(i);
				sum++;
			}
		}
		if (sum == 4){
			numTetris = numTetris + 1;

		}
		numLines = numLines + sum;
	}

	/** Check if there is a full line at the row. 
	* @param row
	* @return true if full
	*/
	private boolean fullLine(int row){
		int sum = 0;
		for (int i = 0; i < NUM_COLS; i++){
			if (!blockMatrix[row][i]){
				return false;
			}
			
			
		}
		return true;	
		
	}

	/** remove the line at a specific full row
	* @param row the row number of the full line
	*/
	private void removeLine(int row){
		boolean[][] blockMatrixtemp = new boolean[NUM_ROWS][NUM_COLS];
		for (int i = 1; i < row+1; i++){
			for (int j = 0; j < NUM_COLS; j++){
				blockMatrixtemp[i][j] = blockMatrix[i-1][j];
				blockMatrix[0][j] = false;
			}
		}
		for (int l = row + 1; l < NUM_ROWS; l++){
			for (int k = 0; k < NUM_COLS; k++){
		
				blockMatrixtemp[l][k] = blockMatrix[l][k];
				
				
			}
		}

		blockMatrix = blockMatrixtemp;
	}

	/** @return the block matrix (the grid of blocks) */
	public boolean[][] getBlockMatrix(){
		return blockMatrix;
	}

	/** @return the currentPiece */
	public TetrisPiece getCurrentPiece(){
		return currentPiece;
	}

	/** @return the currentPieceGridPosition */
	public int[] getCurrentPieceGridPosition(){
		return currentPieceGridPosition;
	}

	/** @return the numCols in the block matrix */
	public int getNumCols(){
		return numCols;
		
	}

	/** @return the numRows in the block matrix */
	public int getNumRows(){
		return numRows;
		
	}

	/** @return number of lines formed */
	public int getNumLines(){
		return numLines;
	}

	/** @return number of Tetrises */
	public int getNumTetris(){
		return numTetris;
	}

}