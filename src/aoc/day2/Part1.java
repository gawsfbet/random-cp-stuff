package aoc.day2;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws Exception {
        File file = new File("resources/data.txt");
        Scanner fileScanner = new Scanner(file);

        Integer[] inputs = Arrays.stream(fileScanner.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int i = 0;

        inputs[1] = 12;
        inputs[2] = 2;
        while (inputs[i] != 99) {
            int input1 = inputs[i + 1];
            int input2 = inputs[i + 2];
            int output = inputs[i + 3];

            if (inputs[i] == 1) {
                inputs[output] = inputs[input1] + inputs[input2];
            } else if (inputs[i] == 2) {
                inputs[output] = inputs[input1] * inputs[input2];
            } else {
                System.out.println("Unknown value: " + inputs[i]);
            }

            i += 4;
        }

        System.out.println(inputs[0]);
    }
}
