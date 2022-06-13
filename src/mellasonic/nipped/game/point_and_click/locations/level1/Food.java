/* ICS Final Project Nipped
 2022/05/26
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.2 - 26 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/18
 Time spent: 20 mins
 New features/processing: created food, add default size and image
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/16
 Time spent: 10 min
 New features/processing: add enabled/disabled
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

import mellasonic.nipped.Tools;

/**
 * A food interactible for point and click games
 */
public abstract class Food extends Consumable {
    /**
     * Default width of food
     */
    public static final int WIDTH = 30;
    /**
     * Default height of food
     */
    public static final int HEIGHT = 30;

    /**
     * Class constructor
     *
     * @param x       x of bounding box of the food
     * @param y       y of bounding box of the food
     */
    public Food(int x, int y) {
        super(Tools.getImage("assets/catfood.png"), Tools.getImage("assets/catfood.png"),
                Tools.getImage("assets/catfoodgs.png"), x, y, WIDTH, HEIGHT);
    }
}
