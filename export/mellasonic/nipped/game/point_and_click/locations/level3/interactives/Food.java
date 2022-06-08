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
 Modification Authors: Daniel Ye, James Huynh
 Version 1.1
 2022/06/03
 Time spent: 20 min
 New features/processing: create interactive
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import mellasonic.nipped.Tools;

public abstract class Food extends Consumable {
    /**
     * Dimensions of this food
     */
    public static int WIDTH=40, HEIGHT=40;

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public Food(int x, int y) {
        super(Tools.getImage("assets/burger.png"), Tools.getImage("assets/burger.png"),
                Tools.getImage("assets/apple.png"), x, y, WIDTH, HEIGHT);
    }
}
