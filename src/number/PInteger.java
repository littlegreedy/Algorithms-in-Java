package number;

public class PInteger {

    public static String toBinaryString(int N){
        String str="";
        for (int i = N; i >0 ; i/=2) {
            str=(i%2)+str;
        }
        return str;
    }

   //返回不大于log2N的最大整数
    public static int lg(int N){
        int t=2;
        int ans=0;
        while(t<=N){
            t*=2;
            ++ans;
        }
        return ans ;
    }
//  loga b
    public static double lg(int a,int b){
        return Math.log(b)/Math.log(a);
    }

//  ln(N!)
    public static double lnNFactorial(int N){
        double sum=0.0;
        for (int i = 1; i <=N ; i++) {
            sum+=Math.log(i);
        }
        return sum;
    }

//    返回M长的数组，数组第i个元素的值为整数i在参数数组中出现的次数
    public static int[] histogram(int[] a, int M)
    {
        if(M<=0) return null;

        int[] h = new int[M];
        int N = a.length;

        for (int i = 0; i < N; i++)
            if (a[i] < M)
                h[a[i]]++;

        return h;
    }


    public static void main(String args[]){

        System.out.println(lg(7)+" "+lg(2,7));
    }
}
