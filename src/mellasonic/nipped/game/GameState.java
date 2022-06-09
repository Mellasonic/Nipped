/* ICS Final Project Nipped
 2022/05/31
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.2 - 31 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/16
 Time spent: 10 mins
 New features/processing: Created Game, override methods, allow for changing method
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/31
 Time spent: 10 min
 New features/processing: Change between levels
*/

package mellasonic.nipped.game;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.WinScreen;
import mellasonic.nipped.game.cards.Level2;
import mellasonic.nipped.game.point_and_click.Level1;
import mellasonic.nipped.game.point_and_click.Level3;
import mellasonic.nipped.main_menu.MainMenu;
import mellasonic.nipped.main_menu.MenuButton;

/**
 * When the player is playing the actual game
 */
public class GameState implements AppState {
    /**
     * The current level
     */
    private Level curLevel;
    /**
     * The current scene
     */
    private final Scene cur;
    /**
     * the container for the levels
     */
    private final Pane container;

    /**
     * Class constructor
     */
    public GameState(){
        // create a container
        container = new Pane();

        // add the menu button
        MenuButton menuButton = new MenuButton(){
            @Override
            public void onClick() {
                // add an overlay
                container.getChildren().add(new MenuOverlay(){
                    @Override
                    public void onExit() {
                        Main.getApp().changeState(new MainMenu());
                    }
                    @Override
                    public void onResume() {
                        // remove the overlay
                        container.getChildren().remove(this.getNode());
                    }
                }.getNode());
            }
        };

        // starting time
        long start = System.currentTimeMillis();

        // add levels
        curLevel = new PopupInstructions("Mittens the cat suffers from food addiction. In this level, you will learn about food addiction, specifically what it is and some symptoms of it. There are bags of cat food and notes scattered about Mittens’s home, and when you click on one, an information notification will appear, telling you about food addiction. Once you’ve clicked on all the notes and food bags, a door will open up to the next level.") {
            @Override
            public void nextLevel() {
            changeLevel(new Level1(){
                @Override
                public void nextLevel() {
                changeLevel(new PopupInstructions("In this level, you have to put your knowledge to the test! Mittens the cat needs help recognizing their food addiction, and you have to answer questions correctly. Each question will have a yes or no option, and you have to get five questions in a row correct in order to move onto the final level.") {
                    @Override
                    public void nextLevel() {
                    changeLevel(new Level2(){
                        @Override
                        public void nextLevel() {
                        changeLevel(new PopupInstructions("Mittens the cat now sees their faults and wants to improve. Help Mittens use different techniques to overcome food addiction. These include replacing unhealthy food with healthy food, writing checklists, finding distractions, and being mindful. Once you’ve helped Mittens in every room of their home, you win!") {
                            @Override
                            public void nextLevel() {
                            changeLevel(new Level3(){
                                @Override
                                public void nextLevel() {
                                // calculate scores
                                long end = System.currentTimeMillis();
                                int score = (int) ((end - start) / 1000);
                                Main.getApp().changeState(new WinScreen(score));
                                }
                            });
                            }
                        });
                        }
                    });
                    }
                });
                }
            });
            }
        };

        // add the components
        container.getChildren().add(curLevel.getNode());
        container.getChildren().add(menuButton.getNode());
        cur = new Scene(container);
    }

    @Override
    public Scene getScene(){
        return cur;
    }

    /**
     * Moves to another level (usually after one is complete)
     * @param to the level to move to
     */
    public void changeLevel(Level to){
        curLevel = to;
        container.getChildren().set(1, curLevel.getNode());
    }
}
