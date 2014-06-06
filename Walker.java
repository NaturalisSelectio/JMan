
import java.awt.*;

/** An instance of this class is a Walker. Walkers cannot change colors but are
  * able to move around the board. They can be eaten depending on their color. */

public class Walker extends Piece {
    
        /** Constructor: Places a new walker at location (x,y).
      * Precondition: The color is specified as an integer and (x,y) is
      * on the board. */
    public Walker(int x, int y, int c) {
        super(Piece.WALKER, x, y, (c == 0 ? Color.RED : (c ==1 ? Color.GREEN : 
                                                             Color.YELLOW)));   
    }
    
       /** Constructor: Places a new walker at location (x,y).
      * Precondition: The color is specified as a color and (x,y) is on
      * the board. */
    public Walker(int x, int y, Color c) {
        super(Piece.WALKER, x, y, c);
    }
    
    /** Yields: representation of this walker */
    public String toString() {
        String color= "";
        return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
    }
    
 /** Walker moves in random direction 1/3 of all moves. If the move
      * is not possible due to another piece, the walker does not move. */
    public void act(JManBoard board) {
         int newx = getX();
         int newy = getY();
        if (!hasActed()) {
            int prob = JManApp.rand(0,11);
            
            if (prob == 0) {
                    newx = getX() + 1;
                    newy = getY();
                }
            if (prob == 1) {
                    newx = getX() - 1;
                    newy = getY();
                }
             if (prob == 2) {
                    newx = getX();
                    newy = getY()+ 1;
                }
              if (prob == 3) {
                    newx = getX();
                    newy = getY() - 1;
                }
                
                if (board.isOnBoard(newx,newy) == false) {
                    newx = Math.min(newx,19);
                    newx = Math.max(newx,0);
                    newy = Math.min(newy,19);
                    newy = Math.max(newy,0);
                }
                    
                    if (board.isEmpty(newx,newy)) {
                        board.move(getX(),getY(),newx,newy);
                    }
            }
        }
    }



