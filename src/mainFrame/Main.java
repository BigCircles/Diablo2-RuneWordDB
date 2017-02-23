package mainFrame;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {
    //Layout Stuff
    private MainFrame rootFrame;
    private Scene rootScene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        init();


        primaryStage.setTitle("POD D2DB");
        primaryStage.setScene(rootScene);
        rootScene.getStylesheets().add(Main.class.getResource("stylesheet.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

   public void init()
   {
    rootFrame = new MainFrame();
    rootScene = new Scene(rootFrame);

   }


    public static void main(String[] args) {


        launch(args);
    }
}
