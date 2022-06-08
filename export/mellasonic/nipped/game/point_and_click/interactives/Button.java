/* ICS Final Project Nipped
 2022/05/25
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 25 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/25
 Time spent: 10 mins
 New features/processing: Create buttons
*/

package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

/**
 * A button interactable for changing locations
 */
public abstract class Button extends Rectangle {
    /**
     * Default width of button
     */
    public static final int WIDTH = 30;
    /**
     * Default height of button
     */
    public static final int HEIGHT = 30;

    /**
     * Class constructor
     *
     * @param dir the direction of the button
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public Button(Direction dir, int x, int y) {
        super(Tools.getImage("assets/" + dir.name() + "-arrow.png"), Tools.getImage("assets/" + dir.name() + "-arrow.png"), x, y, WIDTH, HEIGHT);
    }
}
