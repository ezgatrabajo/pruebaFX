package Core;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController {
    private HashMap<String, Parent> screenMap = new HashMap<>();

    public ScreenController() {
    }

    public void addScreen(String name, Parent pane){
        screenMap.put(name, pane);
    }

    public void removeScreen(String name){
        screenMap.remove(name);
    }

    public Parent getScreen(String name){
        return screenMap.get(name);
    }



}
