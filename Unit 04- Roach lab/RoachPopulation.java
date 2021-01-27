

public class RoachPopulation 
{
	private static final int DEFAULT_POPULATION = 10;
	
	private int numRoaches;		// The roach population
	
	/** Default constructor, initializes the population to 10 
	 */
	public RoachPopulation() 
	{
		numRoaches = DEFAULT_POPULATION;
	}
	


	/** Provides the current roach population
	 *  @return number of roaches remaining
	 */
	public int getRoaches() 
	{
		return numRoaches;
	}


	/**
	 */
	public void waitForDoubling() 
	{
		numRoaches = numRoaches *2;
	}
	
	/**
	 */
	public int spray(double killPercent) 
	{
		double percentageConvert = killPercent / 100;
		int deadRoaches = (int) Math.ceil(numRoaches * percentageConvert);
		numRoaches = numRoaches - deadRoaches;
		return deadRoaches;
	}
}
	