package gcj;

import java.util.*;
import java.io.*;

public class Main {
    private static final int M = 1_000_000_007;

    public static int testCase(int n, int k, String s) {
        long ans = 0, mul = 1;
        //char[] halfLatest = getLatestString(n, s);
        String latest = getLatestPalidrome(n, s);

        for (int i = ((n + 1) / 2) - 1; i >= 0; i--) {
            ans = (ans + mul * (latest.charAt(i) - 'a')) % M;
            mul = (mul * k) % M;
        }

        //System.out.println(latest);

        return (int) ((ans + 1) % M);
    }

    public static String getLatestPalidrome(int n, String s) {
        char[] res = new char[n];
        char c;
        String resStr;

        for (int i = 0; i < (n + 1) / 2; i++) {
            res[i] = s.charAt(i);
            res[n - 1 - i] = s.charAt(i);
        }

        resStr = new String(res);

        if (resStr.compareTo(s) < 0) {
            return resStr;
        } else {
            if (n % 2 == 0) {
                res[n / 2 - 1]--;
                res[n / 2]--;
            } else {
                res[n / 2]--;
            }

            return new String(res);
        }
    }

    /*public static char[] getLatestString(int n, String s) {
        char[] res = new char[(n + 1) / 2];
        char c;

        for (int i = 0; i < res.length; i++) {
            c = (char) Math.min(s.charAt(i), s.charAt(n - 1 - i));
            res[i] = c;
        }

        return res;
    }*/

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int n = in.nextInt(), k = in.nextInt();
            String s = in.next();

            out.println(String.format("Case #%s: %d", t0, testCase(n, k, s)));
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
