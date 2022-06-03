/* ICS Final Project Nipped
 2022/06/02
 Time spent: 10 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - 2 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.0
 2022/06/02
 Time spent: 10 min
 New features/processing: create template
*/

package mellasonic.nipped.game.point_and_click.locations.level3;

import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

/**
 * a note icon
 */
public abstract class Note extends Rectangle {
    /**
     * Dimensions of a note
     */
    public static final int WIDTH=60, HEIGHT=90;

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public Note(int x, int y) {
        super(Tools.getImage("assets/note.png"), Tools.getImage("assets/note.png"), x, y, WIDTH, HEIGHT);
    }
}
