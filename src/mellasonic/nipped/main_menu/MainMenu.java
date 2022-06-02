/* ICS Final Project Nipped
 2022/05/18
 Time spent: 4 hours
*/

/*
 Nipped is a java game with three different levels.
 Version 1.3 - 18 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh
 Version 1.1
 2022/05/16
 Time spent: 2 hours
 New features/processing: created title button, play button, instructions button, exit button, cat sprite, food sprite
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/17
 Time spent: 1 hour
 New features/processing: Created Buttons, position and display onto screen
*/

/*
 Modification Authors: James Huynh
 Version 1.3
 2022/05/18
 Time spent: 1 hour
 New features/processing: ported to jgrasp
*/

package mellasonic.nipped.main_menu;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import mellasonic.nipped.game.ScoreState;
import mellasonic.nipped.interactable.Button;
import mellasonic.nipped.interactable.Interactive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static mellasonic.nipped.Tools.getImage;

/**
 * The main menu
 */
public class MainMenu implements AppState {
    /**
     * Default width of buttons
     */
    public static final int BUTTON_WIDTH = (int) (Main.WIDTH / 2.5);
    /**
     * Default height of buttons
     */
    public static final int BUTTON_HEIGHT = 55;
    /**
     * Starting y coordinate of buttons
     */
    public static final int BUTTON_START = 235;

    @Override
    public Scene getScene() {
        // declare main pane
        Pane p = new Pane();
        // initialize background image & add to pane
        ImageView background = new ImageView(getImage("assets/title.png"));
        background.setFitWidth(Main.WIDTH);
        background.setFitHeight(Main.HEIGHT);
        p.getChildren().add(background);

        // initialize button container
        VBox buttons = new VBox();
        buttons.setLayoutY(BUTTON_START);
        buttons.setPrefHeight(Main.HEIGHT - BUTTON_START);
        buttons.setPrefWidth(Main.WIDTH);
        buttons.setAlignment(Pos.TOP_CENTER);
        buttons.setSpacing(10);

        // initialize buttons
        Interactive exitButton = new Button(getImage("assets/exitbutton.png"), getImage("assets/exitbuttonhover.png"), BUTTON_WIDTH, BUTTON_HEIGHT) {
            @Override
            public void onClick() {
                quit();
            }
        };
        Interactive playButton = new Button(getImage("assets/playbutton.png"), getImage("assets/playbuttonhover.png"), BUTTON_WIDTH, BUTTON_HEIGHT) {
            @Override
            public void onClick() {
                play();
            }
        };
        Interactive instructionsButton = new Button(getImage("assets/instructionsbutton.png"), getImage("assets/instructionsbuttonhover.png"), BUTTON_WIDTH, BUTTON_HEIGHT) {
            @Override
            public void onClick() {
                instructions();
            }
        };

        // add buttons to vbox
        buttons.getChildren().addAll(playButton.getNode(), instructionsButton.getNode(), exitButton.getNode());

        // add buttons to Pane
        p.getChildren().add(buttons);

        return new Scene(p);
    }

    /**
     * Behavior when play button is clicked
     */
    private void play() {
        GameState gameState = new GameState();
        Main.getApp().changeState(gameState);
    }

    /**
     * Behavior when instructions button is clicked
     */
    private void instructions() {
        Instructions instructions = new Instructions();
        Main.getApp().changeState(instructions);
    }

    /**
     * Behavior when exit button is clicked
     */
    private void quit() {
        System.out.println("quit");
    }
}
