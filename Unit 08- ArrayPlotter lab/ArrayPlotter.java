/* The ArrayPlotter program uses 2D Arrays to create a grid with a number of
 *rows and columns. It uses several methods to command the program to fill the grid 
 *in a certain pattern and cleae the grid if necessary.
 *@author: Rishi Villa
 *Collaborators : None
 *Teacher Name : Ms. Garg
 *Period: 5
 *Due date: Jan 24 2019
 */
import javax.swing.JOptionPane;

public class ArrayPlotter
{
	/** The Array Plotter Graphical User Interface. 
	 */
	private ArrayPlotterGUI gui;
	
	/** The Color Array.  The element values indicate how to color a grid cell:
	 *  - true: Color the cell with the Drawing Color.
	 *  - false: Color the cell with the Background Color.
	 */
	private boolean[][] colorArray;
	
	
	/** Constructs an Array Plotter 
	 */
	public ArrayPlotter()
	{
		gui = new ArrayPlotterGUI(this);
		colorArray = null;
	}
	
	/** Initialize this's Color Array to a new 2D array of boolean values
	 *  with the given dimensions.
	 *  @param rows the number of rows in the new array.
	 *  @param cols the number of columns in the new array.
	 *  Postcondition: All of the Color Array's elements have the value false.
	 */
	public void initializeColorArray(int rows, int cols)
	{
		colorArray = new boolean[rows][cols];
	}

	/** Removes all objects from the grid. 
	 */
	public void onClearGridButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for (int col = 0; col < colorArray[row].length; col++)
			{
				colorArray[row][col] = false;
			}
		}
		gui.update(colorArray);
	}
	
	/** Fills in all the cells of the grid using a row-major traversal. 
	 */
	public void onRowMajorFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for (int col = 0; col < colorArray[row].length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}
	
	/**Fills the grid by the column
	 */
	public void onColMajorFillButtonClick()
	{
		for(int col = 0; col < colorArray[0].length; col++)
		{
			for (int row = 0; row < colorArray.length; row++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}
	
	/** Fills only a diagonal line in the grid
	 */
	public void onMainDiagonalFillButtonClick()
	{
		for(int col = 0; col < colorArray[0].length; col++)
		{
			for (int row = 0; row < colorArray.length; row++)
			{
				if (row == col)
				{
					colorArray[row][col] = true;
					gui.update(colorArray);
				}
			}
		}
	}
	
	/** Fills each row in the grid from left to right
	 */
	private void fillRowLeftToRight(boolean[] row)
	{
		for(int col = 0; col < row.length; col++)
		{
				row[col] = true;
				gui.update(colorArray);
		}
	}
	
	/**fills each row in the grid from right to left
	 */
	private void fillRowRightToLeft(boolean[] row)
	{
		for(int col = row.length - 1; col >= 0; col--)
		{
				row[col] = true;
				gui.update(colorArray);
		}
	}
	
	/**uses the lefttoright and righttoeft method to fill the grid in a serpentine pattern
	 */
	public void onSerpentineFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			if (row % 2 == 0)
				fillRowLeftToRight(colorArray[row]);
			else 
				fillRowRightToLeft(colorArray[row]);
		}
	}
	
	/**Fills only the bottom half of the grid in a triangle shape
	 */
	public void onTriangleFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for (int col = 0; col < colorArray[row].length; col++)
			{
				if (row >= col)
				{
					colorArray[row][col] = true;
					gui.update(colorArray);
				}
			}
		}
	}
	
	/**Fills the grid by the column in reverse order
	 */
	public void onReverseColMajorFillButtonClick()
	{
		for(int col = colorArray[0].length - 1; col >= 0; col--)
		{
			for (int row = colorArray.length - 1; row >= 0 ; row--)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}

	
	/**Fills the grid in the shape of a triangle
	 */
	public void onOtherTriangleFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for (int col = 0; col < colorArray[row].length; col++)
			{
				if (row + col >= colorArray.length - 1)
				{
					colorArray[row][col] = true;
					gui.update(colorArray);
				}
			}
		}
	}
	
	/** main method that creates the grid plotter application. 
	 */
	public static void main(String[] args)
	{	
		ArrayPlotter wow = new ArrayPlotter();
	}
}


