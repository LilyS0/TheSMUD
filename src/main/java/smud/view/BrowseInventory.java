package smud.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BrowseInventory {
    // here's my thought process folks:
    // 1) list all possible items here
    // 2) when the user clicks on it itll give info about it + how many they have, if they dont have = 0 etc
    private Stage stage;
    public BrowseInventory(Stage primary) {
        this.stage = primary;
        create(stage);
    }
    public static HBox create(Stage primary) {
        Label armor = new Label("Armor");
        armor.setFont(new Font(12));
        armor.setTextFill(Color.CHARTREUSE);
        Button chainMail = new Button("Chainmail");
        chainMail.setOnAction(e -> {
            Label chainMailDescription = new Label();
            chainMailDescription.setText("Classic chainmail armor.");
            // ADD THE QUANTITY HERE
            formatter(chainMailDescription);
            primary.setScene(new Scene(chainMailDescription));
        });
        Button iron = new Button("Iron");
        iron.setOnAction(e -> {
            Label ironDescription = new Label();
            ironDescription.setText("Classic iron armor.");
            // ADD THE QUANTITY HERE
            formatter(ironDescription);
            primary.setScene(new Scene(ironDescription));
        });
        Button leather = new Button("Leather");
        leather.setOnAction(e -> {
            Label leatherDescription = new Label();
            leatherDescription.setText("Classic leather armor.");
            // ADD THE QUANTITY HERE
            formatter(leatherDescription);
            primary.setScene(new Scene(leatherDescription));
        });
        HBox armorButtons = new HBox();
        armorButtons.getChildren().addAll(chainMail, iron, leather);
        VBox armorSubsection = new VBox();
        armorSubsection.getChildren().addAll(armor, armorButtons);

        Label buffs = new Label("Buffs");
        buffs.setFont(new Font(12));
        buffs.setTextFill(Color.CHARTREUSE);
        Button regen = new Button("Regen");
        regen.setOnAction(e -> {
            Label regenDescription = new Label();
            regenDescription.setText("Regeneration! Woohoo!");
            formatter(regenDescription);
            primary.setScene(new Scene(regenDescription));
        });
        Button resistance = new Button("Resistance");
        resistance.setOnAction(e -> {
            Label resistanceDescription = new Label();
            resistanceDescription.setText("Resisting the urge to lose my marbles rn.");
            formatter(resistanceDescription);
            primary.setScene(new Scene(resistanceDescription));
        });
        Button strength = new Button("Strength");
        strength.setOnAction(e -> {
            Label strengthDescription = new Label();
            strengthDescription.setText("Hulk Smash.");
            formatter(strengthDescription);
            primary.setScene(new Scene(strengthDescription));
        });
        HBox buffsButtons = new HBox();
        buffsButtons.getChildren().addAll(regen, resistance, strength);
        VBox buffsSubsection = new VBox();
        buffsSubsection.getChildren().addAll(buffs, buffsButtons);

        Label food = new Label("Food");
        food.setFont(new Font(12));
        food.setTextFill(Color.CHARTREUSE);
        Button apple = new Button("Apple");
        apple.setOnAction(e -> {
            Label appleDescription = new Label();
            appleDescription.setText("Fruity.");
            formatter(appleDescription);
            primary.setScene(new Scene(appleDescription));
        });
        Button bread = new Button("Bread");
        bread.setOnAction(e -> {
            Label breadDescription = new Label();
            breadDescription.setText("mmm bread");
            formatter(breadDescription);
            primary.setScene(new Scene(breadDescription));
        });
        Button steak = new Button("Steak");
        steak.setOnAction(e -> {
            Label steakDescription = new Label();
            steakDescription.setText("Meat");
            formatter(steakDescription);
            primary.setScene(new Scene(steakDescription));
        });
        HBox foodButtons = new HBox();
        foodButtons.getChildren().addAll(apple, bread, steak);
        VBox foodSubsection = new VBox();
        foodSubsection.getChildren().addAll(food, foodButtons);

        Label weapons = new Label("Weapons");
        weapons.setFont(new Font(12));
        weapons.setTextFill(Color.CHARTREUSE);
        Button axe = new Button("Axe");
        axe.setOnAction(e -> {
            Label axeDescription = new Label();
            axeDescription.setText("Fun Fact: Throwing axes is a hobby for some people.");
            formatter(axeDescription);
            primary.setScene(new Scene(axeDescription));
        });
        Button bow = new Button("Bow");
        bow.setOnAction(e -> {
            Label bowDescription = new Label();
            bowDescription.setText("It's giving Katniss Everdeen.");
            formatter(bowDescription);
            primary.setScene(new Scene(bowDescription));
        });
        Button sword = new Button("Sword");
        sword.setOnAction(e -> {
            Label swordDescription = new Label();
            swordDescription.setText("Unfortunately not a lightsaber :(");
            formatter(swordDescription);
            primary.setScene(new Scene(swordDescription));
        });
        HBox weaponsButtons = new HBox();
        weaponsButtons.getChildren().addAll(axe, bow, sword);
        VBox weaponsSubsection = new VBox();
        weaponsSubsection.getChildren().addAll(weapons, weaponsButtons);

        HBox general = new HBox();
        general.getChildren().addAll(armorSubsection, buffsSubsection, foodSubsection, weaponsSubsection);
        general.setSpacing(75);
        general.setStyle("-fx-background-color: black;");

        return general;
    }

    private static void formatter(Label l) {
        l.setFont(new Font(15));
        l.setTextFill(Color.CHARTREUSE);
        l.setStyle("-fx-background-color: black;");
    }
}
