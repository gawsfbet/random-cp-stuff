package gcj;

import java.io.*;
import java.util.*;

public class Generator {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = 1900;

        for (int i = 0; i < n; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }

        for (int i = 0; i < n; i++) {
            sb.append("zyxwvutsrqponmlkjihgfedcba");
        }


        System.out.println(sb.toString());

    }

    public static void bleh(String[] args) {
        Random r = new Random();
        int m = 20;
        int n = 20;
        int[] a = new int[m], b = new int[n];

        for (int i = 0; i < m; i++) {
            a[i] = 1;//r.nextInt(2);
        }

        for (int i = 0; i < n; i++) {
            b[i] = 1;//r.nextInt(2);
        }

        System.out.println("(" + Arrays.toString(a) + "," + Arrays.toString(b) + ")");

    }
}
