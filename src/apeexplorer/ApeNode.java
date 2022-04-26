package apeexplorer;



public class ApeNode {
    String title;
    String body;
    ApeNode left;
    ApeNode right;
    ApeNode back;
    int groupID;

    public ApeNode(String title, String body, int groupID) {
        this.title = title;
        this.body = body;
        this.groupID = groupID;
    } //ApeNode

    public ApeNode getLeft() {
        return left;
    } //getLeft

    public ApeNode getRight() {
        return right;
    } //getRight

    public ApeNode getBack() {
        return back;
    } //back

    public String getTitle() {
        return title;
    } //getTitle

    public String getBody() {
        return body;
    } //getBody

    public int getGroupID() {
        return groupID;
    } //getPosition

    public void setBack(ApeNode back) {
        this.back = back;
    } //setBack

    public void setRight(ApeNode right) {
        this.right = right;
    } //setRight

    public void setLeft(ApeNode left) {
        this.left = left;
    } //setLeft

} //ApeNode
