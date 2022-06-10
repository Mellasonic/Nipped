/* ICS Final Project Nipped
 2022/05/31
 Time spent: 40 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.2 - 31 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/26
 Time spent: 30 min
 New features/processing: create bedroom, add food
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/31
 Time spent: 10 min
 New features/processing: add bedroom drawer
*/

package mellasonic.nipped.game.point_and_click.locations;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * the bedroom
 */
public class Bedroom extends Location {
    /**
     * the living room
     */
    private Location living;
    /**
     * the attic
     */
    private Location attic;
    /**
     * the drawer
     */
    private Location drawer;

    /**
     * Class constructor
     *
     * @param changer the screen change handler
     * @param grey whether or not the room is greyscale
     */
    public Bedroom(ScreenChanger changer, boolean grey) {
        super(grey ? Tools.getImage("assets/bedroomgs.png") : Tools.getImage("assets/bedroom.png"), changer);

        addObjects(Arrays.asList(
                new Button(Direction.D, Main.WIDTH / 2 - Button.WIDTH / 2, Main.HEIGHT - Button.HEIGHT - 20) {
                    @Override
                    public void onClick() {
                        assert living != null;
                        screenChange(living);
                    }
                }, new Button(Direction.U, Main.WIDTH / 2 - Button.WIDTH / 2, 20) {
                    @Override
                    public void onClick() {
                        assert attic != null;
                        screenChange(attic);
                    }
                }, new Invisible(97, 356, 127, 40, true) {
                    @Override
                    public void onClick() {
                        assert drawer != null;
                        screenChange(drawer);
                    }
                }
        ));
    }

    /**
     * sets the drawer
     * @param drawer the locatin of the drawer
     */
    public void setDrawer(Location drawer) {
        this.drawer = drawer;
    }

    /**
     * sets the attic
     * @param attic the location of the attic
     */
    public void setAttic(Location attic) {
        this.attic = attic;
    }

    /**
     * Sets the living room
     * @param living the room to set the living room to
     */
    public void setLiving(Location living) {
        this.living = living;
    }
}
