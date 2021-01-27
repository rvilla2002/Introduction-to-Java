/**
* The SportsReport class shows different teams and their standings along 
*with their scores and who they beat.
* @author: Rishi Villa
* Collaborators: None
* Teacher Name: Ms. Garg
* Period: 5
* Due Date: 12/3/2018
*/

public class SportsReport
{
  /** These are names of the winning and losing teams */
  private String winner;
  private String loser;

  /**  variables that declare the winning and losing scores */
  private int winningScore;
  private int losingScore;
  
  /** varibales that declare defined phrases for easy access */
  private static String DEFEATEDTHEM = " beat ";
  private static String WITHASCOREOF = " by a score of ";
  private static String TOTHE = " to ";
  
  
  /** Constructs a SportsReport using the information in score
   *  @param score contains winner, loser, and scores in the format:
   *  <winner> beat <loser> by a score of <winning score> to <losing score>
   */
  public SportsReport(String score)
  {
    extractInformation(score);
  }

  /** Changes the sports scoring information
   *  @param score contains winner, loser, and scores in the format:
   *  <winner> beat <loser> by a score of <winning score> to <losing score>
   */
  public void changeScoringInfo(String score)
  {
    extractInformation(score);
  }

  /* this returns the name of the winning team
   * @return winner name of the winning team
   */
  public String getWinner()
  {
    return winner;
  }

  /* This returns th ename of the losing team
   * @return loser name of the losing team
   */
  public String getLoser()
  {
    return loser;
  }

  /* This returns the score of the winning team
   * @return winningScore score of winning team
   */
  public int getWinningScore()
  {
    return winningScore;
  }

  /* This returns the score of he losing team
   * @return losingScore score of the losing team
   */
  public int getLosingScore()
  {
    return losingScore;
  }

  /* This  method calculates the differenve between the scores of the 
   *winning team and the losing team
   * @return difference the difference between the scores
   */
  public int getScoreDifference()
  {
    int differenceOfScores = (winningScore - losingScore);
    return differenceOfScores;    
  }

  @Override
  // This method formats the output of the scores 
  public String toString()
  {
    String str = "";
    str += String.format("%-25s", winner);
    str += String.format("%4d, ", winningScore);
    str += String.format("%-25s", loser);
    str += String.format("%4d", losingScore);
    
    return str;
  }

  /* This method extracts information and places
   *words within the scores
   * make sense to the reader
   * @return report of scores with words between numbers
   */
  private void extractInformation(String line)
  {
    winner = line.substring(0,line.indexOf(DEFEATEDTHEM));
    loser = line.substring((line.indexOf(DEFEATEDTHEM) + DEFEATEDTHEM.length()), line.indexOf(WITHASCOREOF));
    
    String winscoreNumber = line.substring((line.indexOf(WITHASCOREOF) + WITHASCOREOF.length()),
      line.indexOf(TOTHE));
    String losescoreNumber = line.substring((line.indexOf(TOTHE) + TOTHE.length()));
    
    winningScore = Integer.parseInt(winscoreNumber);
    losingScore = Integer.parseInt(losescoreNumber);
  }
}

