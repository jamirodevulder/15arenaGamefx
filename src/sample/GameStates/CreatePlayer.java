package sample.GameStates;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Player.Player;

import java.util.Random;

public class CreatePlayer {
        private int count = 0;
    public Scene createScene(Stage myStage){

        Random ran = new Random();
        myStage.setTitle("15 player arena game");

        GridPane rootNode= new GridPane();
        rootNode.setPadding( new Insets( 15 ) );
        rootNode.setHgap( 5 );
        rootNode.setVgap( 5 );
        rootNode.setAlignment( Pos.CENTER );

        Scene myScene = new Scene(rootNode, 700, 700 );
        myScene.getStylesheets().add("sample/css/style.css");
        rootNode.setId("achtergrond");

        TextField textfield = new TextField();
        rootNode.add(textfield, 0,1);
        Label question = new Label("met hoeveel spelers wil je spelen?");
        Label error = new Label("");
        rootNode.add(error, 0,8);
        rootNode.add(question, 0,0);
        Button aButton = new Button("Play"); rootNode.add(aButton, 0, 4);
        rootNode.setHalignment(aButton, HPos.CENTER);

        aButton.setOnAction(e ->{
         try {
             Integer players = Integer.valueOf(textfield.getText());
             if(players >= 2 && players <= 15)
             {
                 Player[] player = new Player[players];
                 Button setname = setnameplayer(player, question, aButton, textfield);
                 rootNode.getChildren().remove(aButton);
                 rootNode.add(setname, 0, 4);
                 rootNode.setHalignment(setname, HPos.CENTER);


                 setname.setOnAction(b ->{

                     if(count < player.length)
                     {
                         String name = textfield.getText().toString();
                         player[count] = new Player(name, ran.nextInt(10) + 10);
                         textfield.setText("");
                         count++;
                         question.setText("speler " + (count + 1) + " wat is je naam?");
                         if(count == player.length)
                         {
                             GetGearState state = new GetGearState();
                             state.setgear(player, myStage);
                         }
                     }


                 });


             }
             else {
                 error.setText("het moeten meer dan 1 speler zijn en minder dan 15");
             }
         }catch (NumberFormatException b) {
           error.setText("dit is geen cijfer");}



        });
        return myScene;
    }


    public Button setnameplayer(Player[] player, Label question, Button aButton, TextField textfield)
    {
        question.setText("speler 1 wat is je naam?");
        textfield.setText("");
        Button setname = new Button("gebruik naam");

        return setname;
    }
}
