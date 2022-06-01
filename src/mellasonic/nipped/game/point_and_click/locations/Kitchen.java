/* ICS Final Project Nipped
 2022/05/26
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 26 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/26
 Time spent: 30 min
 New features/processing: create kitchen, add food
*/

package mellasonic.nipped.game.point_and_click.locations;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Kitchen room
 */
public abstract class Kitchen extends Location {

    /**
     * The living room
     */
    private Location living;
    /**
     * The drawer
     */
    private Location drawer;

    /**
     * Class constructor
     *
     */
    public Kitchen() {
        super(Tools.getImage("assets/kitchen.png"), new ArrayList<>());
        addObjects(Arrays.asList(
                new Button(Direction.R, Main.WIDTH - Button.WIDTH - 20, Main.HEIGHT / 2 - Button.HEIGHT / 2) {
                    @Override
                    public void onClick() {
                        assert living != null;
                        screenChange(living);
                    }
                }, new Invisible(83, 281, 160, 109){
                    @Override
                    public void onClick() {
                        assert drawer != null;
                        screenChange(drawer);
                    }
                }
        ));
    }

    /**
     * set the living room
     * @param living the room to set the living room to
     */
    public void setLiving(Location living) {
        this.living = living;
    }

    /**
     * set the drawer
     * @param drawer the location of the drawer
     */
    public void setDrawer(Location drawer) {
        this.drawer = drawer;
    }
}
