package mellasonic.nipped.main_menu.leaderboard;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.main_menu.MainMenu;
import mellasonic.nipped.main_menu.MenuButton;

import java.util.List;

public class Leaderboard implements AppState {
    /**
     * the current scene
     */
    private final Scene screen;
    /**
     * the margin of the panel from the screen
     */
    public static final int MARGIN=30;
    /**
     * the margin of the text relative to the panel
     */
    public static final int TEXT_MARGIN=20;
    /**
     * the maximum number of lines to store
     */
    public static final int MAX_LINES = 20;

    /**
     * class constructor
     */
    public Leaderboard(){
        // the main container
        Pane cur = new Pane();
        Tools.setPos(cur, 0, 0);
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // create background
        ImageView bg = new ImageView(Tools.getImage("assets/bg.png"));
        Tools.setPos(bg, 0, 0);
        bg.setFitWidth(Main.WIDTH);
        bg.setFitHeight(Main.HEIGHT);
        cur.getChildren().add(bg);

        // panel for the leaderboard
        ImageView panel = new ImageView(Tools.getImage("assets/panel.png"));
        Tools.setPos(panel, MARGIN, MARGIN);
        panel.setFitWidth(Main.WIDTH - 2 * MARGIN);
        panel.setFitHeight(Main.HEIGHT - 2 * MARGIN);
        cur.getChildren().add(panel);

        // list of scores
        VBox elements = new VBox(5);
        elements.setLayoutX(MARGIN + TEXT_MARGIN);
        elements.setLayoutY(MARGIN + TEXT_MARGIN);

        // add the heading
        Text heading = Tools.createText("Leaderboard", TextAlignment.CENTER, new Font("Gill Sans Ultra Bold", 28),
                0, 0, Main.WIDTH - 2 * MARGIN - TEXT_MARGIN);
        elements.getChildren().add(heading);

        // add a invisible line between the heading and the rest of the text
        Pane spacing = new Pane();
        spacing.setPrefHeight(20);
        elements.getChildren().add(spacing);

        // add the scores
        List<Score> scores = ScoreReader.getScores();
        for(int i = 0; i < Math.min(scores.size(), MAX_LINES); ++i){
            // create the name and score texts
            Score player = scores.get(i);
            Text name = Tools.createText(player.name, TextAlignment.LEFT, new Font("Kristen ITC", 18),
                    150, 0, Main.WIDTH - 2 * MARGIN - TEXT_MARGIN);
            Text score = Tools.createText("(" + player.score + ")", TextAlignment.RIGHT, new Font("Kristen ITC", 18),
                    0, 0, Main.WIDTH - 2 * MARGIN - TEXT_MARGIN - 200);

            // combine them and add it to the list
            Pane element = new Pane(name, score);
            elements.getChildren().add(element);
        }
        cur.getChildren().add(elements);

        // a button to go back to the main menu
        MenuButton menu = new MenuButton() {
            @Override
            public void onClick() {
                Main.getApp().changeState(new MainMenu());
            }
        };
        cur.getChildren().add(menu.getNode());

        screen = new Scene(cur);
    }

    @Override
    public Scene getScene() {
        return screen;
    }
}
