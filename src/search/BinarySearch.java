package search;

public class BinarySearch {

    public static int rank(int key,int[] a){
        return rank(key, a,0,a.length-1);
    }
    public static int rank(int key,int[] a,int lo,int hi){
        if(lo>hi) return -1;

        int mid=lo+(hi-lo)/2;
        if      (key>a[mid]) return rank(key, a, mid+1, hi);
        else if (key<a[mid]) return rank(key, a, lo, mid-1);
        else                 return mid;
    }
//  indent包
    public static int rank_Indent(int key,int[] a){
        return rank_Indent(key, a,0,a.length-1,0);
    }

    public static int rank_Indent(int key, int[] a, int lo, int hi, int indent)
    {
        System.out.printf("%s%-4d%d\n", repeat(4*indent, ' '), lo, hi);

        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) return rank_Indent(key, a, lo, mid - 1, indent + 1);
        else if (key > a[mid]) return rank_Indent(key, a, mid + 1, hi, indent + 1);
        else                   return mid;
    }

    private static String repeat(int n, char c)
    {
        String s = "";
        for (int i = 0; i < n; i++)
            s += c;
        return s;
    }

    public static void main(String args[]){
        int[] a={1,2,3,4,7,8,9};
        System.out.println(rank_Indent(7,a));
    }
}
