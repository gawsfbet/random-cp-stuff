package cf.R670;

import java.io.*;
import java.util.*;

public class B {
    static int M = 1_000_000_007;

    private static long testCase(int n, int[] a) {
        //O(N) solution which is annoying af to type
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE, max5 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE, min4 = Integer.MAX_VALUE;

        long candidate1 = (long) max1 * max2 * max3 * max4 * max5;
        long candidate2 = (long) max1 * max2 * max3 * min1 * min2;
        long candidate3 = (long) max1 * min1 * min2 * min3 * min4;

        return Math.max(candidate1, Math.max(candidate2, candidate3));
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int[] a = in.readArray(n);

            out.println(testCase(n, a));
        }

        out.close();
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        boolean hasNext() {
            return st.hasMoreTokens();
        }

        char[] readCharArray(int n) {
            char[] arr = new char[n];
            try {
                br.read(arr);
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return arr;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
