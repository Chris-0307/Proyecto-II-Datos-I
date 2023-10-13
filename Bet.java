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

    private String preorder(Tree_node sub_tree, String c){
        String chain;
        chain = "";
        if (sub_tree != null){
            chain = c + sub_tree.data.toString() + "\n" + preorder(sub_tree.left, c) + preorder(sub_tree.right, c);
        }
        return chain;
    }
    
    private String inorder(Tree_node sub_tree, String c){
        String chain;
        chain = "";
        if(sub_tree != null){
            chain = c + inorder(sub_tree.left, c) + sub_tree.data.toString() + "\n" + inorder(sub_tree.right, c);
        }
        return chain;
    }

    private String postorder(Tree_node sub_tree, String c){
        String chain;
        chain = "";
        if(sub_tree != null){
            chain = c + postorder(sub_tree.left, c) + postorder(sub_tree.right, c) + sub_tree.data.toString() + "\n";
        }
        return chain;
    }

    public String toString(int a){
        String chain = "";
        switch(a){
            case 0:
                chain = preorder(root, chain);
                break;
            case 1:
                chain = inorder(root, chain);
                break;
            case 2:
                chain = postorder(root, chain);
                break;
        }
        return chain;
    }

    private int priority(char c){
        int p=100;
        switch(c){
            case '^':
                p=30;
                break;
            case '*':
            case '/':
                p=20;
                break;
            case '+':
            case '-':
                p=10;
                break;
            default:
                p=0;
        }
        return p;
    }

    private boolean operator_check(char c){
        boolean result;
        switch(c) {
            case '(':
            case ')':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                result = true;
                break;
            default:
                result = false;
        }
        return result;

    }

    private Tree_node create_bet_tree(String chain){
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
            token = new Tree_node (evaluated_c);

            if(!operator_check(evaluated_c)){
                expressions_pile.insert(token);
            }
            else{
                switch(evaluated_c){
                    case '(':
                        operators_pile.insert(token);
                        break;
                    case ')':
                        while(!operators_pile.void_pile() && !operators_pile.max_pile().data.equals('(')){
                            op2 = expressions_pile.eliminate();
                            op1 = expressions_pile.eliminate();
                            op = operators_pile.eliminate();
                            op = create_subtree(op2, op1, op);
                            expressions_pile.insert(op);
                        }
                        operators_pile.eliminate();
                        break;
                    default:
                        while(!operators_pile.void_pile() && priority(evaluated_c) <= priority(operators_pile.max_pile().data.toString().charAt(0))){
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
        double acum=0;
        if(!operator_check(sub_tree.data.toString().charAt(0))){
            return Double.parseDouble(sub_tree.data.toString());
        }
        else{
            switch(sub_tree.data.toString().charAt(0)){
                case '^':
                    acum = acum + Math.pow(evaluate(sub_tree.left), evaluate(sub_tree.right));
                    break;
                case '*':
                    acum = acum + evaluate(sub_tree.left) * evaluate(sub_tree.right);
                    break;
                case '/':
                    acum = acum + evaluate(sub_tree.left) / evaluate(sub_tree.right);
                    break;
                case '+':
                    acum = acum + evaluate(sub_tree.left) + evaluate(sub_tree.right);
                    break;
                case '-':
                    acum = acum + evaluate(sub_tree.left) - evaluate(sub_tree.right);
                    break;
            }
        }
        return acum;
    }
}
