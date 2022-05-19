/* ICS Final Project Nipped
 2022/05/16
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 16 May 2022
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

package mellasonic.nipped.game.point_and_click;

import javafx.scene.Scene;

/**
 * the first level
 */
public class Level1 extends PointClick{
    /**
     * Class constructor
     */
    public Level1() {
        super();
        // go to a living room screen
        changeScreen(new LivingRoom(){
            @Override
            public void foodConsumed() {
                onFoodConsume();
            }
        });
    }

    /**
     * Called when food is consumed
     */
    private void onFoodConsume(){
        System.out.println("meow");
    }
}
