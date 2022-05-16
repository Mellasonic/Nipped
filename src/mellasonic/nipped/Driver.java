package mellasonic.nipped;

import javafx.application.Application;
import javafx.stage.Stage;
import mellasonic.nipped.main_menu.MainMenu;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Main m = Main.newApp(stage, new MainMenu());
        m.render();
    }
    public static void main(String[] args){
        launch(args);
    }
}
