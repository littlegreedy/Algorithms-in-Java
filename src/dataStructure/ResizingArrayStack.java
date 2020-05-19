package dataStructure;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a=(Item[])new Object[1];
    private int N=0;
    public boolean isEmpty(){ return N==0;}
    public int size(){return N;}
    private void resize(int max){
        Item[] temp=(Item[])new Object[max];
        for (int i = 0; i <N ; i++)
            temp[i]=a[i];
        a=temp;
    }
    public void push(Item item){
        if(a.length==size())  resize(2*a.length);
        a[N++]=item;
    }
    public Item pop(){
        Item item= a[--N];
//        a[N]=null; algs4 displays 对象游离, but JVM told us that always is useless.
        if(N>0 && a.length/4==size())  resize(a.length/2);
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArraysIterator();
    }
    private class ReverseArraysIterator implements Iterator<Item>{
        private int i=N;
        public boolean hasNext(){ return N>0;}
        public Item next(){return a[--i];}
        public void remove(){ ;}
    }
}
