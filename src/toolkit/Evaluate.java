package toolkit;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {

    public static void computer(String input){

        if(input==null)     return ;

        Stack<String> ops=new Stack<String>();
        Stack<Double> vals=new Stack<Double>();

        int opsCount=0;

        for (int index = 0 ; index < input.length() ; ++index) {
            char y = input.charAt(index);
            String s = String.valueOf(y);
            if(s.equals("("))                     ;
            else if( s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt") ) {
                ops.push(s);
                opsCount=1;
            }
            else if(s.equals(")")) {
                midField(ops,vals,opsCount);
            }
            else vals.push(Double.parseDouble(s));
        }

        System.out.printf("%s\n",vals.pop());
    }

    static void midField(Stack<String> ops, Stack<Double> vals,int opsCount){
        opsCount = 0;
        String op=ops.pop();
        double v=vals.pop();
        switch (op) {
            case "+":
                v = vals.pop() + v;
                break;
            case "-":
                v = vals.pop() - v;
                break;
            case "*":
                v = vals.pop() * v;
                break;
            case "/":
                v = vals.pop() / v;
                break;
            case "sqrt":
                v = Math.sqrt(v);
                break;
            default:
                System.out.println("error");
        }
        vals.push(v);
    }
    public static void main(String[] args) {

        String x = new Scanner(System.in).next();
        computer(x);
//(1+((2+3)*(4*5)))

    }
}
