/**
* The CircleComponent class is designed to input random colors and create circles 
*in random positions. Uses the instance variables and provides random colors.
* @author : Rishi Villa 
* Collaborators: None
* Teacher Name: Ms.Garg
* Period: 5
* Due Date: 11-09-2018
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// Declare all the instance variables
public class CircleComponent extends JComponent
{
	private static final int MAX_NUM_CIRCLS = 100;
    private static final int MAX_DIAM_CIRCLS = 50;
	private static final int MIN_DIAM_CIRCLS = 20;
	public static final int MAX_CLR_SIZE = 256;

	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		
		for(int k = 0; k <= MAX_NUM_CIRCLS; k++){
			
			g2.setColor(getRandomColor());
			Ellipse2D.Double generate = generateCircle();
			g2.fill(generate);
		}
	}

	/*Generates and returns a circle with a diameter range of 20 to 50
	*Places circle at a random location via getRandomInteger method
	*@return circle
	*/
	private Ellipse2D.Double generateCircle()
	{
		
		int diameterOfCircle = getRandomInteger(20, 50);
		
		Ellipse2D.Double circle = new Ellipse2D.Double(getRandomInteger(0,
		getWidth() - diameterOfCircle),
		getRandomInteger(0, getHeight() - diameterOfCircle), diameterOfCircle, diameterOfCircle);
		return circle;
		
	}
	
	/*Generates and returns a random integer with a specified range
	 *@param min minimum number
	 *@param max maximum number
	 *@return random integer
	 */
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











