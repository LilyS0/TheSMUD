package smud.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class creates the Welcome screen, which is the first thing the user sees when they launch the game.
 * The user has the option to sign in and play a game, or if they do not want to sign in they can still view the maps.
 *
 * @author Sydney Wilson
 */
public class Welcome {
    private Stage stage;
    public PostLogin postLogin;
    public Welcome(Stage primary) {
        this.stage = primary;
        create(stage);
    }

    public static BorderPane create(Stage primary) {
        // center borderpane
        // game title
        Label title = new Label("SMUD craft");
        title.setFont(new Font(75));
        title.setTextFill(Color.CHARTREUSE);
        BorderPane general = new BorderPane();
        general.setStyle("-fx-background-color: black;");
        general.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        // left borderpane
        // login title
        Label loginTitle = new Label("Login: ");
        loginTitle.setFont(new Font(30));
        loginTitle.setTextFill(Color.CHARTREUSE);
        // credentials go here
        TextField usernameInput = new TextField("USERNAME");
        TextField pwInput = new TextField("PASSWORD");
        // will be tied to authenticate/login functions
        Button enterCredentials = new Button("Login");
        enterCredentials.setOnAction(e -> {
            primary.setScene(new Scene(PostLogin.create(), 400, 300));
        });
        // all are placed in vbox => places in left div of borderpane
        VBox leftBox = new VBox();
        leftBox.getChildren().addAll(loginTitle, usernameInput, pwInput, enterCredentials);
        general.setLeft(leftBox);
        BorderPane.setAlignment(leftBox, Pos.CENTER_LEFT);

        //right borderpane
        // view maps if not logged in button
        Button viewMaps = new Button("View Maps");
        general.setRight(viewMaps);
        BorderPane.setAlignment(viewMaps, Pos.CENTER_RIGHT);

        //bottom borderpane
        // settings? => SW ELABORATE ON THIS

        // center borderpane
        // shit attempt at ascii art lets go
        Label asciiRender = new Label(" ________________________________________\n" +
                "/        Welcome to SMUD Craft!      \\\n" +
                "|                                        |\n" +
                "|    ______                  ________    |\n" +
                "|   /      \\                /      \\   |\n" +
                "|  |   /\\  |    /\\  /\\       /\\  |   |\n" +
                "|  |  /  \\ |   /  \\/  \\  |  /  \\ |   |\n" +
                "|  | /____\\|  /________\\  | /____\\|   |\n" +
                "|  |________|               |________|   |\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "\\________________________________________/\n");
        asciiRender.setFont(new Font(50));
        asciiRender.setTextFill(Color.CORNFLOWERBLUE);
        general.setCenter(asciiRender);
        BorderPane.setAlignment(asciiRender, Pos.CENTER);
        return general;
    }

}
