package mellasonic.nipped;

import javafx.stage.Stage;

public class Main {
    private AppState curState;
    private final Stage stage;
    private static Main instance = null;
    public static final int WIDTH = 852, HEIGHT=480;

    private Main(Stage primaryStage, AppState start){
        this.curState = start;
        this.stage = primaryStage;
    }
    public static Main newApp(Stage primaryStage, AppState start){
        instance = new Main(primaryStage, start);
        return instance;
    }
    public static Main getApp(){
        return instance;
    }
    public void changeState(AppState to){
        curState = to;
        stage.setScene(curState.getScene());
    }
    public void render(){
        stage.setScene(curState.getScene());
        stage.show();
    }
}
