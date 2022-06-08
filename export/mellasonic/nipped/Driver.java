/* ICS Final Project Nipped
 2022/05/16
 Time spent: 30 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 16 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/16
 Time spent: 30 mins
 New features/processing: created driver class and synced it with Main class
*/

package mellasonic.nipped;

import javafx.application.Application;
import javafx.stage.Stage;
import mellasonic.nipped.main_menu.MainMenu;

/**
 * Entry point for applications
 */
public class Driver extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Main m = Main.newApp(stage, new MainMenu());
        m.render();
    }

    /**
     * main method
     * @param args args
     */
    public static void main(String[] args){
        launch(args);
    }
}
