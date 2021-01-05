package modelRecognition;

import basicDataStructure.Bag;
import graphicTheory.DiGraph;
import graphicTheory.DirectDFS;

import java.util.Stack;

public class NFA {
    private char[] re;
    private DiGraph G;
    private int M;

    public NFA(String regexp){
        Stack<Integer> ops=new Stack<Integer>();
        re=regexp.toCharArray();
        M=re.length;
        G=new DiGraph(M+1);

        for (int i = 0; i <M ; i++) {
            int lp=i;
            if(re[i] == '(' || re[i]=='|')
                ops.push(i);
            else if(re[i]==')'){
                int or=ops.pop();
                if(re[or]=='|'){
                    lp=ops.pop();
                    G.addEdge(lp,or+1);
                    G.addEdge(or,i);
                }
                else lp=or;
            }

            if( i<M-1 && re[i+1] == '*'){
                G.addEdge(lp,i+1);
                G.addEdge(i+1,lp);
            }
            if(re[i] == '(' || re[i]=='*' || re[i]== ')')
                G.addEdge(i,i+1);
        }
    }

    public boolean recognizes(String txt){
        Bag<Integer> pc=new Bag<Integer>();
        DirectDFS dfs =new DirectDFS(G,0);

        for (int i = 0; i <txt.length() ; i++) {
            Bag<Integer> match =new Bag<>();
            for (int v:pc) {
                if(v<M)
                    if(re[v] == txt.charAt(i) || re[v]=='.')
                        match.add(v+1);
            }
            pc=new Bag<Integer>();
            dfs=new DirectDFS(G,match);
            for (int j = 0; j <G.V() ; j++) {
                if(dfs.marked(j)) pc.add(j);
            }
        }
        for (int v: pc) {
            if(v==M)
                return true;
        }
        return false;
    }
}
