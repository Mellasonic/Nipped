/* ICS Final Project Nipped
 2022/06/03
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 3 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye, Eric Jin
 Version 1.1
 2022/06/03
 Time spent: 30 min
 New features/processing: Create the menu overlay
*/

package mellasonic.nipped.game;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Button;

/**
 * an overlay for the user to resume the game of exit
 */
public abstract class MenuOverlay {
    /**
     * the node to return
     */
    private final Pane ret;
    /**
     * Dimensions of the card
     */
    public static final int CARD_WIDTH=360, CARD_HEIGHT=360;
    /**
     * dimensions of the buttons
     */
    public static final int BUTTON_WIDTH = 340, BUTTON_HEIGHT=60;

    /**
     * class constructor
     */
    public MenuOverlay(){
        // create a new pane that covers the screen
        ret = new Pane();
        ret.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // add the card
        ImageView card = new ImageView(Tools.getImage("assets/panel.png"));
        card.setFitWidth(CARD_WIDTH);
        card.setFitHeight(CARD_HEIGHT);
        card.setLayoutX(Main.WIDTH / 2.0 - CARD_WIDTH / 2.0);
        card.setLayoutY(Main.HEIGHT / 2.0 - CARD_HEIGHT / 2.0);
        ret.getChildren().add(card);

        // add a vbox for the two buttons
        VBox buttons = new VBox(70);
        buttons.setLayoutX(card.getLayoutX());
        buttons.setLayoutY(card.getLayoutY());
        buttons.setMinHeight(CARD_HEIGHT);
        buttons.setMinWidth(CARD_WIDTH);
        buttons.setMaxHeight(CARD_HEIGHT);
        buttons.setAlignment(Pos.CENTER);

        // add the resume button
        buttons.getChildren().add(new Button(Tools.getImage("assets/resumebutton.png"),
                Tools.getImage("assets/resumebuttonhover.png"), BUTTON_WIDTH, BUTTON_HEIGHT){
            @Override
            public void onClick() {
                onResume();
            }
        }.getNode());

        // add the exit button
        buttons.getChildren().add(new Button(Tools.getImage("assets/exitbutton.png"),
                Tools.getImage("assets/exitbuttonhover.png"), BUTTON_WIDTH, BUTTON_HEIGHT){
            @Override
            public void onClick() {
                onExit();
            }
        }.getNode());

        // add the buttons to the pane
        ret.getChildren().add(buttons);
    }

    /**
     * called when the user opts to exit
     */
    public abstract void onExit();

    /**
     * called when the user opts to resume the game
     */
    public abstract void onResume();

    /**
     * returns the current node
     * @return the node of the menu overlay
     */
    public Pane getNode(){
        return ret;
    }
}
