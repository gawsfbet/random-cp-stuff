package cf.R725;

import java.io.*;
import java.util.*;

public class C {
    static int M = 1_000_000_007;
    static Random rng = new Random();

    private static long testCase(int n, int l, int r, int[] a) {
        long ans = 0;
        int i, j1, j2;

        sort(a);

        i = 0;
        j1 = n;
        j2 = n - 1;

        while (i < j2) {
            while (j1 > i + 1 && a[i] + a[j1 - 1] >= l) j1--;
            while (j2 >= j1 && a[i] + a[j2] > r) j2--;

            //System.out.println(i + ", " + j1 + ", " + j2);

            ans += count(Math.max(j1, i + 1), j2);
            i++;
        }

        return ans;
    }

    private static long count(int a, int b) {
        return Math.max(0, b - a + 1);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt(), l = in.nextInt(), r = in.nextInt();
            int[] a = in.readArray(n);

            out.println(testCase(n, l, r, a));
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
