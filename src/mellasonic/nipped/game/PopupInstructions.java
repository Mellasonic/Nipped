/* ICS Final Project Nipped
 2022/06/09
 Time spent: 1 hour
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 9 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin
 Version 1.1
 2022/06/09
 Time spent: 1 hour
 New features/processing: Create popup page, create random bg, position panel, display text, add arrows; create constructor
*/

package mellasonic.nipped.game;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.main_menu.Instructions;

import java.util.Arrays;
import java.util.List;

/**
 * Instructions that pop up before any level - this is implemented "as a level itself"
 */
public abstract class PopupInstructions implements Level {
    /**
     * the screen
     */
    private final Pane screen;
    /**
     * the margins
     */
    public static final int MARGINS = 60;
    /**
     * the dimensions of the arrows
     */
    public static final int ARROW_WIDTH = Instructions.ARROW_WIDTH, ARROW_HEIGHT = Instructions.ARROW_HEIGHT;
    /**
     * a list of possible backgrounds
     */
    private static final List<String> paths = Arrays.asList(
            "assets/lightbluebg.png",
            "assets/orangebrownbg.png",
            "assets/cyanbg.png",
            "assets/darkbluebg.png"
    );

    /**
     * class constructor
     * @param text the text to display
     */
    public PopupInstructions(String text){
        // create the current pane
        screen = new Pane();
        Tools.setPos(screen, 0, 0);
        screen.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // the background
        ImageView bg = Tools.makeSprite(paths.get((int) (Math.random() * paths.size())), 0, 0, Main.WIDTH, Main.HEIGHT);
        screen.getChildren().add(bg);

        ImageView panel = Tools.makeSprite("assets/panel.png", MARGINS, MARGINS, Main.WIDTH - 2 * MARGINS, Main.HEIGHT - 2 * MARGINS);
        screen.getChildren().add(panel);

        // instructions
        Text instructions = Tools.createText(text, TextAlignment.LEFT, new Font("Palatino Linotype", 18),
                (int) panel.getLayoutX() + MARGINS, (int) panel.getLayoutY() + MARGINS, (int) panel.getFitWidth() - 2 * MARGINS);
        screen.getChildren().add(instructions);

        // create a right arrow for going to the next level
        ImageView rightArrow = Tools.makeSprite("assets/R-greenarrow.png", (int) (panel.getLayoutX() + panel.getFitWidth() - 20 - ARROW_WIDTH),
                (int) (panel.getLayoutY() + panel.getFitHeight() - 20 - ARROW_HEIGHT), ARROW_WIDTH, ARROW_HEIGHT);
        rightArrow.setOnMouseClicked(me -> nextLevel());
        Tools.addCursorChange(rightArrow);
        screen.getChildren().add(rightArrow);
    }

    @Override
    public Parent getNode() {
        return screen;
    }
}
