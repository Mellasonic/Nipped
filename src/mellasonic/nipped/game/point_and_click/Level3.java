/* ICS Final Project Nipped
 2022/05/16
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - 16 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.0
 2022/05/16
 Time spent: 10 mins
 New features/processing: created Level 3 Template
*/

/*
 Modification Authors: Daniel Ye
 Version 1.0.1
 2022/05/19
 Time spent: 10 mins
 New features/processing: Refactor
*/

package mellasonic.nipped.game.point_and_click;

import mellasonic.nipped.game.point_and_click.locations.Drawer;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.*;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.Consumable;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.ConsumableHandler;
import mellasonic.nipped.interactable.Interactive;

/**
 * The third level
 */
public abstract class Level3 extends PointClick{
    /**
     * total number of interactive objects
     */
    public static final int TOT_OBJ = 12;

    /**
     * Class Constructor
     */
    public Level3() {
        super();
        ScreenChanger changer = this::changeScreen;
        ConsumableHandler handler = this::handleConsume;

        // initialize rooms
        LivingRoom living = new LivingRoom(changer, handler);
        Kitchen kitchen = new Kitchen(changer, handler);
        Bedroom bedroom = new Bedroom(changer, handler);
        Drawer bDrawer = new L3Drawer(changer, handler);
        Drawer kDrawer = new L3Drawer(changer, handler);
        Attic attic = new Attic(changer, handler);
        Door door = new Door(changer, handler);
        Drawer lDrawer = new L3Drawer(changer, handler);

        // link rooms to each other
        living.setKitchen(kitchen);
        living.setBedroom(bedroom);
        living.setDoor(door);
        living.setDrawer(lDrawer);
        lDrawer.setPrev(living);
        door.setLiving(living);
        kitchen.setLiving(living);
        kitchen.setDrawer(kDrawer);
        kDrawer.setPrev(kitchen);
        bedroom.setLiving(living);
        bedroom.setAttic(attic);
        bedroom.setDrawer(bDrawer);
        bDrawer.setPrev(bedroom);
        attic.setBedroom(bedroom);

        changeScreen(living);
    }

    /**
     * handles consumption
     * @param consumed the interactive object consumed
     */
    private void handleConsume(Interactive consumed){

    }
}
