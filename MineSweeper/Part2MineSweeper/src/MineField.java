

 //@author 215896 base on model answer
 
public class MineField {
     /** 
      * Initialize the fields, and then populate the minefield
      * @param rows
      * @param columns
      * @param numMines
      */ 
        private int rows, columns, numMines;
        MineTile2[][] TotalMineTile;
        
    public MineField(int rows, int columns, int numMines) {
        this.rows = rows;
        this.columns = columns;
        this.numMines = numMines;
        TotalMineTile = new MineTile2[rows][columns]; //Creating a new MineTile2 call TotalMineTile 
        for (int i = 0; i <= rows-1; i++) {
            for (int j = 0; j <= columns-1; j++) {
                TotalMineTile[i][j] = new MineTile2();
            }
        }
    }

    public boolean mineTile(int row, int column) {
        if (TotalMineTile[row][column].isIndeMined()) {
            return false; //If mined will show false  
        } else TotalMineTile[row][column].setIndeMined(true); //If there is no mine it will mined
        
        //Controling the range for adding neighbours
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
        
        //Adding numbers for the mine neighbours around the Mine
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                TotalMineTile[i][j].setMinedNeighbours();
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
                s+=TotalMineTile[i][j].toString();
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
            int row = (int) (Math.random() * (this.rows-1));
            int col = (int) (Math.random() * (this.columns-1));
            if (!TotalMineTile[row][col].isIndeMined() && 
                !(row == 0 && col == 0)) {
                mineTile(row, col);
                created++;
            }
        }
    }
    
    //Switching the state of flag
    public void flagged (int r, int c) {
        if (TotalMineTile[r][c].isMarked()) {
            TotalMineTile[r][c].setMarked(false);
        }else TotalMineTile[r][c].setMarked(true);
       
      
    }
    
    //Getter 
    public MineTile2[][] getTotalMineTile() {
        return TotalMineTile;
    }
    
    /**
     * Checking the neighbours, if no numbers around choosing grid they will
     * keep searching for the numbers
     */   
    public boolean step(int ro,int co) {
        TotalMineTile[ro][co].setRevealed(true);
        
        if(TotalMineTile[ro][co].isIndeMined()) {  
            return false;
        }else {
            isNeighbours(ro,co);
            return true; 
        }      
    }
    
    //Supporting methods for step
    private void isNeighbours(int ro,int co) {  
        TotalMineTile[ro][co].setRevealed(true);
        if(TotalMineTile[ro][co].getMinedNeighbours()!=0) {
            return;
        }
        
        for(int i = ro-1; i <= ro+1; i++) {
            for(int j = co-1; j <= co+1; j++) {
                if(i<0 || i>= rows||
                   j<0 || j>= columns)
                 continue;
                  
                if(!TotalMineTile[i][j].isRevealed()) {
                    isNeighbours(i,j); //Loop the method when grid was being revealed
                }
            }
        }
    }
    
    //Last step for checking win or not
    public boolean areAllMinesRevealed() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(TotalMineTile[i][j].isIndeMined() 
                   != TotalMineTile[i][j].isMarked())
                    return false;
            }
        }
        return true;
    }  
}

    