package mellasonic.nipped.game.cards;

import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;

public class StreakCounter {
    /**
     * the current pane
     */
    private final Pane cur;
    /**
     * the height of the streak counter's various components
     */
    public static final int TEXT_HEIGHT=24;
    /**
     * Dimensions of each icon
     */
    public static final int ICON_WIDTH=26, ICON_HEIGHT=30;

    /**
     * the current streak
     */
    private int streak;

    /**
     * class constructor
     */
    public StreakCounter(){
        cur = new Pane();
        streak = 0;
        renderStreak(0);
    }

    /**
     * renders the streak counter
     * @param cnt the streak value
     */
    private void renderStreak(int cnt){
        // initialize parent container
        cur.getChildren().clear();

        // initialize component organizer
        VBox contain = new VBox(3);

        // add the text with the streak
        Text streak = new Text("Streak: " + cnt);
        streak.setFont(new Font("PT Bold Stars", TEXT_HEIGHT));
        streak.setTextOrigin(VPos.CENTER);
        streak.setLayoutY(TEXT_HEIGHT / 2.0);
        streak.setLayoutX(0);
        cur.getChildren().add(streak);
        contain.getChildren().add(streak);

        // add the icons
        HBox icons = new HBox(3);
        for(int i = 0; i < cnt; i++){
            ImageView icon = new ImageView(Tools.getImage("assets/checkmark.png"));
            icon.setFitWidth(ICON_WIDTH);
            icon.setFitHeight(ICON_HEIGHT);
            icons.getChildren().add(icon);
        }
        contain.getChildren().add(icons);

        cur.getChildren().add(contain);
    }

    /**
     * returns the streak
     * @return the streak
     */
    public int getStreak() {
        return streak;
    }

    /**
     * sets the streak
     * @param num the streak
     */
    public void setStreak(int num){
        streak = num;
        renderStreak(num);
    }

    /**
     * returns the node representation of the streak counter
     * @return the streak counter
     */
    public Node getNode(){
        return cur;
    }
}
