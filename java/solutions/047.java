/*
 The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */
package projecteuler;

/**
 *
 * @author Rahul Ramkumar
 */
public class DistinctPrimeFactors
{
    int [] primes = new int [9592];
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
    
    void setPrimes()
    {
        int index = 0;
        for(int i = 2; i<= 100000; i++)
        {
            if(isPrime(i))
            {
                primes[index] = i;
                index++;
            }
        }        
    }
    
    int nextPrime(int current)
    {
        int n = current+1;
        while(true)
        {
            if(isPrime(n))
                return n;
            n++;
        }
    }
    
    int getPrimeFactorCount(int n)
    {
        int prime = 2,count = 0;
        int primesIndex = 0;
        
        while(prime <= n/2+1)
        {
            if(n%prime == 0)
            {
                count++;
                prime = primes[++primesIndex];
            }
            else
            {
                prime = primes[++primesIndex];
            }
        }
        return count;
    }
    
    void findOut()
    {
        int count = 0,num = 100;
        while(true)
        {
            if(getPrimeFactorCount(num) == 4)
            {
                count++;
            }
            else
            {
                count = 0;
            }
            if(count == 4)
            {
                System.out.println(num-3);
                break;
            }
            num++;            
        }
    }
    
    public static void main(String [] args)
    {
        DistinctPrimeFactors o1 = new DistinctPrimeFactors();
        o1.setPrimes();
        o1.findOut();
        for(int i = 0; i<o1.primes.length; i++)
        {
           // System.out.println(o1.primes[i]);
            if(o1.primes[i] == 0)
            {
                //System.out.println("i: " + i);
                break;
            }
        }
        
        
    }
}
