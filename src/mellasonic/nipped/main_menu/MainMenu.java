/*
 * Daniel Ye, James Huynh, Eric Jin
 * Version 0.0.1
 * 2 hours
 * James Huynh: created assets for all buttons and backgrounds
 * Daniel Ye: created buttons, display background & buttons
 */

package mellasonic.nipped.main_menu;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.GameState;
import mellasonic.nipped.interactable.Button;
import mellasonic.nipped.interactable.Interactive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static mellasonic.nipped.Tools.getImage;

/**
 * The main menu
 */
public class MainMenu implements AppState {
    public static final int BUTTON_WIDTH = (int) (Main.WIDTH / 2.5);
    public static final int BUTTON_HEIGHT = 55;
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
        Interactive exitButton = new Button(getImage("assets/exitbutton.png"), getImage("assets/exitbutton.png"), BUTTON_WIDTH, BUTTON_HEIGHT) {
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
        Interactive instructionsButton = new Button(getImage("assets/instructionsbutton.png"), getImage("assets/instructionsbutton.png"), BUTTON_WIDTH, BUTTON_HEIGHT) {
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
        System.out.println("instructions");
    }

    /**
     * Behavior when exit button is clicked
     */
    private void quit() {
        System.out.println("quit");
    }
}
