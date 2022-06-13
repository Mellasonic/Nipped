/* ICS Final Project Nipped
 2022/06/06
 Time spent: 1 hour
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 6 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin
 Version 1.1
 2022/06/06
 Time spent: 1 hour
 New features/processing: create Door, add various colliders & activate colliders (open method), add setLiving method
*/

package mellasonic.nipped.game.point_and_click.locations.level3;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.CatExercise;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.ConsumableHandler;

import java.util.Arrays;
import java.util.Collections;

public class Door extends Location {
    /**
     * whether or not the door is open
     */
    private boolean open;
    /**
     * the living room
     */
    private Location living;

    /**
     * Class constructor
     *
     * @param changer    the screen changer
     * @param handler the interactive objects handler
     */
    public Door(ScreenChanger changer, ConsumableHandler handler) {
        super(Tools.getImage("assets/doorclose.png"), changer);

        // add the invisible collider and left button
        addObjects(Arrays.asList(
                new Invisible(368, 142, 137, 250, false) {
                    @Override
                    public void onClick() {
                        // open the door
                        open();

                        // add the catexercise object when the door is opened
                        addObjects(Collections.singletonList(
                                new CatExercise(368, 142, 137, 250) {
                                    @Override
                                    public void onClick() {
                                        setNeedCat(false);
                                        handler.onConsume(this);
                                    }
                                }
                        ));

                        // remove the invisible object
                        removeObject(this);
                    }
                },
                new Button(Direction.L, 20, Main.HEIGHT / 2 - Button.HEIGHT / 2){
                    @Override
                    public void onClick() {
                        assert living != null;
                        changer.screenChange(living);
                    }
                }
        ));
    }

    /**
     * opens the door
     */
    private void open(){
        this.open = true;
        setBackground(Tools.getImage("assets/dooropen.png"));
    }

    /**
     * sets the living room
     * @param living the living room
     */
    public void setLiving(Location living) {
        this.living = living;
    }
}
