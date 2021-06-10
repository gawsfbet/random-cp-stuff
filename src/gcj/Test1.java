package gcj;

import java.io.*;
import java.util.*;

public class Test1 {
    static int M = 1_000_000_007;

    private static boolean testCase(int n, int k, String s) {
        char[] chars = s.toCharArray();
        int numZeroes = 0, numOnes = 0, numAny = 0, prevNumAny = -1;

        for (int i = 0; i < n; i++) {
            if (chars[i] == '?') numAny++;
        }

        //preset
        while (numAny > 0 && prevNumAny != numAny) {
            prevNumAny = numAny;

            for (int i = k; i < n; i++) {
                if (chars[i] == '?' && chars[i - k] != '?') {
                    chars[i] = chars[i - k];
                    numAny--;
                }
            }

            for (int i = n - k - 1; i >= 0; i--) {
                if (chars[i] == '?' && chars[i + k] != '?') {
                    chars[i] = chars[i + k];
                    numAny--;
                }
            }



            numZeroes = 0;
            numOnes = 0;

            for (int i = 0; i < k; i++) {
                if (chars[i] == '0') numZeroes++;
                else if (chars[i] == '1') numOnes++;
            }

            for (int i = k; i < n; i++) {
                if (numZeroes > k / 2 || numOnes > k / 2) return false;

                if (numZeroes == k / 2) {
                    for (int j = i - k; j < i; j++) {
                        if (chars[j] == '?') {
                            chars[j] = '1';
                            numAny--;
                        }
                    }

                    numOnes = k / 2;
                } else if (numOnes == k / 2) {
                    for (int j = i - k; j < i; j++) {
                        if (chars[j] == '?') {
                            chars[j] = '0';
                            numAny--;
                        }
                    }

                    numZeroes = k / 2;
                }

                if (chars[i - k] == '0') {
                    numZeroes--;
                } else if (chars[i - k] == '1') {
                    numOnes--;
                }

                if (chars[i] == '0') {
                    numZeroes++;
                } else if (chars[i] == '1') {
                    numOnes++;
                }
            }
        }

        //System.out.println(new String(chars));

        return isValid(n, k, chars);
    }

    private static boolean isValid(int n, int k, char[] s) {
        int numZeroes = 0, numOnes = 0;

        for (int i = 0; i < k; i++) {
            if (s[i] == '0') {
                numZeroes++;
            } else if (s[i] == '1') {
                numOnes++;
            }
        }

        for (int i = k; i < n; i++) {
            if (numZeroes > k / 2 || numOnes > k / 2) {
                return false;
            }

            if (s[i - k] == '0') {
                numZeroes--;
            } else if (s[i - k] == '1') {
                numOnes--;
            }

            if (s[i] == '0') {
                numZeroes++;
            } else if (s[i] == '1') {
                numOnes++;
            }
        }

        if (numZeroes > k / 2 || numOnes > k / 2) {
            return false;
        } else {
            return true;
        }
    }

    public static double calculateExpected(char[] strat, double win, double draw) {
        double ans = 0, prR = 1.0 / 3, prP = 1.0 / 3, prS = 1.0 / 3;
        int pi = 0, ri = 0, si = 0;

        if (strat[0] == 'R') {
            ans += prS * win + prR * draw;
            ri++;
        } else if (strat[0] == 'P') {
            ans += prR * win + prP * draw;
            pi++;
        } else {
            ans += prP * win + prS * draw;
            si++;
        }

        for (int i = 1; i < 60; i++) {
            prR = (1.0 * si) / (pi + ri + si);
            prP = (1.0 * ri) / (pi + ri + si);
            prS = (1.0 * pi) / (pi + ri + si);

            if (strat[i] == 'R') {
                ans += prS * win + prR * draw;
                ri++;
            } else if (strat[i] == 'P') {
                ans += prR * win + prP * draw;
                pi++;
            } else {
                ans += prP * win + prS * draw;
                si++;
            }
        }

        return ans;
    }

    public static char[] generateStratGreedily(int win, int draw) {
        char[] res = new char[60];
        int pi = 0, ri = 1, si = 0;
        int prP, prR, prS;
        long wp, wr, ws;

        res[0] = 'R';

        for (int i = 1; i < 60; i++) {
            prR = si; //increases with more S played
            prP = ri; //increases with more R played
            prS = pi; //increases with more P played

            wp = win * prR + draw * prP; //win * si + draw * ri
            wr = win * prS + draw * prR; //win * pi + draw * si
            ws = win * prP + draw * prS; //win * ri + draw * pi

            if (wr > wp && wr > ws) {
                res[i] = 'R';
                ri++;
            } else if (ws > wp && ws > wr) {
                res[i] = 'S';
                si++;
            } else if (wp > ws && wp > wr) {
                res[i] = 'P';
                pi++;
            } else {
                if (wr == ws) {
                    if (prP > prS) {
                        res[i] = 'R';
                        ri++;
                    } else {
                        res[i] = 'S';
                        si++;
                    }
                } else if (wr == wp) {
                    if (prS > prR) {
                        res[i] = 'P';
                        pi++;
                    } else {
                        res[i] = 'R';
                        ri++;
                    }
                } else if (ws == wp) {
                    if (prR > prP) {
                        res[i] = 'S';
                        si++;
                    } else {
                        res[i] = 'P';
                        pi++;
                    }
                } else {
                    assert false;
                }
            }
        }

        System.out.println(new String(res));

        return res;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        /*int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //in.nextLine();
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt(), k = in.nextInt();
            String s = in.next();

            out.println(testCase(n, k, s) ? "YES" : "NO");
        }*/

        char[] strat0 = new char[60], strat1 = new char[60], strat2 = new char[60], strat3 = new char[60];

        for (int i = 0; i < 60; i++) {
            strat0[i] = 'R';

            if (i % 3 == 0) {
                strat1[i] = 'R';
            } else if (i % 3 == 1) {
                strat1[i] = 'P';
            } else {
                strat1[i] = 'S';
            }

            if (i % 3 == 0) {
                strat2[i] = 'R';
            } else if (i % 3 == 1) {
                strat2[i] = 'S';
            } else {
                strat2[i] = 'P';
            }
        }

       // out.println(calculateExpected(strat0, 1, 0));
        out.println(calculateExpected(strat1, 1, 0));
        out.println(calculateExpected(generateStratGreedily(2, 1), 1, 0.5));
        //out.println(calculateExpected(generateStratGreedily(1, 0), 1, 0));

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