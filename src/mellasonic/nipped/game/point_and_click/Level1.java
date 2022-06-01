/* ICS Final Project Nipped
 2022/05/31
 Time spent: 3 hours
*/

/*
 Nipped is a java game with three different levels.
 Version 1.5 - 31 May 2022
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

/*
 Modification Authors: Daniel Ye
 Version 1.5
 2022/05/31
 Time spent: 2 hours
 New features/processing: add attic, drawers, door, panels when food has been consumed
*/

package mellasonic.nipped.game.point_and_click;

import javafx.scene.text.Font;
import mellasonic.nipped.game.point_and_click.interactives.Panel;
import mellasonic.nipped.game.point_and_click.locations.level1.*;

/**
 * the first level
 */
public abstract class Level1 extends PointClick{
    private int numConsumed = 0;
    private static final int totFood = 9;
    private final Door door;

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
        BedroomDrawer bDrawer = new BedroomDrawer() {
            @Override
            public void foodConsumed() {
                onFoodConsume();
            }

            @Override
            public void screenChange(Screen to) {
                changeScreen(to);
            }
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
        door = new Door() {
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
        bedroom.setDrawer(bDrawer);
        bDrawer.setPrev(bedroom);
        attic.setBedroom(bedroom);

        // go to a living room screen
        changeScreen(living);
        System.out.println(Font.getFamilies());
    }

    /**
     * Called when food is consumed
     */
    private void onFoodConsume(){
        ++numConsumed;
        if(numConsumed == totFood) door.enable();
        if(numConsumed == 3){
            Screen prev = getCurScreen();
            Panel display = new Panel("Hello this is a super duper cool text", prev.getNode()){
                @Override
                public void onExit() {
                    changeScreen(prev);
                }
            };
            changeScreen(display);
        }
    }
}
