package mellasonic.nipped.main_menu;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;

public class MainMenu implements AppState {
    @Override
    public Scene getScene() {
        Rectangle a = new Rectangle(100, 100, 200, 200);
        Pane p = new Pane(a);
        p.setPrefSize(Main.WIDTH, Main.HEIGHT);
        return new Scene(p);
    }
}
