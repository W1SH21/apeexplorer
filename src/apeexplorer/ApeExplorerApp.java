package apeexplorer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

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
     */
    public void start(Stage stage) {
        parentStage = stage; // reference to main stage
        VBox view = new VBox();
        // creates the menu
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        menuBar.getMenus().add(file);
        file.getItems().add(exit);
        exit.setOnAction(e -> System.exit(0));
        // adds nodes to VBox
        view.getChildren().add(menuBar);
        Scene scene = new Scene(view, 500, 475);
        // sets stage preferences
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        stage.setTitle("GalleryApp!");
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
