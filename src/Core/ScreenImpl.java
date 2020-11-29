package Core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenImpl {
    private static ScreenImpl screenImpl;
    private Parent root;
    private ScreenController screenController;

    private static Stage primaryStage;
    public static final String VG_SAMPLE = "sample";
    public static final String VG_MARCAS = "marcas";




    public  static ScreenImpl getInstance() {


        if (screenImpl==null) {

            screenImpl=new ScreenImpl();
        }
        return screenImpl;
    }
    public void setStage(Stage ps){
        this.primaryStage = ps;
    }
    public void loadStages(){
        try {
            screenController = new ScreenController();
            screenController.addScreen(VG_SAMPLE, FXMLLoader.load(getClass().getResource( "../sample/sample.fxml" )));
            screenController.addScreen(VG_MARCAS, FXMLLoader.load(getClass().getResource( "../view/Marca.fxml" )));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void switchScene(String titulo, String sceneStr){
        root = screenController.getScreen(sceneStr);
        Scene scene = new Scene(root, 400, 350);
        //primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);

        primaryStage.setTitle(titulo);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


}
