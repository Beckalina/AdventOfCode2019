// Two wires are connected to a central port and extend outward on a grid. Trace the path each wire takes as it
// leaves the central port. The wires twist and turn, but the two wires occasionally cross paths. To fix the circuit,
// find the intersection point closest to the central port.

public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid(10,11);
        // start point
        grid.setValue(8, 1, "O");

        Wire wireA = new Wire("a","R8,U5,L5,D3");
        wireA.followPath(grid);

        Wire wireB = new Wire("b","U7,R6,D4,L4");
        wireB.followPath(grid);

        grid.printGrid();
    }
}
