package mellasonic.nipped.game.point_and_click.locations;

import javafx.scene.image.Image;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.interactable.Interactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Kitchen room
 */
public abstract class Kitchen extends Location{

    /**
     * The living room
     */
    private Location living;

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
     * called when a piece of food is clicked
     */
    public abstract void foodConsumed();
}
