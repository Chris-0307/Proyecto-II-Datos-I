/**
 * Represents a class for handling logical expressions using a binary expression tree.
 */
public class Bet_2 {
    Tree_node root;

    public Bet_2(){
        root = null;
    }
    /**
     * Constructs a Bet_2 object and creates a binary expression tree from the given logical expression.
     *
     * @param chain The logical expression in string format.
     */

    public Bet_2(String chain){
        root = create_bet_tree_2(chain);
    }

    public void restart_tree(){
        root = null;
    }

    /**
     * Creates a new node with the specified data and sets it as the root of the tree.
     *
     * @param data The data to be stored in the new node.
     */
    public void create_node(Object data){
        root = new Tree_node(data);
    }
    /**
     * Creates a subtree with the specified data nodes and operator node, and sets it as the root of the tree.
     *
     * @param data_2 The right child node.
     * @param data_1 The left child node.
     * @param operator The operator node.
     * @return The root of the created subtree.
     */
    public Tree_node create_subtree(Tree_node data_2, Tree_node data_1, Tree_node operator){
        operator.left = data_1;
        operator.right = data_2;
        return operator;
    }
    /**
     * Checks if the tree is empty.
     *
     * @return True if the tree is empty, otherwise false.
     */
    public boolean void_tree(){
        return root == null;
    }
    /**
     * Determines the priority of an operator for evaluation purposes.
     *
     * @param c The operator character.
     * @return The priority value.
     */
    private int priority(char c){
        int p=100;

        p = switch(c){
            case '~' -> 40;
            case '&' -> 30;
            case '^' -> 20;
            case '|' -> 10;
            default -> 0;
        };
        return p;
    }
    /**
     * Checks if a character is a valid operator.
     *
     * @param c The character to be checked.
     * @return True if the character is a valid operator, otherwise false.
     */
    private boolean operator_check(char c){
        boolean result;
        result = switch(c) {
            case '(', ')', '^', '~', '&', '|' -> true;
            default -> false;
        };
        return result;

    }
    /**
     * Creates a binary expression tree from the given logical expression string.
     *
     * @param chain The logical expression in string format.
     * @return The root node of the binary expression tree.
     */
    private Tree_node create_bet_tree_2(String chain){
        Pile_bet operators_pile;
        Pile_bet expressions_pile;
        Tree_node token;
        Tree_node op1;
        Tree_node op2;
        Tree_node op;

        operators_pile = new Pile_bet();
        expressions_pile = new Pile_bet();

        char evaluated_c;

        for (int i=0; i<chain.length(); i++){
            evaluated_c = chain.charAt(i);

            if (evaluated_c == 'V' || evaluated_c == 'F') {

                token = new Tree_node(evaluated_c);
                expressions_pile.insert(token);
            } else if (!operator_check(evaluated_c)) {
                token = new Tree_node(evaluated_c);
                expressions_pile.insert(token);
            }
            else {
                token = new Tree_node(evaluated_c);
                switch (evaluated_c) {
                    case '(' -> operators_pile.insert(token);
                    case ')' -> {
                        while (!operators_pile.void_pile() && !operators_pile.max_pile().data.equals('(')) {
                            op2 = expressions_pile.eliminate();
                            op1 = expressions_pile.eliminate();
                            op = operators_pile.eliminate();
                            op = create_subtree(op2, op1, op);
                            expressions_pile.insert(op);
                        }
                        operators_pile.eliminate();
                    }
                    default -> {
                        while (!operators_pile.void_pile() && priority(evaluated_c) <= priority(operators_pile.max_pile().data.toString().charAt(0))) {
                            op2 = expressions_pile.eliminate();
                            op1 = expressions_pile.eliminate();
                            op = operators_pile.eliminate();
                            op = create_subtree(op2, op1, op);
                            expressions_pile.insert(op);
                        }
                        operators_pile.insert(token);
                    }
                }
            }
        }
        while(!operators_pile.void_pile()){
            op2 = expressions_pile.eliminate();
            op1 = expressions_pile.eliminate();
            op = operators_pile.eliminate();
            op = create_subtree(op2, op1, op);
            expressions_pile.insert(op);
        }

        op = expressions_pile.eliminate();
        return op;
    }
    /**
     * Evaluates the logical expression represented by the binary expression tree.
     *
     * @return The result of the logical expression evaluation.
     */
    public boolean evaluate_exp(){
        return evaluate(root);
    }
    /**
     * Recursively evaluates the logical expression represented by the binary expression tree.
     *
     * @param sub_tree The current subtree being evaluated.
     * @return The result of the logical expression evaluation.
     */
    private boolean evaluate(Tree_node sub_tree){
        boolean result = false;
        if (sub_tree != null) {
            if (!operator_check(sub_tree.data.toString().charAt(0))) {
                result = sub_tree.data.toString().equals("V");
            } else {
                char operator = sub_tree.data.toString().charAt(0);
                boolean leftValue = evaluate(sub_tree.left);
                boolean rightValue = evaluate(sub_tree.right);

                switch (operator) {
                    case '&' -> result = leftValue && rightValue;
                    case '|' -> result = leftValue || rightValue;
                    case '^' -> result = leftValue ^ rightValue;
                    case '~' -> result = !rightValue;

                }

            }
        }
        return result;
    }
}
