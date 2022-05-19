/* ICS Final Project Nipped
 2022/05/16
 Time spent: 10 mins
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
        super(new LivingRoom());
    }
}
