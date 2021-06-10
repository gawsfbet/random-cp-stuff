package cf.R711;

import java.io.*;
import java.util.*;

public class B {
    static int M = 1_000_000_007;

    private static long testCase(int n, int W, int[] w) {
        int curr = 0, ans = 0;

        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int wi : w) {
            counts.put(wi, counts.getOrDefault(wi, 0) + 1);
        }

        while (!counts.isEmpty()) {
            curr = counts.lastKey();
            removeOne(counts, curr);

            while (counts.floorKey(W - curr) != null && curr + counts.floorKey(W - curr) <= W) {
                int next = counts.floorKey(W - curr);
                curr += next;
                removeOne(counts, next);
            }

            ans++;
        }

        return ans;
    }

    private static void removeOne(TreeMap<Integer, Integer> counts, int key) {
        int count = counts.getOrDefault(key, 0);

        if (count == 1) {
            counts.remove(key);
        } else {
            counts.put(key, count - 1);
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt(), W = in.nextInt();
            int[] w = in.readArray(n);

            out.println(testCase(n, W, w));
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

