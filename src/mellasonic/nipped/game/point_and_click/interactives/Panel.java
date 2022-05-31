package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Interactive;

/**
 * a panel
 */
public abstract class Panel implements Interactive {
    /**
     * the node
     */
    private final Pane cur;
    /**
     * default margins around the screen of the pane
     */
    public static final int DEFAULT_MARGINS = 30;

    /**
     * Class Constructor with default margins
     * @param display the string to display
     */
    public Panel(String display){
        this(DEFAULT_MARGINS, display);
    }

    /**
     * Class Constructor
     * @param margins the margins around the screen
     * @param display the string the display on the pane
     */
    public Panel(int margins, String display){
        cur = new Pane();
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);
        cur.setLayoutX(0);
        cur.setLayoutY(0);

        ImageView view = new ImageView(Tools.getImage("assets/panel.png"));
        view.setFitWidth(Main.WIDTH - 2 * margins);
        view.setFitHeight(Main.HEIGHT - 2 * margins);
        view.setLayoutY(margins);
        view.setLayoutX(margins);
        cur.getChildren().add(view);

        Text text = new Text(display);
        text.setFont(new Font("Sitka Text", 24));
        text.setWrappingWidth(Main.WIDTH - 2 * margins - 20);
        text.setLayoutX(margins + 15);
        text.setLayoutY(margins + 34);
        cur.getChildren().add(text);

        cur.setOnMouseClicked(me -> {
            onClick();
        });
    }

    @Override
    public Node getNode() {
        return cur;
    }
}
