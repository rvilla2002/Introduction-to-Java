 /**
* The SalmonRunner class is designed to place various objects like 
*the bug object, the rock object in different colors using a for loop.
* @author :Rishi Villa
* Collaborators: None
* Teacher Name: Ms.Garg
* Period: 5
* Due Date: 4/24/2019
*/

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class SalmonRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Add a SalmonCritter in the upper left-hand corner surrounded by rocks
		world.add(new Location(0, 1), new Rock(Color.CYAN));
		world.add(new Location(1, 0), new Rock(Color.CYAN));
		world.add(new Location(1, 1), new Rock(Color.CYAN));
		
		
		// Place bugs, rocks, and another salmon in random locations
		SalmonCritter critter1 = new SalmonCritter();
		Location topLeft = new Location(0,0);
		world.add(topLeft, critter1);
		for(int i = 0; i < 10; i++){
			
			Bug bug1 = new Bug();
			Rock rock1 = new Rock();
			world.add(bug1);
			world.add(rock1);
			
		}
		SalmonCritter critter2 = new SalmonCritter();
		world.add(critter2);





		// Do not delete this statement		
		world.show();
	}
}

