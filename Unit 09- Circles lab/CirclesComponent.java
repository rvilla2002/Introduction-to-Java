/* The CircleComponent class draws non intersecting circles and then 
* checks to see if they are intersecting by seeing if one   
*circle is part of another. It uses arraylist that is filled with ArrayList
*objects and creates graphics using the arraylist named Ellipse2d.double.
 * @Author: Rishi Villa
 * Collaborators: None		
 * Teacher Name: Ms.Garg	
 * Period: 5
 * Due Date: 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class CirclesComponent extends JComponent
{
	
	private static List<Ellipse2D.Double> circles;
	public static final int MAX_COLOR_SIZE = 256;
	public static final int MAX_NUM_CIRCLES = 1000;
	public CirclesComponent()
	{
		circles = new ArrayList<Ellipse2D.Double>();
		 
	}
	
	/**
	 *  it generates the circles and draws it
	 *using the g graphics object.
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		generateCircles();
		drawCircles(g2);
	}
	
	/* The method also generates circles and uses a 
	 *for loop to check if the circles are intersecting.
	 */
	
	private void generateCircles()
	{

		circles = new ArrayList<Ellipse2D.Double>();
		
		
		for(int i = 0; i < MAX_NUM_CIRCLES; i++){
			
			while(circles.size() < MAX_NUM_CIRCLES){
			double diameter = Math.random() * (61 - 1) + 1;
			double y = Math.random() * (getHeight() - diameter);
			double x = Math.random() * (getWidth() - diameter);
			Ellipse2D.Double add = new Ellipse2D.Double(x,y,diameter,diameter);
			
		
			
			if(!circleIntersects(add))	
				circles.add(i, add);
	
				}	
			}	
		}
		
		/* This method draws the circles using random colors and the 
		 *graphics objects.
		 */
	private void drawCircles(Graphics2D g2)
	{
		for(int i = 0; i < circles.size(); i++){
		
		int r = (int) (Math.random() * (MAX_COLOR_SIZE));
		int g = (int) (Math.random() * (MAX_COLOR_SIZE));
		int b = (int) (Math.random() * (MAX_COLOR_SIZE));
		
		Color randColor = new Color(r,g,b);
			
		g2.setColor(randColor);
		g2.draw(circles.get(i));
		
		}
		
		
	}		

	/* 
	 *uses for loop to grow through each circle.
	 *Uses an if statement to check if they are intersecting
	 *returns true if the if condition is met.
	 */
	private boolean circleIntersects(Ellipse2D.Double circle)
	{
		boolean isTouching = false;
		
		for(int i = 0; i < circles.size(); i++){
			
			double locX = Math.pow(circles.get(i).getCenterX() - circle.getCenterX(), 2);
			double locY = Math.pow(circles.get(i).getCenterY() - circle.getCenterY(), 2);
			double locOfBoth = (circles.get(i).getHeight() / 2) + (circle.getHeight() / 2);
			
			if(Math.sqrt(locX + locY) < locOfBoth){
				isTouching = true;
			}
		}
		
		
		return isTouching;
	}
}

