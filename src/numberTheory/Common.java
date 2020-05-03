package numberTheory;

public class Common {
//    求最大公约数 欧几里得算法
    public static int gcd(int p,int q){
        int t=0;
        while(q!=0){
            t=p;
            p=q;
            q=t%q;
            System.out.println(p+" "+q);
        }
        return p;
    }
//   推荐使用gcd
//    public static int gcd_recursion(int p,int q){
//        if(q==0) return p;
//        int r=p%q;
//        System.out.println(p+" "+r);
//        return gcd(q,r);
//    }

    public static void main(String args[]){
        System.out.println(gcd(1111111,1234567));
    }
}

