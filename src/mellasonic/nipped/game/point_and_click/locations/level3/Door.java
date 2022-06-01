/* ICS Final Project Nipped
 2022/05/31
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 31 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/31
 Time spent: 30 min
 New features/processing: created door, add opening & next-level functions, add ghost collider
*/

package mellasonic.nipped.game.point_and_click.locations.level3;

import javafx.scene.image.Image;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.interactable.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The door
 */
public abstract class Door extends Location {

    /**
     * Class constructor
     */
    public Door() {
        super(Tools.getImage("assets/doorclose.png"), new ArrayList<>());
    }
}
