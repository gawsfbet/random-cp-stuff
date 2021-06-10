package aoc.y2020.day3;

import java.io.*;
import java.util.*;

public class Part1 {
    static int M = 1_000_000_007;

    private static int testCase(int n, char[][] a) {
        int col = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            if (a[i][col % a[i].length] == '#') {
                ans++;
            }

            col += 3;
        }

        return ans;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        try {
            FastScanner in = new FastScanner("input.txt");

            int n = 323;
            char[][] a = new char[n][31];

            for (int i = 0; i < n; i++) {
                a[i] = in.readCharArray(31);
            }

            out.println(testCase(n, a));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public FastScanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        }

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