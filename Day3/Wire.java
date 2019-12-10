public class Wire {
    // letter used as value in grid
    String letter;
    String[] path;
    int[] current;

    public Wire(String letter, String p) {
        this.letter = letter;
        path = p.split(",");
        current = new int[]{8, 1};
    }

    public void followPath(Grid grid) {
        for (String p : path) {
            Direction d = new Direction(p);
            current = d.parseDirection(grid, letter, current);
        }
    }


}
