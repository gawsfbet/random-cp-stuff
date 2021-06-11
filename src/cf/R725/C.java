package cf.R725;

import java.io.*;
import java.util.*;

public class C {
    static int M = 1_000_000_007;

    private static long testCase(int n, int l, int r, int[] a) {
        long ans = 0;
        int i, j1, j2;

        Arrays.sort(a);

        for (i = 0; i < n; i++) {
            //find a[j] s.t. l - a[i] <= a[j] <= r - a[i]
            //y = -x - 1 -> -y - 1 = x
            j1 = binarySearch(a, l - a[i], true);
            j2 = binarySearch(a, r - a[i], false);

            //System.out.println(a[i] + ": " + j1 + "," + j2);

            if (i < j1) {
                ans += count(j1, j2);
            } else if (i < j2) {
                ans += count(i + 1, j2);
            }
        }

        return ans;
    }

    private static int binarySearch(int[] arr, int key, boolean isLeft) {
        int low = 0, high = isLeft ? arr.length : arr.length - 1;

        while (low < high) {
            int mid;

            if (isLeft) {
                mid = (low + high) / 2;
                //find first index such that a[i] >= key
                if (arr[mid] >= key) {
                    high = mid;
                } else { //arr[mid] < key
                    low = mid + 1;
                }
            } else {
                mid = (low + high + 1) / 2;
                //find first index such that a[i] <= key
                if (arr[mid] <= key) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return low;
    }

    private static int testCase2(int n, int l, int r, int[] a) {
        int ans = 0;
        int i, j1, j2;

        Arrays.sort(a);

        i = 0;
        j1 = 1;
        j2 = n - 1 ;

        while (j1 < n - 1 && a[i] + a[j1] < l) j1++;
        while (j1 < j2 && a[i] + a[j2] > r) j2--;

        System.out.println(j1 + "," + j2);

        while (i < j2) {
            ans += count(j1, j2);

            i++;

            while (i + 1 < j1 && a[i] + a[j1 - 1] >= l) j1--;
            while (i < j2 && a[i] + a[j2] > r) j2--;

            if (i == j1) {
                j1 = i + 1;
            }

            System.out.println(j1 + "," + j2);
        }

        return ans;
    }

    private static long count(int a, int b) {
        return b - a + 1;
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
}
