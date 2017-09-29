
package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author Rahul Ramkumar
 */
/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
/**
 *
 * @author Rahul Ramkumar
 */
public class SelfPowers {

    static int LENGTH = 3001;
    

    public byte[] findProduct(byte[] arr1, byte[] arr2) {
        byte[] product = new byte[LENGTH];
        byte[] sum = new byte[LENGTH];

        int tempProduct = 0, carry = 0;

        for (int i = LENGTH - 1; i >= 0; i--) {
            for (int j = LENGTH - 1; j >= 0; j--) {
                tempProduct = arr2[i] * arr1[j] + carry;

                if (tempProduct / 10 > 1) {
                    carry = tempProduct / 10;
                    product[j] = (byte) (tempProduct % 10);
                } else {
                    product[j] = (byte) tempProduct;
                    carry = 0;
                }
            }
            if ((LENGTH - i - 1) > 0) {
                product = shiftValues(LENGTH - i - 1, product);
            }

            sum = findSum(product, sum);
        }
        return sum;
    }

    public byte[] findSum(byte arr1[], byte arr2[]) {
        byte[] sum = new byte[LENGTH];
        int tempSum = 0, carry = 0;

        for (int i = LENGTH - 1; i >= 0; i--) {
            tempSum = arr1[i] + arr2[i] + carry;

            if ((tempSum / 10) >= 1) {
                carry = tempSum / 10;
                sum[i] = (byte) (tempSum % 10);
            } else {
                sum[i] = (byte) tempSum;
                carry = 0;
            }
        }
        return sum;
    }

    byte[] findPower(byte[] number, int pow) {
        byte[] power = new byte[LENGTH];
        power[LENGTH - 1] = 1;

        for (int i = 1; i <= pow; i++) {
            power = findProduct(power, number);
        }
        return power;
    }

    byte[] findSumOfSeries(int n) {
        byte[] sum = new byte[LENGTH];
        for (int i = n; i >= 1; i--) {
            sum = findSum(sum, findPower(tobyteArray(i), i));
            print(sum);
        }
        return sum;
    }

    byte[] shiftValues(int shiftValue, byte[] arr) {
        for (int i = 0; i < LENGTH - shiftValue; i++) {
            arr[i] = arr[i + shiftValue];
            arr[i + shiftValue] = 0;
        }
        return arr;
    }

    int numberOfDigits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    void print(byte[] arr) //prints the inputed array
    {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                flag = true;
            }
            if (flag) {
                count++;
                System.out.print(arr[i]);
            }
        }
        System.out.println();
        System.out.println("Number of digits = " + count);
        System.out.println();
    }

    byte[] tobyteArray(int num) //puts num into an array of length 'LENGTH'
    {
        byte[] arr = new byte[LENGTH];
        int index = arr.length - 1;
        while (num != 0) {
            arr[index] = (byte) (num % 10);
            num = num / 10;
            index--;
        }
        return arr;
    }

    int addArray(byte[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SelfPowers o1 = new SelfPowers();

        byte[] sum = o1.findSumOfSeries(1000);
        o1.print(sum);

    }
}
