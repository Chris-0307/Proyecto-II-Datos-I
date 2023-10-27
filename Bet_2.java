public class Bet_2 {
    Tree_node root;

    public Bet_2(){
        root = null;
    }

    public Bet_2(String chain){
        root = create_bet_tree_2(chain);
    }

    public void restart_tree(){
        root = null;
    }

    public void create_node(Object data){
        root = new Tree_node(data);
    }

    public Tree_node create_subtree(Tree_node data_2, Tree_node data_1, Tree_node operator){
        operator.left = data_1;
        operator.right = data_2;
        return operator;
    }

    public boolean void_tree(){
        return root == null;
    }

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

    private boolean operator_check(char c){
        boolean result;
        result = switch(c) {
            case '(', ')', '^', '~', '&', '|' -> true;
            default -> false;
        };
        return result;

    }

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

    public boolean evaluate_exp(){
        return evaluate(root);
    }

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
