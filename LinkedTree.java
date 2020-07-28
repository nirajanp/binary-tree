/*
 * Student: Nirajan Pandey
 * Instructor: Vic Berry
 * Due Date: Dec 9th 2019 @ 6:00 PM
 *
 * The following class uses Linked List to
 * perform operations in Binary Tree.
 *
 * It has methods such as add(), recurAdd(), preOrder()
 * postOrder(), inOrder(), rootWord(), maxDepth(), search()
 * distinctCount(), deepestNode().
 *
 */

public class LinkedTree {

    private Node root;
    private int count = 1;
    /**
     *  Input: None
     *  Output: boolean
     *  Parameter: String
     *
     *  Adds a data to a tree.
     */
    public boolean add(String data) {

        if (root == null) {
            Node newNode = new Node();
            newNode.setData(data);
            root = newNode;
           // System.out.println(root.getData());
        } else {
            return recurAdd(root, data);
        }
        return true;
    }


    /**
     *  Input: None
     *  Output: boolean
     *  Parameter: String
     *
     *  Adds a data to a tree.This is a recursive method,
     *  adds a data to a top, or left child, or right
     *  child lexicographically.
     */
    private boolean recurAdd(Node root, String data) {
        if (root == null) {
            return false;
        }
        // data is equal to root then it increases the count
        // and returns true.
        if (data.compareTo(root.getData()) == 0) {
            // Data already in tree;
            root.increseCount();
            return true;
        }

        // if data is lexicographically less than root
        // then it adds data to left child.
        if (data.compareTo(root.getData()) <=-1) {
            if (root.getlChild() == null) {
                Node newNode = new Node();
                newNode.setData(data);
                root.setlChild(newNode);

                return true;
            } else {
                // Recursion time!
                return recurAdd(root.getlChild(), data);
            }
        }
        else {
            // if data is lexicographically greater than root
            // then it adds data to right child.
                if (root.getrChild() == null) {
                Node newNode = new Node();
                newNode.setData(data);
                root.setrChild(newNode);
                return true;
            } else {
                //Recursion time!!!
                return recurAdd(root.getrChild(), data);
            }
        }
    }

    /**
     *  Input: None
     *  Output: None
     *  Parameter: None
     *
     *  Public method of pre-order traversal
     *  to access from Main class and pass
     *  argument to its private method..
     */
    public void preOrder() {
        count =0;
        preOrder(root);
    }

    /**
     *   Input: None
     *   Output: None
     *   Parameter: root of type Node
     *
     *   Private method of pre-order traversal
     *   which prints first 20 data.
     */
    private void preOrder(Node root) {
        if (count < 20) {
            if (root == null) {
                return;
            } else {
                count++;
                System.out.print(root.getData() + " ");
                preOrder(root.getlChild());
                preOrder(root.getrChild());
            }
        }
    }

    /**
     *   Input: None
     *   Output: None
     *   Parameter: None
     *
     *   Public method of in-order traversal
     *   to access from Main class and pass
     *   argument to its private method..
     */

    public void inOrder() {
        count = 0;
        inOrder(root);
    }
    /**
     *   Input: None
     *   Output: None
     *   Parameter: root of type Node
     *
     *   Private method of in-order traversal
     *   which prints first 20 data.
     */

    private void inOrder(Node root) {
        if (count < 20) {
            if (root == null) {
                return;
            } else {
                count++;
                inOrder(root.getlChild());
                System.out.print(root.getData() + " ");
                inOrder(root.getrChild());
            }
        }
    }

    /**
     *  Input: None
     *  Output: None
     *  Parameter: None
     *
     *  Public method of post-order traversal
     *  to access from Main class and pass
     *  argument to its private method..
     * */

    public void postOrder() {
        count = 0;
        postOrder(root);
    }

    /**
     *  Input: None
     *  Output: None
     *  Parameter: root of type Node
     *  Private method of post-order traversal
     *  which prints first 20 data.
     */

    private void postOrder(Node root) {
        if (count < 20) {
            if (root == null) {
                return;
            } else {
                count++;
                postOrder(root.getlChild());
                postOrder(root.getrChild());
                System.out.print(root.getData()+ " ");
            }
        }
    }

    /**
     *  Input: None
     *  Output: String
     *  Parameter: None
     *  This method returns the root word of the tree.
     * */

    public String rootWord() {
        if (root == null) {
            return "";
        }
        System.out.println(root.getData());
        return root.getData();
    }

    /**
     * Input: none
     * Output: int
     * parameter: none
     * This method returns deepest level of tree.
     * */
    public int maxDepth(){
        return maxDepth(root);
    }

    /**
     * Input: none
     * output: int
     * @param node
     * @return
     *
     * Returns the deepest level of tree.
     */
    private int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            // compute the depth of each subtree
            int lDepth = maxDepth(node.getlChild());
            int rDepth = maxDepth(node.getrChild());

            // use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    /**
     * Input: None
     * Output: None
     * Parameter: word
     *
     *  This method takes a parameter from
     *  Main class to search occurrences
     *  of word in text. This is made public.
     */
    public void search(String word) {
        search(root, word);
    }

    /**
     * Input: None
     * Output: None
     * Parameter: root, word
     *
     * Root is compared to word passed from
     * Main class to perform word occurrences.
     * This is made private.
     */
    private void search(Node root, String word) {
        if (root == null) {
            return;

        } else {
            if(root.getData().equals(word)){
                System.out.println(root.getData() + ": " + root.getCount());
                return;
            }
            search(root.getlChild(), word);
            search(root.getrChild(), word);
        }

    }

    /**
     * Input: None
     * Output: None
     * Parameter: root, word
     *
     *  This method finds deepest node of the tree.
     * */
    private int maxLevel = -1;
    private String res = "-1";
    private void findDeepest(Node root, int level) {
        if (root !=null) {
            findDeepest(root.getlChild(), ++level);

            if (level > maxLevel) {
                res = root.getData();
                maxLevel = level;
            }
            findDeepest(root.getrChild(), level);
        }
    }

    private String deepestNode(Node root) {
        findDeepest(root,0);
        return res;
    }

    /**
     * Input: None
     * Output: None
     * Parameter: root, word
     *
     * This is overloaded deepestNOde () which
     * method returns the value in main.
     * */
    public String deepestNode () {
        return deepestNode(root);
    }

    /**
     * Input: None
     * Output: int
     * Parameter: none
     *
     * This method returns total number of distinct
     * words in the text.
     * */
    public int distinctCount () {
        distinctCount(root);
        return count;
    }


    /**
     * Input: None
     * Output: int
     * Parameter: root
     *
     * This is private method to return number
     * of distinct count.
     * */
    private int distinctCount (Node root) {
            if (root == null) {
                return 0;
            } else {
                count++;
                distinctCount(root.getlChild());
                distinctCount(root.getrChild());
            }
            return count;
    }

}

