/* ICS Final Project Nipped
 2022/06/01
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 1 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/06/01
 Time spent: 10 min
 New features/processing: create consumable handler
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

/**
 * a handler for consumable objects
 */
public interface ConsumableHandler {
    /**
     * Called when a consumable is consumed in level 1
     * @param consumed the consumed consumable
     */
    void onConsume(Consumable consumed);
}
