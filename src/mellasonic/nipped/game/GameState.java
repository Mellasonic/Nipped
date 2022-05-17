package mellasonic.nipped.game;

import javafx.scene.Scene;
import mellasonic.nipped.AppState;
import mellasonic.nipped.game.point_and_click.Level1;

public class GameState implements AppState {
    Level curLevel;
    Scene cur;
    public GameState(){
        curLevel = new Level1();
        cur = new Scene(curLevel.getNode());
    }
    public Scene getScene(){
        return cur;
    }
    public void changeLevel(Level to){
        curLevel = to;
        cur.setRoot(curLevel.getNode());
    }
}
