package cf.R725;

import java.io.*;
import java.util.*;

public class G {
    static int M = 1_000_000_007;
    static Random rng = new Random();

    private static long testCase(long x, long y, long a, long b) {
        if (x < y) {
            long temp = x;
            x = y;
            y = temp;
        }

        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        if (a > b) {
            if (x - (a * (y / b)) >= 0) {
                return y / b;
            } else {
                long additional = (x - y) / (a - b);

                x -= additional * a;
                y -= additional * b;

                long pairs = y / (a + b);
                x -= pairs * (a + b);
                y -= pairs * (a + b);

                return additional + (pairs << 1) + (x >= a && y >= b ? 1 : 0);
            }
        } else {
            return y / b;
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            long x = in.nextLong(), y = in.nextLong(), a = in.nextLong(), b = in.nextLong();

            out.println(testCase(x, y, a, b));
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

    private static void sort(int[] arr) {
        int temp, idx;

        for (int i = arr.length - 1; i > 0; i--) {
            idx = rng.nextInt(i + 1);

            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        Arrays.sort(arr);
    }

    private static void sort(long[] arr) {
        long temp;
        int idx;

        for (int i = arr.length - 1; i > 0; i--) {
            idx = rng.nextInt(i + 1);

            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        Arrays.sort(arr);
    }

    private static <T> void sort(T[] arr) {
        T temp;
        int idx;

        for (int i = arr.length - 1; i > 0; i--) {
            idx = rng.nextInt(i + 1);

            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        Arrays.sort(arr);
    }

    private static <T> void sort(T[] arr, Comparator<? super T> cmp) {
        T temp;
        int idx;

        for (int i = arr.length - 1; i > 0; i--) {
            idx = rng.nextInt(i + 1);

            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        Arrays.sort(arr, cmp);
    }

    private static <T extends Comparable<? super T>> void sort(ArrayList<T> list) {
        T temp;
        int idx;

        for (int i = list.size() - 1; i > 0; i--) {
            idx = rng.nextInt(i + 1);

            temp = list.get(i);
            list.set(i, list.get(idx));
            list.set(idx, temp);
        }

        Collections.sort(list);
    }

    private static <T> void sort(ArrayList<T> list, Comparator<? super T> cmp) {
        T temp;
        int idx;

        for (int i = list.size() - 1; i > 0; i--) {
            idx = rng.nextInt(i + 1);

            temp = list.get(i);
            list.set(i, list.get(idx));
            list.set(idx, temp);
        }

        Collections.sort(list, cmp);
    }
}
