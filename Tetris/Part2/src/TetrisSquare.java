/**
* This class extends TetrisPiece. It creates 4 different orientations of square shaped Tetromino.
* @author Haimi Nguyen
* @Date 3/8/17
*/
public class TetrisSquare extends TetrisPiece{

	/** Constructor inherits super constructor and initialize the variable
	* that saves boolean value 
	* of the shape of all 4 orientations */
	public TetrisSquare(){
		super();
		boolean[][][] filled = {
			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			}
		};

		filledSquares = filled;
	}
}