/* ICS Final Project Nipped
 2022/05/16
 Time spent: 10 mins
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
 New features/processing: create level 2 template
*/

package mellasonic.nipped.game.cards;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.game.Level;

/**
 * Level 2
 */
public abstract class Level2 implements Level {
    /**
     * The current pane
     */
    private final Pane cur;

    /**
     * Class Constructor
     */
    public Level2(){
        cur = new Pane();
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);


    }

    @Override
    public Parent getNode() {
        return cur;
    }
}
