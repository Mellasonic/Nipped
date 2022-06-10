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

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.GameState;
import mellasonic.nipped.game.ScoreState;
import mellasonic.nipped.interactable.Button;
import mellasonic.nipped.interactable.Interactive;
import mellasonic.nipped.main_menu.leaderboard.Leaderboard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static mellasonic.nipped.Tools.getImage;
 /**
 * Handles splash screen
 */
 public class SplashScreen implements AppState{
   @Override
   public Scene getScene(){
      Pane p = new Pane();
      ImageView bg = new ImageView(getImage("assets/splash.png"));
      bg.setOnMouseClicked(me -> {
         next();
      });
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