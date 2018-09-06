package com.sysgears.practice.kprimes;

/*
A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity.

A natural number is thus prime if and only if it is 1-prime.

Examples:
k = 2 -> 4, 6, 9, 10, 14, 15, 21, 22, …
k = 3 -> 8, 12, 18, 20, 27, 28, 30, …
k = 5 -> 32, 48, 72, 80, 108, 112, …

#Task:

    Write function count_Kprimes (or countKprimes or count-K-primes or kPrimes) which given parameters k, start, end (or nd) returns an array (or a list or a string depending on the language - see "Solution" and "Sample Tests") of the k-primes between start (inclusive) and end (inclusive).

#Example:

countKprimes(5, 500, 600) --> [500, 520, 552, 567, 588, 592, 594]

...............................................................................

 Given positive integers s and a, b, c where a is 1-prime, b 3-prime, c 7-prime find the number of solutions of a + b + c = s. Call this function puzzle(s).

Examples:

puzzle(138) --> 1 ([2 + 8 + 128] is solution)
puzzle(143) --> 2 ([3 + 12 + 128, 7 + 8 + 128] are solutions)

...............................................................................

Notes:

    The first function would have been better named: findKprimes or kPrimes :-)

    In C some helper functions are given (see declarations in 'Solution').

    For Go: nil slice is expected when there are no k-primes between start and end.


*/


import java.util.ArrayList;
import java.util.List;

public class KPrimes {

    /**
     * del method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(puzzle(138));
        System.out.println("need: 1");
    }

    /**
     * return the number of prime factors to obtain a input number
     *
     * @param start
     * @return long
     */
    public static long kPrimes(long start) {
        List<Long> modNumbers = new ArrayList<>();
        long count = 0;
        long n = start;
        List<Long> list = primeListNumbers((long) (start));
        for (int i = 0; i < list.size(); i++) {
            if (n==1) break;
             long l = list.get(i);
            if (n % l == 0) {
                n /= l;
                i--;
                count++;
            }
        }
        return n==1?count:0;
    }

    public static long[] countKprimes(int k, long start, long end) {
        // your code
        List<Long> result = new ArrayList<>();

        for (long i = start; i <= end; i++) if (kPrimes(i) == k) result.add(i);

        return result.stream().mapToLong(l -> l).toArray();
    }

    public static int puzzle(int s) {
        return 0;
        // TODO: 06.09.18 not done )))) 
        // your code
    }

    /**
     * return list of simple numbers from 1 to max
     *
     * @param max end of list
     * @return long[] simple numbers
     */
    private static List<Long> primeListNumbers(long max) {
        List<Long> result = new ArrayList<Long>();
        if (max < 2) return result;
        for (long i = 2; i <= max; i++) {
            if (isPrime(i)) result.add(i);
        }
        return result;
    }

    /**
     * Check is the number is prime
     *
     * @param n an long greater than 0
     * @return true if the number is prime
     */
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        long count = 0;
        for (long i = 1; i < (long) (Math.sqrt(n)) + 1; i++) {
            count += n % i == 0 ? 1 : 0;
            if (count > 1) break;
        }
        return count == 1;
    }
}

