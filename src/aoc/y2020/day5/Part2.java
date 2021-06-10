package aoc.y2020.day5;

import java.io.*;
import java.util.*;

public class Part2 {
    static int M = 1_000_000_007;

    private static int testCase(int n, String[] p) {
        int low, high, left, right;
        boolean[] hasSeat = new boolean[1024];

        for (String s : p) {
            low = 0;
            high = 127;
            left = 0;
            right = 7;

            for (int i = 0; i < 7; i++) {
                //System.out.println(low + "," + high);
                switch (s.charAt(i)) {
                    case 'F':
                        high = (low + high) >> 1;
                        break;
                    case 'B':
                        low = ((low + high) >> 1) + 1;
                        break;
                }
            }

            assert low == high;

            for (int i = 7; i < 10; i++) {
                //System.out.println(left + "," + right);
                switch (s.charAt(i)) {
                    case 'L':
                        right = (left + right) >> 1;
                        break;
                    case 'R':
                        left = ((left + right) >> 1) + 1;
                        break;
                }
            }

            assert left == right;

            //System.out.println(low + "," + left);

            hasSeat[(low << 3) + left] = true;
        }

        for (int i = 1; i < 1023; i++) {
            if (!hasSeat[i] && (hasSeat[i - 1] && hasSeat[i + 1])) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        try {
            FastScanner in = new FastScanner("input.txt");

            int n = 940;
            String[] p = new String[n];

            for (int i = 0; i < n; i++) {
                p[i] = in.next();
            }

            out.println(testCase(n, p));
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

        String readSegment() {
            StringBuilder sb = new StringBuilder();

            try {
                String line;
                while ((line = br.readLine()) != null) {
                    if(!line.isEmpty()){
                        sb.append(line);
                        sb.append(' ');
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return sb.toString();
        }

        boolean hasNext() throws IOException {
            return br.readLine() != null;
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
