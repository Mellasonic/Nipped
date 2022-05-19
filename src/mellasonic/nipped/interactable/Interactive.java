/* ICS Final Project Nipped
 2022/05/17
 Time spent: 10 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 17 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/17
 Time spent: 10 mins
 New features/processing: create interface
*/

package mellasonic.nipped.interactable;

// imports
import javafx.scene.Node;

/**
 * An object that can be interacted with
 */
public interface Interactive {
    /**
     * The actions to perform when the object is clicked
     */
    void onClick();

    /**
     * @return the node representation of this interactive object
     */
    Node getNode();
}
