//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//// Except for the universal Center of Mass (COM), every object in space is in orbit around exactly one other object.
////
//// Whenever A orbits B and B orbits C, then A indirectly orbits C.
//// This chain can be any number of objects long: if A orbits B, B orbits C, and C orbits D, then A indirectly orbits D.
////
//// What is the total number of direct and indirect orbits in your map data?
//
//public class Day6a {
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        File file = new File("Day6/Day6_input.txt");
//        Scanner sc = new Scanner(file);
//
//        ArrayList<String> orbitsList = new ArrayList<>();
//
//        // read input and add to orbits list
//        while (sc.hasNextLine()) {
//            orbitsList.add(sc.nextLine());
//        }
//
//        HashMap<Body, Body> orbitsMap = new HashMap<>();
//
//        // make Body objects and map satellite to primary
//        for (String o : orbitsList) {
//            String primaryStr = o.substring(0, 3);
//            String satelliteStr = o.substring(4);
//            Body primary = new Body(primaryStr);
//            Body satellite = new Body(satelliteStr);
//            // a body that does not orbit round another is mapped to itself
//            if (!orbitsMap.containsKey(primary)) {
//                orbitsMap.put(primary, primary);
//            }
//            orbitsMap.put(satellite, primary);
//        }
//
//        System.out.println(orbitsMap);
//
//        // calculate total number of direct and indirect orbits
//        Tree orbitTree = new Tree(orbitsMap);
//        int result = orbitTree.countTotalOrbits();
//        System.out.println("Total orbits = " + result);
//
//    }
//}
