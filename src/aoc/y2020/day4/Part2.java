package aoc.y2020.day4;

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class Part2 {
    static int M = 1_000_000_007;

    private static int testCase(List<String> passports) {
        int ans = 0;
        boolean isValid;

        for (String passport : passports) {
            isValid = true;

            Pattern byrPattern = Pattern.compile(".*byr:(\\d{4}).*");
            Pattern iyrPattern = Pattern.compile(".*iyr:(\\d{4}).*");
            Pattern eyrPattern = Pattern.compile(".*eyr:(\\d{4}).*");
            Pattern hgtPattern = Pattern.compile(".*hgt:(\\d+)(cm|in).*");
            Pattern hclPattern = Pattern.compile(".*hcl:#[0-9a-f]{6}.*");
            Pattern eclPattern = Pattern.compile(".*ecl:(?:amb|blu|brn|gry|grn|hzl|oth).*");
            Pattern pidPattern = Pattern.compile(".*pid:\\d{9}.*");

            Matcher byrMatcher = byrPattern.matcher(passport);
            Matcher iyrMatcher = iyrPattern.matcher(passport);
            Matcher eyrMatcher = eyrPattern.matcher(passport);
            Matcher hgtMatcher = hgtPattern.matcher(passport);
            Matcher hclMatcher = hclPattern.matcher(passport);
            Matcher eclMatcher = eclPattern.matcher(passport);
            Matcher pidMatcher = pidPattern.matcher(passport);

            if (byrMatcher.matches()) {
                int byr = Integer.parseInt(byrMatcher.group(1));

                if (byr < 1920 || byr > 2002) {
                    isValid = false;
                }

                //System.out.println(byr + " byr is valid");
            } else {
                isValid = false;
            }

            if (iyrMatcher.matches()) {
                int iyr = Integer.parseInt(iyrMatcher.group(1));

                if (iyr < 2010 || iyr > 2020) {
                    isValid = false;
                }

                //System.out.println(iyr + " iyr is valid");
            } else {
                isValid = false;
            }

            if (eyrMatcher.matches()) {
                int eyr = Integer.parseInt(eyrMatcher.group(1));

                if (eyr < 2020 || eyr > 2030) {
                    isValid = false;
                }
            } else {
                isValid = false;
            }

            if (hgtMatcher.matches()) {
                String uom = hgtMatcher.group(2);
                int value = Integer.parseInt(hgtMatcher.group(1));

                if (uom.equals("in")) {
                    if (59 > value || value > 76) {
                        isValid = false;
                        //System.out.println(hgtMatcher.group(1) + " hgt in is valid");
                    }
                    //System.out.println(value + uom);
                } else if (uom.equals("cm")) {
                    if (150 > value || value > 193) {
                        isValid = false;
                        //System.out.println(hgtMatcher.group(1) + " hgt cm is valid");
                    }
                    System.out.println(value + uom);
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }

            if (!hclMatcher.matches()) {
                isValid = false;
            }

            if (!eclMatcher.matches()) {
                isValid = false;
            }

            if (!pidMatcher.matches()) {
                isValid = false;
            }

            if (isValid) {
                //System.out.println(passport + " is valid.");
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
