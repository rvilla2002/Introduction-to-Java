/**
 *	ComedyOfErrors Class
 *	This class takes a celsius input and converts it into farenheit.
 *  using the formula F = 1.8 X C + 32 and the values were assigned using double;
 *
 */
import java.util.Scanner;

public class ComedyOfErrors
{
	// Constants used in the formula F = 1.8 x C + 32
	public static final double MULTIPLIER = 1.8;
	public static final int ADDITIVE = 32;

	public static void main(String[] args)
	{
		// Enter degrees in Celsius
	    System.out.print("Enter degrees in Celsius to convert: ");
	    Scanner input = new Scanner(System.in);
		double degreesCelsius = input.nextDouble();
		
		// Convert to Fahrenheit
		double degreesFahrenheit = convertToFahrenheit(degreesCelsius);
		
		// Output converted temperature
		System.out.println();
		System.out.print(degreesCelsius + " degrees Celsius = ");
		System.out.print(degreesFahrenheit + " degrees Fahrenheit");
		System.out.println();
	}
	
	/** Calculates and returns the degrees in Celsius to Fahrenheit
	 *  @param degreesC the degrees in Celsius to be converted
	 *  @return the degreesC converted to Fahrenheit
	 */
	public static double convertToFahrenheit(double degreesC)
	{
		double degreesF = MULTIPLIER * degreesC;
		degreesF = degreesF + ADDITIVE; 
		return degreesF;		
	}
}