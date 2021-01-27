   /**
* The RectangleComponent class is designed to generate smaller rectangles that fill 
*the previous bigger one with different colors and it does not repeat a color.
* @author Rishi Villa
* Collaborators: None
* Teacher Name: Ms.Garg 
* Period: 5
* Due Date: 11-09-2018
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

//Declare all the instance variables
public class RectangleComponent extends JComponent
{
	private static final int MAX_DIAM_CIRCLS = 50;
	private static final int MIN_DIAM_CIRCLS = 20;
	private static final int MAX_NUM_CIRCLS = 100;
	public static final int MAX_CLR_SIZE = 256;
	public static final int WIDTH_CONSTANT = 10;
	public static final int HEIGHT_CONSTANT = 5;
	@Override
	
	//Generates rectangles nested within one another
	
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
	
		int width = getWidth();
		int height = getHeight();
		int x = 0;
		int y = 0;
		while (width > WIDTH_CONSTANT && height > HEIGHT_CONSTANT)
		{
			g2.setColor(getRandomColor());
			Rectangle box = new Rectangle(x, y, width, height);
			g2.fill(box);
			x += WIDTH_CONSTANT;
			y += WIDTH_CONSTANT;
			width -= (2 * WIDTH_CONSTANT);
			height -= (2 * WIDTH_CONSTANT);
		}
	
	/*Generates and returns a random integer with a specified range
	 *@param min minimum number
	 *@param max maximum number
	 *@return random integer
	 */
	}
	private int getRandomInteger(int min, int max)
	{
		int randomRange = (int) (Math.random() * (max  + 1 - min) + min);
	
		return randomRange;
	}
	
	/*Generates and returns a random color
	*@return random color
	*/
	private Color getRandomColor()
	{
		int red = (int) (Math.random() * (MAX_CLR_SIZE));
		int green = (int) (Math.random() * (MAX_CLR_SIZE));
		int blue = (int) (Math.random() * (MAX_CLR_SIZE));

		Color randomColorOfCircle = new Color(red,green,blue);

		return randomColorOfCircle; 
	}
}
