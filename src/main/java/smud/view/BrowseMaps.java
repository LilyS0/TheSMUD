package smud.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BrowseMaps {
    public static VBox create(Stage primary) {
        VBox mapButtons = new VBox();
        // will have to connect maps to map button
        Label title = new Label("Maps");
        title.setFont(new Font(75));
        title.setTextFill(Color.CHARTREUSE);
        Button map1button = new Button("Map #1 - *insert creative title*");
        map1button.setOnAction(e -> {
            primary.setScene(new Scene(BrowseMaps.mapMaker("src/main/java/smud/model/Environment/map/maps/map1.txt")));
            // have to make a derivation of the maps first
        });
        Button map2button = new Button("Map #2 - *insert creative title*");
        map2button.setOnAction(e -> {
            primary.setScene(new Scene(BrowseMaps.mapMaker("src/main/java/smud/model/Environment/map/maps/map2.txt")));
        });
        mapButtons.getChildren().addAll(title, map1button, map2button);
        mapButtons.setAlignment(Pos.CENTER);
        mapButtons.setStyle("-fx-background-color: black;");

        return mapButtons;
    }

    // map maker map maker make me a map
    // find me a shrine catch me an axe
    private static Label mapMaker(String filePath) {
        Label map = new Label();
        String mapContent = readContentFromFile(filePath);
        map.setText(mapContent);
        return map;
    }

    private static String readContentFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
