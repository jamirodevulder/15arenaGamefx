package sample.GameStates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import sample.Gear.Armor;
import sample.Gear.Item;
import sample.Gear.Shield;
import sample.Gear.Weapon;
import sample.Player.Player;

import java.util.Arrays;
import java.util.Collections;

public class GetGearState {
private int count = 0;
private Weapon[] weapon = new Weapon[4];
private Shield[] shield = new Shield[3];
private Armor[] armor = new Armor[3];
private Button nextplayer = new Button("next Player");
private Label errordisplay = new Label("je gear is te zwaar kies iets anders!");
    public void setgear(Player[] player, Stage myStage)
    {
        GridPane root = new GridPane();
        root.setPadding( new Insets( 0 ) );
        root.setAlignment( Pos.TOP_CENTER);

        Label thisPlayer = new Label("<" + player[count].getName() + " het gewicht wat je nog kan dragen: " + player[count].getMaxWeight() + ">");
        Label thisPlayerStats = new Label( "jouw stats"+ ": kracht: " + player[count].getAttack() + " defence: " + player[count].getDefence());
        Label weaponsdisplay = new Label("speer  kracht: 70. gewicht: 60\n" + "zwaard  kracht: 60. gewicht: 50\n" + "dagger  kracht: 50. gewicht: 30\n" + "bijl  kracht: 40. gewicht: 20\n" );
        Label schildsdisplay = new Label("kleinschild  defence: 5. gewicht: 10\n" + "middelschild  defence: 10. gewicht: 15\n" + "grootschild  defence: 15. gewicht: 20\n");
        Label armordisplay = new Label("leerenpanzer  defence: 15. gewicht: 20\n" + "ijzerpanzer defence: 30. gewicht: 40\n" + "grootschild  defence: 60. gewicht: 60\n");
        root.setHalignment(thisPlayer, HPos.CENTER);
        root.setHalignment(thisPlayerStats, HPos.CENTER);
        root.setHalignment(weaponsdisplay, HPos.CENTER);
        root.setHalignment(schildsdisplay, HPos.CENTER);
        root.setHalignment(armordisplay, HPos.CENTER);
        thisPlayer.setId("playername");

         root.setHalignment(nextplayer, HPos.RIGHT); root.add(nextplayer, 0, 12);
        root.setHalignment(errordisplay, HPos.RIGHT); root.add(errordisplay, 0, 12);


        errordisplay.setVisible(false);
        Label kiesplaceholder = new Label("kies");

        ObservableList<String> options = FXCollections.observableArrayList("speer", "zwaard", "dagger", "bijl", "kies");
        final ComboBox comboBox = new ComboBox(options);
        comboBox.setPlaceholder(kiesplaceholder);

        ObservableList<String> options1 = FXCollections.observableArrayList("kleinschild", "middelschild", "grootschild", "kies");
        final ComboBox comboBox1 = new ComboBox(options1);
        comboBox1.setPlaceholder(kiesplaceholder);

        ObservableList<String> options2 = FXCollections.observableArrayList("leerenpanzer", "ijzerpanzer", "goudenpanzer", "kies");
        final ComboBox comboBox2 = new ComboBox(options2);
        comboBox1.setPlaceholder(kiesplaceholder);


        comboBox.setOnAction(e ->{
            switch (comboBox.getValue().toString())
            {
                case "speer" :
                    weapon[0] = new Weapon(70, 50);
                    weapon[0].setName("speer");
                    weapon[0].setDurabillity(90);
                    weapon[0].setWeight(60);
                    weapon[0].setAccuracy(50);
                    weaponWeight(weapon[0], player[count]);
                    comboBox1.setVisible(false);

                    break;
                case "zwaard" :
                    weapon[1] = new Weapon(60, 70);
                    weapon[1].setName("zwaard");
                    weapon[1].setDurabillity(80);
                    weapon[1].setAccuracy(60);
                    weapon[1].setWeight(50);
                    weaponWeight(weapon[1], player[count]);
                    comboBox1.setVisible(true);
                    break;
                case "dagger" :
                    weapon[2] = new Weapon(50, 80);
                    weapon[2].setName("dagger");
                    weapon[2].setDurabillity(70);
                    weapon[2].setWeight(30);
                    weapon[2].setAccuracy(80);
                    weaponWeight(weapon[2], player[count]);

                    comboBox1.setVisible(true);
                    break;
                case "bijl" :
                    weapon[3] = new Weapon(40, 90);
                    weapon[3].setName("bijl");
                    weapon[3].setDurabillity(70);
                    weapon[3].setWeight(20);
                    weapon[3].setAccuracy(90);
                    comboBox1.setVisible(true);
                    weaponWeight(weapon[3], player[count]);
                    break;
                case "kies":
                    weaponweightback(player[count]);
                    comboBox1.setVisible(true);
                break;

            }

            changeWeightDisplay(thisPlayer, player[count]);
            checkweight(player[count]);
        });



        comboBox1.setOnAction(e ->{
            switch (comboBox1.getValue().toString())
            {
                case "kleinschild":
                    shield[0] = new Shield();
                    shield[0].setDefence(5);
                    shield[0].setDurabillity(100);
                    shield[0].setWeight(10);
                    shieldWeight(shield[0], player[count]);

                    break;
                case "middelschild":
                    shield[1] = new Shield();
                    shield[1].setDefence(10);
                    shield[1].setDurabillity(100);
                    shield[1].setWeight(15);
                    shieldWeight(shield[1], player[count]);
                    break;
                case "grootschild":
                    shield[2] = new Shield();
                    shield[2].setDefence(15);
                    shield[2].setDurabillity(100);
                    shield[2].setWeight(20);
                    shieldWeight(shield[2], player[count]);
                    break;
                case "kies":
                    shieldweightback(player[count]);
                    break;
            }

                changeWeightDisplay(thisPlayer, player[count]);
            checkweight(player[count]);
        });



        comboBox2.setOnAction(e ->{
            switch (comboBox2.getValue().toString())
            {
                case "leerenpanzer":
                    armor[0] = new Armor();
                    armor[0].setDurabillity(100);
                    armor[0].setName("leerenpanzer");
                    armor[0].setDefence(15);
                    armor[0].setWeight(20);
                    armorWeight(armor[0], player[count]);
                    break;
                case "ijzerpanzer":
                    armor[1] = new Armor();
                    armor[1].setDurabillity(100);
                    armor[1].setName("ijzerpanzer");
                    armor[1].setDefence(30);
                    armor[1].setWeight(40);
                    armorWeight(armor[1], player[count]);
                    break;
                case "goudenpanzer":
                    armor[2] = new Armor();
                    armor[2].setDurabillity(100);
                    armor[2].setName("ijzerpanzer");
                    armor[2].setDefence(45);
                    armor[2].setWeight(60);
                    armorWeight(armor[2], player[count]);
                    break;
                case "kies":
                    armorweightback(player[count]);
                    break;
            }

            changeWeightDisplay(thisPlayer, player[count]);
            checkweight(player[count]);
        });

        nextplayer.setOnAction(e ->{
           count++;
           if(count >= player.length )
            {
                order(player);
                AttackState play = new AttackState(player, myStage);
            }
           else {
               thisPlayer.setText("<" + player[count].getName() + " het gewicht wat je nog kan dragen: " + player[count].getMaxWeight() + ">");
               thisPlayerStats.setText("jouw stats" + ": kracht: " + player[count].getAttack() + " defence: " + player[count].getDefence());
               comboBox.setValue("");
               comboBox1.setValue("");
               comboBox2.setValue("");
               comboBox1.setVisible(true);
           }
        });





        root.setHalignment(comboBox2, HPos.CENTER);
        root.setHalignment(comboBox1, HPos.CENTER);
        root.setHalignment(comboBox, HPos.CENTER);

        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        thisPlayerStats.setId("stats");
        root.add(schildsdisplay, 0,7);
        root.add(comboBox1, 0, 8);
        root.add(armordisplay, 0, 9);
        root.add(comboBox2, 0, 10);
        root.add(thisPlayerStats, 0, 2);
        root.add(weaponsdisplay, 0,4);
        root.add(thisPlayer, 0 ,1);
        root.add(comboBox, 0 ,6);







        myStage.setScene(scene);





    }


    public static Player[] order(Player[] players)
    {
        Integer[] counts = new Integer[players.length];
        Player[] set = new Player[players.length];
        int counter = 0;

        Boolean check;
        for (int i = 0; i < players.length; i++)
        {
            counts[i] = players[i].getMaxWeight();
        }
        Arrays.sort(counts, Collections.reverseOrder());
        for (int i = 0; i < players.length; i++)
        {
            check = true;
            for (int j = counter; j < players.length; j++)
            {
                if(counts[i] == players[j].getMaxWeight() && check)
                {
                    // player 0 = 10 dus set j
                    set[j] = players[i];
                    players[i] = players[j];
                    players[j] = set[j];
                    check = false;
                    counter += 1;
                }
            }

        }
        return players;
    }




    public void armorweightback(Player player)
    {
        if(player.getArmor() != null)
        {
            player.setMaxWeight(player.getArmor().getWeight() + player.getMaxWeight());
            player.setArmor(null);
        }
    }

    public void shieldweightback(Player player)
    {
        if(player.getShield() != null)
        {
            player.setMaxWeight(player.getShield().getWeight() + player.getMaxWeight());
            player.setShield(null);
        }
    }

    public void weaponweightback(Player player)
    {
        if(player.getWeapon() != null)
        {
            player.setMaxWeight(player.getWeapon().getWeight() + player.getMaxWeight());
            player.setWeapon(null);
        }
    }

    public void armorWeight(Item item, Player player)
    {
        if(player.getArmor() != null)
        {
            player.setMaxWeight(player.getArmor().getWeight() + player.getMaxWeight());
        }
        player.setArmor(item);
        player.setMaxWeight(player.getMaxWeight() - item.getWeight());
    }

    public void shieldWeight(Item item, Player player)
    {
        if(player.getShield() != null)
        {
            player.setMaxWeight(player.getShield().getWeight() + player.getMaxWeight());
        }
        player.setShield(item);
        player.setMaxWeight(player.getMaxWeight() - item.getWeight());
    }

    public void weaponWeight(Item item, Player player)
    {
        if(player.getWeapon() != null)
        {
            player.setMaxWeight(player.getWeapon().getWeight() + player.getMaxWeight());
        }
        if(item.getWeight() >= 50)
        {
            if(player.getShield() != null) {
                player.setMaxWeight(player.getMaxWeight() + player.getShield().getWeight());
                player.setShield(null);
            }
        }
        player.setMaxWeight(player.getMaxWeight() - item.getWeight());
        player.setWeapon(item);
    }

    public void changeWeightDisplay(Label weightLabel, Player player)
    {
        weightLabel.setText("<" + player.getName() + " het gewicht wat je nog kan dragen: " + player.getMaxWeight() + ">");
    }


    public void checkweight(Player player)
    {
        if(player.getMaxWeight() < 0)
        {
            nextplayer.setVisible(false);
            errordisplay.setVisible(true);
        }
        else
        {
            errordisplay.setVisible(false);
            nextplayer.setVisible(true);
        }

    }

}
