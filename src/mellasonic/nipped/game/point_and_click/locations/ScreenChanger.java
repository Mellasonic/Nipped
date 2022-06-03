/* ICS Final Project Nipped
 2022/06/02
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 2 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin, James Huynh
 Version 1.1
 2022/06/02
 Time spent: 10 min
 New features/processing: create screen changer
*/

package mellasonic.nipped.game.point_and_click.locations;

import mellasonic.nipped.game.point_and_click.Screen;

/**
 * A screen changing utility class
 */
public interface ScreenChanger {
    /**
     * changes the screen
     * @param to the screen to change to
     */
    void screenChange(Screen to);
}
