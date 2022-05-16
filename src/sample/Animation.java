package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {
    @Override
    public void start(Stage primaryStage){
        Rectangle a = new Rectangle(100, 100, 200, 200);
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(1000));
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(45);
        rotate.setNode(a);

        TranslateTransition trans = new TranslateTransition();
        trans.setByX(500);
        trans.setDuration(Duration.millis(400));
        trans.setNode(a);

        a.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rotate.play();
                trans.play();
            }
        });

        Pane g = new Pane(a);
        Scene s = new Scene(g, 500, 500);
        primaryStage.setScene(s);
        primaryStage.show();
    }
    public static void main(String[] args){ launch(args); }
}
