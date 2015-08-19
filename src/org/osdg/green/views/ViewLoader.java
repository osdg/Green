package org.osdg.green.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Created by plter on 8/19/15.
 */
public class ViewLoader {

    public static Parent loadView(String name){
        try {
            return FXMLLoader.load(ViewLoader.class.getResource(name));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't load view by name %s",name));
        }
    }
}
