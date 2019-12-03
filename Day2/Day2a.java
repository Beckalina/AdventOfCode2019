import java.util.Arrays;

// An Intcode program is a list of integers separated by commas (like 1,0,0,3,99). To run one, start by looking at the
// first integer (called position 0). Here, you will find an opcode - either 1, 2, or 99.
// Opcode 1 = adds together numbers read from position 1 and 2 and stores the result in the position indicated in
// position 3.
// Opcode 2 = the same as opcode 1, but multiply instead of add
// Opcode 99 = halt the programme

public class Day2a {
    // For the group of 4, positions 0,1,2,3 are here i,x,y,z
    public static int[] checkOpcode(int i, int[] input) {
        int x = input[i+1];
        int y = input[i+2];
        int z = input[i+3];
        if (input[i] == 1) {
            input[z] = input[x] + input[y];
            System.out.println(Arrays.toString(input));
            return input;
        }
        else if (input[i] == 2) {
            input[z] = input[x] * input[y];
            System.out.println(Arrays.toString(input));
            return input;
        }
        else {
            System.out.println("Something went wrong");
            System.out.println("Unknown opcode: " + input[i]);
            return null;
        }
    }

    public static void main(String[] args) {

        int[] input = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,2,23,9,27,1,5,27,31,1,9,31,35,1,35,10,39,2,13,39,43,1,43,9,47,1,47,9,51,1,6,51,55,1,13,55,59,1,59,13,63,1,13,63,67,1,6,67,71,1,71,13,75,2,10,75,79,1,13,79,83,1,83,10,87,2,9,87,91,1,6,91,95,1,9,95,99,2,99,10,103,1,103,5,107,2,6,107,111,1,111,6,115,1,9,115,119,1,9,119,123,2,10,123,127,1,127,5,131,2,6,131,135,1,135,5,139,1,9,139,143,2,143,13,147,1,9,147,151,1,151,2,155,1,9,155,0,99,2,0,14,0};

        // restore the program to the "1202 program alarm" state it had just before the last computer caught fire
        input[1] = 12;
        input[2] = 2;
        System.out.println(Arrays.toString(input));

        int i = 0;
        while ((i < input.length) && (input[i] != 99)) {
            System.out.println(input[i]);
            input = checkOpcode(i, input);
            i += 4;
        }
        System.out.println(Arrays.toString(input));
    }
}
