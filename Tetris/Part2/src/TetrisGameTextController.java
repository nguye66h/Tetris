import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/** This class is the controller class of the game
* @author Haimi Nguyen
* @Date 3/8/17
*/
public class TetrisGameTextController{
	
	TetrisBoardTextView view;
	TetrisBoard board;

	/** constructor, initialize the board and view as well as display board
	* read input from console
	*/
	public TetrisGameTextController(){
		board = new TetrisBoard();
	
		view = new TetrisBoardTextView(board);
		refreshDisplay();
		readInput();

	}

	/** read the input from the console to move the piece */
	private void readInput(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// prompt the user for input
		System.out.println( "Please enter an move (l,r,d,z,x) or type Quit to end." ); 
 
		// I/O almost always requires a try/catch
		// block as exceptions may be thrown 
		try 
		{
			String line;
 
			// loop until the user types "Quit"
			do {
 
				// try to read a line
				// this function potentially throws an IOException
				line = reader.readLine(); 

				moveEntered(line);
				
				refreshDisplay();
				
 
			} while ( (!line.equals( "Quit" ) ) );
				
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}

	/** Print text view of the game. First, print the number of tetrises cleared. 
	* Second, print the number of lines cleared. Then, print the tetris board. 
	**/
	private void refreshDisplay(){

		System.out.println("Number of Tetrises cleared: " + board.getNumTetris());
		System.out.println("Number of lines cleared: "+ board.getNumLines());

		System.out.println("----------");
		view.getBoardString();
		System.out.println("----------");
	}

	/** r: right l: left d: down z: cw x: ccw
	@param move **/
	private void moveEntered(String move){
		int moveType = 5;
		switch (move){
			case "r": board.moveRight();
						break;
										
			case "l": board.moveLeft();
			
					break;	

			case "d": board.moveDown();
			break;
			
			case "z": board.rotateCW();
				break;

			case "x": board.rotateCCW();
			
					break;

			default: break;
		}

	
	}
}