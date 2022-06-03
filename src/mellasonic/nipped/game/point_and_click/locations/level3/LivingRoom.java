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

import mellasonic.nipped.game.point_and_click.interactives.Invisible;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

import java.util.Arrays;

public class LivingRoom extends mellasonic.nipped.game.point_and_click.locations.LivingRoom {
    /**
     * the drawer
     */
    private Location drawer;

    /**
     * Class constructor
     *
     * @param changer the screen change handler
     */
    public LivingRoom(ScreenChanger changer) {
        super(changer, false);
        addObjects(Arrays.asList(
                new Invisible(612, 339, 87, 51, true) {
                    @Override
                    public void onClick() {
                        assert drawer != null;
                        screenChange(drawer);
                    }
                }
        ));
    }

    /**
     * sets the drawer location
     * @param drawer the drawer location
     */
    public void setDrawer(Location drawer){
        this.drawer = drawer;
    }
}
