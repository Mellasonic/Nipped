/* ICS Final Project Nipped
 2022/05/18
 Time spent: 2 hours
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 18 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel
 Version 1.0
 2022/05/18
 Time spent: 1 hour
 New features/processing: Initial Class
*/

/*
 Modification Authors: Daniel
 Version 1.1
 2022/05/18
 Time spent: 2 hour
 New features/processing: Add Interactive elements
*/

package mellasonic.nipped.game.point_and_click;

// imports
import javafx.scene.image.Image;
import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.interactable.Interactive;
import mellasonic.nipped.interactable.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

import static mellasonic.nipped.Tools.getImage;

/**
 * The first room - a living room in level 1 and 3
 */
public class LivingRoom extends Location{
    /**
     * Class constructor
     */
    public LivingRoom() {
        super(getImage("assets/livingroom.png"), new ArrayList<>());

        // add objects to the list of interactives
        addObjects(Arrays.asList(new Food(100, 100){
            @Override
            public void onClick() {
                System.out.println("Meow");
            }
        }));
    }
}
