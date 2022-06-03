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

import mellasonic.nipped.game.point_and_click.locations.Door;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.*;

/**
 * The third level
 */
public abstract class Level3 extends PointClick{
    /**
     * the door
     */
    private final Door door;

    /**
     * Class Constructor
     */
    public Level3() {
        super();
        ScreenChanger changer = this::changeScreen;

        // initialize rooms
        LivingRoom living = new LivingRoom(changer);
        Kitchen kitchen = new Kitchen(changer);
        Bedroom bedroom = new Bedroom(changer);
        BedroomDrawer bDrawer = new BedroomDrawer(changer);
        KitchenDrawer kDrawer = new KitchenDrawer(changer);
        Attic attic = new Attic(changer);
        door = new Door(changer, false) {
            @Override
            public void onDoorClicked() {
                nextLevel();
            }
        };

        // link rooms to each other
        living.setKitchen(kitchen);
        living.setBedroom(bedroom);
        living.setDoor(door);
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
}
