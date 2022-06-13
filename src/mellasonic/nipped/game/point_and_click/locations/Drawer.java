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
 Modification Authors: Daniel Ye, Eric Jin
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

import java.util.Arrays;
import java.util.Collections;

/**
 * a drawer
 */
public class Drawer extends Location {
    /**
     * the previous scene
     */
    private Screen prev;

    /**
     * Class constructor
     *
     * @param changer the screen change handler
     * @param grey whether or not the room is greyscale
     */
    public Drawer(ScreenChanger changer, boolean grey) {
        super(grey ? Tools.getImage("assets/drawergs.png") : Tools.getImage("assets/drawer.png"), changer);
        addObjects(Collections.singletonList(
                new Button(Direction.D, 414, 436) {
                    @Override
                    public void onClick() {
                        assert prev != null;
                        screenChange(prev);
                    }
                }
        ));

        setNeedCat(false);
    }

    /**
     * sets the previous scene
     * @param prev the scene to go back to when the back button is clicked
     */
    public void setPrev(Screen prev) {
        this.prev = prev;
    }
}
