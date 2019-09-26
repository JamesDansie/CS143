package csc143.gol;

import java.io.*;
/**
 * This class is for the Game Of Life Model
 * 
 * @author James Dansie
 * @version PA7 - Game of Life Standard Level
 */
public class MyGameOfLife extends java.util.Observable 
    implements GameOfLife, GoBoardConstants, Serializable {
	/**
    *This field represents the board.
    */
	private int[][] board;
	
	/**
	 * This is a parameterless constructor. It creates the board as 19x19 2D int array.
	 */
	public MyGameOfLife() {
		this.board = new int[19][19];
	}

	/**
	 * This method gets the state of a cell.
	 * @param row This is the row of the array/board
	 * @param col This is the column of the array/board
	 * @return Returns a 0 if the cell is dead, and 1 if the cell is alive.
     * @throws IllegalArugmentException If column or row is out of bounds
	 */
	@Override
	public int getCellState(int row, int col){
        if(row < FIRST_ROW || row > LAST_ROW){
            throw new java.lang.IllegalArgumentException("Row is out of bounds");
        }else if(col < FIRST_COLUMN || col > LAST_COLUMN){
            throw new java.lang.IllegalArgumentException("Column is out of bounds");
        }else{
            return this.board[row-1][col-1];
        }
	}

	/**
	 * This method sets the state of the cell.
	 * @param row This is the row of the array/board
	 * @param col This is the column of the array/board
	 * @param state This is the state of the cell. 0 is dead, 1 is alive.
     * @throws IllegalArugmentException If column or row is out of bounds	 
     */
	@Override
	public void setCellState(int row, int col, int state) {
        if(row < FIRST_ROW || row > LAST_ROW){throw new java.lang.IllegalArgumentException("Row is out of bounds");}
		if(col < FIRST_COLUMN || col > LAST_COLUMN){throw new java.lang.IllegalArgumentException("Column is out of bounds");}
        if(state < 0 || state > 5){throw new java.lang.IllegalArgumentException("State is out of bounds");}
		this.board[row-1][col-1] = state;
        setChanged();
        notifyObservers();

	}
	
	/**
	 * This method returns the array/board as a string with live
	 * cells as "O" and dead cells as "."
	 * @return String version of the board with "O" and "."
	 */
	@Override
	public String toString() {
		String boardStr = "";
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] == 1)
					boardStr += "O ";
				else
					boardStr += ". ";
			}
			boardStr += "\n";
		}
		return boardStr;
	}

	/**
	 * This method determines the next generation. It will loop through one time to determine
	 * if any cells are birthing, lonely, or overcrowded. After that it will loop through 
	 * again to set cells to alive or dead.
	 */
	@Override
	public void nextGeneration() {
		int count = 0;
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				count = countNeighbors(row, col);
				if(board[row][col] == 0 && count == 3)
					//Birthing
					board[row][col] = 2;
				//Because count includes the current cell we use count <= 2, not count <= 1.
				else if(board[row][col] == 1 && count <= 2)
					//Lonely cell
					board[row][col] = 3;
				//Because count includes the current cell we use count >= 5, not count >= 4.
				else if(board[row][col] == 1 && count >= 5)
					//Overcrowded cell
					board[row][col] = 4;
			}
		}
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] == 2)
					//Birthing cells are now alive.
					this.board[row][col] = 1;
				else if(board[row][col] == 3 || board[row][col] == 4)
					//Lonely or Overcrowded cells are now dead.
					this.board[row][col] = 0;
			}
		}
        setChanged();
        notifyObservers();
	}
	/**
	 * This method counts all the neighbors including the current cell.
	 * @param rowIn The row of the current cell
	 * @param colIn The column of the current cell
	 * @return The number of neighboring cells including the current cell.
	 */
	public int countNeighbors(int rowIn, int colIn) {
		int count = 0;
		int rowStart = rowIn - 1;
		int rowEnd = rowIn + 1;
		int colStart = colIn - 1;
		int colEnd = colIn + 1;
		//The if statements keep the for loops inside the board.
		if(rowIn-1 < 0)
			rowStart = 0;
		if(rowIn+1 > 18)
			rowEnd = 18;
		if(colIn-1 < 0)
			colStart = 0;
		if(colIn+1 > 18)
			colEnd = 18;
		
		for(int row = rowStart; row <= rowEnd; row++) {
			for(int col = colStart; col <= colEnd; col++) {
				//If the cell is alive, lonely (3), or overcrowded(4) it counts as a neighbor.
				if(board[row][col] == 1 || 
				   board[row][col] == 3 ||
				   board[row][col] == 4)
					count++;
			}
		}
		return count;
	}
    /**
     *This method opens a file to restore a game
     *@param filename the name of the file to open
     *@throws java.io.IOException throws an error if the file can't open
     *@throws ClassNotFoundException throws an error if the class is not found?
     */
    public void fileOpen(String filename) throws java.io.IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(filename);
        //FileInputStream fis = new FileInputStream("start.gol");

        ObjectInputStream ois = new ObjectInputStream(fis);
        this.board = (int[][]) ois.readObject();
    }
    /**
     *This method opens a file to restore a game
     *@param file the file to open
     *@throws java.io.IOException throws an error if the file can't open
     *@throws ClassNotFoundException throws an error if the class is not found?
     */
    public void fileOpen(java.io.File file) throws java.io.IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        //FileInputStream fis = new FileInputStream("start.gol");

        ObjectInputStream ois = new ObjectInputStream(fis);
        this.board = (int[][]) ois.readObject();
    }
    /**
     *This method saves a game
     *@param filename the name of the file to be saved
     *@throws java.io.IOException throws an error if the file can't open
     */
    public void fileSave(String filename) throws java.io.IOException{
        FileOutputStream fos = new FileOutputStream(new File(filename));
        //FileOutputStream fos = new FileOutputStream(new File("start.gol"));

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.board);
        oos.close();
    }
    /**
     *This method saves a game
     *@param file the file to be saved
     *@throws java.io.IOException throws an error if the file can't open
     */
    public void fileSave(File file) throws java.io.IOException{
        FileOutputStream fos = new FileOutputStream(file);
        //FileOutputStream fos = new FileOutputStream(new File("start.gol"));

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.board);
        oos.close();
    }
}