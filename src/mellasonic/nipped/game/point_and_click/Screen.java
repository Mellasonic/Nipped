/* ICS Final Project Nipped
 2022/05/16
 Time spent: 10 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 16 Month 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/16
 Time spent: 10 mins
 New features/processing: created Screen interface
*/

package mellasonic.nipped.game.point_and_click;

import javafx.scene.Node;

/**
 * A particular screen for each part of the point and click game
 */
public interface Screen {
    /**
     * @return the node of the current screen
     */
    Node getNode();
}
