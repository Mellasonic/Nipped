/* ICS Final Project Nipped
 2022/05/19
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 19 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/19
 Time spent: 10 min
 New features/processing: created singleton pattern, numFood attribute
*/

package mellasonic.nipped.game;

/**
 * Singleton class for the current game data
 */
public class GameData {
    /**
     * singleton pattern - instance of the game data
     */
    private static GameData instance;

    /**
     * Number of foods consumes
     */
    private int numFood;

    /**
     * Private class constructor - there should only be one instance
     */
    private GameData(){
        numFood = 0;
    }

    /**
     * @return the amount of food consumed
     */
    public int getNumFood() {
        return numFood;
    }

    /**
     * Sets the amount of food consumer
     * @param numFood the amount of food consumed
     */
    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    /**
     * consumes a piece of food - increasing the amount of food
     */
    public void consume(){
        setNumFood(getNumFood() + 1);
    }

    /**
     * Creates a new instance of GameData
     * @return the new instance
     */
    public static GameData newInstance(){
        instance = new GameData();
        return instance;
    }

    /**
     * @return the current game instance
     */
    public static GameData getInstance(){
        return instance;
    }
}
