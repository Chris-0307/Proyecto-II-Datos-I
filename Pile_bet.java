/**
 * Represents a stack (pile) data structure for Tree_node objects.
 */
public class Pile_bet {
    private Node_pile max;

    public Pile_bet(){
        max = null;
    }
    /**
     * Inserts a Tree_node element onto the top of the stack.
     *
     * @param element The Tree_node to be inserted.
     */
    public void insert(Tree_node element){
        Node_pile new_pile;
        new_pile = new Node_pile(element);
        new_pile.next = max;
        max = new_pile;

    }
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean void_pile(){
        return max==null;
    }
    /**
     * Returns the Tree_node at the top of the stack without removing it.
     *
     * @return The Tree_node at the top of the stack.
     */
    public Tree_node max_pile(){
        return max.data;
    }

    public void restart_pile(){
        max = null;
    }
    /**
     * Removes and returns the Tree_node at the top of the stack.
     *
     * @return The removed Tree_node, or null if the stack is empty.
     */
    public Tree_node eliminate(){
        Tree_node ext = null;
        if(!void_pile()){
            ext = max.data;
            max = max.next;
        }

        return ext;
    }
}
