/* ICS Final Project Nipped
 2022/05/31
 Time spent: 1.5
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - May 31, 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh
 Version 1.0
 2022/05/31
 Time spent: 1 hour
 New features/processing: Beginning code, adds background & writing
*/
/*
 Modification Authors: James Huynh
 Version 1.1
 2022/06/01
 Time spent: 0.5 hours
 New features/processing: Add instructions to the menu
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
            "Level 1\nLevel 1 is a learning area. Mittens the cat has been having some troubles with food recently, and as you move through the level, you'll learn more about Mitten's addiction to eating. Mittens has left pieces of cat food and notes around for you to click on and read more about food addiction. Once you've looked at all the notes and cat food, a door will open up to level 2.",
            "Level 2\nLevel 2 is about applying your learning. Mittens needs some help choosing which is a symptom of food addiction and which isn't. For each one you get right, you'll gain a streak, and once you've gotten a streak of 5, you'll continue to level 3.",
            "Level 3\nLevel 3 is Mittens's final challenge. Mittens has to apply some strategies to prevent them from eating too much. You'll have to help Mittens write notes, find hobbies, and much more. Once you've helped Mittens in every room of their home, you'll be finished with the game!"
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
     * dimensions of arrow
     */
    public static final int ARROW_WIDTH=60, ARROW_HEIGHT=48;

    public Instructions(){
        // declare main pane
        screen = new Pane();
        screen.setPrefSize(Main.WIDTH, Main.HEIGHT);
    }

    /**
     * Creates a node representing the current panel of the instructions
     * @param page the page number to be rendered
     * @return a node displaying the panel
     */
    private Pane paneOf(int page){
        // dimensions of the panel
        int width = Main.WIDTH - 2 * PANEL_MARGIN;
        int height = Main.HEIGHT - 2 * PANEL_MARGIN;

        // the entire panel
        Pane p = new Pane();

        // the image of the panel
        ImageView panel = new ImageView(getImage("assets/panel.png"));
        panel.setFitWidth(width);
        panel.setFitHeight(height);
        p.getChildren().add(panel);

        // add the relevant text to the panel
        Text text = new Text(pages.get(page));
        text.setTextOrigin(VPos.TOP);
        text.setWrappingWidth(width - 2 * CONTENT_MARGIN);
        text.setLayoutX(CONTENT_MARGIN);
        text.setLayoutY(CONTENT_MARGIN);
        text.setFont(new Font("Bell MT", 24));
        p.getChildren().add(text);

        // if there is a previous page, add it
        if(page > 0){
            // the left arrow
            ImageView leftArrow = new ImageView(getImage("assets/R-redarrow.png"));
            leftArrow.setFitWidth(ARROW_WIDTH);
            leftArrow.setFitHeight(ARROW_HEIGHT);
            leftArrow.setLayoutX(CONTENT_MARGIN);
            leftArrow.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT);

            // the text denoting that this arrow goes to the previous page
            Text left = new Text("Previous");
            left.setFont(new Font("Baskerville Old Face", 18));
            left.setTextOrigin(VPos.CENTER);
            left.setLayoutX(CONTENT_MARGIN + ARROW_WIDTH + 5);
            left.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT / 2.0);

            // when it is clicked, go to the previous page
            leftArrow.setOnMouseClicked(me -> {
                Pane add = paneOf(page - 1);
                screen.getChildren().set(1, add);
            });

            // add the left arrow
            p.getChildren().add(leftArrow);
            p.getChildren().add(left);
        }

        // if there is a next page, add an arrow for it
        if(page < pages.size() - 1){
            // the image of the right arrow
            ImageView rightArrow = new ImageView(getImage("assets/R-greenarrow.png"));
            rightArrow.setFitWidth(ARROW_WIDTH);
            rightArrow.setFitHeight(ARROW_HEIGHT);
            rightArrow.setLayoutX(width - CONTENT_MARGIN - ARROW_WIDTH);
            rightArrow.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT);

            // the text stating that this arrow goes to the next page
            Text right = new Text("Next");
            right.setFont(new Font("Baskerville Old Face", 18));
            right.setTextOrigin(VPos.CENTER);
            right.setTextAlignment(TextAlignment.RIGHT);
            right.setWrappingWidth(100);
            right.setLayoutX(width - CONTENT_MARGIN - ARROW_WIDTH - 100);
            right.setLayoutY(height - CONTENT_MARGIN - ARROW_HEIGHT / 2.0);

            // add functionality to the arrow
            rightArrow.setOnMouseClicked(me -> {
                Pane add = paneOf(page + 1);
                screen.getChildren().set(1, add);
            });

            // add the right arrow
            p.getChildren().add(rightArrow);
            p.getChildren().add(right);
        }

        // position this page in the proper position
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

        // set the screen to the first pane
        screen.getChildren().add(paneOf(0));

        screen.getChildren().add(new MenuButton(10,10){
            @Override
            public void onClick() {
                Main.getApp().changeState(new MainMenu());
            }
        }.getNode());
        return new Scene(screen);
    }
}