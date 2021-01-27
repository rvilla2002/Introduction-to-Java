/**
* The SalmonCritter class is designed to use conditional statements to decide the 
*color of the objects placed in the grid. It also uses other instance variables in other loops
to determine the color and location of the objects.
* @author : Rishi Villa
* Collaborators: None
* Teacher Name: Ms.Garg
* Period: 5
* Due Date:4/24/2019
*/
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class SalmonCritter extends Critter
{
	public static final Color YOUTH = Color.ORANGE;
	public static final Color MATURITY = Color.RED;
	public static final int MAX_AGE = 10;
	public static final int MATURITY_AGE = 4;
	public static final double PROBABILITY_OF_EGG = .20;
	
	private int age;
	private boolean hasEgged;
	
	/* Default constructor
	 *
	 */
	public SalmonCritter(){
		
		setColor(YOUTH);
		setDirection(Location.EAST);
		age = 0;
		hasEgged = false;
	}
	
	/* Overrides the processActors method and redefines how they interact
	 *@param actors the list of actors
	 *
	 */
	
	@Override
	public void processActors(ArrayList<Actor> actors){
		
		int rand = (int) (Math.random() * (5-1 + 1) + 1);
		//System.out.println (rand);
		age += 1;
		
		
		
		
		
		if(age >= 4 && (rand * PROBABILITY_OF_EGG == 1)){
			hasEgged = hatchEggs();
			
			
		}
		
		for(int i = 0; i < actors.size(); i++){
			if(actors.get(i) instanceof Bug){
				
				Bug remove = (Bug) (actors.get(i));
				
				remove.removeSelfFromGrid();
				
			}
		
		}
		
		if(age >= MATURITY_AGE){
			setColor(MATURITY);
		}
		
	
	}
	
	
	/* Overrides the the selectMoveLocation method to alter the location of the fist
	 *
	 *@param locs the list of locations
	 *
	 *@return the next valid location to move to
	 */
	@Override
	public Location selectMoveLocation(ArrayList<Location> locs){
		
		
		if(age == MAX_AGE || hasEgged == true){
			return null;
		}
		return super.selectMoveLocation(locs);
	}
	/* Hatches eggs and fills in the area around the old fish
	 *@return if a fish could be added
	 */
	public boolean hatchEggs(){
		boolean canPlace = false;
		ArrayList<Location> possibleLocs
			 = super.getGrid().getEmptyAdjacentLocations(getLocation()); 
		for(int i = 0; i < possibleLocs.size(); i++){
			
			
				
			Location temp = possibleLocs.get(i);
			SalmonCritter wow = new SalmonCritter();
			
			wow.putSelfInGrid(getGrid(), temp);
			canPlace = true;
		
			
		}
		
		return canPlace;
	}


	
}
