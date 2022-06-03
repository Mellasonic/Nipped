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

import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

import java.util.Arrays;

/**
 * an attic
 */
public class Attic extends mellasonic.nipped.game.point_and_click.locations.Attic{
    /**
     * class constructor
     * @param handler the object for handling when something is consumed
     * @param changer the screen change handler
     */
    public Attic(ConsumableHandler handler, ScreenChanger changer) {
        super(changer, true);
        addObjects(Arrays.asList(
                new Food(599, 392) {
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                },
                new Food(564, 153){
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
