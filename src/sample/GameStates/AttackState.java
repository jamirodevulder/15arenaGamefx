package sample.GameStates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import sample.Attacks.Attack;
import sample.Gear.Armor;
import sample.Gear.Item;
import sample.Gear.Shield;
import sample.Gear.Weapon;
import sample.Player.Player;

public class AttackState {
public int count = 0;
private int check = 0;
private String theattack;


    public AttackState(Player[] player, Stage myStage)
    {
        showOrder(player, myStage);

    }













    public void showOrder(Player[] player, Stage myStage)
    {
        GridPane root = new GridPane();
        root.setPadding( new Insets( 0 ) );
        root.setAlignment( Pos.TOP_CENTER);
        Label text1 = new Label("order");
        text1.setId("order");
        root.add(text1, 0,0);
        for (int i =0; i< player.length; i++)
        {
            Label[] order = new Label[player.length];
            order[i] = new Label( (i + 1) + ". " +player[i].getName());
            root.add(order[i], 0, (i + 1));
            order[i].setId("order");
        }
        Button doorgaan = new Button("doorgaan");
        root.setHalignment(doorgaan, HPos.CENTER);
        root.add(doorgaan, 0, player.length + 1);

        doorgaan.setOnAction(e ->{

            attack(player, myStage);


        });

        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        myStage.setScene(scene);

    }


    public void attack(Player[] player, Stage myStage)
    {
        GridPane root = new GridPane();
        root.setPadding( new Insets( 0 ) );
        root.setAlignment( Pos.TOP_CENTER);
        Label thisPlayer = new Label("Player: "+ player[count].getName() + " Its your turn!");
        Label thisPlayerHealt = new Label("jouw aantal levens zijn nog: " + player[count].getHealt());
        thisPlayer.setId("thisplayer");
        root.setHalignment(thisPlayerHealt, HPos.CENTER);
        root.add(thisPlayer, 0,0);
        root.add(thisPlayerHealt, 0,1);
        thisPlayer.setId("thisplayer");
        System.out.println(player[count].getWeapon().getStrength());


        Button normalAttack = new Button("normale aanval");
        Button rest = new Button("rust");
        Button heavyAttack = new Button("zwaare aanval");
        root.setHalignment(rest, HPos.CENTER);
        root.setHalignment(normalAttack, HPos.CENTER);
        root.setHalignment(heavyAttack, HPos.CENTER);
        root.add(normalAttack, 0 ,2);
        root.add(rest, 0 ,3);
        root.add(heavyAttack, 0 ,4);
        Label weapon = new Label();
        Label shield = new Label();
        Label armor = new Label();





        if(player[count].getWeapon() != null)
        {
            weapon.setText("Wapen: heel");
        }
        else
        {
            weapon.setText("Wapen: gebroken");
        }
        if(player[count].getArmor() != null)
        {
            armor.setText("Panzer: heel");
        }
        else
        {
            armor.setText("Panzer: gebroken");
        }
        if(player[count].getShield() == null)
        {
            if(check == 0) {
                shield.setText("Shield: niet gekozen");
                check ++;
            }
            else
            {
                shield.setText("Schild: gebroken");
            }
        }
        else
        {
            shield.setText("Schild: heel");
        }
        check++;

        root.add(weapon, 0,5);
        root.add(shield, 0,6);
        root.add(armor, 0,7);


        normalAttack.setOnAction(event -> {
            normalAttack(player, root, myStage);
            theattack = "normal";
            setinvis(normalAttack, rest,heavyAttack, weapon, shield, armor);



                });

        rest.setOnAction(event -> {
            setinvis(normalAttack, rest,heavyAttack, weapon, shield, armor);
            player[count].setRest(true);
            theattack = "rest";
            reset(player, myStage , player[count], 0);

        });


        heavyAttack.setOnAction(event -> {
            theattack = "heavy";
            player[count].setWaitfornextturn(true);
            normalAttack(player, root, myStage);
            setinvis(normalAttack, rest,heavyAttack, weapon, shield, armor);
        });




        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        myStage.setScene(scene);


    }

    public void setinvis(Button button1, Button button2, Button button3, Label label1, Label label2, Label label3)
    {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
    }

    public void normalAttack(Player[] player, GridPane root, Stage myStage)
    {

        ObservableList<String> options = FXCollections.observableArrayList();
        for (int i = 0; i < player.length; i++)
        {
            if(i != count)
            {
                if(!player[i].getDead()) {
                    Label[] players = new Label[player.length];


                    players[i] = new Label(player[i].getName() + " hp: " + player[i].getHealt());

                    root.add(players[i], 0, (i + 2));
                    root.setHalignment(players[i], HPos.CENTER);
                    options.add(player[i].getName());
                }

            }
        }
        Button hit = new Button("attack this player");
        final ComboBox comboBox = new ComboBox(options);

        root.add(comboBox, 0,98);
        root.add(hit, 0 ,99);
        root.setHalignment(comboBox, HPos.CENTER);
        root.setHalignment(hit, HPos.CENTER);

        hit.setOnAction(event -> {
            for(int i = 0; i < player.length; i++)
            {
                if(comboBox.getValue().toString().equals(player[i].getName()))
                {
                    int damage = 0;
                    if(theattack.equals("normal")) {
                        Attack nAttack = new Attack();
                        damage = nAttack.normalAttack(player[count], player[i], theattack);
                    }
                    if(theattack.equals("heavy"))
                    {
                        Attack nAttack = new Attack();
                        damage = nAttack.normalAttack(player[count], player[i], theattack);
                    }
                    System.out.println(player[i].getHealt());




                    reset(player,  myStage, player[i], damage);
                }
            }

        });



    }



    public void reset(Player[] player,  Stage myStage, Player enemy, int damage)
    {
        int deadamount = 0;
        GridPane root = new GridPane();
        root.setPadding( new Insets( 0 ) );
        root.setAlignment( Pos.TOP_CENTER);
            count++;
        if(count == player.length)
        {
            count = 0;
        }
        if(player[count].getWaitfornextturn())
        {
         player[count].setWaitfornextturn(false);
         count ++;
            if(count == player.length)
            {
                count = 0;
            }
        }

        if(enemy.getHealt() <= 0) {
            enemy.setDead(true);
        }


        while (player[count].getDead())
        {
            deadamount++;
            count++;
            if(count == player.length)
            {
                count = 0;
            }
        }
        int dead = deadamount;
        Label label = new Label();
        Button button = new Button("Doorgaan");
        if(!enemy.getDead() && damage != 0) {
             label = new Label(enemy.getName() + " verloor: " + damage + "hp. en heeft nu nog maar " + enemy.getHealt() +  " hp over");
        }
        else if (theattack.equals("rest"))
        {
            label = new Label("je besluit om uit te rusten");
            theattack = "";
        }
        else if (theattack.equals("heavy"))
        {
            label = new Label(enemy.getName() + " verloor: " + damage + "hp. en heeft nu nog maar " + enemy.getHealt() +  " hp over. nu moet je alleen een beurt wachten");
            theattack = "";
        }
        else if(damage == 0)
        {
            label = new Label("helaas je miste je aanval!");
        }
        else {
            label = new Label(enemy.getName() + " verloor: " + damage + " en heeft deze aanval niet overleefd");
        }


        root.add(label, 0,0);
        root.add(button, 0,1);
        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        myStage.setScene(scene);
        button.setOnAction(event -> {
        if(dead == player.length - 1)
        {
            System.out.println("you won");
        }
        else {
            attack(player, myStage);
        }
        });
    }

}
