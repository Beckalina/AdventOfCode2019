import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// Part b extends part a with recursion.
// For each module mass, calculate its fuel and add it to the total. Then, treat the fuel amount you just calculated as
// the input mass and repeat the process, continuing until a fuel requirement is zero or negative. E.g. the total fuel
// required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.

public class Day1b {
    // calls recursively while f is positive
    public static int calculateFuel(int mass, int total) {
        double f = (Math.floor(mass/3)) - 2;
        if (f <= 0) {
            return total;
        }
        else {
            total += (int)f;
            return(calculateFuel((int)f, total));
        }
    }

    public static void main(String[] args) throws Exception {
        // mass of modules
        ArrayList<Integer> modules = new ArrayList<>();
        // total fuel requirement per module
        ArrayList<Integer> fuelRequirements = new ArrayList<>();

        File file = new File("Day1\\Day1_input.txt");
        Scanner sc = new Scanner(file);
        // read input and add to list modules
        while (sc.hasNextInt()) {
            modules.add(sc.nextInt());
        }

        // calculate fuel requirement per module (recursive), add result to fuelRequirements
        for (Integer m : modules) {
            int modTotal = 0;
            int fuel = calculateFuel(m, modTotal);
            fuelRequirements.add(fuel);
        }
        System.out.println(fuelRequirements);

        // sum fuelRequirements
        int totalFuel = 0;
        for (Integer f : fuelRequirements) {
            totalFuel += f;
        }
        // answer
        System.out.println(totalFuel);
    }
}
