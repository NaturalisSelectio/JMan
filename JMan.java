

import java.awt.*;

/** This class is a MODEL class; an instance of this class represents
  * a J*Man, storing data such as current position and color.
  * However, this class does have one method that provides CONTROLLER
  * functionality -- the method act().  Each board piece needs to act
  * differently, therefore it makes sense to put the code for the
  * action in the class representing the board piece.  Technically
  * this violates the Model-View-Controller separation, but it 
  * illustrates a more important point: MVC is more of a guideline
  * than a rule.  If following the rule exactly makes your program
  * harder to understand, you can relax the rules.       */
public class JMan extends Piece {
    
    /** Constructor: a new J*Man at position (x, y) with given color c.
      * The initial color is Color.red if c = 0, Color.green if c = 1, 
      * and Color.yellow if c = 2.
      * Precondition: (x, y) is a nonnegative coordinate and the value c 
      * is in the range 0..2         */
    public JMan(int x, int y, int c) {
        // constructs a new J*Man at position (x,y) with color c
        super(Piece.JMAN,x,y, (c == 0 ? Color.RED : (c ==1 ? Color.GREEN : 
                                                          Color.YELLOW)));
    }
    
    /** Constructor: a new J*Man at position (x, y) with given color c.
      * Precondition: (x, y) is a nonnegative coordinate and the color c
      * is one of Color.red, Color.green, and Color.yellow.
      */
    public JMan(int x, int y, Color c) {
        // constructs a new J*Man at position (x,y) with color c
        super(Piece.JMAN, x, y, c);
    }
    
    /** Yields: representation of this piece */
    public String toString() {
        String color= "";
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
    
    /** If possible, move JMan in the direction given by the field
      *  nextManDirection in the provided controller. This should be one of the 
      *  JManApp constants MOVE_UP, MOVE_DOWN, MOVE_LEFT, and MOVE_RIGHT.
      *  Precondition: The board for the provided controller includes this
      *  piece at the position (x,y).    */
    public void act(JManBoard board) {
    	int x = getX();
    	/* 33 */     int y = getY();
    	/* 34 */     int px = x;
    	/* 35 */     int py = y;
    	/* 36 */     if (board.nextJManDirection() == 1) py -= 1;
    	/* 37 */     if (board.nextJManDirection() == 2) py += 1;
    	/* 38 */     if (board.nextJManDirection() == 3) px -= 1;
    	/* 39 */     if (board.nextJManDirection() == 4) px += 1;
    	/*    */ 
    				 
    		
    	/* 41 */     if (!board.isOnBoard(px, py)) {
    	/* 42 */      if (px < 0) {
    					Piece p = board.pieceAt(19, py);
    					if (p == null) {
    						board.move(x, y, 19, py);
    						return;
    					}
    					
    					if ((p.getType() == 0) || (!canEat(p.getColor()))) {
    						return;
    					}	
    				
    					setColor(p.getColor());
    					board.move(x, y, 19, py);
    					return;
    	/*    */     }

    				if (px > 19) {
    					Piece p = board.pieceAt(0, py);
    					if (p == null) {
    						board.move(x, y, 0, py);
    						return;
    					}
    					
    					if ((p.getType() == 0) || (!canEat(p.getColor()))) {
    						return;
    					}	
    				
    					setColor(p.getColor());
    					board.move(x, y, 0, py);
    					return;
    				/*    */     }
    				
    				if (py < 0) {
    					Piece p = board.pieceAt(px, 19);
    					if (p == null) {
    						board.move(x, y, px, 19);
    						return;
    					}
    					
    					if ((p.getType() == 0) || (!canEat(p.getColor()))) {
    						return;
    					}	
    				
    					setColor(p.getColor());
    					board.move(x, y, px, 19);
    					return;
    				/*    */     }
    				
    				if (py > 19) {
    					Piece p = board.pieceAt(px, 0);
    					if (p == null) {
    						board.move(x, y, px, 0);
    						return;
    					}
    					
    					if ((p.getType() == 0) || (!canEat(p.getColor()))) {
    						return;
    					}	
    				
    					setColor(p.getColor());
    					board.move(x, y, px, 0);
    					return;
    				/*    */     }
    	/*    */ 	  
    	/* 46 */    }

    	             Piece p = board.pieceAt(px, py);
    	/* 47 */     if (p == null) {
    	/* 48 */       board.move(x, y, px, py);
    	/* 49 */       return;
    	/*    */     }
    	/*    */ 
    	/* 52 */     if ((p.getType() == 0) || (!canEat(p.getColor()))) {
    	/* 53 */       return;
    	/*    */     }
    	/*    */ 
    	/* 57 */     setColor(p.getColor());
    	
    	/* 58 */     board.move(x, y, px, py);
    				 if (p.getType()==2){
    					 double ntwo= Math.random();
    					 if (ntwo <= .25){
    						 int nw= 0;
    						 for(int i=x; i < board.getWidth(); i += 1){
    							 for(int j= y; y < board.getHeight(); j +=1){
    								if (board.isEmpty(i, j)){
    									board.placePiece(3, i, j);
    									nw += 1;
    								}
    								if (nw >= 2){
    									return;
    								}
    							 }
    						 }
    						 for(int i=x; i == 0; i -= 1){
    							 for(int j= y; y == 0; j -=1){ 
    								 if (board.isEmpty(i, j)){
     									board.placePiece(3, i, j);
     									nw += 1;
     								}
     								if (nw >= 2){
     									return;	 
    							 }
    						 }
    					 }
    				 }
    			  }
    				 if (p.getType()==3){
    					 double nthree= Math.random();
    					 if (nthree <= .20){
    						 int np= 0;
    						 for(int i=x; i < board.getWidth(); i += 1){
    							 for(int j= y; y < board.getHeight(); j +=1){
    								if (board.isEmpty(i, j)){
    									board.placePiece(2, i, j);
    									np += 1;
    								}
    								if (np >= 3){
    									return;
    								}
    							 }
    						 }
    						 for(int i=x; i == 0; i -= 1){
    							 for(int j= y; y == 0; j -=1){ 
    								 if (board.isEmpty(i, j)){
     									board.placePiece(2, i, j);
     									np += 1;
     								}
     								if (np >= 3){
     									return;	 
    							 }
    						 }
    						 
    					 }
    				
    				 }
    				 }

    }
        
    
    /* Yields: "Piece p's color is the color J*Man can currently capture". */
    private boolean canEat(Color c) {
        // returns whether or not p's color is the color J*Man can capture
        return (getColor() == Color.YELLOW && c == Color.RED)
            || (getColor() == Color.RED && c == Color.GREEN)
            || (getColor() == Color.GREEN && c == Color.YELLOW);
        
    }
    
    
}
