import java.util.ArrayList;
import java.util.Map;

public class Tree {

    Map<String, Body> bodies;

    public Tree(Map<String, Body> bodies) {
        this.bodies = bodies;
    }

    public int countTotalOrbits() {
        int TotalCounter = 0;
        for (String s: bodies.keySet()) {
            int countOfS = countOrbits(bodies.get(s));
            TotalCounter += countOfS;
        }
        return TotalCounter;
    }

    private int countOrbits(Body b) {
        int counter = 0;
        while (!b.equals(b.primary)) {
            counter += 1;
            b = b.primary;
        }
        return counter;
    }

    private ArrayList<Body> listPath(Body b) {
        ArrayList<Body> path = new ArrayList<>();

        // path from b to root node
        while (!b.equals(b.primary)) {
            path.add(b.primary);
            b = b.primary;
        }
        System.out.println(path);
        return path;
    }

    public int calculateOrbitalTransfer(String xStr, String yStr) {
        Body x = bodies.get(xStr);
        Body y = bodies.get(yStr);

        ArrayList<Body> xPath = listPath(x);
        ArrayList<Body> yPath = listPath(y);

        // find lowest common ancestor in paths to root
        for (int i = 0; i <= xPath.size(); i++) {
            if (yPath.contains(xPath.get(i))) {
                // minimum orbital transfer
                return i + yPath.indexOf(xPath.get(i));
            }
        }
        return 0;
    }
}

