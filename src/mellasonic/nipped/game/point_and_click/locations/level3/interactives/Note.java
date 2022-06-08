/* ICS Final Project Nipped
 2022/06/07
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 7 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye, James Huynh
 Version 1.1
 2022/06/07
 Time spent: 30 min
 New features/processing: create note interactive object
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.overlays.NoteOverlay;

public abstract class Note extends Consumable{
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
     * @param cur      the current location
     */
    public Note(int x, int y, ScreenChanger changer, Location cur) {
        super(Tools.getImage("assets/note.png"), Tools.getImage("assets/note.png"),
                Tools.getImage("assets/note.png"), x, y, WIDTH, HEIGHT);
        this.changer = changer;
        this.cur = cur;
    }

    @Override
    public void onClick() {
        super.onClick();
        changer.screenChange(new NoteOverlay(cur, changer,
                "Hey, I made your favourite lasagna today, how about we all eat it together?\n\n- Sincerely, mom"));
    }
}
