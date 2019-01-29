package sample.GameStates;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import sample.Player.Player;

public class WinState {

    public WinState(Player[] player, Stage myStage)
    {
        GridPane root = new GridPane();
        root.setPadding( new Insets( 0 ) );
        root.setAlignment(Pos.CENTER);



        for(int i = 0; i < player.length; i++)
        {
            if(!player[i].getDead()) {
                Label  winPlayer = new Label(player[i].getName());
                Label winner = new Label("WINNAAR");
                winner.setId("winner");

               winPlayer.setId("playername");
               root.add(winPlayer, 0, 0);
               root.add(winner, 0,1);
            }
        }







        Scene scene = new Scene(root, 700,700);
        scene.getStylesheets().add("sample/css/style.css");
        root.setId("achtergrond");
        myStage.setScene(scene);

    }



}
