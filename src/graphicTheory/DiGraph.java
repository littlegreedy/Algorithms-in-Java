package graphicTheory;

import basicDataStructure.Bag;

public class DiGraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        this.E = 0;
        adj=(Bag<Integer>[]) new Bag[V];
    }

    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
