/* ICS Final Project Nipped
 2022/06/03
 Time spent: 20 min
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
 Time spent: 20 min
 New features/processing: create drawer
*/

package mellasonic.nipped.game.point_and_click.locations.level3;

import mellasonic.nipped.game.point_and_click.locations.Drawer;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.Food;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.ConsumableHandler;

import java.util.Arrays;

/**
 * A drawer in Level 3
 */
public class L3Drawer extends Drawer {
    /**
     * Class constructor
     *
     * @param changer the screen change handle
     * @param handler the interactive consumable handler
     */
    public L3Drawer(ScreenChanger changer, ConsumableHandler handler) {
        super(changer, false);

        addObjects(Arrays.asList(
                new Food(302, 245) {
                    @Override
                    public void onConsume() {
                        handler.onConsume(this);
                    }
                },
                new Food(504, 246) {
                    @Override
                    public void onConsume() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
