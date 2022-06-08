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
 New features/processing: create attic, add elements
*/

package mellasonic.nipped.game.point_and_click.locations;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * an attic
 */
public class Attic extends Location{
    /**
     * the bedroom
     */
    private Location bedroom;

    /**
     * Class constructor
     *
     * @param changer the screen change handler
     */
    public Attic(ScreenChanger changer, boolean grey) {
        super(grey ? Tools.getImage("assets/atticgs.png") : Tools.getImage("assets/attic.png"), changer);
        addObjects(Arrays.asList(
                new Button(Direction.D, Main.WIDTH / 2 - Button.WIDTH / 2, Main.HEIGHT - 20 - Button.HEIGHT) {
                    @Override
                    public void onClick() {
                        assert bedroom != null;
                        screenChange(bedroom);
                    }
                }
        ));
    }

    /**
     * sets the bedroom
     * @param bedroom the location of the bedroom
     */
    public void setBedroom(Location bedroom) {
        this.bedroom = bedroom;
    }
}
