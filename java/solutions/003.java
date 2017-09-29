/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
package projecteuler;

import java.math.BigInteger;
import util.BigNumber;

/**
 *
 * @author Rahul Ramkumar
 */
public class LargestPrimeFactor 
{
    
    
    boolean isPrime(long n) 
    {
        if (n < 0) {
            n = -n;
        }
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n == 3) {
            return true;
        }
        for (int i = 3; i <= n / 2 + 1; i += 2) {
            if (n % 2 == 0 || n % i == 0) {
                return false;
            }
        }
        return true;
    }

    void check()
    {
        long n = 600851475143l;
        
        for(long i = n/2; i>= 1; i--)
        {
            if(n%i == 0)
            {
                if(isPrime(i))
                {
                    System.out.println(i);
                    break;
                }
            }
        }       
    }
    
    
    public static void main(String [] args)
    {
        LargestPrimeFactor o1 = new LargestPrimeFactor();
        o1.check();
    }
}
