import javax.swing.JOptionPane;

/**
 *This class is for playing the Game of Life.
 * @author James Dansie
 * @version PA1 - Game of Life Challenge
 */
public class TestGameOfLife {
	/**
    *This method sets the board for the first starting position
    *@param This object is the board/GameOfLife object
    */
    public static void setBoard(GameOfLife board) {
        // the two alive cells in the upper left
        board.setCellState(3, 4, GameOfLife.ALIVE);
        board.setCellState(4, 4, GameOfLife.ALIVE);
        // the block in the upper right
        board.setCellState(3, 13, GameOfLife.ALIVE);
        board.setCellState(3, 14, GameOfLife.ALIVE);
        board.setCellState(4, 13, GameOfLife.ALIVE);
        board.setCellState(4, 14, GameOfLife.ALIVE);
        // the beehive in the center
        board.setCellState(8, 7, GameOfLife.ALIVE);
        board.setCellState(8, 8, GameOfLife.ALIVE);
        board.setCellState(9, 6, GameOfLife.ALIVE);
        board.setCellState(9, 9, GameOfLife.ALIVE);
        board.setCellState(10, 7, GameOfLife.ALIVE);
        board.setCellState(10, 8, GameOfLife.ALIVE);
        // the glider on the lower left
        board.setCellState(15, 6, GameOfLife.ALIVE);
        board.setCellState(16, 4, GameOfLife.ALIVE);
        board.setCellState(16, 6, GameOfLife.ALIVE);
        board.setCellState(17, 5, GameOfLife.ALIVE);
        board.setCellState(17, 6, GameOfLife.ALIVE);
        // the blinker in the lower right
        board.setCellState(13, 13, GameOfLife.ALIVE);
        board.setCellState(13, 14, GameOfLife.ALIVE);
        board.setCellState(13, 15, GameOfLife.ALIVE);
        
    }
   /**
    *This is the main method for the game of life. It declares the board,
    *sets the board, and then calls new generations.
    *@param agrs stores any sting input arguements. Not used here.
    */
	public static void main(String[] args) {
        GameOfLife life = null;
      life = new MyGameOfLife();
		
//		//I made life into my own class so I could call a new method.
//		MyGameOfLife life = new MyGameOfLife();
//      System.out.println(life.countNeighbor(3,13)));
      setBoard(life);
      
//      System.out.println("Starting point:");
//      System.out.println(life.toString());
//      System.out.println();
//
//      life.nextGeneration();
//      System.out.println("First Generation:");
//      System.out.println(life);
//      System.out.println();
      

      

      for(int gen = 0; gen <= 7; gen++) {
    	  System.out.println("Generation "+gen+":");
    	  System.out.println(life);
    	  System.out.println();
          JOptionPane.showMessageDialog(null, "Click OK to continue");
          life.nextGeneration();
      }
	}

}
