package gcj;

import java.util.*;
import java.io.*;

public class Test {

    static Random rng = new Random();

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

    private static int count(int a, int b) {
        return b - a + 1;
    }

    private static long testCaseExpected(int n, int l, int r, int[] a) {
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (l <= a[i] + a[j] && a[i] + a[j] <= r) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int[] generate(int n) {
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = 1 + rng.nextInt(100);
        }

        return res;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = 1000;//in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int t0 = 0; t0 <= t; ++t0) {
            int n = 10;
            int l = n, r = 2 * n;
            int[] a = generate(n);

            long expected = testCaseExpected(n, l, r, a), actual = testCase(n, l, r, a);


            if (expected != actual) {
                System.out.println(String.format("%s, %s, %s, %s, expected: %d, actual: %d", n, l, r, Arrays.toString(a), expected, actual));
            } else {
                //System.out.println(String.format("%s, %s", expected, actual));
            }

            //out.println(String.format("Case #%s: %s", t0, ans));
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

