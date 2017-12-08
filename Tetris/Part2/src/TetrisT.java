/**
* This class extends TetrisPiece. It creates 4 different orientations of T shaped Tetromino.
* @author Haimi Nguyen
* @Date 3/8/17
*/
public class TetrisT extends TetrisPiece{

	/** Constructor inherits super constructor and initialize the variable
	* that saves boolean value 
	* of the shape of all 4 orientations */
	public TetrisT(){
		super();
		boolean[][][] fs = {
			{
				{false, true, false, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, false, false, false},
				{true, true, false, false},
				{true, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, true, false},
				{false, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{false, true, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false},
			}
		};

		filledSquares = fs;
	}
}