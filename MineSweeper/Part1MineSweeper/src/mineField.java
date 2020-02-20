import java.util.Arrays;
import java.util.Random;

public class mineField {
    
    boolean[][] minefield;
    int[][] minedNeighbours;
    int total;
    int row;
    int column;
    int current;

    public mineField(int row0, int column0, int total) {
        this.total = total;
        row = row0;
        column = column0;
        current = total;
        this.minefield = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                minefield[i][j] = false;
            }
        }

        this.minedNeighbours = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                minedNeighbours[i][j] = 0;
            }
        }

    }

    public boolean mineTile(int row1, int column1) {
        boolean isMine = false;
        if (isMine == minefield[row1][column1] && current > 0) {

            minefield[row1][column1] = true;
            current--;
            for (int i = row1 - 1; i < row1 + 2; i++) {
                for (int j = column1 - 1; j < column1 + 2; j++) {
                    if (i < 0 || i >= row || j < 0 || j >= column) {
                        continue;
                    }
                    minedNeighbours[i][j] += 1;

                }
            }

            return minefield[row1][column1];

        } else {
            return false;
        }
    }

    public void populate() {
        int i = 0;
        while (current > 0) {
            Random rand = new Random();
            int num = rand.nextInt(row);
            int num1 = rand.nextInt(column);
            if (num == 0 && num1 == 0) {
                continue;
            }

            mineTile(num, num1);
            i++;

        }
    }


    public String toString() {
        String tmp = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (minefield[i][j] == true) {
                    minedNeighbours[i][j] = -1;
                    tmp = tmp + '*';
                } else {
                    tmp = tmp + String.valueOf(minedNeighbours[i][j]);
                }
            }
            tmp = tmp + "\n";

        }
        System.out.println(tmp);
        return tmp;

    }

}

