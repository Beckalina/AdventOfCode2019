import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5a {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Day5/testInput.txt");
        Scanner sc = new Scanner(file);

        ArrayList<String> orbits = new ArrayList<>();

        // read input and add to orbits list
        while (sc.hasNext()) {
            // Make satellites objects too. Have array of satellites.
            // create string array of each token, split on ")". -> String[] satellites = sc.nextLine.split("");
            // For each satellite, if not in array, make new satellite obj and add to array. If in array, use existing satellite obj.
            orbits.add(sc.nextLine());
        }

        System.out.println(orbits);


        Orbit myOrbit = new Orbit(5);
        System.out.println(myOrbit);

        myOrbit.unify(0, 1);
        System.out.println(myOrbit);

        System.out.println(myOrbit.findRoot(1));
    }
}
