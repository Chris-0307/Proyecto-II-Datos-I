public class Pile_bet {
    private Node_pile max;

    public Pile_bet(){
        max = null;
    }

    public void insert(Tree_node element){
        Node_pile new_pile;
        new_pile = new Node_pile(element);
        new_pile.next = max;
        max = new_pile;

    }

    public boolean void_pile(){
        return max==null;
    }

    public Tree_node max_pile(){
        return max.data;
    }

    public void restart_pile(){
        max = null;
    }

    public Tree_node eliminate(){
        Tree_node ext = null;
        if(!void_pile()){
            ext = max.data;
            max = max.next;
        }

        return ext;
    }
}
