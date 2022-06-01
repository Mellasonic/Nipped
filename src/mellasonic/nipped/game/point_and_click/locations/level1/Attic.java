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

import java.util.Arrays;

/**
 * an attic
 */
public abstract class Attic extends mellasonic.nipped.game.point_and_click.locations.Attic{
    /**
     * Class constructor
     *
     */
    public Attic(ConsumableHandler handler) {
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
