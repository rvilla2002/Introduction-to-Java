/** 
 * The BugLandRunner class <replace this with description of your program>
 *
 * @author Rishi Villa
 * Collaborators:None				
 * Teacher Name: Ms.Garg
 * Period: 5
 * Due Date: 9/4/2018
 */
 
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import java.awt.Color;
import info.gridworld.grid.Location;

public class BugLandRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Comment each grouping of code. Example: creating randomly located bugs
		// adds the bugs
		Bug bugUp;
		bugUp = new Bug(Color.RED);
		Location topleft = new Location(0,4);
		bugUp.setDirection(120);
		world.add(topleft, bugUp);
				
      Bug bugLeft;
		bugLeft = new Bug(Color.BLUE);
		Location middleleft = new Location(5,0);
		bugLeft.setDirection(45);
		world.add(middleleft, bugLeft);
		
		Bug bugBottom;
		bugBottom = new Bug(Color.ORANGE);
		Location down = new Location(9,5);
		bugBottom.setDirection(315);
		world.add(down, bugBottom);
				   
	   Bug bugRight;
		bugRight = new Bug(Color.CYAN);
		Location middleright = new Location(4,9);
		bugRight.setDirection(225);
		world.add(middleright, bugRight);
		// adds rocks
		Rock Rock1;
		Rock1 = new Rock(Color.BLACK);
		Location abovebug = new Location(4,0);
		Rock1.setDirection(0);
		world.add(abovebug, Rock1);
		
		Rock Rock2;
		Rock2 = new Rock(Color.GREEN);
		Location one = new Location(1,3);
		Rock2.setDirection(0);
		world.add(one, Rock2);
		
		Rock Rock3;
		Rock3 = new Rock(Color.BLUE);
		Location two = new Location(3,1);
		Rock3.setDirection(0);
		world.add(two, Rock3);
		
		Rock Rock4;
		Rock4 = new Rock(Color.RED);
		Location three = new Location(2,2);
		Rock4.setDirection(0);
		world.add(three, Rock4);
		
		Rock Rock5;
		Rock5 = new Rock(Color.MAGENTA);
		Location four = new Location(6,1);
		world.add(four, Rock5);
		
		Rock Rock6;
		Rock6 = new Rock(Color.GREEN);
		Location five = new Location(7,2);
		world.add(five, Rock6);
		
		Rock Rock7;
		Rock7 = new Rock(Color.BLUE);
		Location six = new Location(8,3);
		world.add(six, Rock7);
		
		Rock Rock8;
		Rock8 = new Rock(Color.RED);
		Location seven = new Location(9,4);
		world.add(seven, Rock8);
		
		Rock Rock9;
		Rock9 = new Rock(Color.BLUE);
		Location eight = new Location(8,6);
		world.add(eight, Rock9);
		
		Rock Rock10;
		Rock10 = new Rock(Color.GREEN);
		Location nine = new Location(7,7);
		world.add(nine, Rock10);
		
		Rock Rock11;
		Rock11 = new Rock(Color.MAGENTA);
		Location ten = new Location(6,8);
		world.add(ten, Rock11);
		
		Rock Rock12;
		Rock12 = new Rock(Color.GREEN);
		Location eleven = new Location(5,9);
		world.add(eleven, Rock12);
		
		Rock Rock13;
		Rock13 = new Rock(Color.MAGENTA);
		Location twelve = new Location(3,8);
		world.add(twelve, Rock13);
		
		Rock Rock14;
		Rock14 = new Rock(Color.BLUE);
		Location thirteen = new Location(2,7);
		world.add(thirteen, Rock14);
		
		Rock Rock15;
		Rock15 = new Rock(Color.BLUE);
		Location fourteen = new Location(1,6);
		world.add(fourteen, Rock15);
		
		Rock Rock16;
		Rock16 = new Rock(Color.BLUE);
		Location fifteen = new Location(0,5);
		world.add(fifteen, Rock16);
				   		   
				   		   
				   		   
				   		   
				   		   
				   		   
				   		   
				   		   
				   		   
				   		   
				   
				   
				   
		
		
		// show the world - DO NOT DELETE THIS!!!!
		world.show();
	}
}