import java.util.Arrays;

// Determine what pair of inputs produces the output 19690720. The inputs should still be provided to the program by
// replacing the values at addresses 1 (the 'noun') and 2 (the 'verb'), just like before. Each of the two input values
// will be between 0 and 99, inclusive. Once the program has halted, its output is available at address 0, also just
// like before. Each time you try a pair of inputs, reset the computer's memory to the values in the program (your
// puzzle input). Find the input noun and verb that cause the program to produce the output 19690720.
// What is 100 * noun + verb? (For example, if noun=12 and verb=2, the answer would be 1202.)

public class Day2b {

    public static int[] runIntCode(int[] intCode) {
        int pointer = 0;
        while ((pointer < intCode.length) && (intCode[pointer] != 99)) {
            int[] subArray = Arrays.copyOfRange(intCode, pointer, pointer+4);
            Instruction instr = new Instruction(subArray);
            System.out.println(instr.toString());
            intCode = instr.readOpcode(intCode);
            // for invalid opcodes
            if (intCode == null) {
                return null;
            }
            pointer += 4;
            }
        return intCode;
    }

    public static int tryPair(int[] input) {
        System.out.println(Arrays.toString(input));
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                System.out.println("noun = " + noun +", verb = " + verb);
                int[] intCode = input.clone();
                intCode[1] = noun;
                intCode[2] = verb;
                int[] result = runIntCode(intCode);
                if (result != null) {
                    int output = result[0];
                    if (output == 19690720) {
                        return (100 * noun + verb);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] input = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,2,23,9,27,1,5,27,31,1,9,31,35,1,35,10,39,2,13,39,43,1,43,9,47,1,47,9,51,1,6,51,55,1,13,55,59,1,59,13,63,1,13,63,67,1,6,67,71,1,71,13,75,2,10,75,79,1,13,79,83,1,83,10,87,2,9,87,91,1,6,91,95,1,9,95,99,2,99,10,103,1,103,5,107,2,6,107,111,1,111,6,115,1,9,115,119,1,9,119,123,2,10,123,127,1,127,5,131,2,6,131,135,1,135,5,139,1,9,139,143,2,143,13,147,1,9,147,151,1,151,2,155,1,9,155,0,99,2,0,14,0};

        // answer
        int output = tryPair(input);
        System.out.println("Answer = " + output);
    }
}
