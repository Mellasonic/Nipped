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
 New features/processing: create bedroom, add food
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * the bedroom
 */
public abstract class Bedroom extends Location{
    /**
     * the living room
     */
    private Location living;
    /**
     * the attic
     */
    private Location attic;

    /**
     * Class constructor
     *
     */
    public Bedroom() {
        super(Tools.getImage("assets/bedroom.png"), new ArrayList<>());

        addObjects(Arrays.asList(
                new Button(Direction.D, Main.WIDTH / 2 - Button.WIDTH / 2, Main.HEIGHT - Button.HEIGHT - 20) {
                    @Override
                    public void onClick() {
                        assert living != null;
                        screenChange(living);
                    }
                }, new Button(Direction.U, Main.WIDTH / 2 - Button.WIDTH / 2, 20){
                    @Override
                    public void onClick() {
                        assert attic != null;
                        screenChange(attic);
                    }
                }
        ));
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
