/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteenpuzzlestart;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author AshiK
 */
public class filledRectangle {
    private int x1,x2,y1,y2;
    Color c1,c2;

    public filledRectangle(int x1, int x2, int y1, int y2, Color c1) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.c1 = c1;
        
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRoundRect(x1, y1, x2, y2, 40, 40);
        g.setColor(c1);
        g.fillRoundRect(x1+5, y1+5, x2-10, y2-10, 40, 40);
    }
}
