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
import javafx.scene.text.TextAlignment;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;

import java.beans.EventHandler;

/**
 * A card for the quiz
 */
public abstract class Card {
    /**
     * The current node
     */
    private final Pane cur;

    /**
     * Dimensions of the card
     */
    public static final int WIDTH=270, HEIGHT=360;
    /**
     * Dimensions of the arrows
     */
    public static final int ARROW_WIDTH = 40, ARROW_HEIGHT = 32;
    /**
     * the margins of the support image
     */
    public static int MARGIN = 7;

    /**
     * Class constructor
     * @param background the background/icon of the image
     * @param message the message/prompt of the card
     * @param isYes whether or not the answer is "yes"
     */
    public Card(Image background, String message, boolean isYes){
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
        int boxWidth = 198 - 2 * MARGIN, boxHeight = 126 - 2 * MARGIN;
        // calculate the optimal dimensions for the image
        double width = Math.min(boxWidth, (double) boxHeight * background.getWidth() / background.getHeight());
        double height = background.getHeight() / background.getWidth() * width;

        // set the dimensions & add it
        supportImage.setFitWidth(width);
        supportImage.setFitHeight(height);
        supportImage.setLayoutX(329 + boxWidth / 2.0 - width / 2.0 + MARGIN);
        supportImage.setLayoutY(98 + boxHeight / 2.0 - height / 2.0 + MARGIN);
        cur.getChildren().add(supportImage);

        // initialize and add the question
        Text question = new Text(message);
        question.setFont(new Font("Bell MT", 16));
        question.setWrappingWidth(199);
        question.setLayoutX(330);
        question.setLayoutY(245);
        question.setTextOrigin(VPos.TOP);
        cur.getChildren().add(question);

        // add "arrows" for yes and no prompt
        ImageView yArrow = new ImageView(Tools.getImage("assets/R-greenarrow.png"));
        yArrow.setFitWidth(ARROW_WIDTH);
        yArrow.setFitHeight(ARROW_HEIGHT);
        yArrow.setLayoutX(Main.WIDTH / 2.0 + WIDTH / 2.0 - ARROW_WIDTH - 15);
        yArrow.setLayoutY(Main.HEIGHT / 2.0 + HEIGHT / 2.0 - ARROW_HEIGHT - 15);

        ImageView nArrow = new ImageView(Tools.getImage("assets/R-redarrow.png"));
        nArrow.setFitWidth(ARROW_WIDTH);
        nArrow.setFitHeight(ARROW_HEIGHT);
        nArrow.setLayoutX(Main.WIDTH / 2.0 - WIDTH / 2.0 + 15);
        nArrow.setLayoutY(Main.HEIGHT / 2.0 + HEIGHT / 2.0 - ARROW_HEIGHT - 15);

        // add prompts for the arrows
        Text yes = new Text("TRUE");
        yes.setFont(new Font("Old Antic Outline", 18));
        yes.setLayoutX(0);
        yes.setWrappingWidth(yArrow.getLayoutX() - 10);
        yes.setTextAlignment(TextAlignment.RIGHT);
        yes.setTextOrigin(VPos.CENTER);
        yes.setLayoutY(yArrow.getLayoutY() + ARROW_HEIGHT / 2.0);

        Text no = new Text("FALSE");
        no.setFont(new Font("Old Antic Outline", 18));
        no.setLayoutX(nArrow.getLayoutX() + ARROW_WIDTH + 10);
        no.setLayoutY(nArrow.getLayoutY() + ARROW_HEIGHT / 2.0);
        no.setTextOrigin(VPos.CENTER);

        cur.getChildren().add(yes);
        cur.getChildren().add(no);
        cur.getChildren().add(yArrow);
        cur.getChildren().add(nArrow);

        nArrow.setOnMouseClicked(me -> onAnswer(!isYes));
        yArrow.setOnMouseClicked(me -> onAnswer(isYes));
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
