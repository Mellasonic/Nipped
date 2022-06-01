/* ICS Final Project Nipped
 2022/05/31
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 31 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/31
 Time spent: 30 min
 New features/processing: Create Card, position elements, add wrapping
*/

package mellasonic.nipped.game.cards;

import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;

/**
 * A card for the quiz
 */
public abstract class Card {
    /**
     * The current node
     */
    private final Pane cur;
    /**
     * The correct answer for the card (true=yes, false=no)
     */
    private final boolean ans;

    /**
     * Dimensions of the card
     */
    public static final int WIDTH=270, HEIGHT=360;

    /**
     * Class constructor
     * @param background the background/icon of the image
     * @param message the message/prompt of the card
     * @param isYes whether or not the answer is "yes"
     */
    public Card(Image background, String message, boolean isYes){
        // initialize instance variables
        this.ans = isYes;

        // current pane
        cur = new Pane();
        cur.setLayoutX(0);
        cur.setLayoutY(0);
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // initialize and add the background card
        ImageView bg = new ImageView(Tools.getImage("assets/lvl2panel.png"));
        bg.setFitWidth(WIDTH);
        bg.setFitHeight(HEIGHT);
        bg.setLayoutX(Main.WIDTH / 2.0 - WIDTH / 2.0);
        bg.setLayoutY(Main.HEIGHT / 2.0 - HEIGHT / 2.0);
        cur.getChildren().add(bg);

        // initialize and add the supporting image
        ImageView supportImage = new ImageView(background);
        supportImage.setLayoutX(329);
        supportImage.setLayoutY(98);
        supportImage.setFitWidth(198);
        supportImage.setFitHeight(126);
        cur.getChildren().add(supportImage);

        // initialize and add the question
        Text question = new Text(message);
        question.setFont(new Font("Bell MT", 16));
        question.setWrappingWidth(199);
        question.setLayoutX(330);
        question.setLayoutY(245);
        question.setTextOrigin(VPos.TOP);
        cur.getChildren().add(question);


    }

    /**
     * Called when the user tried to answer the question
     * @param correct whether or not the user entered the correct answer
     */
    public abstract void onAnswer(boolean correct);

    /**
     * returns the node representation of the card
     * @return the node representation
     */
    public Node getNode(){
        return cur;
    }
}
