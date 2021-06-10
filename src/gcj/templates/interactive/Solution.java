package gcj.templates.interactive;

import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(FastScanner in, PrintWriter out, int low, int high, int n) {
        int mid;
        String ans;

        while (low <= high) {
            mid = low + (high - low) / 2;

            out.println(mid);
            out.flush();

            ans = in.next();

            if (ans.equals("TOO_BIG")) {
                high = mid - 1;
            } else if (ans.equals("TOO_SMALL")) {
                low = mid + 1;
            } else if (ans.equals("CORRECT")) {
                return 0;
            } else {
                return 1;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int a = in.nextInt(), b = in.nextInt();
            int n = in.nextInt();

            int val = testCase(in, out, a + 1, b, n);

            if (val != 0) {
                System.exit(val);
            }
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