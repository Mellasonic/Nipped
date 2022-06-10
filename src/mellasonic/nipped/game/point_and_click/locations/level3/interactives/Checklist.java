/* ICS Final Project Nipped
 2022/06/06
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 6 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh, Eric Jin
 Version 1.1
 2022/06/06
 Time spent: 30 min
 New features/processing: create checklist
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.overlays.ChecklistOverlay;

public abstract class Checklist extends Consumable{
    /**
     * the dimensions of the checklist
     */
    public static final int WIDTH=30, HEIGHT=40;
    /**
     * the screen changer
     */
    private final ScreenChanger changer;
    /**
     * the current screen
     */
    private final Location cur;

    /**
     * Class constructor
     *
     * @param x        x of bounding box
     * @param y        y of bounding box
     * @param changer  the screen changer
     * @param cur      the location of the current location
     */
    public Checklist(int x, int y, ScreenChanger changer, Location cur) {
        super(Tools.getImage("assets/note.png"), Tools.getImage("assets/note.png"),
                Tools.getImage("assets/checklistmain.png"), x, y, WIDTH, HEIGHT);
        this.changer = changer;
        this.cur = cur;
    }

    @Override
    public void onClick() {
        super.onClick();
        changer.screenChange(new ChecklistOverlay(cur, changer));
    }
}
