package apeexplorer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryApeTree {
    public ApeNode head;
    public ApeNode current;
    File loadFile;

    public BinaryApeTree() throws FileNotFoundException {
        loadFile = new File("phylogeny.monke");
        Scanner file = new Scanner(loadFile);
        ApeNode newNode;
        String temp = "";
        String title = "";
        String body = "";
        int GID = 0;
        if (file.hasNext()) {
            temp = file.next();
        } else {
            monkeMarkupError("Empty .monke file!");
        } //if

        while (file.hasNext()) {
            if (temp.equals("<chunk>")) {
                if (file.hasNext()) {
                    temp = file.next();
                } else {
                    monkeMarkupError("Missing closing flag for <chunk>");
                } //if
                if (temp.equals("KEY:")) {
                    GID = file.nextInt();
                } //if
                while(!temp.equals("</chunk>")) {
                    if (file.hasNext()) {
                        temp = file.next();
                        if (temp.equals("<monke>")) {
                            while (!temp.equals("</monke>")) {
                                if (file.hasNext()) {
                                    temp = file.next();
                                    if (temp.equals("<name>")) {
                                        while (!temp.equals("</name>")) {
                                            if (file.hasNext()) {
                                                temp = file.next();
                                                title += temp;
                                            } else {
                                                monkeMarkupError("Missing closing flag for <name>.");
                                            } //if
                                        } //while
                                        if(temp.equals("<body>")) {
                                            while (!temp.equals("</body>")) {
                                                if (file.hasNext()) {
                                                    temp = file.next();
                                                    body += temp;
                                                } else {
                                                    monkeMarkupError("Missing closing flag for <body>.");
                                                } //if
                                            } //while
                                        } //if <body>
                                    } //if <name>
                                } else {
                                    monkeMarkupError("Missing closing flag for <monke>.");
                                } //if
                            } //while
                        } //if <monke>
                    } else {
                        monkeMarkupError("Missing closing flag for <chunk> tag");
                    } //if
                } //while
            } //if <chunk>
            newNode = new ApeNode(title, body, GID);
        insert(newNode);
    } //while
    file.close();
} //BinaryApeTree



    private void insertRecurse(ApeNode tree, ApeNode n, int ID) {
        if (ID == 0) {
            head = n;
        } else if (tree.getLeft() == null && (ID < tree.getGroupID())) {
            tree.setLeft(n);
            tree.getLeft().setBack(tree);
        } else if (tree.getRight() == null && (ID > tree.getGroupID())) {
            tree.setRight(n);
            tree.getRight().setBack(tree);
        }else if(ID < tree.getGroupID()) {
            insertRecurse(tree.getLeft(), n, ID);
        } else {
            insertRecurse(tree.getRight(), n, ID);
        } //if
    } //insertRecurse

    private void insert(ApeNode newNode) {
        int gid = newNode.getGroupID();
        insertRecurse(head, newNode, gid);
    } //insert

    public ApeNode getHead() {
        return head;
    } //getHead

    private static void monkeMarkupError(String msg) {
        System.err.print("MonkeMarkupException: " + msg);
        System.exit(0);
    } //monkeError

} //BinaryApeTree
