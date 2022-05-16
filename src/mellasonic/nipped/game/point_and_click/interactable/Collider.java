package mellasonic.nipped.game.point_and_click.interactable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Collider implements Interactive{
    private final Image normal;
    private final Image onHover;
    protected final int x, y, width, height;

    public Collider(Image normal, Image onHover, int x, int y, int width, int height){
        this.normal = normal;
        this.onHover = onHover;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    @Override
    public void render(GraphicsContext drawer, int mouseX, int mouseY){
        if(hit(mouseX, mouseY)){
            drawer.drawImage(onHover, x, y, width, height);
        } else {
            drawer.drawImage(normal, x, y, width, height);
        }
    }
}
