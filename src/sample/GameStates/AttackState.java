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
        root.add(thisPlayer, 0,0);
        thisPlayer.setId("thisplayer");
        System.out.println(player[count].getWeapon().getStrength());


        Button normalAttack = new Button("normale aanval");
        Button rest = new Button("rust");
        Button heavyAttack = new Button("zwaare aanval");
        root.setHalignment(rest, HPos.CENTER);
        root.setHalignment(normalAttack, HPos.CENTER);
        root.setHalignment(heavyAttack, HPos.CENTER);
        root.add(normalAttack, 0 ,1);
        root.add(rest, 0 ,2);
        root.add(heavyAttack, 0 ,3);



        normalAttack.setOnAction(event -> {
            normalAttack(player, root, myStage);
            setinvis(normalAttack, rest,heavyAttack);



                });

        rest.setOnAction(event -> {
            setinvis(normalAttack, rest,heavyAttack);
        });


        heavyAttack.setOnAction(event -> {
            setinvis(normalAttack, rest,heavyAttack);
        });




        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        myStage.setScene(scene);


    }

    public void setinvis(Button button1, Button button2, Button button3)
    {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
    }

    public void normalAttack(Player[] player, GridPane root, Stage myStage)
    {

        ObservableList<String> options = FXCollections.observableArrayList();
        for (int i = 0; i < player.length; i++)
        {
            if(i != count)
            {

                Label[] players = new Label[player.length];


                players[i] = new Label(player[i].getName() + " hp: " + player[i].getHealt());

                root.add(players[i], 0,(i + 1));
                root.setHalignment(players[i], HPos.CENTER);
                options.add(player[i].getName());

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
                    Attack nAttack = new Attack();
                    nAttack.normalAttack(player[count], player[i]);
                    System.out.println(player[i].getHealt());

                    reset(player, root, myStage, player[i]);
                }
            }

        });



    }



    public void reset(Player[] player, GridPane root, Stage myStage, Player enemy)
    {
        int deadamount = 0;
        root.getChildren().removeAll();
        count++;
        if(enemy.getHealt() <= 0) {
            enemy.setDead(true);
        }
        if(count == player.length)
        {
            count = 0;
        }
        while (player[count].getDead())
        {
            deadamount++;
            count++;
        }
        if(deadamount == player.length - 1)
        {
            System.out.println("you won");
        }
        else {
            attack(player, myStage);
        }
    }
}
