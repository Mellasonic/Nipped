/* ICS Final Project Nipped
 2022/05/18
 Time spent: 1 hour 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.2 - 5 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/18
 Time spent: 20 mins
 New features/processing: added getImage method
*/

/*
 Modification Authors: Daniel Ye, James Huynh
 Version 1.2
 2022/06/05
 Time spent: 1 hour
 New features/processing: create addsprite, positioning, add score, create text, add cursor change
*/

package mellasonic.nipped;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.*;

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
        throw new IllegalArgumentException("Invalid URL: " + url);
    }

    /**
     * creates a sprite (an imageview with specified dimensions)
     * @param url the url to the image of the sprite
     * @param width the width of the sprite
     * @param height the height of the sprite
     * @return the sprite
     */
    public static ImageView makeSprite(String url, int width, int height){
        ImageView ret = new ImageView(Tools.getImage(url));
        ret.setFitWidth(width);
        ret.setFitHeight(height);
        return ret;
    }

    /**
     * creates a sprite, and imageview with the desired dimensions and position
     * @param url the url to the image
     * @param x the x coordinate of the sprite
     * @param y the y coordinate of the sprite
     * @param width width of the sprite
     * @param height height of the sprite
     * @return the imageview (sprite)
     */
    public static ImageView makeSprite(String url, int x, int y, int width, int height){
        ImageView ret = makeSprite(url, width, height);
        ret.setLayoutX(x);
        ret.setLayoutY(y);
        return ret;
    }

    /**
     * sets the dimensions of a node
     * @param cur the node
     * @param x the x
     * @param y the y
     */
    public static void setPos(Node cur, int x, int y){
        cur.setLayoutX(x);
        cur.setLayoutY(y);
    }

    /**
     * adds a score to the file
     * @param name the name of the player
     * @param score the score of the player
     */
    public static void addScore(String name, int score){
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("scores.txt", true));
            pw.println(name + " " + score);
            pw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * creates a text object
     * @param message the message to display
     * @param align the alignment of the text
     * @param font the font to use
     * @param x the x coordinate of the top left
     * @param y the y coordinate of the top left
     * @param width the width of the textbox
     * @return a text object with the specified parameters
     */
    public static Text createText(String message, TextAlignment align, Font font, int x, int y, int width){
        Text ret = new Text(message);
        ret.setWrappingWidth(width);
        ret.setFont(font);
        ret.setTextAlignment(align);
        ret.setX(x);
        ret.setY(y);
        return ret;
    }

    /**
     * alters a node so that the cursor changes when the node is clicked
     * @param toChange the node to change
     */
    public static void addCursorChange(Node toChange){
        toChange.setOnMouseEntered(me -> Main.getApp().setCursor(Cursor.HAND));
        toChange.setOnMouseExited(me -> Main.getApp().setCursor(Cursor.DEFAULT));
    }
}
