package mellasonic.nipped.game.point_and_click;

import javafx.scene.Node;

public interface Screen {
    void onClick(int x, int y);
    Node render();
}
