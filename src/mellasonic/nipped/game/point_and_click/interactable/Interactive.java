package mellasonic.nipped.game.point_and_click.interactable;

import javafx.scene.canvas.GraphicsContext;

public interface Interactive {
    boolean hit(int x, int y);
    void onClick(int x, int y);
    void render(GraphicsContext drawer, int mouseX, int mouseY);
}
