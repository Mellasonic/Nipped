/* ICS Final Project Nipped
 2022/06/02
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - 2 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.0
 2022/06/02
 Time spent: 10 min
 New features/processing: create template
*/

package mellasonic.nipped.game.point_and_click.locations.level3;

import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level1.ConsumableHandler;

public class Kitchen extends mellasonic.nipped.game.point_and_click.locations.Kitchen {
    /**
     * class constructor
     *
     * @param changer the screen change handler
     */
    public Kitchen(ScreenChanger changer) {
        super(changer, false);
    }
}
