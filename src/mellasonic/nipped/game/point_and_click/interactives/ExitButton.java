package mellasonic.nipped.game.point_and_click.interactives;

import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;
import mellasonic.nipped.main_menu.MenuButton;

public abstract class ExitButton extends Rectangle {
    /**
     * dimensions of the exit button
     */
    public static final int WIDTH= MenuButton.WIDTH, HEIGHT=MenuButton.HEIGHT;

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public ExitButton(int x, int y) {
        super(Tools.getImage("assets/xbutton.png"), Tools.getImage("assets/xbuttonhover.png"), x, y, WIDTH, HEIGHT);
    }
}
