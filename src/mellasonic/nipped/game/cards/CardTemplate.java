/* ICS Final Project Nipped
 2022/06/01
 Time spent: 30 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - 01 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh
 Version 1.0
 2022/06/01
 Time spent: 30 mins
 New features/processing: Styling for the card
*/

package mellasonic.nipped.game.cards;

import javafx.scene.image.Image;

/**
 * A template data structure for a card including all of its relevant information
 */
public class CardTemplate {
    /**
     * the background
     */
    private final Image background;
    /**
     * the message
     */
    private final String message;
    /**
     * the answer
     */
    private final boolean isYes;

    /**
     * class constructor
     * @param background  the background
     * @param message the message of the card
     * @param isYes whether or not the answer is "yes"
     */
    public CardTemplate(Image background, String message, boolean isYes){
        this.background = background;
        this.message = message;
        this.isYes = isYes;
    }

    /**
     * returns the background
     * @return and image; the background
     */
    public Image getBackground() {
        return background;
    }

    /**
     * returns the question
     * @return a string; the question
     */
    public String getMessage() {
        return message;
    }

    /**
     * returns whether or not the answer is yes
     * @return a boolean; the answer
     */
    public boolean isYes() {
        return isYes;
    }
}
