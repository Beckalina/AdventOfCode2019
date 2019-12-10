import java.util.ArrayList;
import java.util.List;

public class Grid {
    List<List<String>> grid;

    public Grid(int rows, int columns) {
        this.grid = new ArrayList<>();
        // start with specified rows and columns of dots
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(".");
            }
            grid.add(row);
        }
    }

    public void setValue(int row, int column, String value){
        if (grid.get(row).get(column) == ".") {
            grid.get(row).set(column, value);
        }
        else if (grid.get(row).get(column) == value) {
            // do nothing
            ;
        }
        else {
            // crossed wires
            grid.get(row).set(column, "X");
        }
    }

    public String printRow(List<String> arr) {
        String row = "";
        for (int j = 0; j < arr.size(); j++) {
            row = row.concat(arr.get(j) + " ");
        }
        return row;
    }

    public void printGrid() {
        for (int i = 0; i < grid.size(); i++) {
            System.out.println(printRow(grid.get(i)));
        }
    }

}
