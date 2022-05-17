package mellasonic.nipped.game.point_and_click;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import mellasonic.nipped.game.Level;

public class PointClick implements Level {
    private Screen curScreen;
    private final Pane cur;

    public PointClick(Screen startScreen){
        curScreen = startScreen;
        cur = new Pane(startScreen.getNode());
    }
    @Override
    public Parent getNode() {
        return null;
    }
    public void changeScreen(Screen to){
        curScreen = to;
        cur.getChildren().clear();
        cur.getChildren().add(to.getNode());
    }
}
