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
import mellasonic.nipped.game.point_and_click.locations.level1.Door;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level1.*;

/**
 * the first level
 */
public abstract class Level1 extends PointClick{
   /**
    * the number of consumables consumed
    */
   private int numConsumed = 0;
   /**
    * the total number of consumables
    */
   private static final int totObject = 11;
   /**
    * the door
    */
   private final Door door;

   /**
    * Class constructor
    */
   public Level1() {
      super();
   
      // initialize handlers
      ConsumableHandler handler = 
         consumed -> {
            consumed.disable();
            onConsume();
         };
   
      ScreenChanger changer = this::changeScreen;
   
      // initialize rooms
      LivingRoom living = new LivingRoom(handler, changer);
      Kitchen kitchen = new Kitchen(handler, changer);
      Bedroom bedroom = new Bedroom(handler, changer);
      BedroomDrawer bDrawer = new BedroomDrawer(handler, changer);
      KitchenDrawer kDrawer = new KitchenDrawer(handler, changer);
      Attic attic = new Attic(handler, changer);
      door = 
         new Door(changer, true) {
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
   
      // go to a living room screen
      changeScreen(living);
      System.out.println(Font.getFamilies());
   }

   /**
    * Called when something is consumed
    */
   private void onConsume(){
      ++numConsumed;
      if(numConsumed == totObject) door.enable();
      Screen prev = getCurScreen();
      anel display = 
         new Panel("Hello this is a super duper cool text", prev.getNode()){
            @Override
            public void onExit() {
               changeScreen(prev);
            }
         };
      changeScreen(display);
      
   }
}
