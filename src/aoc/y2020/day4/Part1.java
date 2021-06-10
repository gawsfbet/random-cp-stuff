package aoc.y2020.day4;

import java.io.*;
import java.util.*;

public class Part1 {
    static int M = 1_000_000_007;

    private static int testCase(List<String> passports) {
        int ans = 0;

        for (String passport : passports) {
            if (passport.contains("byr:") && passport.contains("iyr:") && passport.contains("eyr:") && passport.contains("hgt:") && passport.contains("hcl:") && passport.contains("ecl:") && passport.contains("pid:")) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        try {
            FastScanner in = new FastScanner("input.txt");

            List<String> passports = new ArrayList<>();
            String segment;

            while (!(segment = in.readSegment()).isEmpty()) {
                passports.add(segment);
            }

            out.println(testCase(passports));
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
