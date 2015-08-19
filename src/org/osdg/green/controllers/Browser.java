package org.osdg.green.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.osdg.green.tools.TextUtil;
import org.osdg.green.views.ViewLoader;

import java.net.URL;
import java.util.ResourceBundle;

public class Browser implements Initializable{

    public TextField tfUrlInputField;
    public WebView webView;

    public static void show(){
        Parent root = ViewLoader.loadView("Browser.fxml");
        Stage stage = new Stage();
        stage.setTitle("Green browser");
        stage.setScene(new Scene(root,1000,700));
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webView.getEngine().locationProperty().addListener((observable, oldValue, newValue) -> {
            tfUrlInputField.setText(newValue);
        });
    }


    public void btnGoClickedHandler(ActionEvent actionEvent) {
        gotoUrl();
    }

    private void gotoUrl(){
        String url = tfUrlInputField.getText();
        if (!TextUtil.isEmpty(url)){
            if (!url.startsWith("http://")){
                url = "http://"+url;
            }

            webView.getEngine().load(url);
        }
    }

    public void btnRefreshClickedHandler(ActionEvent actionEvent) {
        webView.getEngine().reload();
    }


    public void tfUrlInputFieldKeyPressedHandler(KeyEvent event) {
        if (event.getCode()== KeyCode.ENTER){
            gotoUrl();
        }
    }

    public void btnBackClickedHandler(ActionEvent actionEvent) {
        WebHistory history = webView.getEngine().getHistory();
        if (history.getCurrentIndex()>0) {
            history.go(-1);
        }
    }
}
