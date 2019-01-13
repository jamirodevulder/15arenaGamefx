package sample;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;


public class Main extends Application
{

    public void start(Stage myStage)
    {

        CreatePlayer createplayer = new CreatePlayer();
        Scene myScene = createplayer.createScene(myStage);

        myStage.setScene(myScene);
        myStage.show();
    }



    public static void main( String [] args)
    {
        launch(args);
    }




}

