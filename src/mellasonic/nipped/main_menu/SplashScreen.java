/* ICS Final Project Nipped
 2022/06/10
 Time spent: 30 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - June 10, 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh
 Version 1.1
 2022/06/10
 Time spent: 30 mins
 New features/processing: Implemented splashscreen and click to go to main menu
 */
package mellasonic.nipped.main_menu;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;

import static mellasonic.nipped.Tools.getImage;
 /**
 * Handles splash screen
 */
 public class SplashScreen implements AppState{
   @Override
   public Scene getScene(){
      Pane p = new Pane();
      ImageView bg = new ImageView(getImage("assets/splash.png"));
      bg.setOnMouseClicked(me -> next());
      bg.setFitWidth(Main.WIDTH);
      bg.setFitHeight(Main.HEIGHT);
      p.getChildren().add(bg);
      return new Scene(p);
   }
   /**
   * Sets scene to main menu
   */
   public void next(){
      MainMenu mm = new MainMenu();
      Main.getApp().changeState(mm);
   }
 }