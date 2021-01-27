/* The TriangleComponent class uses instance variables and methods like 
 *the getHeight, getWeight and classes like graphics which are then used by the 
 *drawTriangle method to draw triangles with a triangle with the specified colors;
 *
 *@author Rishi Villa	
 *Teacher: Ms. Garg 
 *Period: 5
 *Due Date: 21st March 2019
 */
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
	
	//  Declaring the constant class array to hold progression of colors
	private static final Color LAVENDER = new Color(204, 153, 255);
	private static final Color PURPLE = new Color(153, 0, 255);
	private static final Color[] colors = {LAVENDER, Color.cyan, Color.darkGray, 
		Color.blue, PURPLE, Color.pink, Color.black, Color.lightGray};
	private final int offset = 5;	
	//  This declares the raphics object used for drawing
	private Graphics2D gr;
	
	/** The drawTriangle method is used to draw the triangle within the parameters
	 * declares g the Graphics object for drawing in this component
	 */
	@Override
	public void paintComponent(Graphics g) 
	{
		gr = (Graphics2D) g;
		
		
		
		drawTriangle(getWidth() / 2, offset, offset, getHeight() - offset, getWidth() - offset,
		 getHeight() - offset, 0);	
		 	
		 	// place first call to your drawTriangle method here
		
		
		
	}
	
	/* Draws the triangles with given coordinates according to frame using recursion
	 * param x1 the first X coordinate
	 *  x2 the second X coordinate
	 *  x3 the third X coordinate
	 *  y1 the first Y coordinate
	 *  y2 the second Y coordinate
	 *  y3 the third Y coodrinate
	 */
	
	private void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int colorIndex)
	{
		
		if(colorIndex == colors.length - 1){
			colorIndex = 0;
		}
		int[] xValues = {x1,x2,x3};
		int[] yValues = {y1,y2,y3};
		Polygon triangle = new Polygon(xValues, yValues, 3);
			
		gr.setColor(colors[colorIndex]);
		gr.fill(triangle);
		
		// This block of the code draws the main triangle
		if((y1+y2) / 2 != y1){
			drawTriangle(x1, y1, (x1+x2) / 2, (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y3) / 2,
			 colorIndex + 1);
		}
		
		//This block of the code draws the Triangle from the right
		if((x2 + x3) / 2 != x2){
			drawTriangle((x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2,
			 colorIndex + 1);
		}
		
		//This block of the code draws the Triangle from the left
		if((x2 + x3) / 2 != x2){
			drawTriangle((x1 + x3) / 2, (y1 + y3) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3,
			 colorIndex + 1);
		}

	}
}

