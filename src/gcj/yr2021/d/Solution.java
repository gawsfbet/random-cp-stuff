package gcj.yr2021.d;

import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(FastScanner in, PrintWriter out, int n) {
        int res, low, high, start, end;

        ArrayList<Integer> arr = new ArrayList<>();

        res = query(in, out, 1, 2, 3);

        if (res == 1) {
            arr.add(2);
            arr.add(1);
            arr.add(3);
        } else if (res == 2) {
            arr.add(1);
            arr.add(2);
            arr.add(3);
        } else {
            arr.add(2);
            arr.add(3);
            arr.add(1);
        }

        outer:
        for (int i = 4; i <= n; i++) {
            start = 0;
            end = arr.size() - 1;

            while (start + 1 < end) {
                low = start + ((end - start) / 3);
                high = end - ((end - start) / 3);

                System.err.println(low + "," + high);

                res = query(in, out, arr.get(low), i, arr.get(high));

                if (res == arr.get(low)) {
                    if (low == start) {
                        arr.add(start, i);
                        continue outer;
                    } else {
                        end = low;
                    }
                } else if (res == arr.get(high)) {
                    if (high == end) {
                        arr.add(end + 1, i);
                        continue outer;
                    } else {
                        start = high;
                    }
                } else if (res == i) {
                    if (low + 1 == high) {
                        arr.add(high, i);
                        continue outer;
                    } else {
                        start = low;
                        end = high - 1;
                    }
                }
            }

            res = query(in, out, arr.get(start), i, arr.get(end));

            if (res == arr.get(start)) {
                arr.add(start, i);
            } else if (res == arr.get(end)) {
                arr.add(end + 1, i);
            } else if (res == i) {
                arr.add(end, i);
            }
        }

        return answer(in, out, arr) ? 0 : 1;
    }

    private static int query(FastScanner in, PrintWriter out, int x1, int x2, int x3) {
        out.println(String.format("%d %d %d", x1, x2, x3));
        out.flush();

        return in.nextInt();
    }

    private static boolean answer(FastScanner in, PrintWriter out, ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            out.print(arr.get(i) + " ");
        }

        out.println(arr.get(arr.size() - 1));
        out.flush();

        if (in.nextInt() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), n = in.nextInt(), q = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int val = testCase(in, out, n);

            if (val != 0) {
                System.exit(val);
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
