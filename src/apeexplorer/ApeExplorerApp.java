package apeexplorer;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;



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
        BinaryApeTree mainTree = new BinaryApeTree();
        ApePane mainPane = new ApePane(mainTree.getHead());
      
        Scene scene = new Scene(mainPane, 925, 672);
        // sets stage preferences
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        stage.setTitle("APE EXPLORER");
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
