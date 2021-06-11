package cf.R725;

import java.io.*;
import java.util.*;

public class D {
    static int M = 1_000_000_007;

    private static boolean testCase(int a, int b, int k) {
        List<Integer> pfA = primeFactors(a), pfB = primeFactors(b);
        int commonElems = longestCommonSubsequence(pfA, pfB);
        int remA = pfA.size() - commonElems, remB = pfB.size() - commonElems;
        int min, max = pfA.size() + pfB.size();

        if (remA == 0 && remB == 0) {
            return k > 1 && k <= 2 * pfA.size();
        } else if (remA > 0 && remB > 0) {
            min = 2;
        } else {
            min = 1;
        }

        return min <= k && k <= max;
    }

    private static List<Integer> primeFactors(int number) {
        int n = number;

        List<Integer> factors = new ArrayList<>();

        while (n > 1 && n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; n > 1 && i * i <= n; i += 2) {
            while (n > 1 && n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static int longestCommonSubsequence(List<Integer> list1, List<Integer> list2) {
        int[][] memo = new int[list1.size() + 1][list2.size() + 1];

        for (int i = list1.size() - 1; i >= 0; i--) {
            for (int j = list2.size() - 1; j >= 0; j--) {
                if (list1.get(i).equals(list2.get(j))) {
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                } else {
                    memo[i][j] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }

        return memo[0][0];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            int a = in.nextInt(), b = in.nextInt(), k = in.nextInt();

            out.println(testCase(a, b, k) ? "YES" : "NO");
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
