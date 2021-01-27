/**
* The LeprechaunCritter class is designed to use the Critter superclass and all its
*methods to create constructors of the existing classes and create new methods.                                        
* @author : Rishi Villa
* Collaborators: None
* Teacher Name: Ms.Garg
* Period: 5
* Due Date:4/17/2019 
*/
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class LeprechaunCritter extends Critter
{

	
	private int purseMoney;
	
	
	
	/* Creates a new LeprechaunCritter object
	 *
	 */
	public LeprechaunCritter(){
		
		purseMoney = 0;
	}
	
	/* Creates a new LeprechaunCritter object
	 *with a given money value
	 *
	 *@param moneyGift the starting amount of money
	 */
	public LeprechaunCritter(int moneyGift){
		
		purseMoney = moneyGift;
	}

	/* Gets the amount of money in the LeprechaunCritter's
	 *purse
	 *
	 *@return the money in the purse
	 */
	public int getMoneyInPurse(){
		
		return purseMoney;
	}


	/* Overrides the default processActors method so that
	 *the LeprechaunCritters take the highest valued, closest
	 *PotOfGold
	 *
	 *param actors the array of actors
	 */
	@Override
	public void processActors(ArrayList<Actor> actors){
		
		for(int i = 0; i < actors.size(); i++){
			
			
			if(actors.get(i) instanceof PotOfGold){
				
				PotOfGold firstPot = (PotOfGold) (actors.get(i));
				PotOfGold best = (PotOfGold) (actors.get(i));
				int largestValue = firstPot.getValue();
				
				for(int j = 0; j < actors.size(); j++){
					
					if(actors.get(j) instanceof PotOfGold == true){
						
						PotOfGold test = (PotOfGold) (actors.get(j));
						
						if(largestValue < test.getValue()){
							largestValue = test.getValue();
							best = (PotOfGold) (actors.get(j));
						}
					}
					
				}
				
				
				 
				purseMoney += largestValue;
				
				if(purseMoney >= Integer.MAX_VALUE || purseMoney < 0){
					
					purseMoney = Integer.MAX_VALUE;
				}
				
			
				
				
				best.resetValue();	
			}

				
			
				
				getColor();
				
				
		}
		
	
	
		
	}
	
	/* Overrides the default makeMove method to change
	 *the behavior of the leprechaun
	 *
	 *param loc the location to process
	 */
	
	@Override
	public void makeMove(Location loc){
	
			setDirection(getLocation().getDirectionToward(loc));
			super.makeMove(loc);
			
		
		
		
		
	}
	
	
	
	
	
	/** Turns off the color on the critter's image
	 */
	public Color getColor()
	{
		return null;
	}
}
