package smud.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BrowseInventory {
    // here's my thought process folks:
    // 1) list all possible items here
    // 2) when the user clicks on it itll give info about it + how many they have, if they dont have = 0 etc
    public static HBox create() {
        Label armor = new Label("Armor");
        armor.setFont(new Font(12));
        armor.setTextFill(Color.CHARTREUSE);
        Button chainMail = new Button("Chainmail");
        Button iron = new Button("Iron");
        Button leather = new Button("Leather");
        HBox armorButtons = new HBox();
        armorButtons.getChildren().addAll(chainMail, iron, leather);
        VBox armorSubsection = new VBox();
        armorSubsection.getChildren().addAll(armor, armorButtons);

        Label buffs = new Label("Buffs");
        buffs.setFont(new Font(12));
        buffs.setTextFill(Color.CHARTREUSE);
        Button regen = new Button("Regen");
        Button resistance = new Button("Resistance");
        Button strength = new Button("Strength");
        HBox buffsButtons = new HBox();
        buffsButtons.getChildren().addAll(regen, resistance, strength);
        VBox buffsSubsection = new VBox();
        buffsSubsection.getChildren().addAll(buffs, buffsButtons);

        Label food = new Label("Food");
        food.setFont(new Font(12));
        food.setTextFill(Color.CHARTREUSE);
        Button apple = new Button("Apple");
        Button bread = new Button("Bread");
        Button steak = new Button("Steak");
        HBox foodButtons = new HBox();
        foodButtons.getChildren().addAll(apple, bread, steak);
        VBox foodSubsection = new VBox();
        foodSubsection.getChildren().addAll(food, foodButtons);

        Label weapons = new Label("Weapons");
        weapons.setFont(new Font(12));
        weapons.setTextFill(Color.CHARTREUSE);
        Button axe = new Button("Axe");
        Button bow = new Button("Bow");
        Button sword = new Button("Sword");
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
}
