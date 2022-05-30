/* ICS Final Project Nipped
 2022/05/26
 Time spent: 1 hour
*/

/*
 Nipped is a java game with three different levels.
 Version 1.4 - 26 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/18
 Time spent: 10 mins
 New features/processing: created level 1
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/19
 Time spent: 10 min
 New features/processing: override on food consume method
*/

/*
 Modification Authors: Daniel Ye
 Version 1.3
 2022/05/20
 Time spent: 10 min
 New features/processing: extrapolate living room
*/

/*
 Modification Authors: Daniel Ye
 Version 1.4
 2022/05/26
 Time spent: 20 min
 New features/processing: add locations
*/

package mellasonic.nipped.game.point_and_click;

import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.*;

/**
 * the first level
 */
public abstract class Level1 extends PointClick{
    /**
     * Class constructor
     */
    public Level1() {
        super();

        // initialize rooms
        LivingRoom living = new LivingRoom(){
            @Override
            public void screenChange(Screen to) {
                changeScreen(to);
            }
            @Override
            public void foodConsumed() {
                onFoodConsume();
            }
        };
        Kitchen kitchen = new Kitchen() {
            @Override
            public void foodConsumed() {onFoodConsume();}
            @Override
            public void screenChange(Screen to) {changeScreen(to);}
        };
        Bedroom bedroom = new Bedroom() {
            @Override
            public void screenChange(Screen to) { changeScreen(to); }
        };
        KitchenDrawer kDrawer = new KitchenDrawer() {
            @Override
            public void foodConsumed() { onFoodConsume(); }
            @Override
            public void screenChange(Screen to) { changeScreen(to); }
        };
        Attic attic = new Attic() {
            @Override
            public void foodConsumed() {
                onFoodConsume();
            }
            @Override
            public void screenChange(Screen to) {
                changeScreen(to);
            }
        };
        Door door = new Door() {
            @Override
            public void onDoorClicked() {
                nextLevel();
            }
            @Override
            public void screenChange(Screen to) {
                changeScreen(to);
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
        attic.setBedroom(bedroom);

        // go to a living room screen
        changeScreen(living);
    }

    /**
     * Called when food is consumed
     */
    private void onFoodConsume(){
        System.out.println("meow");
    }
}
