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
 * the bedroom
 */
public abstract class Bedroom extends mellasonic.nipped.game.point_and_click.locations.Bedroom {
    /**
     * Class constructor
     *
     */
    public Bedroom(ConsumableHandler handler) {
        addObjects(Arrays.asList(
                new Note(366, 298){
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
