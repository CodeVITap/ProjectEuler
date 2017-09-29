/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
package projecteuler;

/**
 *
 * @author Rahul Ramkumar
 */
public class GoldbachConjecture
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
        for(int i = 2; i<= 10000; i++)
        {
            if(isPrime(i))
            {
                primes[index] = i;
                index++;
            }
        }        
    }
    
    boolean check(int num)
    {
        int primesIndex = 0;
        int i;
        
        for(i = 1; i<num; i++)
        {
            primesIndex = 0;
            while(primes[primesIndex] < num)
            {
                if((primes[primesIndex] + 2*i*i) == num)    
                {
                   System.out.println(primes[primesIndex] + " + " + "2 x " + i + "^2");
                   return true;
                }    
                primesIndex++;
            }
           
        }
        return false;
    }
    
    void findOut()
    {
        int i = 3;
        while(true)
        {
            if(check(i) == false)
            {
                if(isPrime(i) == false)
                {
                    System.out.println("i: " + i);
                    break;
                }
            }
            i = i+2;
        }
    }
    
    public static void main(String [] args)
    {
        GoldbachConjecture o1 = new GoldbachConjecture();
        o1.setPrimes();
        o1.findOut();
    }
    
}
