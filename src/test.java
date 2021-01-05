import modelRecognition.NFA;

public class test {
    public static void main(String args[]){
//        int a=0,b=1,c=1,d=3;
//        a=b+c*d;
        String regexp= "(.*"+args[0]+".*)";
        NFA nfa=new NFA(regexp);
        System.out.println(nfa);
    }
}
