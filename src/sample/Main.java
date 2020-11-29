package sample;

import Core.ScreenImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;
    private Scene scene;
    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Scene scene = new Scene(root, 300, 275);
        //primaryStage.setTitle("HRApiRest");
        //primaryStage.setScene(scene);
        //primaryStage.show();
        ScreenImpl.getInstance().setStage(primaryStage);
        ScreenImpl.getInstance().loadStages();
        ScreenImpl.getInstance().switchScene("Principal","sample");

    }


    public static void main(String[] args) {
        launch(args);
    }


}
