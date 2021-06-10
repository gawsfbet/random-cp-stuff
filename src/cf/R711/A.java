package cf.R711;

import java.io.*;
import java.util.*;

public class A {
    static int M = 1_000_000_007;

    private static long testCase(long n) {
        while (n % 3 != 0) {
            if (gcdSum(n) > 1) {
                break;
            }

            n++;
        }

        return n;
    }

    private static long gcdSum(long n) {
        long d = 0, num = n;

        while (num > 0) {
            d += num % 10;
            num /= 10;
        }

        return gcd(n, d);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            long n = in.nextLong();

            out.println(testCase(n));
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
