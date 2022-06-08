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

package mellasonic.nipped;

import javafx.scene.Scene;

/**
 * An interface for each of the application states (game, main menu, credits, etc.)
 */
public interface AppState {
    /**
     * Returns a scene pertaining to the current user interface
     * @return a JavaFX scene to display to the user
     */
    Scene getScene();
}
