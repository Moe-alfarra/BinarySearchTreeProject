
/**
 * Implements the node of a binary search tree.
 *
 * @author Prof. A. Hernandez
 */
public class Node
{

    private ElementType info;     //element stored in this node
    private Node left;    //link to left child
    private Node right;   //link to right child

    Node()
    {
        info = new ElementType();
        left = right = null;
    }

    ElementType getInfo()
    {
        return info;
    }

    Node getLeftChild()
    {
        return left;
    }

    Node getRightChild()
    {
        return right;
    }

    void setInfo(ElementType info)
    {
        this.info = info;
    }

    void setLeftChild(Node left)
    {
        this.left = left;
    }

    void setNode(ElementType info, Node left, Node right)
    {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    void setRightChild(Node right)
    {
        this.right = right;
    }
}

