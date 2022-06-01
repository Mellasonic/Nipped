/* ICS Final Project Nipped
 2022/05/31
 Time spent: 1
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - May 31, 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh
 Version 1.0
 2022/05/31
 Time spent: 1 hour
 New features/processing: Beginning code, adds background
*/
package mellasonic.nipped.main_menu;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.GameState;
import mellasonic.nipped.interactable.Button;
import mellasonic.nipped.interactable.Interactive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mellasonic.nipped.Tools.getImage;

/**
 * The state in which users get their instructions
 */
public class Instructions implements AppState {
    /**
     * the text that appears on each page
     */
    private static final List<String> pages = Arrays.asList(
            "In the first level, you eat food and you eat more food and blob blob blob and more sample text which is yummy",
            "In the second level, you blob away"
    );

    /**
     * the screen
     */
    private final Pane screen;
    /**
     * the margins of the panel itself
     */
    public static final int PANEL_MARGIN = 30;
    /**
     * the margins of the context from the panel
     */
    public static final int CONTENT_MARGIN = 30;
    /**
     * dimensions of the arrow
     */
    public static final int ARROW_WIDTH=60, ARROW_HEIGHT=48;

    public Instructions(){
        // declare main pane
        screen = new Pane();
        screen.setPrefSize(Main.WIDTH, Main.HEIGHT);
    }

    /**
     * Creates a node representing the current panel of the instructions
     * @param page the page number
     * @return a node displaying the panel
     */
    private Pane paneOf(int page){
        int width = Main.WIDTH - 2 * PANEL_MARGIN;
        int height = Main.HEIGHT - 2 * PANEL_MARGIN;
        Pane p = new Pane();

        ImageView panel = new ImageView(getImage("assets/panel.png"));
        panel.setFitWidth(width);
        panel.setFitHeight(height);
        p.getChildren().add(panel);

        Text text = new Text(pages.get(page));
        text.setTextOrigin(VPos.TOP);
        text.setWrappingWidth(width - 2 * CONTENT_MARGIN);
        text.setLayoutX(CONTENT_MARGIN);
        text.setLayoutY(CONTENT_MARGIN);
        text.setFont(new Font("Bell MT", 24));
        p.getChildren().add(text);

        if(page > 0){
            ImageView leftArrow = new ImageView(getImage("assets/R-redarrow.png"));
            leftArrow.setFitWidth(ARROW_WIDTH);
            leftArrow.setFitHeight(ARROW_HEIGHT);
            leftArrow.setLayoutX(CONTENT_MARGIN);
            leftArrow.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT);

            Text left = new Text("Previous");
            left.setFont(new Font("Baskerville Old Face", 18));
            left.setTextOrigin(VPos.CENTER);
            left.setLayoutX(CONTENT_MARGIN + ARROW_WIDTH + 5);
            left.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT / 2.0);

            leftArrow.setOnMouseClicked(me -> {
                Pane add = paneOf(page - 1);
                add.setLayoutX(PANEL_MARGIN);
                add.setLayoutY(PANEL_MARGIN);
                screen.getChildren().set(1, add);
            });

            p.getChildren().add(leftArrow);
            p.getChildren().add(left);
        }
        if(page < pages.size() - 1){
            ImageView rightArrow = new ImageView(getImage("assets/R-greenarrow.png"));
            rightArrow.setFitWidth(ARROW_WIDTH);
            rightArrow.setFitHeight(ARROW_HEIGHT);
            rightArrow.setLayoutX(width - CONTENT_MARGIN - ARROW_WIDTH);
            rightArrow.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT);

            Text right = new Text("Next");
            right.setFont(new Font("Baskerville Old Face", 18));
            right.setTextOrigin(VPos.CENTER);
            right.setTextAlignment(TextAlignment.RIGHT);
            right.setWrappingWidth(100);
            right.setLayoutX(width - CONTENT_MARGIN - ARROW_WIDTH - 100);
            right.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT / 2.0);

            rightArrow.setOnMouseClicked(me -> {
                Pane add = paneOf(page + 1);
                screen.getChildren().set(1, add);
            });

            p.getChildren().add(rightArrow);
            p.getChildren().add(right);
        }
        p.setLayoutX(PANEL_MARGIN);
        p.setLayoutY(PANEL_MARGIN);

        return p;
    }

    @Override
    public Scene getScene(){
        // initialize background image & add to pane
        ImageView background = new ImageView(getImage("assets/livingroom.png"));
        background.setFitWidth(Main.WIDTH);
        background.setFitHeight(Main.HEIGHT);
        screen.getChildren().add(background);

        screen.getChildren().add(paneOf(0));
        return new Scene(screen);
    }
}