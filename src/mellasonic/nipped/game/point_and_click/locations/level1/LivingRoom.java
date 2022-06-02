/* ICS Final Project Nipped
 2022/06/01
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 1 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/06/1
 Time spent: 20 min
 New features/processing: extrapolate locations
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

// imports

import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

import java.util.Arrays;

/**
 * The first room - a living room in level 1 and 3
 */
public class LivingRoom extends mellasonic.nipped.game.point_and_click.locations.LivingRoom {

    /**
     * class constructor
     * @param handler the object for handling when something is consumed
     * @param changer the screen change handler
     */
    public LivingRoom(ConsumableHandler handler, ScreenChanger changer) {
        super(changer);
        // add objects to the list of interactives
        addObjects(Arrays.asList(
                new Food(600, 75) {
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                }, new Food(650, 235) {
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                }, new Food(300, 290) {
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
