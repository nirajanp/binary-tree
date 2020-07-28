/*
 * Student: Nirajan Pandey
 * Instructor: Vic Berry
 * Due Date: Dec 9th 2019 @ 6:00 PM
 *
 * This class provides getters and setters method for
 * private variables data, left child, right child,
 * and count of a tree.
 */
public class Node {
    private String data;
    private Node lChild;
    private Node rChild;
    private int count;

    //Constructor initializes count to 1.
    public Node () {
        this.count = 1;
        this.data = null;
        this.lChild = null;
        this.rChild = null;
    }

    public void increseCount () {
        this.count++;
    }
    public int getCount() {
        return count;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public Node getlChild() {
        return lChild;
    }
    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }
    public Node getrChild() {
        return rChild;
    }
    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }
}
