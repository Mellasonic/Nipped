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

public class Instructions implements AppState {

    private static final List<String> pages = Arrays.asList(
            "In the first level, you eat food",
            "In the second level, you blob away"
    );

    public static final int PANEL_MARGIN = 30;
    public static final int CONTENT_MARGIN = 30;

    private Pane paneOf(int page){
        int width = Main.WIDTH - 2 * PANEL_MARGIN;
        int height = Main.HEIGHT - 2 * PANEL_MARGIN;
        Pane p = new Pane();

        ImageView panel = new ImageView(Tools.getImage("assets/panel.png"));
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

        return p;
    }

    @Override
    public Scene getScene(){
        // declare main pane
        Pane p = new Pane();
        p.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // initialize background image & add to pane
        ImageView background = new ImageView(getImage("assets/livingroom.png"));
        background.setFitWidth(Main.WIDTH);
        background.setFitHeight(Main.HEIGHT);
        p.getChildren().add(background);

        ArrayList<Pane> nodes = new ArrayList<>();
        for(int i = 0; i < pages.size(); i++){
            Pane add = paneOf(i);
            add.setLayoutX(PANEL_MARGIN);
            add.setLayoutY(PANEL_MARGIN);
            nodes.add(add);
        }

        p.getChildren().add(nodes.get(0));
        return new Scene(p);
    }
}