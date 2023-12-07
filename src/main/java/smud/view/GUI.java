package smud.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

/**
 * This class implements JavaFX as well as several other classes to
 * generate the SMUD GUI.
 * PLEASE NOTE: This has been developed using the liberica-17.0.9 Version of Java.
 *
 * @author Sydney Wilson
 */
public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(Welcome.create(primaryStage), 400, 300);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setTitle("SMUDcraft");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
