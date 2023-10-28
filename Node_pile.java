/**
 * Represents a node used in a stack (pile) data structure for Tree_node objects.
 */
public class Node_pile {
    Tree_node data;
    Node_pile next;
    /**
     * Constructs a new Node_pile with the specified Tree_node data.
     *
     * @param x The Tree_node data to be stored in the node.
     */
    public Node_pile(Tree_node x){
        data = x;
        next = null;
    }

}
