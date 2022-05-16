package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CanvasTest extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Canvas c = new Canvas(300, 300);
        GraphicsContext draw = c.getGraphicsContext2D();
        FileInputStream fs = new FileInputStream("assets/catface.png");
        Image img = new Image(fs);
        draw.drawImage(img, 0, 0, 100, 100);
        Pane p = new Pane(c);
        p.setPrefSize(852, 480);
        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
