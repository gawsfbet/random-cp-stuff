package gcj.yr2021.a;

import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(int n, int[] l) {
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int idx = i - 1;

            while (l[idx] != i) idx++;

            ans += reverse(l, i - 1, idx);
        }

        return ans;
    }

    public static int reverse(int[] arr, int start, int end) {
        int temp;

        for (int i = 0; start + i < end - i; i++) {
            temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int n = in.nextInt();
            int[] l = in.readArray(n);

            out.println(String.format("Case #%s: %d", t0, testCase(n, l)));
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

