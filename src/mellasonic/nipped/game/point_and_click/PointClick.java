package mellasonic.nipped.game.point_and_click;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import mellasonic.nipped.game.Level;

public class PointClick implements Level {
    Screen curScreen;
    Pane cur;
    public PointClick(Screen startScreen){
        curScreen = startScreen;
        cur = new Pane(startScreen.render());
    }
    @Override
    public Parent render() {
        return null;
    }
    public void changeScreen(Screen to){
        curScreen = to;
        cur.getChildren().clear();
        cur.getChildren().add(to.render());
    }
}
