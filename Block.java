

import java.awt.*;

/** This is for the blocks or obstacles that are stationary on the board.*/
public class Block extends Piece {
    
    /** Constructor: a new J*Man at position (x, y) with given color c.*/
    public Block(int x, int y, Color c){
        super(Piece.BLOCK, x, y, c);
        setColor(Color.WHITE);
    }
    
    /**Yields representation of piece  */
    public String toString() {
        String color= "";
        return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
    }
    
    /** put this piece on the board**/
    public void act(JManBoard board) {
        return;
    }
}    
