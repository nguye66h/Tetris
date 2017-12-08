/**
* The class displays the board and Tetromino pieces on board
* @author Haimi Nguyen
* @Date 3/8/17
*/
public class TetrisBoardTextView{
	
	/** the board */
	protected TetrisBoard board;

	/** constructor, initialize the board and add new piece */
	public TetrisBoardTextView(TetrisBoard b){
		board = b;
		board.addNewPiece();
	}

	/** print out the board and blocks on it */
	public void getBoardString(){



		for (int i = 0; i < board.getNumRows(); i++){
			for (int j = 0; j < board.getNumCols(); j++){
				if (i <= board.getCurrentPieceGridPosition()[0]+3 && i >= board.getCurrentPieceGridPosition()[0] &&
					j <= board.getCurrentPieceGridPosition()[1]+3 && j >= board.getCurrentPieceGridPosition()[1]){
						if (board.getCurrentPiece().isFilled(board.getCurrentPiece().getPieceRotation(),i - board.getCurrentPieceGridPosition()[0], j - board.getCurrentPieceGridPosition()[1]) || board.hasBlock(i,j) ){
								
							System.out.print("x");
						}
							
						else{
									
							System.out.print(" ");
						}
							
						
					
				}	
				else {
					if (board.hasBlock(i,j)){
						System.out.print("x");
					}
					else {
						System.out.print(" ");
					}
					
					
				}
						
							
			}
			System.out.println();	
				
		}	
	}	
}