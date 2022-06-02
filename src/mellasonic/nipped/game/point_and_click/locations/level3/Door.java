package mellasonic.nipped.game.point_and_click.locations.level3;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

public abstract class Door extends Location {
    /**
     * Class constructor
     *
     */
    public Door() {
        super(Tools.getImage("assets/doorclose.png"), null);
    }

    /**
     * called when the door is clicked **and** the game is supposedly done
     */
    public abstract void onDoorClicked();
}
