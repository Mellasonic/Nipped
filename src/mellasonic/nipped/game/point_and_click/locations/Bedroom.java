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

package mellasonic.nipped.game.point_and_click.locations;

import javafx.scene.image.Image;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.interactable.Interactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * the bedroom
 */
public abstract class Bedroom extends Location{
    /**
     * the living room
     */
    private Location living;

    /**
     * Class constructor
     *
     */
    public Bedroom() {
        super(Tools.getImage("assets/bedroom.png"), new ArrayList<>());

        addObjects(Arrays.asList(
                new Button(Direction.D, Main.HEIGHT - Button.HEIGHT - 20, Main.WIDTH / 2 - Button.WIDTH / 2) {
                    @Override
                    public void onClick() {
                        assert living != null;
                        screenChange(living);
                    }
                }
        ));
    }

    /**
     * Sets the living room
     * @param living the room to set the living room to
     */
    public void setLiving(Location living) {
        this.living = living;
    }
}
