/**
* This class extends TetrisPiece. It creates 4 different orientations of S shaped Tetromino.
* @author Haimi Nguyen
* @Date 3/8/17
*/
public class TetrisS1 extends TetrisPiece{

	/** Constructor inherits super constructor and initialize the variable
	* that saves boolean value 
	* of the shape of all 4 orientations */
	public TetrisS1(){
		super();
		boolean[][][] filled = {
			{
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, false, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false},
			},

			{
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, false, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false},
			}
		};

		filledSquares = filled;
	}
}