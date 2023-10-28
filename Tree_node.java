/**
 * Represents a node in a binary tree.
 */
public class Tree_node {
    Object data;
    Tree_node left;
    Tree_node right;
    /**
     * Constructs a new Tree_node with the specified data, and null left and right children.
     *
     * @param x The data to be stored in the node.
     */
    public Tree_node(Object x){
        data = x;
        left = null;
        right = null;
    }
}
