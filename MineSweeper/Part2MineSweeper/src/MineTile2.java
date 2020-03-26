

/**
 *
 * @author 215896
 */

public class MineTile2 {
    boolean indeMined = false;
    int minedNeighbours;
    boolean revealed = false;
    boolean marked = false;
    
    public MineTile2() {
        
    }

    public boolean isIndeMined() {
        return indeMined;
    }

    public void setIndeMined(boolean indeMined) {
        this.indeMined = indeMined;
    }
    
    public int getMinedNeighbours() {
        return minedNeighbours;
    }
    
    public void setMinedNeighbours() {
        this.minedNeighbours++;
    }
    
    public boolean isRevealed() {
        return revealed;
    }
    
    public void setRevealed(boolean reveal) {
        this.revealed = true;
    }
    
    public boolean isMarked() {
        return marked;
    }
    
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
    
    public String toString() {
        String s = "";
        if(revealed) {
            if(indeMined){
                s+="*";
            }
            if(!indeMined){
                s+=minedNeighbours;
            }
        }else {
            if(!marked) {
                s+=".";
            }
            if(marked) {
            s+="F";
            }
        
        }
        return s;
    }
}
