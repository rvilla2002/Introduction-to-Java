/**
* The PotOfGold class is designed to use instance variables 
*and create constructors with parameters so it can be displayed 
*as a gif.
 @author : Rishi Villa
* Collaborators: None
* Teacher Name: Ms.Garg
* Period: 5
* Due Date:4/17/2019 
*/

import info.gridworld.actor.Actor;
import java.awt.Color;

public class PotOfGold extends Actor
{
	
	private static final int minimum = 1;
	private static final int maximum = 10;
	
	private int value;
	
	/* Constructs a PotOfGold Object
	 *@param goldValue the initial value of the pot
	 *@param changePot the new color of the pot
	 *
	 */
	public PotOfGold(int goldValue, Color changePot){
		
		value = goldValue;
		super.setColor(changePot);
	}
	
	
	/* Updates the value of the pot with a random number
	 *in between [1,10]
	 */
	@Override
	public void act(){
		
		if(value <= Integer.MAX_VALUE){
			
			int rand = (int) (Math.random() * (maximum+1-minimum)) + minimum;
			value += rand;
			
		}
		
	}
	/* Gets the pot of gold's value
	 *@return the value of the pot
	 */
	public int getValue(){
		
		return value;
	}
	
	/* Resets the pots value to 0
	 */
	public void resetValue(){
		
		value = 0;
	}
	
		
	
	/** Retrieves the value for displaying on the grid
	 */
	public String getText()
	{
		return "" + String.valueOf(value);  // update to return the value as a string
	}
}
