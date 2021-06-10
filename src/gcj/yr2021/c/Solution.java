package gcj.yr2021.c;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Solution {

    public static int[] testCase(int n, int c) {
        if (c < n - 1 || c > ((n * (n + 1)) >> 1) - 1) {
            return null;
        } else {
            int ans[] = IntStream.range(1, n + 1).toArray();

            for (int i = n - 2; i >= 0; i--) {
                //if (c == i + 1) break;

                if (c - n + 1 > 0) {
                    //c = c - n + i
                    c -= reverse(ans, i, n - 1);
                } else {
                    c -= reverse(ans, i,c - 1);
                    assert c == i + 1;
                }

                //System.out.println("Remaining cost: " + c);
            }

            //System.out.println(Arrays.toString(ans) + ": " + cost(Arrays.copyOf(ans, ans.length)));

            return ans;
        }
    }

    public static int cost(int[] l) {
        int ans = 0;

        for (int i = 1; i < l.length; i++) {
            int idx = i - 1;

            while (l[idx] != i) idx++;

            ans += reverse(l, i - 1, idx);
        }

        return ans;
    }


    public static int reverse(int[] arr, int start, int end) {
        int temp;

        //assert start <= end;
        //System.out.println("Reversing from " + start + " to " + end);

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
            int n = in.nextInt(), c = in.nextInt();

            int[] res = testCase(n, c);

            if (res == null) {
                out.println(String.format("Case #%s: IMPOSSIBLE", t0));
            } else {
                out.print(String.format("Case #%s:", t0));

                for (int re : res) {
                    out.print(" " + re);
                }

                out.println();
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
