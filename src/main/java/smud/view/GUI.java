package smud.view;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.scene.text.Font;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("SMUD craft");
        title.setFont(new Font(75));
        title.setTextFill(Color.CHARTREUSE);
//        title.setAlignment(Pos.CENTER);
        BorderPane general = new BorderPane();
        general.setStyle("-fx-background-color: black;");
        general.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        Scene scene = new Scene(general, 400, 300);
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
