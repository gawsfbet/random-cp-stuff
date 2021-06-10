package aoc.day1;

import java.io.*;
import java.util.*;

public class Part1 {

    public static void main(String[] args) throws Exception {
        File file = new File("resources/data.txt");
        Scanner fileScanner = new Scanner(file);
        ArrayList<Integer> inputs = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            inputs.add(fileScanner.nextInt());
        }

        int ans = inputs.stream().reduce(0, (Integer total, Integer next) -> total + getFuel(next));

        System.out.println(ans);
    }

    private static int getFuel(int mass) {
        return (mass / 3) - 2;
    }
}
