/* ICS Final Project Nipped
 2022/06/03
 Time spent: 30 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - June 3, 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh, Daniel Ye
 Version 1.0
 2022/06/03
 Time spent: 30 mins
 New features/processing: Added ability to store scores as an object in this class
*/

package mellasonic.nipped.main_menu.leaderboard;

/**
* This class stores a singular score, by storing the name and its corresponding score
*/
public class Score {
   /**
   * This variable stores the score of the user
   */
    public final int score;
    /**
    * This variable stores the name of the user
    */
    public final String name;
    /**
    * Class constructor
    * @param name The name of the user
    * @param score The score of the user
    */
    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String toString(){
      return "[" + score + " " + name + "]";
    }
}
