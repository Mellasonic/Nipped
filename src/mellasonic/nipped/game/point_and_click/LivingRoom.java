/*
 * Daniel Ye, James Huynh, Eric Jin
 * Version 0.0.1
 * 1 hour
 * Daniel Ye: create constructor for Living Room
 */

package mellasonic.nipped.game.point_and_click;

import javafx.scene.image.Image;
import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.interactable.Interactive;
import mellasonic.nipped.interactable.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

import static mellasonic.nipped.Tools.getImage;

public class LivingRoom extends Location{
    /**
     * Class constructor
     */
    public LivingRoom() {
        super(getImage("assets/livingroom.png"), new ArrayList<>());
        addObjects(Arrays.asList(new Food(100, 100){
            @Override
            public void onClick() {
                System.out.println("Meow");
            }
        }));
    }
}
