package toolkit;

import java.util.Scanner;
import java.util.Stack;

class Option{
    String op;
    int prior;
    public Option(String op) {
        this.op = op;
        this.prior=option_2_prior(op);
    }
    private int option_2_prior(String op){
//        优先级 0 1 2 依次减小，0为最大优先级
        int priorManager=3;
        switch (op) {
            case "+":
            case "-":
                priorManager=2;
                break;
            case "*":
            case "/":
                priorManager=1;
                break;
            case "sqrt":
                priorManager=0;
                break;
            default:
                System.out.println("option error");
        }
        return priorManager;
    }
}

public class Go {

    public static void computer(String input){
        if(input==null)   return ;
        Stack<Option> ops=new Stack<Option>();
        Stack<Double> vals=new Stack<Double>();
        int opsPoint=0;
//        判断是否补齐右括号的option指针
        for (int index = 0 ; index < input.length() ; ++index) {
            char y = input.charAt(index);
            String s = String.valueOf(y);
            if(s.equals("("))           opsPoint=0       ;
            else if( opsPoint==0 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) ) {
                ops.push(new Option(s));
                opsPoint=1;
            }
            else if(opsPoint==1 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))){
                Option newOption=new Option(s);
                if( !ops.isEmpty() && (ops.peek().prior <=newOption.prior) ){
                    midField(ops,vals);
                    ops.push(newOption);
                    opsPoint=0;
                }
                else{
                    ops.push(newOption);
                }
            }
            else if(s.equals(")")) {
                if(opsPoint==1){
                    midField(ops,vals);
                    midField(ops,vals);
                }
                else  midField(ops,vals);

            }
            else vals.push(Double.parseDouble(s));
        }
//       由于上面已经把只能从左至右计算的符号处理完毕，此处把可能存在遗漏的从右至左计算完
       while(vals.size()!=1){
           midField(ops,vals);
       }
//       打印结果
        System.out.printf("%s\n",vals.pop());
    }
//      中缀计算 形如 a options b
    static void midField(Stack<Option> ops, Stack<Double> vals){

        String op=ops.pop().op;
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
//        for(double s: vals)
//            System.out.print(s+" ");
    }
    public static void main(String[] args) {

        String x = new Scanner(System.in).next();
        computer(x);
//(1+((2+3)*(4*5)))

    }
}
