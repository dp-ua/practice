package com.sysgears.practice.kprimes;


import java.util.Map;
import java.util.TreeMap;

import static com.sysgears.practice.kprimes.KPrimes.isPrime;

/**
 * Function factors
 * <p>
 * Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :
 * <p>
 * "(p1**n1)(p2**n2)...(pk**nk)"
 * <p>
 * with the p(i) in increasing order and n(i) empty if n(i) is 1.
 * <p>
 * Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
 */


public class PrimeDecomp {
    public static void main(String[] args) {

        System.out.println("Expect (2)(3)(5**2)(354353)");
        System.out.println(factors(53152950));

        System.out.println(factors(26396967));

    }

    public static String factors(int input) {
        // your code
        if (input <= 1) return new String();

        Map<Integer, Integer> result = new TreeMap<>();
        int n = input;
        int i = 2;

        if (isPrime(n)) result.put(n, 1);

        while (n != 1 && i <= Math.sqrt(n) + 1) {
            if (isPrime(i))
                while (n % i == 0) {
                    n /= i;
                    if (result.containsKey(i)) result.put(i, result.get(i) + 1);
                    else result.put(i, 1);
                }
            i++;
        }
        if (isPrime(n)) {
            result.put(n, 1);
            n = 1;
        }
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
                sb.append("(").append(pair.getKey());
                if (pair.getValue() != 1) sb.append("**").append(pair.getValue());
                sb.append(")");
            }
        }
        return sb.toString();
    }

}
