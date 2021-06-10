import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(int n, String wall) {
        int curr = 0, max, start = 0, end;
        int sections = (n + 1) / 2;

        for (end = 0; end < sections; end++) {
            curr += wall.charAt(end) - '0';
        }

        max = curr;

        while (end < n) {
            curr -= wall.charAt(start) - '0';
            curr += wall.charAt(end) - '0';

            start++;
            end++;

            max = Math.max(max, curr);
        }

        return max;
    }

    private static int getTideChange(int currTime, int k) {
        if (currTime % (2 * k) <= k) {
            return currTime % (2 * k);
        } else {
            return (2 * k) - currTime % (2 * k);
        }
    }

    public static void main(String[] args) {
        System.out.println(getTideChange(0, 2));
        System.out.println(getTideChange(1, 2));
        System.out.println(getTideChange(2, 2));
        System.out.println(getTideChange(3, 2));
        System.out.println(getTideChange(4, 2));
    }
}
