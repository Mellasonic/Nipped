/* ICS Final Project Nipped
 2022/05/31
 Time spent: 20 min
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
 Time spent: 20 min
 New features/processing: Created Drawer subclass of Location, add "previous" button & add bg
*/

package mellasonic.nipped.game.point_and_click.locations;

import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.locations.Location;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * a drawer
 */
public abstract class Drawer extends Location {
    /**
     * the previous scene
     */
    private Screen prev;

    /**
     * Class constructor
     */
    public Drawer() {
        super(Tools.getImage("assets/drawer.png"), new ArrayList<>());
        addObjects(Arrays.asList(
                new Button(Direction.D, 414, 436) {
                    @Override
                    public void onClick() {
                        assert prev != null;
                        screenChange(prev);
                    }
                }
        ));
    }

    /**
     * sets the previous scene
     * @param prev the scene to go back to when the back button is clicked
     */
    public void setPrev(Screen prev) {
        this.prev = prev;
    }
}