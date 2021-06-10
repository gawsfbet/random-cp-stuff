package gcj.yr2021.b;

import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(int x, int y, String s) {
        int ans = 0;

        s = s.replaceAll("\\?", "");

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 'C' && s.charAt(i) == 'J') {
                ans += x;
            } else if (s.charAt(i - 1) == 'J' && s.charAt(i) == 'C') {
                ans += y;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int x = in.nextInt(), y = in.nextInt();
            String s = in.next();

            out.println(String.format("Case #%s: %d", t0, testCase(x, y, s)));
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
