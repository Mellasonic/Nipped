package mellasonic.nipped.game.point_and_click.interactable;

import javafx.scene.image.Image;

public abstract class Rectangle extends Collider{
    public Rectangle(Image normal, Image onHover, int x, int y, int width, int height) {
        super(normal, onHover, x, y, width, height);
    }

    @Override
    public boolean hit(int x, int y) {
        return this.x <= x && x <= this.x + this.width && this.y <= y && y <= this.y + this.height;
    }
}
