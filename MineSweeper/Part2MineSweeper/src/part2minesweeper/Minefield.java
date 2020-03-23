package part2minesweeper;
/**
 *
 * @author 215896
 */
public class Minefield {

    // Check that there are fields to hold the current state of the minefield
    //private boolean[][] minefield;
    //private int[][] minedNeighbours;
    private int rows, columns, numMines;
    MineTile2[][] TotalMineTile;
    /**
     * Initialize the fields, and then populate the minefield
     *
     * @param rows
     * @param columns
     * @param numMines
     */
    public Minefield(int rows, int columns, int numMines) {
        this.rows = rows;
        this.columns = columns;
        this.numMines = numMines;
        // Note that these could be rows+2, columns+2 if edge boundaries are
        // used
        minefield = new boolean[rows][columns];
        minedNeighbours = new int[rows][columns];
    }

    public boolean mineTile(int row, int column) {
        if (minefield[row][column]) {
            return false;
        } else {
            minefield[row][column] = true;
        }
        // There are a number of ways of doing this.  I've chosen to precalculate
        // the start and end points of the for loops
        // However, these checks could be internal to the for loops
        // or the arrays could have unused boundary row and columns
        int startRow, endRow, startColumn, endColumn;
        if (row == 0) {
            startRow = 0;
        } else {
            startRow = row - 1;
        }
        if (column == 0) {
            startColumn = 0;
        } else {
            startColumn = column - 1;
        }
        if (row == this.rows - 1) {
            endRow = row;
        } else {
            endRow = row + 1;
        }
        if (column == this.columns - 1) {
            endColumn = column;
        } else {
            endColumn = column + 1;
        }
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {

                minedNeighbours[i][j]++;

            }
        }
        return true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    /**
     * Provide the grid representation
     *
     * @return Stars for mines, ints for adjacent
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (minefield[i][j]) {
                    s += "*";
                } else {
                    s += minedNeighbours[i][j];
                }
            }
            s += "\n";
        }
        return s;
    }

    /**
     * A simple loop creating random coordinates, mining the tile until the
     * required number of mines have been laid
     */
    public void populate() {
        int created = 0;
        while (created < this.numMines) {
            int row = (int) (Math.random() * this.rows);
            int col = (int) (Math.random() * this.columns);
            if (!minefield[row][col] && !(row == 0 && col == 0)) {
                mineTile(row, col);
                created++;
            }

        }
    }

}

    