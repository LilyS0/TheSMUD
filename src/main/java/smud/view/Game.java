package smud.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Game {
    // left box: game text
    // right box: split - top is current inventory, bottom is map (add to when done)

    // left box:
    // after each text line a new line (\n) will need to be started so it does like the star wars opening credits rolly thingy
    public static HBox create() {
        Label gameText = new Label("You have entered the SMUD");
        gameText.setFont(new Font(20));
        gameText.setTextFill(Color.VIOLET);

        // replace fake map w real one, obvi
        Label fakeMap = new Label("""
                ____________________
                |    |    |    |    |
                ____________________
                |    |    |    |    |
                ____________________
                |    |    |    |    |
                ____________________
                |    |    |    |    |
                ____________________
                |    |    |    |    |
                ____________________
                |    |    |    |    |
                ____________________""");
        fakeMap.setFont(new Font(20));
        fakeMap.setTextFill(Color.PAPAYAWHIP);

        // view inventory will go to the BrowseInventory page
        Button viewIntentory = new Button("View Inventory");

        VBox rhs = new VBox();
        rhs.getChildren().addAll(viewIntentory, fakeMap);
        rhs.setAlignment(Pos.CENTER_RIGHT);

        HBox total = new HBox();
        total.getChildren().addAll(gameText, rhs);
        total.setStyle("-fx-background-color: black;");

        return total;
    }
}
