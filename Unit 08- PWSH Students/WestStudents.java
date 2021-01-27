/**
*The Plano West students lab accesses the arrays that have students GPA and then bumps it up.
*@author: Rishi Villa
*Collaborators:None 
*Teacher name: Ms.Garg 
*Period :5
*Due date: 1/16/2019
*
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WestStudents 
{
    // Declares the arrays and other instance variables.
	public static void main( String[] args) 
	{
		// Populate array of Student objects
		Student[] westWolves = loadStudents();
		
		// Display the students
		showStudents(westWolves);
		
		// Calculate the average GPA of all students
		double avgGPA = calcAverageGPA(westWolves);
		System.out.printf("Average GPA: %.5f %n%n", avgGPA);
		
		// Determine the number of juniors
		int numJuniors = calcNumInGrade(westWolves, 11);
		System.out.println("Number of juniors: " + numJuniors);
		
		// Determine the number of seniors
		int numSeniors = calcNumInGrade(westWolves, 12);
		System.out.println("Number of seniors: " + numSeniors);
		System.out.println();
		
		// Bump those with GPA in range [1.9, 2.0] to 2.0
		int numChanged = bumpGPAS(westWolves, 1.9, 2.0);
		System.out.println("Bumped " + numChanged + " gpas in [1.9, 2.0]");
		
		// Bump those with GPA in range [3.55, 3.6] to 3.6
		numChanged = bumpGPAS(westWolves, 3.55, 3.6);
		System.out.println("Bumped " + numChanged + " gpas in [3.55, 3.6]");
		System.out.println();
		
		System.out.println("After bumping:");
		showStudents(westWolves);
		
		// Get the names of students graduating with honors
		String[] honorStudents = getHonorStudents(westWolves, 3.6);
		System.out.println("Honor graduates: " + Arrays.toString(honorStudents));
		System.out.println();		
	}
	
	/** Displays each Student object from the array on a separate line
	 * the parameter is students array with Student objects being evaluated
	 */
	public static void showStudents(Student[] students)
	{
		for(int k = 0; k < students.length; k++)	
			System.out.println(students[k]);
		
		System.out.println();
	}
	
	/** Calculates and returns the average GPA of all the students in the array students
	 *   students array with Student objects being evaluated
	 *  returns average GPA of all the students in the array
	 */
	public static double calcAverageGPA(Student[] students)
	{
		double average = 0;
		double sum = 0;
		
		for(int k = 0; k < students.length; k++)
			sum += students[k].getGPA();
		
		average = sum / students.length;
		
		return average;
	}
	
	/** Counts and returns the number of students who have the same grade level as the given input
	 *  parameter is students array with Student objects being evaluated
	 *  parameter is grade grade level to match
	 *  returns number of students who have the same grade level as grade
	 */
	public static int calcNumInGrade(Student[] students, int grade)
	{
		int count = 0;
		
		for(int k = 0; k < students.length; k++)
		{
			if(students[k].getGradeLevel() == grade)
				count++;
		}
		
		return count;
	}
	
	/** changes the GPA of stdents with a GPA from minGPA to maxGPA to the maxGPA value and returns
	 *    the number of students whose GPAs were changed
	 *  parameter is  students array with Student objects being evaluated
	 * parameter is minGPA minimum GPA to be bumped to maxGPA on the inclusive range [minGPA , maxGPA]
	 *  parameter is maxGPA maximum GPA to be bumped to maxGPA on the inclusive range [minGPA , maxGPA]
	 *  returns number of students whose GPAs were changed
	 */
	public static int bumpGPAS(Student[] students, double minGPA, double maxGPA)
	{
		int count = 0;
		
		for(int k = 0; k < students.length; k++)
		{
			if(students[k].getGPA() >= minGPA && students[k].getGPA() <= maxGPA)
			{
				students[k].updateGPA(maxGPA);
				count++;
			}
		}
		
		return count;
	}
	
	/** Generates and returns an array of Students who have a GPA of at least as large as the
	 *    provided GPA
	 *  array with Student objects being evaluated
	 *   honorsGPA the minimum GPA required to be an honor student
	 *  return fully populated String array containing names of honors students
	 */
	public static String[] getHonorStudents(Student[] students, double honorsGPA)
	{
		int count = 0;
		
		for(int k = 0; k < students.length; k++)
		{
			if(students[k].getGPA() >= honorsGPA)
				count++;
		}
		
		//instantiates resulting array with number of indexes
		String[] honors = new String[count];
		
		//separate index of resulting array
		int i = 0;
		
		for(int k = 0; k < students.length; k++)
		{
			if(students[k].getGPA() >= honorsGPA)
			{
				honors[i] = students[k].getName();
				i++;
			}
		}
		
		return honors;
	}
	
	/** Generates and returns an array of Student objects with data from
	 *  the file PWSH_Students.txt
	 *  returns fully populated array of Student objects
	 */
	private static Student[] loadStudents()
	{
		final String INPUT_FILE = "PWSH_Students.txt";
		
		// Check if the file exists
		File input = new File(INPUT_FILE);
		if (!input.exists())
		{
			System.out.println(INPUT_FILE 
				+ " not found. Check with your teacher.");
			System.out.println("Ending program");
			System.exit(0);
		}
		
		try
		{
			Scanner reader = new Scanner(input);
			
			// read in # of students in file and create array
			int numStudents = reader.nextInt();
			Student[] wolfpack = new Student[numStudents];
			
			// read in each students' data and add to array
			for (int k = 0; k < wolfpack.length; k++)
			{
				int grade = reader.nextInt();
				double gpa = reader.nextDouble();
				String name = reader.nextLine().trim();
				
				Student stu = new Student(name, gpa, grade);
				wolfpack[k] = stu;
			}
			
			return wolfpack;
		}
		catch (IOException exc)
		{
			System.out.println(exc.getMessage());
			System.out.println("Ending program");
			System.exit(0);
		}
		return null;
	}
}
