package smud.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PostLogin {
    public static VBox create() {
        // vbox 1: resume game button, new game button
        // vbox 2: browse maps button, browse inventory button
        // hbox 1 = vbox1 + vbox 2
        // hbox 2: settings button
        // hbox 3: list of stats (# items found, games played, lives lost, monsters slain, gold earned)
        VBox vb1 = new VBox();
        Button resumeGame = new Button("Resume Game");
        Button newGame = new Button("New Game");
        vb1.getChildren().addAll(resumeGame, newGame);
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(75);

        VBox vb2 = new VBox();
        Button browseMaps = new Button("Browse Maps");
        Button browseInventory = new Button("Browse Inventory");
        vb2.getChildren().addAll(browseMaps, browseInventory);
        vb2.setAlignment(Pos.CENTER);
        vb2.setSpacing(75);

        HBox upper = new HBox();
        upper.getChildren().addAll(vb1, vb2);
        upper.setAlignment(Pos.CENTER);
        upper.setSpacing(75);

        HBox lower = new HBox();
        Button settings = new Button("Settings");
        lower.getChildren().add(settings);
        lower.setAlignment(Pos.CENTER);
        lower.setSpacing(75);

        HBox statsBox = new HBox();
        Label stats = new Label("# items found || games played || lives lost || monsters slain || gold earned");
        statsBox.getChildren().add(stats);
        statsBox.setAlignment(Pos.CENTER);
        statsBox.setSpacing(75);

        VBox total = new VBox();
        total.getChildren().addAll(upper, lower, statsBox);
        total.setStyle("-fx-background-color: black;");
        total.setSpacing(75);

        return total;
    }
}