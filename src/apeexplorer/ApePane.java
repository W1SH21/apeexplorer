package apeexplorer;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class ApePane extends Pane {
    
    public ApeNode head;
    public ApeNode current;
    public MenuItem exitButton;
    public MenuItem bigPicture;
    public MenuItem about;
    public MenuButton leftMenu;
    public MenuButton rightMenu;
    public Button backButton;
    public Button leftButton;
    public Button rightButton;
    public Button addInfo;
    public Label title;
    public Label body;


    public ApePane (ApeNode node) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("APEFXML.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } //try
        head = node;
        current = node;
        exitButton.setOnAction(e -> System.exit(0));
        bigPicture.setOnAction(this::showBigPicture);
        about.setOnAction(this::showAboutInfo);
        backButton.setOnAction(this::traverseBack);
        backButton.setDisable(true);
        leftButton.setOnAction(this::traverseLeft);
        rightButton.setOnAction(this::traverseRight);

        if (current.getLeft() != null) {
            leftButton = new Button(current.getLeft().getTitle());
        } //if
        if (current.getRight() != null) {
            rightButton = new Button(current.getRight().getTitle());
        } //if
        addInfo.setOnAction(this::showAddInfo);
        addInfo.setDisable(true);
        backButton.setDisable(true);
        title.setText(node.getTitle());
        body.setText(node.getBody());
    } //ApePane



    private void showBigPicture(ActionEvent e) {

    } //displayAddInfo

    private void showAboutInfo(ActionEvent e) {

    } //showAboutInfo
    
    private void showAddInfo(ActionEvent e) {

    } //showAddInfo




    private void traverseBack(ActionEvent e) {
        if (current.getBack() != null) {
            current = current.getLeft();
            if (current.getLeft() != null) { 
                leftButton.setText(current.getLeft().getTitle());
                leftButton.setDisable(false);
            } else { leftButton.setDisable(true); }
            if (current.getRight() != null) {
                rightButton.setText(current.getRight().getTitle());
                rightButton.setDisable(false);
            } else { rightButton.setDisable(true); }
            if (current.getBack() != null) {
                backButton.setText(current.getBack().getTitle());
                backButton.setDisable(false);
            } else {backButton.setDisable(true); }
        } //if
    } //traverseLeft
    
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
        if (current.getLeft() != null) {
            leftButton.setText(current.getLeft().getTitle());
            leftButton.setDisable(false);
        } else {leftButton.setDisable(true); }
        if (current.getRight() != null) {
            rightButton.setText(current.getRight().getTitle());
            rightButton.setDisable(false);
        } else {rightButton.setDisable(true); }
        title.setText(current.getTitle());
        body.setText(current.getBody());
    } //jumpToHead

} //ApePane