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
 New features/processing: create cat cleaning interactive
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import mellasonic.nipped.Tools;

public abstract class CatClean extends Consumable {
    /**
     * Dimensions of the icon
     */
    public static int WIDTH=70, HEIGHT=80;

    /**
     * Class constructor
     *
     * @param x        x of bounding box
     * @param y        y of bounding box
     */
    public CatClean(int x, int y) {
        super(Tools.getImage("assets/broom.png"), Tools.getImage("assets/broom.png"),
                Tools.getImage("assets/sweepcat.gif"), x, y, WIDTH, HEIGHT);
    }
}
