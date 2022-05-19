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

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class for the current game data
 */
public class GameData {
    /**
     * singleton pattern - instance of the game data
     */
    private static GameData instance;

    /**
     * Map of foods consumed
     */
    Map<String, Boolean> consumed;

    /**
     * Private class constructor - there should only be one instance
     */
    private GameData(){
        consumed = new HashMap<>();
    }

    /**
     * Returns whether a particular piece of food was consumed
     * @param id the id of the desired food
     * @return whether or not it was consumed
     */
    public boolean isConsumed(String id) {
        if(!consumed.containsKey(id)) consumed.put(id, false);
        return consumed.get(id);
    }

    /**
     * Consumes food, setting consumed to true
     * @param id the id of the piece of food
     */
    public void consume(String id){
        consumed.put(id, true);
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
