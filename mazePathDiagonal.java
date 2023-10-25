public class mazePathDiagonal {
    static void maze(int c, int r, int endCol, int endRow, String str) {
        if (r == endRow && c == endCol) {
            System.out.println(str);
            return;
        }
        if (r < endRow && c < endCol) {
            maze(c + 1, r + 1, endCol, endRow, str + "v");
        }
        if (r < endRow) {
            maze(c, r + 1, endCol, endRow, str + "R");
        }
        if (c < endCol) {
            maze(c + 1, r, endCol, endRow, str + "D");
        }
    }

    public static void main(String[] args) {
        maze(0, 0, 2, 2, "");
    }
}
