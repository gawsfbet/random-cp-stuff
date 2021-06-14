package gcj;

import java.util.*;
import java.io.*;

public class Solution {
    private static final int M = 1_000_000_007;
    private static Random rng = new Random();

    public static String testCase(int x, int w, int e) {
        char[] ans = new char[60];
        long curr = 0;

        if (e == w) {
            for (int i = 0; i < 60; i++) {
                if (i % 3 == 0) {
                    ans[i] = 'R';
                } else if (i % 3 == 1) {
                    ans[i] = 'P';
                } else {
                    ans[i] = 'S';
                }
            }
        } else {
            if (e == 0) {
                ans = generateStratGreedily(1, 0);
            } else {
                ans = generateStratGreedily(w / e, 1);
            }
        }

        //System.out.println(sums);

        return new String(ans);
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

        return res;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), x = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int w = in.nextInt(), e = in.nextInt();

            out.println(String.format("Case #%s: %s", t0, testCase(x, w, e)));
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
