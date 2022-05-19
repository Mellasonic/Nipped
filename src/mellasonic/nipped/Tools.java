/* ICS Final Project Nipped
 2022/05/18
 Time spent: 20 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 18 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/18
 Time spent: 20 mins
 New features/processing: added getImage method
*/

package mellasonic.nipped;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class with general static methods for utility function
 */
public class Tools {
    /**
     * gets an image from a url
     *
     * @param url the url to query from
     * @return the Image at the url
     */
    public static Image getImage(String url) throws IllegalArgumentException {
        try {
            return new Image(new FileInputStream(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Invalid URL!");
    }
}
