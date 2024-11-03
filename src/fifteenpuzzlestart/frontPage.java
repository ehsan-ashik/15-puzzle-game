/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteenpuzzlestart;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author AshiK
 */
public class frontPage extends JPanel{
    Random rand= new Random();
    Random shufflerand = new Random(5);
    //Color c1 = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
    Color c1 = new Color(16, 102, 148);
    Color c2 ;
    Color cop = new Color(252, 63, 134);
    Color str = new Color(137, 217, 248);
    String Stemp;
    
    public int diceArr_W [][] = { {100,150,200,250}, {100,150,200,250}, {100,150,200,250}, {100,150,200,250} };
    public int diceArr_H [][] = { {250,250,250,250}, {300,300,300,300}, {350,350,350,350}, {400,400,400,400} };
    public int diceArr_W1 [][] = { {100,150,200,250}, {100,150,200,250}, {100,150,200,250}, {100,150,200,250} };
    public int diceArr_H1 [][] = { {250,250,250,250}, {300,300,300,300}, {350,350,350,350}, {400,400,400,400} };
    
    
    boolean false_alarm[][]={ {false,false,false,false}, {false,false,false,false}, {false,false,false,false}, {false,false,false,true} };
    boolean false_alarm_reset[][]={ {false,false,false,false}, {false,false,false,false}, {false,false,false,false}, {false,false,false,true} };
    
    public int dice_click_width = 0,dice_click_height = 0,temp;
    public boolean opflg= false;
    public boolean game_flag = false;
    public boolean game_flag1 = false;
    boolean diceflg = false;
    boolean wonflag = false;
    boolean wonflag1 = true;
    boolean shuffleflag = false;
    int winShowFlag = 0;
    
    public OptionPage op_Page = new OptionPage();
    public GamePage game_page = new GamePage();
    
    public filledRectangle Game = new filledRectangle(50, 280, 50, 130, str);
    private filledRectangle start = new filledRectangle(70, 240, 160+60, 100, cop);
    private filledRectangle optns = new filledRectangle(70, 240, 320+60, 100, cop);
    private filledRectangle help = new filledRectangle(70, 240, 480+60, 100, cop);
    private filledRectangle exit = new filledRectangle(333, 50, 1, 50, cop);
    private filledRectangle back = new filledRectangle(230, 150, 590, 50, cop);
    private filledRectangle won = new filledRectangle(40, 300, 480, 50, cop);
    
    public void dicerefrsh()
    {
            for (int m= 0;m<4;m++)
            {
                for(int n = 0; n<4;n++)
                {
                    c2 = (n%2 == 0)? Color.RED : Color.WHITE;
                    game_page.dices[m][n] = new filledRectangle(diceArr_W[m][n], 50, diceArr_H[m][n], 50, c2 );
                }
            }
            game_page.ix = 3;
            game_page.iy = 3;
            for(int x = 0 ;x <4 ; x++)
                System.arraycopy(false_alarm_reset[x], 0, false_alarm[x], 0, 4);
    }
    public void changeAdd_R(int wid,int hit)
    {
                game_page.ix = dice_click_height; 
                game_page.iy = dice_click_width;
                false_alarm[ dice_click_height][ dice_click_width ] = true;
                Stemp = game_page.int_count[hit][wid];
                game_page.int_count[hit][wid] = game_page.int_count[dice_click_height][dice_click_width];
                game_page.int_count[dice_click_height][dice_click_width] = Stemp;
                false_alarm[hit][ wid] = false;
        
    }
    public void changeAdd_L(int wid,int hit)
    {
                game_page.ix = dice_click_height; 
                game_page.iy = dice_click_width;
                false_alarm[ dice_click_height][ dice_click_width ] = true;
                Stemp = game_page.int_count[hit][wid];
                game_page.int_count[hit][wid] = game_page.int_count[dice_click_height][dice_click_width];
                game_page.int_count[dice_click_height][dice_click_width] = Stemp;
                false_alarm[hit][ wid] = false;
    }
    
    public void changeAdd_U(int wid,int hit)
    {
                game_page.ix = dice_click_height; 
                game_page.iy = dice_click_width;
                false_alarm[ dice_click_height][ dice_click_width ] = true;
                Stemp = game_page.int_count[hit][wid];
                game_page.int_count[hit][wid] = game_page.int_count[dice_click_height][dice_click_width];
                game_page.int_count[dice_click_height][dice_click_width] = Stemp;
                false_alarm[hit][ wid] = false;
    }
    
    public void changeAdd_D(int wid,int hit)
    {
                game_page.ix = dice_click_height; 
                game_page.iy = dice_click_width;
                false_alarm[ dice_click_height][ dice_click_width ] = true;
                Stemp = game_page.int_count[hit][wid];
                game_page.int_count[hit][wid] = game_page.int_count[dice_click_height][dice_click_width];
                game_page.int_count[dice_click_height][dice_click_width] = Stemp;
                false_alarm[hit][ wid] = false;
    }
    
    
   public void trueChange()
    {
        //row 3
        if(dice_click_height == 3 && dice_click_width == 3 )
        {
            if( false_alarm[ dice_click_height][ dice_click_width-1] ==true )
            {
                changeAdd_L(dice_click_width -1, dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }
        }
        else if(dice_click_height == 3 && dice_click_width == 0)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }   
        }
        
        else if(dice_click_height == 3 && dice_click_width != 0 && dice_click_width != 3)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
       
            else if( false_alarm[ dice_click_height][ dice_click_width-1 ] == true )
            {
                changeAdd_L(dice_click_width - 1,dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            } 
        }
        
        
        
        
        //row 2
        if(dice_click_height == 2 && dice_click_width == 3 )
        {
            if( false_alarm[ dice_click_height][ dice_click_width-1] ==true )
            {
                changeAdd_L(dice_click_width -1, dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        else if(dice_click_height == 2 && dice_click_width == 0)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            } 
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        
        else if(dice_click_height == 2 && dice_click_width != 0 && dice_click_width != 3)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
       
            else if( false_alarm[ dice_click_height][ dice_click_width-1 ] == true )
            {
                changeAdd_L(dice_click_width - 1,dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        
        
        
        //row 1
        if(dice_click_height == 1 && dice_click_width == 3 )
        {
            if( false_alarm[ dice_click_height][ dice_click_width-1] ==true )
            {
                changeAdd_L(dice_click_width -1, dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        else if(dice_click_height == 1 && dice_click_width == 0)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            } 
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        
        else if(dice_click_height == 1 && dice_click_width != 0 && dice_click_width != 3)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
       
            else if( false_alarm[ dice_click_height][ dice_click_width-1 ] == true )
            {
                changeAdd_L(dice_click_width - 1,dice_click_height);
            }
            else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        
        
        
        //row 0
        if(dice_click_height == 0 && dice_click_width == 3 )
        {
            if( false_alarm[ dice_click_height][ dice_click_width-1] ==true )
            {
                changeAdd_L(dice_click_width -1, dice_click_height);
            }
            /*else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }*/
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        else if(dice_click_height == 0 && dice_click_width == 0)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
            /*else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            } */
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        
        else if(dice_click_height == 0 && dice_click_width != 0 && dice_click_width != 3)
        {
            if( false_alarm[ dice_click_height][ dice_click_width + 1] == true )
            {
                changeAdd_R(dice_click_width + 1,dice_click_height);
            }
       
            else if( false_alarm[ dice_click_height][ dice_click_width-1 ] == true )
            {
                changeAdd_L(dice_click_width - 1,dice_click_height);
            }
            /*else if( false_alarm[ dice_click_height -1 ][ dice_click_width] ==true )
            {
                changeAdd_U(dice_click_width,dice_click_height - 1);
            }*/
            else if( false_alarm[ dice_click_height +1 ][ dice_click_width] ==true )
            {
                changeAdd_D(dice_click_width,dice_click_height +1 );
            }
        }
        
    }
    
    
   public void isWon()
   {
       for(int p = 0; p < 4; p++)
           for(int q = 0; q<4 ; q++)
           {
               if(game_page.int_countTest[p][q].equals(game_page.int_count [p][q]))
                   wonflag1 = true;
               else
               {
                   wonflag1 = false;
                   break;
               }
               
           }
       if(wonflag1 == true)
           wonflag = true;
       
   }
    
    @Override
    public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
        repaint();
        exit.draw(g);
            g.setColor(Color.BLACK);
            g.setFont(op_Page.fonts[op_Page.fontflag]);
            g.drawString("X", 343, 37);
        if(opflg == true || game_flag == true)  
        {
            back.draw(g);
            g.setColor(Color.BLACK);
            g.setFont(op_Page.fonts[op_Page.fontflag]);
            g.drawString("BACK", 250,630);
        }
            
        if(opflg == false && game_flag == false)
        {
            Game.draw(g);
            g.setColor(Color.BLACK);
            g.setFont(op_Page.fonts[op_Page.fontflag]);
            g.drawString("15 PUZZLE", 76, 130);
            start.draw(g);
            g.setColor(Color.BLACK);
            g.setFont(op_Page.fonts[op_Page.fontflag]);
            g.drawString("START", 120, 280);
            optns.draw(g);
            g.setColor(Color.BLACK);
            g.setFont(op_Page.fonts[op_Page.fontflag]);
            g.drawString("OPTIONS", 97, 440);
            help.draw(g);
            g.setColor(Color.BLACK);
            g.setFont(op_Page.fonts[op_Page.fontflag]);
            g.drawString("HELP", 140, 600);
            
        }
        if(opflg == true && game_flag == false)
        {
            op_Page.draw(g);   
        }
        if(opflg == false && game_flag == true)
        {
            game_page.draw(g);
            
            if(diceflg == true)
            {
                //game_page.dices[dice_click_height][dice_click_width] = new filledRectangle(diceArr_W[dice_click_height][dice_click_width], 50, diceArr_H[dice_click_height][dice_click_width], 50, c2 );
                for (int m= 0;m<4;m++)
                {
                    for(int n = 0; n<4;n++)
                    {
                        if(m==3 && n == 3)
                            continue;
                        Color c3 = (n%2 == 0)? Color.RED : Color.WHITE;
                        game_page.dices[m][n] = new filledRectangle(diceArr_W[m][n], 50, diceArr_H[m][n], 50, c3 );
                        
                    }
                }
            }
            if(wonflag == true && winShowFlag == 1)
            {
                won.draw(g);
                g.setColor(Color.BLACK);
                g.setFont(op_Page.fonts[op_Page.fontflag]);
                g.drawString("YoU WoN :D", 80, 515);
            }
            diceflg = false;
            
        }
    }
    
}
