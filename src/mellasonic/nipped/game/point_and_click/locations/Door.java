package mellasonic.nipped.game.point_and_click.locations;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Interactive;
import mellasonic.nipped.interactable.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The door
 */
public abstract class Door extends Location{
    /**
     * whether or not the rest of the game is finished
     */
    private boolean finished = false;

    /**
     * Class constructor
     */
    public Door() {
        super(Tools.getImage("assets/doorclose.png"), new ArrayList<>());
        // a ghost collider for detecting the door
        Image ghostCollide = Tools.getImage("assets/invisible.png");
        addObjects(Arrays.asList(
                new Rectangle(ghostCollide, ghostCollide, 0, 0, 10, 10) {
                    @Override
                    public void onClick() {
                        if(finished){
                            setBackground(Tools.getImage("assets/dooropen.png"));
                            System.out.println("clicked");
                        }
                    }
                }
        ));
    }

    /**
     * enables the door - should be called when all other activities have been completed
     */
    public void enable(){
        finished = true;
    }
}
