/* ICS Final Project Nipped
 2022/05/16
 Time spent: 30 min
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
 Time spent: 20 mins
 New features/processing: created class, implement methods, implement changing screen
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/19
 Time spent: 10 min
 New features/processing: remove need for starting screen
*/

package mellasonic.nipped.game.point_and_click;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import mellasonic.nipped.game.Level;

/**
 * A point and click level
 */
public abstract class PointClick implements Level {
    /**
     * The current screen/location of the level
     */
    private Screen curScreen;
    /**
     * Current javaFX node
     */
    private final Pane cur;

    /**
     * Class constructor
     */
    public PointClick(){
        cur = new Pane();
    }

    @Override
    public Parent getNode() {
        return cur;
    }

    /**
     * changes the screen to another screen/location
     * @param to the screen/location to change to
     */
    public void changeScreen(Screen to){
        // reset location
        curScreen = to;

        // replace child with the new screen's node
        cur.getChildren().clear();
        cur.getChildren().add(to.getNode());
    }
}
