
import java.awt.*;

/** An instance of this class is a Pillar. Pillars cannot move, but they change colors
  * and can be eaten depending on their color. */
public class Pillar extends Piece {
    
   /** Constructor: A new Pillar with color c at location (x,y). 
      * Precondition: The value of c (color) must be between zero and 2
      * inclusive and (x,y) must be on the board. */
    public Pillar(int x, int y, int c) {
        super(Piece.PILLAR, x, y, (c == 0 ? Color.RED : (c ==1 ? Color.GREEN : 
                                                             Color.YELLOW)));
    }
    
    /** Constuctor: A new Pillar with given color at location (x,y).
      * Precondition: The color is red, green, or yellow and (x,y) is
      * on the board */
    public Pillar(int x, int y, Color c) {
        super(Piece.PILLAR, x, y, c);
    }
    
    /** Yields: representation of this pillar */
    public String toString() {
        String color= "";
        return getColorWord() + " Pillars at (" + getX() + ", " + getY() + ")";
    }
    
    /** Pillar should only be able to change color, not move. Pillar should 
      * change color only 1/3 of the time. */
    public void act(JManBoard board) {
        if (!hasActed()) {
            int prob = JManApp.rand(0,8);
            if (prob == 0) {
                    setColor(Color.RED);
                }
             if (prob == 1) {
                 setColor(Color.GREEN);
                }
             if (prob == 2) {
                 setColor(Color.YELLOW);
                }
            }
        }
    }


