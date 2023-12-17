
/**
 * The class BinarySearchTree implements a binary search tree. The type of each
 * element consists of two components: word and meaning. The organization of the
 * tree is based on the word component.
 *
 * @author Mohammed Alfarra, 6368950, U02
 */
public class BinarySearchTree
{

    private Node root;    //root of the bst; implemented as a dummy node.

    /**
     * Default constructor. Sets this object as an empty BST.
     */
    public BinarySearchTree()
    {
        root = new Node();        //dummy node as the root
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setInfo(new ElementType("DUMMY word", "DUMMY meaning"));
    }

    /**
     * Adds a new element to the BST.
     *
     * @param x new element
     */
    public void add(ElementType x)
    {
        if (root.getLeftChild() == null) {
            Node p = new Node();
            p.setNode(x, null, null);
            root.setLeftChild(p);
        }
        else {
            add(x, root.getLeftChild());
        }
    }

    /**
     * Determines if given word is in the BST.
     *
     * @param x given word
     * @return true if x is a word in the tree, false otherwise
     */
    public boolean contain(String x)
    {
        return contain(x, root.getLeftChild());
    }

    /**
     * If given word is found in the tree, meaning of word is returned;
     * otherwise, empty string is returned.
     *
     * @param x given word
     * @return meaning of given word if word is in the tree; empty string
     * otherwise
     */
    public String find(String x)
    {
        return find(x, root.getLeftChild());
    }

    /**
     * Returns number of elements in the BST.
     *
     * @return number of elements in the BST
     */
    public int getCount()
    {
        return getCount(root.getLeftChild());
    }

    /**
     * Determines if this BST is empty.
     *
     * @return true if tree is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return root.getLeftChild() == null;
    }

    /**
     * If given word is found in the tree, it replaces its meaning with the
     * given one and a value of true is returned; otherwise false is returned.
     *
     * @param x given word
     * @param y given meaning
     * @return true if replacement is successful, false otherwise
     */
    public boolean replace(String x, String y)
    {
        if (!contain(x)) {
            return false;
        }
        else {
            return replace(x, y, root.getLeftChild());
        }
    }

    /**
     * Builds a String description of this BST.
     *
     * @return String containing the BST elements
     */
    public String toString()
    {
        return toString(root.getLeftChild());
    }

    /**
     * Recursive implementation of method add(ElementType x).
     */
    private void add(ElementType x, Node p)
    {
        if (cmp(x.word, p) == -1) {
            if (p.getLeftChild() == null) {
                Node q = new Node();
                q.setNode(x, null, null);
                p.setLeftChild(q);
            }
            else {
                add(x, p.getLeftChild());
            }
        }
        else if (p.getRightChild() == null) {
            Node q = new Node();
            q.setNode(x, null, null);
            p.setRightChild(q);
        }
        else {
            add(x, p.getRightChild());
        }
    }

    /**
     * Compares given string with word in given node.
     *
     * @param x given string
     * @param p given node
     * @return -1 if x is less than word in node, 0 if x is equal to word in
     * node, 1 if x is greater than word in node
     */
    private int cmp(String x, Node p)
    {
        if (x.compareTo(p.getInfo().word) < 0)
            return -1;
        else
        if (x.compareTo(p.getInfo().word) == 0)
            return 0;
        else
            return 1;
    }

    /**
     * Recursive implementation of method contain(String x).
     */
    private boolean contain(String x, Node p)
    {
        if (p == null) {
            return false;
        }
        else if (cmp(x, p) == 0) {
            return true;
        }
        else if (cmp(x, p) == -1) {
            return contain(x, p.getLeftChild());
        }
        else {
            return contain(x, p.getRightChild());
        }
    }

    /**
     * Recursive implementation of method find(String x).
     */
    private String find(String x, Node p)
    {
        if (p == null) {
            return "";
        }
        else if (cmp(x, p) == 0) {
            return p.getInfo().meaning;
        }
        else if (cmp(x, p) == -1) {
            return find(x, p.getLeftChild());
        }
        else {
            return find(x, p.getRightChild());
        }
    }

    /**
     * Recursive implementation of method getCount().
     */
    private int getCount(Node p)
    {
        if (p == null) {
            return 0;
        }
        else {
            return 1 + getCount(p.getLeftChild()) +getCount(p.getRightChild());
        }
    }

    /**
     * Recursive implementation of method replace(String x, String y).
     */
    private boolean replace(String x, String y, Node p)
    {
        if (cmp(x, p) == 0) {
            ElementType z = new ElementType(x, y);
            p.setInfo(z);
            return true;
        }
        else if (cmp(x, p) == -1) {
            return replace(x, y, p.getLeftChild());
        }
        else {
            return replace(x, y, p.getRightChild());
        }
    }

    /**
     * Recursive implementation of method toString().
     */
    private String toString(Node p)
    {
        if (p != null)
            return toString(p.getLeftChild())
                    + p.getInfo().word + ": " + p.getInfo().meaning + "\n"
                    + toString(p.getRightChild());
        else
            return "";
    }

}
