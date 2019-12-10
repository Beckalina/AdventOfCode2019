public class Direction {
    String direction;

    public Direction(String direction) {
        this.direction = direction;
    }

    public int[] left(Grid grid, String wireLetter, int[] current, int n) {
        for (int i = 0; i < n; i++) {
            grid.setValue(current[0], current[1]-1, wireLetter);
            current[1] -= 1;
        }
        return current;
    }

    public int[] right(Grid grid, String wireLetter, int[] current, int n) {
        for (int i = 0; i < n; i++) {
            grid.setValue(current[0], current[1]+1, wireLetter);
            current[1] += 1;
        }
        return current;
    }

    public int[] up(Grid grid, String wireLetter, int[] current, int n) {
        for (int i = 0; i < n; i++) {
            grid.setValue(current[0]-1, current[1], wireLetter);
            current[0] -= 1;
        }
        return current;
    }

    public int[] down(Grid grid, String wireLetter, int[] current, int n) {
        for (int i = 0; i < n; i++) {
            grid.setValue(current[0]+1, current[1], wireLetter);
            current[0] += 1;
        }
        return current;
    }

    public int[] parseDirection(Grid grid, String wireLetter, int[] current) {
        String[] dir = direction.split("");

        switch(dir[0]) {
            case "L":
                return left(grid, wireLetter, current, Integer.parseInt(dir[1]));
            case "R":
                return right(grid, wireLetter, current, Integer.parseInt(dir[1]));
            case "U":
                return up(grid, wireLetter, current, Integer.parseInt(dir[1]));
            case "D":
                return down(grid, wireLetter, current, Integer.parseInt(dir[1]));
        }
        return null;
    }

}
