package apeexplorer;

public class ApeNode {
    String title;
    String body;
    String leftButtonText;
    String rightButtonText;
    String backButtonText;
    ApeNode left;
    ApeNode right;
    ApeNode back;

    public ApeNode(String title, String body, String leftButtonText, String rightButtonText, String backButtonText, ApeNode left, ApeNode right, ApeNode back) {
        this.title = title;
        this.body = body;
        this.leftButtonText = leftButtonText;
        this.rightButtonText = rightButtonText;
        this.backButtonText = backButtonText;
        this.left = left;
        this.right = right;
        this.back = back;
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

    public String getLeftButtonText() {
        return leftButtonText;
    } //getLeftButtonText

    public String getRightButtonText() {
        return rightButtonText;
    } //getRightButtonText

    public String getBackButtonText() {
        return backButtonText;
    } //getBackButtonText
    
} //ApeNode
