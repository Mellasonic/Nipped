/* ICS Final Project Nipped
 2022/06/03
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 3 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin
 Version 1.1
 2022/06/03
 Time spent: 10 min
 New features/processing: create interactive handler
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import mellasonic.nipped.interactable.Interactive;

public interface ConsumableHandler {
    /**
     * called when an interactive object is consumed
     * @param object the consumed object
     */
    void onConsume(Interactive object);
}
