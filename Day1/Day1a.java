import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Day1a {
    public static int calculateFuel(int mass) {
        double f = (Math.floor(mass/3)) - 2;
        return (int)f;
    }

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> modules = new ArrayList<>();

        File file = new File("Day1\\Day1_input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextInt()) {
            modules.add(sc.nextInt());
        }

        int totalFuel = 0;

        for (Integer m : modules) {
            int fuel = calculateFuel(m);
            totalFuel += fuel;
        }
        System.out.println(totalFuel);

    }
}
