package smud.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BrowseMaps {
    public static VBox create() {
        VBox mapButtons = new VBox();
        // will have to connect maps to map button
        Label title = new Label("Maps");
        title.setFont(new Font(75));
        title.setTextFill(Color.CHARTREUSE);
        Button map1button = new Button("Map #1 - *insert creative title*");
        Button map2button = new Button("Map #2 - *insert creative title*");
        mapButtons.getChildren().addAll(title, map1button, map2button);
        mapButtons.setAlignment(Pos.CENTER);
        mapButtons.setStyle("-fx-background-color: black;");

        return mapButtons;
    }
}
