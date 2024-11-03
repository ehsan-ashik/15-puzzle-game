/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteenpuzzlestart;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author AshiK
 */
public class GamePage {
    public int fontflag1=0;
    
    int trueFlag = 0;
    int ix= 3,iy = 3;
    int intShuffle = 0;
    //dice
    Color str = new Color(137, 217, 248);
    Color cop = new Color(252, 63, 134);
    //string
    String int_count5[][] = { {"14","1","3","10"}, {"15","4","13","2"}, {"5","3","9","12"} , {"6","7","11","16"} };
    String int_count1[][] = { {"5","1","3","4"}, {"9","2","6","8"}, {"13","10","7","12"} , {"14","11","15","16"} };
    String int_count2[][] = { {"1","2","4","8"}, {"6","9","7","11"}, {"10","13","15","3"} , {"5","14","12","16"} };
    String int_count3[][] = { {"13","4","9","8"}, {"3","10","15","1"}, {"5","6","14","11"} , {"12","7","2","16"} };
    String int_count4[][] = { {"1","5","9","8"}, {"4","2","7","10"}, {"6","14","15","13"} , {"3","11","12","16"} };
    String int_countTest[][] = { {"1","2","3","4"}, {"5","6","7","8"}, {"9","10","11","12"} , {"13","14","15","16"} };
    String int_count[][] = { {"1","2","3","4"}, {"5","6","7","8"}, {"9","10","11","12"} , {"13","14","15","16"} };
    int widthString[][] ={ {110,160,210,260}, {110,160,210,260}, {110,160,210,260} , {110,160,210,260} };
    int widthString1[][] ={ {110,160,210,260}, {110,160,210,260}, {110,160,210,260} , {110,160,210,260} };
    int heightString[][]= { {286,286,286,286}, {336,336,336,336} , {386,386,386,386} , {436,436,436,436} };
    int heightString1[][]= { {286,286,286,286}, {336,336,336,336} , {386,386,386,386} , {436,436,436,436} };
    
    filledRectangle dices[][] = new filledRectangle[4][4];
    
    public Color c1;
    public OptionPage op1 = new OptionPage(); 
    public filledRectangle game = new filledRectangle(75, 230, 50, 80, str);
    public filledRectangle puzzle = new filledRectangle(15, 170, 180, 50, cop);
    public filledRectangle reset = new filledRectangle(210, 170, 180, 50, cop);
 
    public void draw_dices(Graphics g)
    {
         
        for(int i = 0; i<4;i++)
            for(int j = 0; j<4;j++)
        {
            if(i==ix && j == iy)
                        continue;
  
            dices[i][j].draw(g);
            g.setColor(Color.blue);
            g.setFont(op1.fonts[fontflag1]); 
            if(intShuffle == 1)
            {
                for(int x = 0; x<4 ; x++)
                    System.arraycopy(int_count1[x], 0, int_count[x], 0, 4);
                intShuffle = 0;
            }
            if(intShuffle == 2)
            {
                for(int x = 0; x<4 ; x++)
                    System.arraycopy(int_count2[x], 0, int_count[x], 0, 4);
                intShuffle = 0;
            }
            if(intShuffle == 3)
            {
                for(int x = 0; x<4 ; x++)
                    System.arraycopy(int_count3[x], 0, int_count[x], 0, 4);
                intShuffle = 0;
            }
            if(intShuffle == 4)
            {
                for(int x = 0; x<4 ; x++)
                    System.arraycopy(int_count4[x], 0, int_count[x], 0, 4);
                intShuffle = 0;
            }
            if(intShuffle == 5)
            {
                for(int x = 0; x<4 ; x++)
                    System.arraycopy(int_count5[x], 0, int_count[x], 0, 4);
                intShuffle = 0;
            }
            if(intShuffle == 6)
            {
                for(int x = 0; x<4 ; x++)
                    System.arraycopy(int_countTest[x], 0, int_count[x], 0, 4);
               intShuffle = 0;
            }
            
            g.drawString(int_count[i][j], widthString[i][j], heightString[i][j] );  
            
  
        }
    }
    public void draw(Graphics g)
    {
        game.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(op1.fonts[fontflag1]);
        g.drawString("Game", 135, 98);
        draw_dices(g);
        
        puzzle.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(op1.fonts[fontflag1]);
        g.drawString("Shuffle", 20, 215);
        
        reset.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(op1.fonts[fontflag1]);
        g.drawString("Reset", 230, 215);
    }
}
