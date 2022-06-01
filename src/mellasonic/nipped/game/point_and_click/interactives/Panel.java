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
 New features/processing: create panel, position & wrap text, position panel, add close button
*/

package mellasonic.nipped.game.point_and_click.interactives;

import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.main_menu.MenuButton;

/**
 * a panel
 */
public abstract class Panel implements Screen {
    /**
     * the node
     */
    private final Pane screen;
    /**
     * default margins around the screen of the pane
     */
    public static final int DEFAULT_MARGINS = 30;
    /**
     * the size of the close button
     */
    public static final int CLOSE_SIZE = 40;

    /**
     * Class Constructor with default margins
     * @param display the string to display
     * @param prev the previous node in the background
     */
    public Panel(String display, Node prev){
        this(DEFAULT_MARGINS, display, prev);
    }

    /**
     * Class Constructor
     * @param margins the margins around the screen
     * @param display the string the display on the pane
     * @param prev the previous node in the background
     */
    public Panel(int margins, String display, Node prev){
        // create parent pane
        screen = new Pane();
        screen.setPrefSize(Main.WIDTH, Main.HEIGHT);
        screen.setLayoutX(0);
        screen.setLayoutY(0);

        // add the previous screen
        screen.getChildren().add(prev);

        // the current pane for the panel
        Pane cur = new Pane();
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);
        cur.setLayoutX(0);
        cur.setLayoutY(0);

        // add the picture of the panel
        ImageView view = new ImageView(Tools.getImage("assets/panel.png"));
        view.setFitWidth(Main.WIDTH - 2 * margins);
        view.setFitHeight(Main.HEIGHT - 2 * margins);
        view.setLayoutY(margins);
        view.setLayoutX(margins);
        cur.getChildren().add(view);

        // display the text in the panel
        Text text = new Text(display);
        text.setFont(new Font("Sitka Text", 24));
        text.setWrappingWidth(Main.WIDTH - 2 * margins - 20);
        text.setLayoutX(margins + 15);
        text.setLayoutY(margins + 15);
        text.setTextOrigin(VPos.TOP);
        cur.getChildren().add(text);

        // create the "close panel" button
        MenuButton exitButton = new MenuButton(Main.WIDTH - DEFAULT_MARGINS - MenuButton.WIDTH / 2, DEFAULT_MARGINS - MenuButton.HEIGHT / 2) {
            @Override
            public void onClick() {
                onExit();
            }
        };
        cur.getChildren().add(exitButton.getNode());

        // add the panel to the screen
        screen.getChildren().add(cur);
    }

    /**
     * called when the panel is exited
     */
    public abstract void onExit();

    @Override
    public Node getNode() {
        return screen;
    }
}
