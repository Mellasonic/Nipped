/*
* Version 0.0.1
* Daniel Ye, Eric Jin
* Ms. Krasteva
* May 17, 2022
* Interactive objects
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
