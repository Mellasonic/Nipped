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

import mellasonic.nipped.game.point_and_click.locations.level1.Note;
import mellasonic.nipped.game.point_and_click.locations.Drawer;

import java.util.Arrays;

/**
 * a drawer in the bedroom
 */
public abstract class BedroomDrawer extends Drawer{
    /**
     * class constructor
     * @param handler the object for handling when something is consumed
     */
    public BedroomDrawer(ConsumableHandler handler){
        super();
        addObjects(Arrays.asList(
                new Food(502, 250){
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                },
                new Note(311, 241){
                    @Override
                    public void onClick() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
