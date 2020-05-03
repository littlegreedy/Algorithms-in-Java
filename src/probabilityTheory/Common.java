package probabilityTheory;

public class Common {
//    未优化的二项分布
//    public static double binomialPrimary(int N,int K,double p){
//        if(N==0 && K==0)    return 1.0;
//        if(N<0 || K<0)      return 0.0;
//        return (1.0-p)*binomial(N-1,K,p)+p*binomial(N-1,K-1,p);
//    }

    public static double binomial(int n, int k, double p)
    {
        double[][] v = new double[n+1][k+1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                v[i][j] = -1;

        return binomial(v, n, k, p);
    }

    public static double binomial(double[][] v, int n, int k, double p)
    {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;

        if (v[n][k] == -1)
        {
            v[n][k] = (1.0 - p) * binomial(v, n-1, k, p) + p * binomial(v, n-1, k-1, p);
        }

        return v[n][k];
    }

    public static void main(String args[]){
        System.out.println( binomial(100,50,0.25) );
    }
}
