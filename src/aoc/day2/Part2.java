package aoc.day2;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws Exception {
        File file = new File("resources/data.txt");
        Scanner fileScanner = new Scanner(file);

        Integer[] inputs = Arrays.stream(fileScanner.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        for (int i1 = 0; i1 < 100; i1++) {
            for (int i2 = 0; i2 < 100; i2++) {
                int ans = calculate(Arrays.copyOf(inputs, inputs.length), i1, i2);

                if (ans == 19690720) {
                    System.out.println(100 * i1 + i2);
                    break;
                }
            }
        }
    }

    private static int calculate(Integer[] array, int noun, int verb) {
        int i = 0;
        array[1] = noun;
        array[2] = verb;
        while (array[i] != 99) {
            int input1 = array[i + 1];
            int input2 = array[i + 2];
            int output = array[i + 3];

            if (array[i] == 1) {
                array[output] = array[input1] + array[input2];
            } else if (array[i] == 2) {
                array[output] = array[input1] * array[input2];
            } else {
                System.out.println("Unknown value: " + array[i]);
            }

            i += 4;
        }

        return array[0];
    }
}
