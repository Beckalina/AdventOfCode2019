import java.util.Arrays;

public class Instruction {
    int[] subArray;
    int opcode;
    int par1;
    int par2;
    int par3;


    public Instruction(int[] subArray) {
        this.subArray = subArray;
        opcode = subArray[0];
        par1 = subArray[1];
        par2 = subArray[2];
        par3 = subArray[3];

    }

    @Override
    public String toString() {
        return "Instruction{" +
                "subArray=" + Arrays.toString(subArray) +
                '}';
    }


    public int[] readOpcode(int[] intCode) {
        if (opcode == 1) {
            intCode[par3] = intCode[par1] + intCode[par2];
            System.out.println(Arrays.toString(intCode));
            return intCode;
        }
        else if (opcode == 2) {
            intCode[par3] = intCode[par1] * intCode[par2];
            System.out.println(Arrays.toString(intCode));
            return intCode;
        }
        else {
            System.out.println("Unknown opcode: " + opcode);
            return null;
        }
    }
}
