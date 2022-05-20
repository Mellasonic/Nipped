/* ICS Final Project Nipped
 2022/05/16
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.3 - 20 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/18
 Time spent: 10 mins
 New features/processing: created level 1
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/19
 Time spent: 10 min
 New features/processing: override on food consume method
*/

/*
 Modification Authors: Daniel Ye
 Version 1.3
 2022/05/20
 Time spent: 10 min
 New features/processing: extrapolate living room
*/

package mellasonic.nipped.game.point_and_click;

import mellasonic.nipped.game.point_and_click.locations.LivingRoom;
import mellasonic.nipped.game.point_and_click.locations.Location;

/**
 * the first level
 */
public class Level1 extends PointClick{
    /**
     * Class constructor
     */
    public Level1() {
        super();
        LivingRoom start = new LivingRoom(){
            @Override
            public void screenChange(Screen to) {
                changeScreen(to);
            }
            @Override
            public void foodConsumed() {
                onFoodConsume();
            }
        };
        LivingRoom secondary = new LivingRoom() {
            @Override
            public void foodConsumed() {
                System.out.println("Meow!");
            }

            @Override
            public void screenChange(Screen to) {
                changeScreen(to);
            }
        };

        start.setLeft(secondary);
        secondary.setLeft(start);
        // go to a living room screen
        changeScreen(start);
    }

    /**
     * Called when food is consumed
     */
    private void onFoodConsume(){
        System.out.println("meow");
    }
}
