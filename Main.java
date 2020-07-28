/*
 * Student: Nirajan Pandey
 * Instructor: Vic Berry
 * Due Date: Dec 9th 2019 @ 6:00 PM
 *
 * The following program parse a text file and adds all the words
 * into a Binary Tree. It also performs operations such as searching
 * occurrences word in tree, finding out the deepest level of tree,
 * finding total numbers of words and distinct words in tree, and
 * printing first 20 words of post-order,in-order and pre-order traversal.
 *
 */
import edu.bu.met.cs342a1.TextParser;

public class Main {
    public static void main(String[] args) {
        Main me = new Main();
        me.doIt();
    }

    public void doIt() {
        // Objects of LinkedTree and TextParser classes.
        LinkedTree tree = new LinkedTree();
        TextParser tp = new TextParser();

        // Opens a text file names "pg.345.txt"
        tp.openFile("pg345.txt");

        int count = -1;
        String word  ;
        int counter = 0;
        // Parses the text file and adds it to the tree.
        while ((word = tp.getNextWord()) != null) {
            tree.add(word);
            count++;
        }

        // #1 Total words are in the book.
        System.out.println("Text contains " + count + " Total words") ;

        // #2. Words appearances in the text.
        System.out.println("Word apperances in the tree:");
        tree.search("the");
        tree.search("transylvania");
        tree.search("vampire");
        tree.search("harker");
        tree.search("expostulate");
        tree.search("renfield");
        tree.search("fang");

        // #3. Depth of the tree
        System.out.println("Tree is "+ tree.maxDepth() + " nodes deep");

        // #4. Distinct words in tree.
        System.out.println("Tree contains " + tree.distinctCount() + " distinct words");

        // #5. Root word of the tree.
        System.out.println("Word at the root is " + tree.rootWord());

        // #6. Word at the deepest leaf in the tree.
        System.out.println("Deepest word is "+ tree.deepestNode());

        // #7. Most frequently occurred word.


        // #8. Display First 20 word in a Pre-Order Traversal
        System.out.print("First 20 pre word order: ");
        tree.preOrder();
        System.out.println();

        // #9. Display First 20 word in a Post-Order Traversal
        System.out.print("First 20 post word order: ");
        tree.postOrder();
        System.out.println();

        // #10. Display First 20 word in a In-Order Traversal
        System.out.print("First 20 in word order: ");
        tree.inOrder();


    }
}
