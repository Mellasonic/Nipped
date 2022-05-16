package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SceneSwap extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle a = new Rectangle(100, 100, 200, 200);
        Rectangle b = new Rectangle(200, 200, 200, 200);
        Pane p = new Pane(a);
        p.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p.getChildren().clear();
                p.getChildren().add(b);
                System.out.println(p.getChildren());
            }
        });
        p.setPrefSize(500, 500);
        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
