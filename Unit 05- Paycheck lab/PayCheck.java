
/**
 *	Paycheck Class
 * The Paycheck Class is the 
 * @author Rishi Villa
 * Collaborators: None
 * Teacher Name: Ms.Garg
 * Period: 5
 * Due Date: 10-29-2018
 */
 
  
public class PayCheck 
{
	/* Static Constants Go Here */
	public static final int NO_HRS = 40;
	public static final double HRLY_WGE = 9.75;
	public static final double OVERTIME_WAGE = 1.5 * HRLY_WGE;
	public static final int MNGR_BONUS = 100;
	public static final double CMSN_1 = 0.05;
	public static final double CMSN_2 = 0.08;
	public static final double CMSN_3 = 0.13;


	
	/* Instance variables */
	private String employee;
	private double hoursWorked;
	private boolean isManager;
	private double weeklySales;
	
	/** 
	 *  Creates a PayCheck object for an employee given the name and
	 *  whether or not this employee is a manager.
	 */
	public PayCheck(String name, boolean manager)
	{
		employee = name;
		isManager = manager;
		hoursWorked = 0;
		weeklySales = 0;
	}


	public double calcWages()
	{
		double wage = 0;
		
		if (hoursWorked >= NO_HRS)
		{
			wage = (hoursWorked - NO_HRS) * OVERTIME_WAGE;
			wage = wage + (NO_HRS *HRLY_WGE);
		}
		else
			wage = hoursWorked *HRLY_WGE;
		
		if (isManager)
			wage = wage + MNGR_BONUS;
			
		wage = wage + calcCommission();
		
		return wage;
	}
	
	private double calcCommission()
	{
		if (weeklySales>=300)
			return (CMSN_3*weeklySales);
		else if (weeklySales>=100)
			return (CMSN_2*weeklySales);
		else
			return (CMSN_1*weeklySales);
	}
	
	/** Retrieves the employee's name
	 *  @return the name of this employee
	 */
	public String getName()
	{
		return employee;
	}
	
	/** Reports whether or not this employee is a manager
	 *  @return true if this employee is a manager, false otherwise
	 */
	public boolean isManager()
	{
		return isManager;
	}
	
	/** Retrieves the number of hours worked 
	 *  @return the number of hours worked this pay period
	 */
	public double getHours()
	{
		return hoursWorked;
	}

	/** Resets the number of hours worked to newHours
	 *  @param newHours the number of hours worked this pay period
	 */
	public void setHours(double newHours)
	{
		hoursWorked = newHours;
	}

	/** Retrieves the total amount of sales generated 
	 *  @return the total amount of sales generated this pay period
	 */
	public double getSales()
	{
		return weeklySales;
	}

	/** Resets the amount of sales generated to newSales
	 *  @param newSales the total amount of sales generated this pay period
	 */
	public void setSales(double newSales)
	{
		weeklySales = newSales;
	}
}
