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
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.CatClean;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.ConsumableHandler;

import java.util.Arrays;

public class Attic extends mellasonic.nipped.game.point_and_click.locations.Attic {


    /**
     * class constructor
     *
     * @param changer the screen change handler
     * @param handler the interactive objects handler
     */
    public Attic(ScreenChanger changer, ConsumableHandler handler) {
        super(changer, false);
        addObjects(Arrays.asList(
                new CatClean(414, 282) {
                    @Override
                    public void onConsume() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
