package mellasonic.nipped.game.point_and_click;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.game.point_and_click.interactable.Interactive;

import java.util.ArrayList;

public abstract class Location implements Screen{

    private final ArrayList<Interactive> objects;
    private final Image background;
    private final Pane cur;

    public Location(Image background, ArrayList<Interactive> interactive){
        this.background = background;
        this.objects = interactive;
        cur = new Pane(drawElements(-9999, -9999));
    }

    @Override
    public void onClick(int x, int y) {
        for(Interactive i : objects){
            i.onClick(x, y);
        }
    }

    private Canvas drawElements(int x, int y){
        Canvas canvas = new Canvas(Main.WIDTH, Main.HEIGHT);
        GraphicsContext drawer = canvas.getGraphicsContext2D();
        drawer.drawImage(background, 0, 0, Main.WIDTH, Main.HEIGHT);
        for(Interactive i : objects){
            i.render(drawer, x, y);
        }
        return canvas;
    }

    @Override
    public void onMove(int x, int y) {
        cur.getChildren().clear();
        cur.getChildren().add(drawElements(x, y));
    }

    @Override
    public Node render() {
        return cur;
    }
}
