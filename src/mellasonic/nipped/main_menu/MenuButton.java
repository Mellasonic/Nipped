package mellasonic.nipped.main_menu;

import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

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
        super(Tools.getImage("assets/xbutton.png"), Tools.getImage("assets/xbuttonhover.png"), x, y, WIDTH, HEIGHT);
    }
}
