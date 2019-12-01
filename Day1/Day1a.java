import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

// Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module,
// take its mass, divide by three, round down, and subtract 2. E.g. For a mass of 14, divide by 3 and round down to
// get 4, then subtract 2 to get 2.

public class Day1a {
    // divide by three, round down, and subtract 2
    public static int calculateFuel(int mass) {
        double f = (Math.floor(mass/3)) - 2;
        return (int)f;
    }

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> modules = new ArrayList<>();

        File file = new File("Day1\\Day1_input.txt");
        Scanner sc = new Scanner(file);

        // read input and add to list modules
        while (sc.hasNextInt()) {
            modules.add(sc.nextInt());
        }

        int totalFuel = 0;

        for (Integer m : modules) {
            int fuel = calculateFuel(m);
            totalFuel += fuel;
        }
        // answer
        System.out.println(totalFuel);
    }
}
