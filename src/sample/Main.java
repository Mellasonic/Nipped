package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle a = new Rectangle(100, 100, 200, 200);
        Rectangle b = new Rectangle(200, 200, 300, 300);
        Pane p1 = new Pane(a);
        Pane p2 = new Pane(b);
        p1.setPrefSize(500, 500);
        p2.setPrefSize(500, 500);
        Scene s1 = new Scene(p1);
        Scene s2 = new Scene(p2);

        a.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                primaryStage.setScene(s2);
            }
        });

        p2.setOnMousePressed(me -> {
            primaryStage.setScene(s1);
        });

        primaryStage.setScene(s1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
