package apeexplorer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;


public class ApeExplorerApp extends Application {

    static Stage parentStage;

    /**
     * Start method for the {@code OmegaApp}.
     *  
     * @param stage The primary {@code Stage} object of the application
     * @throws IOException
     */
    public void start(Stage stage) throws IOException {
        parentStage = stage; // reference to main stage
        /*
        VBox mainBox = new VBox();
        // creates the menu
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu view = new Menu("View");
        MenuItem exit = new MenuItem("Exit");
        MenuItem bigPicture = new MenuItem("Big Picture");
        menuBar.getMenus().add(file);
        menuBar.getMenus().add(view);
        view.getItems().add(bigPicture);
        file.getItems().add(exit);
        exit.setOnAction(e -> System.exit(0));
        // adds nodes to VBox
        mainBox.getChildren().add(menuBar);
        Scene scene = new Scene(mainBox, 925, 672);
        // sets stage preferences
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        */
       
        stage.setTitle("APE EXPLORER");
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("APEFXML.fxml")));
        stage.setTitle("APE EXPLORER");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    } // start

    /**
     * A method that returns a reference to the 
     * application's parent stage.
     *
     * @return Stage The parent stage. 
     */
    public static Stage getParent() {
        return parentStage;
    } // getParent
    
} // ApeExplorerApp
