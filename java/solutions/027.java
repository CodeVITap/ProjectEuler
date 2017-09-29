/*
Euler discovered the remarkable quadratic formula:

n2+n+41n2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39. However, when n=40,402+40+41=40(40+1)+41n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41n=41,412+41+41 is clearly divisible by 41.

The incredible formula n2−79n+1601n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n2+an+bn2+an+b, where |a|<1000|a|<1000 and |b|≤1000|b|≤1000

where |n||n| is the modulus/absolute value of nn
e.g. |11|=11|11|=11 and |−4|=4|−4|=4
Find the product of the coefficients, aa and bb, for the quadratic expression that produces the maximum number of primes for consecutive values of nn, starting with n=0n=0.
 */
package projecteuler;

/**
 *
 * @author Rahul Ramkumar
 */
public class QuadraticPrimes {

    boolean isPrime(int n) {
        if (n < 0) {
            n = -n;
        }
        if (n == 1) {
            return true;
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

    void check() {

        int[] primes = new int[500];

        int index = 0;
        for (int i = 1; i <= 1000; i++) //finding primes from 1 to 1000
        {
            if (isPrime(i)) {
                primes[index] = i;
                index++;
                primes[index] = -i;
                index++;
            }
        }

        int n = 0, num = 0, a = 0, b = 0, max = 0;

        for (int index1 = 0; index1 < 336; index1++) {
            a = primes[index1];
            for (int index2 = 0; index2 < 336; index2++) {
                b = primes[index2];
                while (true) {
                    num = n * n + a * n + b;

                    if (isPrime(num) == false) {
                        if (n > max) {
                            System.out.println("a: " + a + " b: " + b + " count: " + n);
                            max = n;
                        }
                        break;
                    }
                    n++;
                }
                n = 0;
            }
        }
        System.out.println("max: " + max);
    }

    public static void main(String[] args) {
        QuadraticPrimes o1 = new QuadraticPrimes();
        o1.check();

    }

}
