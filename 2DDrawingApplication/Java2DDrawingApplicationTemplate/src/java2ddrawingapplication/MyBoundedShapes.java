/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

/**
 * due 10/19/23
 * @author Kevin Cai
 */
public abstract class MyBoundedShapes extends MyShapes{
    private boolean filled;
    
    public MyBoundedShapes(Point pntA, Point pntB, Paint paint, Stroke strk, boolean filled)
    {
        super(pntA, pntB, paint, strk);
        this.filled = filled;
    }

    /**
     * @return isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * @param isFilled the isFilled to be set
     */
    public void setIsFilled(boolean isFilled) {
        filled = isFilled;
    }
    
    public int getTopLeftX()
    {
        return Math.min((int)(getStartPoint().getX()), (int)(getEndPoint().getX()));
    }
    
    public int getTopLeftY()
    {
        return Math.min((int)(getStartPoint().getY()), (int)(getEndPoint().getY()));
    }
    
    public int getWidth()
    {
        return Math.abs((int)getStartPoint().getX() - (int)getEndPoint().getX());
    }
    
    public int getHeight()
    {
        return Math.abs((int)getStartPoint().getY() - (int)getEndPoint().getY());
    }
    
    
}
