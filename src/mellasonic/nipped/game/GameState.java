/* ICS Final Project Nipped
 2022/05/16
 Time spent: 10 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 16 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/16
 Time spent: 10 mins
 New features/processing: Created Game, override methods, allow for changing method
*/

package mellasonic.nipped.game;

import javafx.scene.Scene;
import mellasonic.nipped.AppState;
import mellasonic.nipped.game.point_and_click.Level1;

/**
 * When the player is playing the actual game
 */
public class GameState implements AppState {
    /**
     * The current level
     */
    private Level curLevel;
    /**
     * The current scene
     */
    private Scene cur;

    /**
     * Class constructor
     */
    public GameState(){
        curLevel = new Level1(){
            @Override
            public void nextLevel() {
                System.out.println("Level 2");
            }
        };
        cur = new Scene(curLevel.getNode());
    }
    @Override
    public Scene getScene(){
        return cur;
    }

    /**
     * Moves to another level (usually after one is complete)
     * @param to the level to move to
     */
    public void changeLevel(Level to){
        curLevel = to;
        cur.setRoot(curLevel.getNode());
    }
}
