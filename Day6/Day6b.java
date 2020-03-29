
// Matt's suggestion to improve on 6a: rather than hashmap, have set of all bodies, make body objects,
// store primary as property on object rather than value in hashmap.
// Does the same thing, but makes it clearer to understand, and I think more efficient too?

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6b {

    static ArrayList<String> readInput(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        ArrayList<String> inputList = new ArrayList<>();

        // read input line by line and add to list
        while (sc.hasNextLine()) {
            inputList.add(sc.nextLine());
        }

        return inputList;
    }

    static Map<String, Body> mapBodies(ArrayList<String> orbitsList) {
        Map<String, Body> bodies = new HashMap<>();

        // make Body objects and map satellite to primary
        for (String o : orbitsList) {
            String primaryStr = o.substring(0, 3);
            String satelliteStr = o.substring(4);

            if (!bodies.containsKey(primaryStr)) {
                Body primary = new Body(primaryStr);
                bodies.put(primaryStr, primary);
            }

            if (bodies.containsKey(satelliteStr)) {
                bodies.get(satelliteStr).setPrimary(bodies.get(primaryStr));
            }
            else {
                Body satellite = new Body(satelliteStr);
                bodies.put(satelliteStr, satellite);
                satellite.setPrimary(bodies.get(primaryStr));
            }
        }
        return bodies;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Day6/Day6_input.txt");

        ArrayList<String> orbitsList = readInput(file);

        Map<String, Body> bodies = mapBodies(orbitsList);
        System.out.println(bodies);

        // calculate total number of direct and indirect orbits
        Tree orbitTree = new Tree(bodies);
        int result = orbitTree.countTotalOrbits();
        System.out.println("Total orbits = " + result);

        int minOrbitalTransfers = orbitTree.calculateOrbitalTransfer("YOU", "SAN");
        System.out.println("Minimum number of orbital transfers = " + minOrbitalTransfers);
    }
}
