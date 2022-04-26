
import java.io.IOException;

import apeexplorer.ApeNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class ApePane extends Pane {
    
    public ApeNode head;
    public ApeNode current;
    public MenuItem exitButton;
    public MenuItem bigPicture;
    public MenuItem about;
    public Button backButton;
    public Button leftButton;
    public Button rightButton;
    public Button addInfo;
    public Label title;
    public Label body;

    public ApePane(ApeNode node) throws IOException {
        super();
        this.getChildren().add(FXMLLoader.load(getClass().getResource("APEFXML.fxml")));
        head = node;
        current = node;
        exitButton.setOnAction(e -> System.exit(0));
        bigPicture.setOnAction(this::showBigPicture);
        about.setOnAction(this::showAboutInfo);
        backButton.setOnAction(this::traverseBack);
        backButton.setVisible(false);
        leftButton.setOnAction(this::traverseLeft);
        rightButton.setOnAction(this::traverseRight);
        addInfo.setOnAction(this::showAddInfo);
        
        backButton.setVisible(false);
        leftButton.setText(node.getLeft().getTitle());
        rightButton.setText(node.getRight().getTitle());
        title.setText(node.getTitle());
        body.setText(node.getBody());
    } //ApePane



    private void showBigPicture(ActionEvent e) {

    } //displayAddInfo

    private void showAboutInfo(ActionEvent e) {

    } //showAboutInfo

    private void traverseBack(ActionEvent e) {
        if (current.getBack() != null) {
            current = current.getBack();
            if (current.getBack() != null) {
                backButton.setText(current.getBack().getTitle());
                backButton.setDisable(false);
            } else {backButton.setDisable(true); } //if
            if (current.getLeft() != null) {
            leftButton.setText(current.getLeft().getTitle());
            leftButton.setDisable(false);
            } else { leftButton.setDisable(true); } //if
            if (current.getRight() != null) {
            rightButton.setText(current.getRight().getTitle());
            rightButton.setDisable(false);
            } else {rightButton.setDisable(true); }
            title.setText(current.getTitle());
            body.setText(current.getBody());
        } //if
    } //traverseBack

    private void traverseLeft(ActionEvent e) {
        if (current.getLeft() != null) {
            current = current.getLeft();
            if (current.getLeft() != null) { 
                leftButton.setText(current.getLeft().getTitle());
                leftButton.setDisable(false);
            } else { leftButton.setDisable(true); }
            if (current.getRight() != null) {
                rightButton.setText(current.getRight().getTitle());
                rightButton.setDisable(false);
            } else { rightButton.setDisable(true); }
            backButton.setText(current.getBack().getTitle());
            backButton.setDisable(false);
        } //if
    } //traverseLeft

    private void traverseRight(ActionEvent e) {
        if (current.getRight() != null) {
            current = current.getRight();
            if (current.getLeft() != null) {
                leftButton.setText(current.getLeft().getTitle());
                rightButton.setDisable(false);
            } else { leftButton.setDisable(true); }
            if (current.getRight() != null) {
                rightButton.setText(current.getRight().getTitle());
                rightButton.setDisable(false);
            } else {rightButton.setDisable(true);}
            backButton.setText(current.getBack().getTitle());
            backButton.setDisable(false);
        } //if
    } //traverseRight

    private void jumpToHead(ActionEvent e) {
        current = head;
        backButton.setText(null);
        backButton.setDisable(true);
        leftButton.setText(current.getLeft().getTitle());
        rightButton.setText(current.getRight().getTitle());
        title.setText(current.getTitle());
        body.setText(current.getBody());
        leftButton.setDisable(false);
        rightButton.setDisable(false);
    } //jumpToHead

    private void showAddInfo(ActionEvent e) {

    } //showAddInfo
} //ApePane
