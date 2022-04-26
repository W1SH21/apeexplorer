package apeexplorer;

import java.io.File;

public class BinaryApeTree {
    public ApeNode head;
    public ApeNode current;
    File loadFile;

    public BinaryApeTree() {
        loadFile = new File("phylogeny.monke");
        head = new ApeNode();
    } //BinaryApeTree

} //BinaryApeTree
