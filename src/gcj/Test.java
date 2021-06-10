package gcj;

import java.util.*;
import java.io.*;

public class Test {

    static TreeSet<Integer> set = generate();

    public static long testCase(long y) {
        if (y < 10) {
            return 12;
        } else {
            long ans = Long.MAX_VALUE;
            String yString = Long.toString(y);
            StringBuilder sb = new StringBuilder(), sb1;
            long d9 = 9;

            for (int i = 0; i < yString.length(); i++) {
                sb.append(yString.charAt(i));
                long curr = Long.parseLong(sb.toString());

                ans = Math.min(ans, get(curr, y));
                ans = Math.min(ans, get(curr + 1, y));
            }

            for (int m = 1; m <= Long.MAX_VALUE / 10 && m <= y; m *= 10) {
                ans = Math.min(ans, get(m, y));
            }

            for (long i = d9; i <= Long.MAX_VALUE / 10 && i <= y; i = (i * 10) + 9) {
                for (long j = i; last(j, y); j--) {
                    ans = Math.min(ans, get(j, y));
                }
            }

            return ans;
        }
    }

    private static boolean last(long curr, long y) {
        long start = curr;
        boolean added = false;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(curr++);

        while (isParseable(sb1.toString()) && Long.parseLong(sb1.toString()) <= y) {
            added = true;
            sb1.append(curr);
            curr++;
        }

        if (added && isParseable(sb1.toString())) {
            return Long.toString(start).length() != Long.toString(curr).length();
        } else {
            return true;
        }
    }

    private static long get(long curr, long y) {
        //System.out.println("Starting from " + curr);
        boolean added = false;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(curr++);

        while (isParseable(sb1.toString()) && Long.parseLong(sb1.toString()) <= y) {
            added = true;
            sb1.append(curr);
            curr++;
        }

        if (added && isParseable(sb1.toString())) {
            //System.out.println(sb1.toString());
            return Long.parseLong(sb1.toString());
        } else {
            //System.out.println();
            return Long.MAX_VALUE;
        }
    }

    private static boolean isParseable(String s) {
        try {
            long l = Long.parseLong(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private static long testCaseExpected(long y) {
        set.add(998999);
        set.add(1234567);
        return set.higher((int) y);
    }

    private static TreeSet<Integer> generate() {
        int limit = 1000000;
        TreeSet<Integer> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 998; i++) {
            int j = i;
            sb = new StringBuilder(Integer.toString(j));

            while (Integer.parseInt(sb.toString()) <= limit) {
                sb.append(++j);

                if (Integer.parseInt(sb.toString()) <= limit) {
                    set.add(Integer.parseInt(sb.toString()));
                }
            }
        }

        return set;
    }

    private static int not(int b) {
        int mask = b;

        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;

        return ~b & mask;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        Random rng = new Random();
        for (int t0 = 0; t0 <= t; ++t0) {
            System.out.println(t0 + "," + not(t0));

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

