package sample;
        import javafx.application.*;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.scene.*;
        import javafx.scene.control.*;
        import javafx.stage.*;
        import javafx.scene.layout.*;
        import javafx.geometry.*;
        import javafx.event.*;

public class GetGearState {
private int weight = 100;
private int count = 0;
private int lastItemWeight;
private int lastShieldWeight;
private Weapon[] weapon = new Weapon[4];
private Shield[] shield = new Shield[3];
    public void setgear(Player[] player, Stage myStage)
    {
        GridPane root = new GridPane();
        root.setPadding( new Insets( 0 ) );
        root.setAlignment( Pos.TOP_CENTER);

        Label thisPlayer = new Label("<" + player[count].getName() + " het gewicht wat je nog kan dragen: " + weight + ">");
        Label thisPlayerStats = new Label( "jouw stats"+ ": kracht: " + player[count].getAttack() + " defence: " + player[count].getDefence());
        Label weaponsdisplay = new Label("speer  kracht: 70. gewicht: 60\n" + "zwaard  kracht: 60. gewicht: 50\n" + "dagger  kracht: 50. gewicht: 30\n" + "bijl  kracht: 40. gewicht: 20\n" );
        Label schildsdisplay = new Label("kleinschild  defence: 5. gewicht: 10\n" + "middelschild  defence: 10. gewicht: 15\n" + "grootschild  defence: 15. gewicht: 20\n");
        root.setHalignment(thisPlayer, HPos.CENTER);
        root.setHalignment(thisPlayerStats, HPos.CENTER);
        root.setHalignment(weaponsdisplay, HPos.CENTER);
        root.setHalignment(schildsdisplay, HPos.CENTER);
        thisPlayer.setId("playername");

        ObservableList<String> options = FXCollections.observableArrayList("speer", "zwaard", "dagger", "bijl");
        final ComboBox comboBox = new ComboBox(options);

        ObservableList<String> options1 = FXCollections.observableArrayList("kleinschild", "middelschild", "grootschild");
        final ComboBox comboBox1 = new ComboBox(options1);


        comboBox.setOnAction(e ->{
            switch (comboBox.getValue().toString())
            {
                case "speer" :
                    weapon[0] = new Weapon(70, 50);
                    weapon[0].setName("speer");
                    weapon[0].setDurabillity(90);
                    weapon[0].setWeight(60);
                    player[count].setWeapon(weapon[0]);
                    getWeaponWeight(thisPlayer,weapon[0], player[count]);
                    comboBox1.setVisible(false);

                    break;
                case "zwaard" :
                    weapon[1] = new Weapon(60, 70);
                    weapon[1].setName("zwaard");
                    weapon[1].setDurabillity(80);
                    weapon[1].setWeight(50);
                    player[count].setWeapon(weapon[1]);
                    getWeaponWeight(thisPlayer, weapon[1], player[count]);
                    comboBox1.setVisible(true);
                    break;
                case "dagger" :
                    weapon[2] = new Weapon(50, 80);
                    weapon[2].setName("dagger");
                    weapon[2].setDurabillity(70);
                    weapon[2].setWeight(30);
                    player[count].setWeapon(weapon[2]);
                    getWeaponWeight(thisPlayer, weapon[2], player[count]);
                    comboBox1.setVisible(true);
                    break;
                case "bijl" :
                    weapon[3] = new Weapon(40, 90);
                    weapon[3].setName("bijl");
                    weapon[3].setDurabillity(70);
                    weapon[3].setWeight(20);
                    player[count].setWeapon(weapon[2]);
                    getWeaponWeight(thisPlayer, weapon[3], player[count]);
                    comboBox1.setVisible(true);
                    break;
            }


        });



        comboBox1.setOnAction(e ->{
            switch (comboBox1.getValue().toString())
            {
                case "kleinschild":
                    shield[0] = new Shield(5);
                    shield[0].setDurabillity(100);
                    shield[0].setWeight(10);
                    player[count].setShield(shield[0]);
                    getShieldnWeight(thisPlayer, shield[0], player[count]);
                    break;
                case "middelschild":
                    shield[1] = new Shield(10);
                    shield[1].setDurabillity(100);
                    shield[1].setWeight(15);
                    player[count].setShield(shield[1]);
                    getShieldnWeight(thisPlayer, shield[1], player[count]);
                    break;
                case "grootschild":
                    shield[2] = new Shield(15);
                    shield[2].setDurabillity(100);
                    shield[2].setWeight(20);
                    player[count].setShield(shield[2]);
                    getShieldnWeight(thisPlayer, shield[2], player[count]);
                    break;

            }


        });










        root.setHalignment(comboBox1, HPos.CENTER);
        root.setHalignment(comboBox, HPos.CENTER);

        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/style.css");
        root.setId("achtergrond");
        thisPlayerStats.setId("stats");
        root.add(schildsdisplay, 0,7);
        root.add(comboBox1, 0, 8);
        root.add(thisPlayerStats, 0, 2);
        root.add(weaponsdisplay, 0,4);
        root.add(thisPlayer, 0 ,1);
        root.add(comboBox, 0 ,6);







        myStage.setScene(scene);





    }

    private void getShieldnWeight(Label thislabel, Item item, Player player)
    {
        weight += lastShieldWeight;
        lastShieldWeight = item.getWeight();
        weight = weight - item.getWeight();

        thislabel.setText("<" + player.getName() + " het gewicht wat je nog kan dragen: " + weight + ">");

    }
    private void getWeaponWeight(Label thislabel, Item item, Player player)
    {
        if(item.getName().equals("speer"))
        {
            weight += lastShieldWeight;
        }
        weight += lastItemWeight;
        lastItemWeight = item.getWeight();
        weight = weight - item.getWeight();

        thislabel.setText("<" + player.getName() + " het gewicht wat je nog kan dragen: " + weight + ">");

    }

}
