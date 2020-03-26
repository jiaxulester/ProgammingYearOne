

import CommandGame.CommandWord;
import CommandGame.Parser;
import CommandGame.Command;

/**
 *
 * @author 215896
 */
        
public class Minesweeper {
    Parser parser = new Parser();
    MineField createField;
    
    public Minesweeper() {
       
    }
    
    public static void main(String args[]) {
        Minesweeper ct = new Minesweeper();
        ct.commandLine();
    }
    
    //Switching case when enter command
    private void play(Command c) {
        
        switch(c.getCommand()) {
            //New command for createing new Game
            case NEW:
                createField  = new MineField(c.getRow(),c.getColumn(),2);
                createField.populate();
                System.out.println(createField.toString());
                break;
                
            //Step command for remove the cover    
            case STEP: 
                if(createField.step(c.getRow(), c.getColumn())) {
                    System.out.println(createField.toString());
                } else {
                    System.out.println("Game Over");
                    System.exit(0);
                  }
                break;
                
            //Mark for marking the mines    
            case MARK:
                createField.flagged(c.getRow(), c.getColumn());
                System.out.println(createField.toString());
                if(createField.areAllMinesRevealed()) {
                    System.out.println("Win!");
                    System.exit(0);
                }
                break;
            case QUIT: System.out.println(c.getMsg());
                break;
            default:
                System.out.println(c);
        } printPrompt(c.getMsg());
    }
    
    private void commandLine() {
        printPrompt("New Game");
        
        Command c = parser.getCommand();
        while(c.getCommand() != CommandWord.QUIT) {
            play(c);
            c = parser.getCommand();
        }
    }
    
    private void printPrompt(String msg) {
        System.out.println(msg);
        System.out.print(">");
        
    } 
}