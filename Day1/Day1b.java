import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1b {
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

        ArrayList<Integer> modules = new ArrayList<>();
        ArrayList<Integer> fuelRequirements = new ArrayList<>();

        File file = new File("Day1\\Day1_input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextInt()) {
            modules.add(sc.nextInt());
        }

        for (Integer m : modules) {
            int modTotal = 0;
            int fuel = calculateFuel(m, modTotal);
            fuelRequirements.add(fuel);
        }
        System.out.println(fuelRequirements);

        int totalFuel = 0;
        for (Integer f : fuelRequirements) {
            totalFuel += f;
        }
        System.out.println(totalFuel);
    }
}
