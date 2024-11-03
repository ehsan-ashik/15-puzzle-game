/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteenpuzzlestart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author AshiK
 */
public class OptionPage {
    Color c2;
    Color c1= Color.RED;
    Color str = new Color(137, 217, 248);
    Color cop = new Color(252, 63, 134);
    public int fontflag = 0;

    public Font fonts[]={new Font("Snap ITC", Font.BOLD, 30),new Font("Ravie", Font.BOLD, 30)};
    public filledRectangle option = new filledRectangle(75, 230, 50, 80, str);
    private filledRectangle font = new filledRectangle(110, 150, 160, 60, cop);
    public filledRectangle font1=new filledRectangle(70, 50, 241, 50, c1);
    public  filledRectangle font2 = new filledRectangle(70, 50, 300, 50, c2);
    
    private filledRectangle mode = new filledRectangle(110, 150, 375, 50, cop);
    public filledRectangle mode1=new filledRectangle(70, 50, 450, 50, c1);
    public  filledRectangle mode2 = new filledRectangle(70, 50, 510, 50, c2);
    
    
    public void draw(Graphics g)
    {
        option.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Options", 110, 98);
        
        font.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Fonts", 128,197);
        
        font1.draw(g);        
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Snap ITC", 134,274);
        
        font2.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Ravie", 134,335);
        
        mode.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Mode", 128,410);
        
        mode1.draw(g);       
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Numbers", 134,484);
        
        mode2.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(fonts[fontflag]);
        g.drawString("Pictures", 134,545);
    }
}
