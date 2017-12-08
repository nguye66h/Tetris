/**
* This class extends TetrisPiece. It creates 4 different orientations of backward L shaped Tetromino.
* @author Haimi Nguyen
* @Date 3/8/17
*/
public class TetrisL2 extends TetrisPiece{

	/** Constructor inherits super constructor and initialize the variable
	* that saves boolean value 
	* of the shape of all 4 orientations */
	public TetrisL2(){
		super();
		boolean[][][] filled = {
			{
				{false, false, true, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, false, false, false},
				{true, false, false, false},
				{true, true, false, false},
				{false, false, false, false},
			},

			{
				{true, true, true, false},
				{true, false, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, false, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, false, false, false},
			}
		};

		filledSquares = filled;
	}
}