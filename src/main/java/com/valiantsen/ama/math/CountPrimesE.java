package main.java.com.valiantsen.ama.math;

/**
 * Description:

Count the number of prime numbers less than a non-negative number, n.
 * @ClassName: CountPrimesE
 * @author zhangyasen
 * @date 2017年9月23日
 */
public class CountPrimesE {
 /**
  * Sieve of Eratosthenes algorithm
  * TODO
  * @param n
  * @return
  */
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] notPrime = new boolean[n+1];
        notPrime[0]=true;
        notPrime[1]=true;
        int count=0;
        for(int i=2;i<n;i++){
            if(!notPrime[i]) count++;
            for(int j=2;i*j<n;j++){
                notPrime[i*j] =true;
            }
        }
        return count;
    }
}
