package mellasonic.nipped;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
