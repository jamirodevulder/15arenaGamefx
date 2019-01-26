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

        Label thisPlayer = new Label("Player: "+ player[count].getName() + " Its your turn!");
        root.add(thisPlayer, 0,0);
        thisPlayer.setId("thisplayer");


        Button normalAttack = new Button("normale aanval");
        Button rest = new Button("rust");
        Button heavyAttack = new Button("zwaare aanval");



        normalAttack.setOnAction(event -> {
            for (int i = 0; i < player.length; i++)
            {
                if(i != count)
                {

                }
            }
                });

        rest.setOnAction(event -> {

        });


        heavyAttack.setOnAction(event -> {

        });




        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        myStage.setScene(scene);


    }

}
