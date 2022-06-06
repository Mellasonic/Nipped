package mellasonic.nipped.game.point_and_click.locations.level3.overlays;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * an overlay for adding a checklist
 */
public class ChecklistOverlay implements Screen {
    /**
     * the previous location
     */
    private final Location prev;
    /**
     * the pane
     */
    private final Pane cur;
    /**
     * dimensions of the checklist overlay
     */
    public static final int WIDTH=70, HEIGHT=100;

    /**
     * class constructor
     * @param prev the previous location
     * @param changer the screen changer
     */
    public ChecklistOverlay(Location prev, ScreenChanger changer){
        // create current pane
        this.prev = prev;
        cur = new Pane(prev.getNode());

        // make the pane the full screen
        cur.setLayoutX(0);
        cur.setLayoutY(0);
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // create the overlay & position it
        Pane overlay = new Pane();
        Tools.setPos(overlay, 0, 0);
        overlay.setPrefSize(Main.WIDTH, Main.HEIGHT);
        cur.getChildren().add(overlay);

        // darken the background
        Rectangle bg = new Rectangle(0, 0, Main.WIDTH, Main.HEIGHT);
        bg.setFill(new Color(0, 0, 0, 0.4));
        overlay.getChildren().add(bg);

        // the clickable notepad
        ImageView click = new ImageView(Tools.getImage("assets/note.png"));
        Tools.setPos(click, Main.WIDTH / 2 - WIDTH / 2, Main.HEIGHT / 2 - HEIGHT / 2);
        click.setFitWidth(WIDTH);
        click.setFitHeight(HEIGHT);

        // add functionality to the notepad
        AtomicBoolean changed = new AtomicBoolean(false);
        click.setOnMouseClicked(me -> {
            // if we already changed the notepad, go to the previous screen
            if(changed.get()){
                changer.screenChange(prev);
            } else {
                // add text to the notepad
                click.setImage(Tools.getImage("assets/checklistmain.png"));
                changed.set(true);
            }
        });
        overlay.getChildren().add(click);
    }

    @Override
    public Node getNode() {
        return cur;
    }
}
