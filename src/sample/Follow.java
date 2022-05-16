package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Follow extends Application {
    @Override
    public void start(Stage primaryStage){
        Rectangle a = new Rectangle(100, 100, 200, 200);

        Pane g = new Pane(a);
        g.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Rectangle r = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 100, 100);
                g.getChildren().clear();
                g.getChildren().add(r);
            }
        });
        Scene s = new Scene(g, 500, 500);
        primaryStage.setScene(s);
        primaryStage.show();
    }
    public static void main(String[] args){ launch(args); }
}
