package part2minesweeper;

/**
 *
 * @author 215896
 */

public class MineTile2 {
    boolean indeMined;
    int minedNeighbours;
    boolean end;
    
    //Getter
    public boolean getindeMined(){
        return indeMined;
    }
    //Setter
    public boolean setindeMined(boolean newIndeMined){
        return newIndeMined;
    } 
    public int getMinedNeighbours() {
        return minedNeighbours;
    }

    public boolean isEnd() {
        return end;
    }

    public void setMinedNeighbours(int minedNeighbours) {
        this.minedNeighbours = minedNeighbours;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }
    boolean marked;
    
    
}
