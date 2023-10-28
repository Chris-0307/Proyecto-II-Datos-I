public class Bet {
    Tree_node root;

    public Bet(){
        root = null;
    }

    public Bet(String chain){
        root = create_bet_tree(chain);
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
            case '^' -> 30;
            case '*', '/', '%' -> 20;
            case '+', '-' -> 10;
            default -> 0;
        };
        return p;
    }

    private boolean operator_check(char c){
        boolean result;
        result = switch(c) {
            case '(', ')', '^', '*', '/', '%', '+', '-' -> true;
            default -> false;
        };
        return result;

    }

    private Tree_node create_bet_tree(String chain){
        chain = chain.replace("**", "^");
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

            if (Character.isDigit(evaluated_c) || evaluated_c == '.') {
                StringBuilder num_builder = new StringBuilder();

                while (i < chain.length() && (Character.isDigit(chain.charAt(i)) || chain.charAt(i) == '.')){
                    num_builder.append(chain.charAt(i));
                    i++;
                }

                i--;
                if (num_builder.toString().contains(".")) {
                    token = new Tree_node(Double.parseDouble(num_builder.toString()));
                } else {
                    token = new Tree_node(Integer.parseInt(num_builder.toString()));
                }
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

    public double evaluate_exp(){
        return evaluate(root);
    }

    private double evaluate(Tree_node sub_tree){
        double result = 0;
        if (sub_tree != null) {
            if (!operator_check(sub_tree.data.toString().charAt(0))) {
                result = Double.parseDouble(sub_tree.data.toString());
            } else {
                char operator = sub_tree.data.toString().charAt(0);
                double leftValue = evaluate(sub_tree.left);
                double rightValue = evaluate(sub_tree.right);

                switch (operator) {
                    case '^' -> result = Math.pow(leftValue, rightValue);
                    case '*' -> result = leftValue * rightValue;
                    case '/' -> result = leftValue / rightValue;
                    case '%' -> result = leftValue % rightValue;
                    case '+' -> result = leftValue + rightValue;
                    case '-' -> result = leftValue - rightValue;
                }

            }
        }
        return result;
    }

}