package mellasonic.nipped.game.point_and_click.locations;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.interactable.Interactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * a drawer
 */
public abstract class Drawer extends Location{
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