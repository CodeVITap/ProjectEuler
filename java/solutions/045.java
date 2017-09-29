/*
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.
 */
package projecteuler;

/**
 *
 * @author Rahul Ramkumar
 */
public class TPH 
{
    public static void main(String [] args)
    {
        long i = 286l,t,p,h;
        boolean found = false;
        while(true)
        {
            t = i*(i+1)/2;
            for(long j = 166l; j <= i; j++)
            {
                if(j>i)
                {
                    break;
                }
                p = j*(3*j-1)/2; 
                if(t == p)
                {
                    for(long k = 142l; k<=j; k++)
                    {
                        h = k*(2*k-1);
                        if(h == p)
                        {
                            found = true;
                            System.out.println("t: " + t + " Tn: " + i + " Pn: " + j + " Hn: " + k);
                            break;
                        }
                    }
                }
                if(found)
                {
                    break;
                }
            }
            if(found)
            {
                break;
            }
            i++;
        }
    }
}