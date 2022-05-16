package mellasonic.nipped;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    AppState curState;
    public static Main instance = null;
    private Main(){}
    public static Main newApp(){
        instance = new Main();
        return instance;
    }
    public static Main getApp(){
        return instance;
    }
    public void changeState(AppState to){
        curState = to;
        curState.getScene();
    }

    @Override
    public void start(Stage stage) throws Exception {
        curState.getScene();
    }
    public static void main(String[] args){
        launch(args);
    }
}
