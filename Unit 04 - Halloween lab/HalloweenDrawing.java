
/*
 @author Rishi Villa
 Collaborators : None
 Teacher Name : Ms.Garg
 Due Date : 10/5/2018
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class HalloweenDrawing extends JComponent
{
	private Graphics2D g2;
	private int width;
	private int height;
	
	/** Draw a house, a pumpkin, and a greeting
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Convert g back to its Graphics2D self
		g2 = (Graphics2D)g;
		
		// Get size of component window
		width = getWidth();
		height = getHeight();
		
		// Draw house 
		drawHouse();
		
		// Draw pumpkin
		drawPumpkin();
		
		// Draw greeting
		g2.setColor(Color.DARK_GRAY);
		g2.drawString("Happy halloween, WolfPack", 25,25);

	}
	
	/** 
	 */
	public void drawHouse()
	{
		g2.setColor(Color.red);
		int houseX = 40;
	    int houseY = 140;
	    int houseWidth = 200;
	    int houseHeight = 160;
	    Rectangle house = new Rectangle( houseX, houseY, houseWidth, houseHeight); 	
	    g2.draw(house);	
	    g2.setColor(Color.blue);
	    g2.fill(house);	
	    
	    // draw roof of house
	    g2.setColor(Color.black);
	    Line2D.Double line1 = new Line2D.Double(40,140,140,100);
	    g2.draw(line1);
	    g2.setColor(Color.black);
	    Line2D.Double line2 = new Line2D.Double(240, 140,140,100);
	    g2.draw(line2);	
	    drawHouseFeatures( houseX, houseY, houseWidth,  houseHeight);	

	}
	
	/** 
	 */
	public void drawHouseFeatures(int houseX, int houseY, int houseWidth, int houseHeight)
	{
		//Draw the door on the house
		g2.setColor(Color.red);
		int doorX = houseX + 70;
		int doorY = houseY + 80;
		int doorWidth =  50;
		int doorHeight = (houseHeight/2);
		Rectangle door = new Rectangle(doorX, doorY, doorWidth, doorHeight);	
		g2.draw(door);
		Color crimson = new Color(220,20,60);
		Color lightCyan = new Color(224,255,255);
		g2.setColor(crimson);
		g2.fill(door);	
			
		//Draw the right window of the house
		g2.setColor(lightCyan)	;
		int windowX = houseX +20;	
		int windowY = houseY + 75; 
		int windowWidth = doorWidth - 10;
        int windowHeight = (doorHeight/2 + 3);
        Rectangle windowRight = new Rectangle (windowX, windowY, windowWidth, windowHeight);
        g2.draw(windowRight);
        g2.fill(windowRight);
        
        //Draw the left window of the house 
        g2.setColor(lightCyan)	;
		int windowX2 = houseX +130;	
		int windowY2 = houseY + 75; 
		int windowWidth2 = doorWidth - 10;
        int windowHeight2 = (doorHeight/2 + 3);
        Rectangle windowLeft = new Rectangle (windowX2, windowY2, windowWidth2, windowHeight2);
        g2.draw(windowLeft);
        g2.fill(windowLeft);
        	
	}
	
	/** 
	 */
	public void drawPumpkin()
	{
		//Drawing the pumpkin next to the house
		Color pumpkinOrange = new Color(255,140,0);
		g2.setColor(pumpkinOrange);
		int pumpkinX = width / 2 + 40;
		int pumpkinY = height / 2 - 75;
		int pumpkinWidth = 280;
		int pumpkinHeight = 175;
		Ellipse2D.Double pumpkinbase = new Ellipse2D.Double(pumpkinX, pumpkinY, pumpkinWidth, pumpkinHeight);
		g2.draw(pumpkinbase);
		g2.fill(pumpkinbase);
		
		// draw the stem on the pumpkin
		g2.setColor(Color.green);
		double stemH = pumpkinX + 135;
		double stemV = pumpkinY - 20;
		int stemWidth = 25;
		int stemHeight = 30;
		Rectangle.Double stem = new Rectangle.Double (stemH, stemV, stemWidth, stemHeight);
		g2.draw(stem);
		g2.fill(stem);
		
		drawPumpkinFace(pumpkinX, pumpkinY, pumpkinWidth, pumpkinHeight);
		
		
		

	}
	
	/** 
	 */
	public void drawPumpkinFace(int pumpkinX, int pumpkinY, int pumpkinWidth, int pumpkinHeight)
		
	{
		//draw the mouth
		double mouthOfPumpkinX = pumpkinX + 120;
		double mouthOfPumpkinY = pumpkinY + 120;
		double diameter = 60;
		Ellipse2D.Double mouth;
		mouth = new Ellipse2D.Double(mouthOfPumpkinX, mouthOfPumpkinY, diameter, diameter);
		g2.setColor(Color.black);
		g2.draw(mouth);
		g2.fill(mouth);
		
		
		//draw the left eye
		double leftEyeX = pumpkinX + 65;
		double leftEyeY = pumpkinY + 65;
		double diameter2 = 30;
		Ellipse2D.Double leftEye;
		leftEye = new Ellipse2D.Double(leftEyeX, leftEyeY, diameter2,diameter2);
		g2.setColor(Color.black);
		g2.draw(leftEye);
		g2.fill(leftEye);

	}
}