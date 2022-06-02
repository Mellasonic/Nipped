package mellasonic.nipped.game;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.main_menu.MainMenu;

/**
 * a state which prompts the user for their name
 */
public class ScoreState implements AppState {
    /**
     * the root scene
     */
    private final Scene root;
    /**
     * the margins of the panel
     */
    public static final int MARGIN = 30;
    /**
     * the size of the text field
     */
    public static final int NAME_WIDTH = 300;
    /**
     * the maximum name length
     */
    public static int MAX_LENGTH = 40;

    /**
     * class constructor
     * @param score the score of the player
     */
    public ScoreState(int score) {
        // initialize the pane
        Pane cur = new Pane();
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // add the background
        ImageView bg = Tools.makeSprite("assets/livingroom.png", Main.WIDTH, Main.HEIGHT);
        cur.getChildren().add(bg);

        // add the foreground panel
        ImageView submitCard = Tools.makeSprite("assets/panel.png", MARGIN, MARGIN, Main.WIDTH - 2 * MARGIN,
                Main.HEIGHT - 2 * MARGIN);
        cur.getChildren().add(submitCard);

        // the components
        VBox components = new VBox(20);
        Tools.setPos(components, (int) submitCard.getLayoutX(), (int) submitCard.getLayoutY() + 15);

        // add a heading
        Text heading = new Text("Good Job!");
        heading.setFont(new Font("Tw Cen MT Condensed Extra Bold", 64));
        heading.setWrappingWidth(submitCard.getFitWidth());
        heading.setTextAlignment(TextAlignment.CENTER);
        components.getChildren().add(heading);

        // add a score text
        Text scoreText = new Text("You got a score of " + score);
        scoreText.setFont(new Font("Tw Cen MT Condensed Extra Bold", 24));
        scoreText.setWrappingWidth(submitCard.getFitWidth());
        scoreText.setTextAlignment(TextAlignment.CENTER);
        components.getChildren().add(scoreText);

        // add the textfield for the name entering
        TextField name = new TextField("Enter your name here");
        name.setLayoutX(submitCard.getLayoutX() + submitCard.getFitWidth() / 2 - NAME_WIDTH / 2.0);
        name.setLayoutY(250);
        name.setPrefWidth(NAME_WIDTH);
        name.setFont(new Font("Tw Cen MT", 24));
        name.setOnAction(ae -> {
            if(name.getText().length() > MAX_LENGTH){
                // if the name is too long, then tell the player to shorten the name
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name too long");
                alert.setHeaderText("Your name is too long!");
                alert.setContentText("Please enter at most " + MAX_LENGTH + " characters");
                alert.showAndWait();
            } else {
                // add the score and return to main menu
                Tools.addScore(name.getText().replace(' ', '_'), score);
                Main.getApp().changeState(new MainMenu());
            }
        });
        // add the name textfield
        cur.getChildren().add(name);

        // add the components
        cur.getChildren().add(components);

        // add the current node
        root = new Scene(cur);
    }

    @Override
    public Scene getScene() {
        return root;
    }
}
