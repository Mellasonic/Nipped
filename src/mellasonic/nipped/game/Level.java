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
 New features/processing: Created interface
*/

package mellasonic.nipped.game;

import javafx.scene.Parent;

/**
 * A particular level in the game
 */
public interface Level {
    /**
     * @return the screen/mini application of the current level
     */
    Parent getNode();
}
