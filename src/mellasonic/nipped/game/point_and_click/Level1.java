/* ICS Final Project Nipped
 2022/06/06
 Time spent: 4 hours
*/

/*
 Nipped is a java game with three different levels.
 Version 1.6 - 6 June 2022
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

/*
 Modification Authors: James Huynh
 Version 1.6
 2022/06/06
 Time spent: 1 hour
 New features/processing: add facts and randomizing facts
*/

package mellasonic.nipped.game.point_and_click;

import mellasonic.nipped.game.point_and_click.interactives.Panel;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level1.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
   * All possible facts as an arraylist
   */
   public List<String> facts = new ArrayList<String>(Arrays.asList(
      "Animal and human experiments show that food, especially ones high in sugar, starch, and fat, can activate the same reward and pleasure centers, like dopamine centers, in the brain as addictive drugs like cocaine and heroin.  ",
      "Common symptoms of food addiction include hiding eating from others, inability to stop despite physical problems, and feeling guilty afterwards but soon eating until excessively stuffed again. ",
      "Steps towards a solution to food addiction are listing foods to avoid completely, listing fast food places with healthier alternatives, and thinking before you eat, remembering the pros and cons to your choices. ",
      "An ongoing abuse of food will lead to emotional, social, and physical costs such as obesity, depression, low-self-worth, and isolation, not to mention the additional physical effects.",
      "Healthy eating can be a challenge for anyone, but it is especially challenging for teens. With hormones causing imbalanced food cravings, teens also have access to easily obtained and widespread junk food items in places such as most stores, school, and at home. ",
      "A healthy diet includes whole grains, fruits, vegetables, low-fat milk, beans, eggs, fish, nuts, lean meats, and eight glasses of water everyday. Another important element of healthy teenage eating habits is to reduce sugar intake. This helps teens maintain a healthy weight and avoid the mood swings that sugar creates.",
      "Teens need to eat more food than they did as children. If they just eat more food overall, this may be a normal sign of healthy development. If they tend to eat when not hungry or binge-eat while under stress, they may be struggling with food addiction. ",
      "Like most addicts, food addicts often have certain triggers that turn on a craving which may include deadlines, arguments, or food courts.",
      "For adolescents, the palatable food rewards center is much stronger when eating. In other words, teenagers are a lot more affected by food and processed foods because of its effect on reward centers in the brain.",
      "A conscious decision to stop with imposed goals and deadlines may help break the cycle of compulsive eating. Always consider seeking help from a professional or support groups. ",
      "Food addiction is defined by whether it is frequent and whether the eating interferes in one's life. Research has found that more than half a million teenagers are suffering from some sort of food addiction or eating disorder."
    ));
   /**
    * Class constructor
    */
   public Level1() {
      super();
      Collections.shuffle(facts);
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
   }

   /**
    * Called when something is consumed
    */
   private void onConsume(){
      ++numConsumed;
      if(numConsumed == totObject) door.enable();
      Screen prev = getCurScreen();
      String text = facts.remove(0);
      Panel display = 
         new Panel(text, prev.getNode()){
            @Override
            public void onExit() {
               changeScreen(prev);
            }
         };
      changeScreen(display);
      Collections.shuffle(facts);
   }
}
