/* ICS Final Project Nipped
 2022/06/07
 Time spent: 15 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 07 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/06/07
 Time spent: 15 min
 New features/processing: create menu button
*/

package mellasonic.nipped.main_menu;

import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

/**
 * A button in the corner for going to the main menu
 */
public abstract class MenuButton extends Rectangle {
    /**
     * The dimensions of the menu button
     */
    public static final int WIDTH=50, HEIGHT=50;

    /**
     * Class Constructor
     */
    public MenuButton(){
        this(10, 10);
    }

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public MenuButton(int x, int y) {
        super(Tools.getImage("assets/menubutton.png"), Tools.getImage("assets/menubuttonhover.png"), x, y, WIDTH, HEIGHT);
    }
}
