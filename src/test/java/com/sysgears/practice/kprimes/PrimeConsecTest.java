package com.sysgears.practice.kprimes;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeConsecTest {

    private static void testing(int k, long[] arr, int expected) {
        assertEquals(expected, PrimeConsec.consecKprimes(k, arr));
    }
    @Test
    public void test() {
        System.out.println("Basic Tests consecKprimes");
        testing(6, new long[] {10098}, 0);
        testing(6, new long[] {10176, 10164}, 0);
        testing(5, new long[] {10116, 10108, 10092, 10104, 10100, 10096, 10088}, 6);
        testing(5, new long[] {10188, 10192, 10212, 10184, 10200, 10208}, 1);
        testing(4, new long[] {10175, 10185, 10180, 10197}, 3);

        testing(2, new long[] {10081, 10071, 10077, 10065, 10060, 10070, 10086, 10083, 10078, 10076, 10089, 10085, 10063, 10074, 10068, 10073, 10072, 10075}, 2);
        testing(5, new long[] {11056, 10952, 10928, 10856, 10998, 10768, 11016, 11032, 10875, 10976, 10878, 10968, 11004, 10816, 10904, 10956, 10830, 10989, 10812, 10935, 10900, 10881, 10840, 10860, 11050, 11052, 10850, 10760, 11040, 11020, 10776, 10832, 10868, 10792, 10948, 10950, 10788, 10808}, 27);

    }
}