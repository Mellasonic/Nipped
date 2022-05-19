/* ICS Final Project Nipped
 2022/05/17
 Time spent: 1 hour
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 17 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/17
 Time spent: 1 hour
 New features/processing: created main class, implement scene switching
*/

package mellasonic.nipped;

import javafx.stage.Stage;

/**
 * The main class for the application
 */
public class Main {
    /**
     * Current state of the application (Main Menu, Game State, Credits State, etc.)
     */
    private AppState curState;
    /**
     * The screen
     */
    private final Stage stage;
    /**
     * A singleton pattern - the current application instance
     */
    private static Main instance = null;
    /**
     * Dimensions of the screen
     */
    public static final int WIDTH = 852, HEIGHT=480;

    /**
     * Class Constructor
     * @param primaryStage The screen
     * @param start the starting application state
     * @implNote To implement the singleton pattern, the constructor is private - classes cannot easily make an instance of it
     */
    private Main(Stage primaryStage, AppState start){
        this.curState = start;
        this.stage = primaryStage;
    }

    /**
     * Creates a new instance of the application
     * @param primaryStage the screen
     * @param start the starting state
     * @return the created instance of Main
     */
    protected static Main newApp(Stage primaryStage, AppState start){
        instance = new Main(primaryStage, start);
        return instance;
    }

    /**
     * @return the instance of the application
     */
    public static Main getApp(){
        return instance;
    }

    /**
     * Changes the state
     * @param to the state to change the current state to
     */
    public void changeState(AppState to){
        curState = to;
        stage.setScene(curState.getScene());
    }

    /**
     * Initial screen drawing
     */
    protected void render(){
        stage.setScene(curState.getScene());
        stage.show();
    }
}
