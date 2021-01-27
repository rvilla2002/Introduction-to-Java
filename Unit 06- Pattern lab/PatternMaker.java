/**This program uses a grid to create patterns of numbers and colors in specific rows and 
 *columns using nested loops.
 * @author: Rishi Villa	
 * Teacher Name: Ms.Garg
 * Period: 5
 * Due Date: 11/15/2018 
 */

import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
//This block of code is used to declare the instance variables.
public class PatternMaker
{
	/** Dimensions for the different worlds */
	public static final int NUM_ROWS_NUMBER_GRID = 10;
	public static final int NUM_COLS_NUMBER_GRID = 10;
	
	public static final int NUM_ROWS_COLOR_GRID = 19;
	public static final int NUM_COLS_COLOR_GRID = 19;
	
	/** Draw the different patterns. Comment others out while working on a single pattern.
	 *  Uncomment calls to completed patterns before turning in.
	 */	
	 	
	 	
	 //This block of code is used to set the parameters amd specify where the patterns are drawn.	
	public static void main(String[] args)
	{
		drawPattern1(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
		drawPattern2(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern3(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern4(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	}
	
//This block of code draws the first pattern in the grid using a for loop.
	public static void drawPattern1(int numRows, int numCols)
	{
		BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
		World<Integer> world = new World<Integer>(grid);
		
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				Location myLoc = new Location(row, col);
				if(row >= col)
					world.add(myLoc, col);
			}
		}

		world.show();

	}
	
// This method draws the second pattern using for loops and if statements.
	public static void drawPattern2(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				Location myLoc = new Location(row, col);
				if(row > col)
					world.add(myLoc, Color.red);
				else if(row == col)
					world.add(myLoc, Color.green);
				else
					world.add(myLoc, Color.blue);
			}
		}
				
		world.show();
	}
	
//This method draws the third patter using for loops and if statements within each other.
	public static void drawPattern3(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				Location myLoc = new Location(row, col);
				if(col % 3 == 0)
					world.add(myLoc, Color.red);
				else if(col % 3 == 1)
					world.add(myLoc, Color.green);
				else
					world.add(myLoc, Color.blue);
			}
		}
				
		world.show();
	}
	
/*This method draws the third pattern using for loops and declaring boolean values.
 *It also uses an if statement to draw the various patterns in a specified color.
 */
	public static void drawPattern4(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				Location myLoc = new Location(row, col);
				
				Boolean part1 = (col + row) >= 9;
				Boolean part2 = (col - row) <= 9;
				Boolean part3 = (row - col) <= 9;
				Boolean part4 = (row + col) <= 27;
				
				if(part1 && part2 && part3 && part4)
					world.add(myLoc, Color.red);
			}
		}
		
		world.show();
	}
}

