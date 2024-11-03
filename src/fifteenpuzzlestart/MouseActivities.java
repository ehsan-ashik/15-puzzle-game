/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteenpuzzlestart;


 //* To change this template, choose Tools | Templates
 //* and open the template in the editor.
 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;



 //*
// * @author AshiK

public class MouseActivities extends JFrame{
    public frontPage mousePanel;
    public JLabel statusBar;
    
    public MouseActivities()
    {
        super("15 Puzzle Game");
        mousePanel = new frontPage();
        mousePanel.setBackground(mousePanel.c1);
        add(mousePanel,BorderLayout.CENTER);
        
        statusBar = new JLabel("Mouse Outside JPanel");
        add(statusBar,BorderLayout.NORTH);
        
        mouseHandler handler = new mouseHandler();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    }
    
    public class mouseHandler implements MouseListener,MouseMotionListener
    {
        @Override
        public void mouseClicked(MouseEvent event)
        { 
            if(event.getX()>50 && event.getX()<330 && event.getY()>50 && event.getY()<180)
                statusBar.setText(String.format("Clicked inside box 15 PUZZLE....!!!"));
            else if(event.getX()>333 && event.getX()<383 && event.getY()>0 && event.getY()<50)
            {
                statusBar.setText(String.format("Clicked inside box Exit....!!!"));
                System.exit(1); 
            }
            //FRONT START
            if(mousePanel.game_flag == false && mousePanel.opflg == false && event.getX()>70 && event.getX()<310 && event.getY()>220 && event.getY()<320)
            {
                mousePanel.dicerefrsh();
                statusBar.setText(String.format("Clicked inside box start....!!")); 
                mousePanel.game_flag = true;
            }
            //Create reset
            if(mousePanel.game_flag == true && mousePanel.opflg == false && event.getX()>210 && event.getX()<380 && event.getY()>180 && event.getY()<230)
            {
                mousePanel.dicerefrsh();
                statusBar.setText(String.format("Clicked inside box reset....!!")); 
                mousePanel.shuffleflag = true;
                mousePanel.game_page.intShuffle = 6;
                mousePanel.wonflag = false;
                mousePanel.wonflag1 = true;
                mousePanel.winShowFlag = 0;
            }
            //Create shuffle
            if(mousePanel.game_flag == true && mousePanel.opflg == false && event.getX()>15 && event.getX()<185 && event.getY()>180 && event.getY()<230)
            {
                //mousePanel.dicerefrsh();
                statusBar.setText(String.format("Clicked inside box start....!!")); 
                mousePanel.shuffleflag = true;
                mousePanel.game_page.intShuffle = new Random().nextInt(6);
                mousePanel.winShowFlag = 1;
                mousePanel.wonflag = false;
            }
            
            //START Game
            if( mousePanel.shuffleflag == true && mousePanel.game_flag == true  && event.getX()>100 && event.getX()<300 && event.getY()>250 && event.getY()<450)
            {
                statusBar.setText(String.format("Clicked inside box start....!!!")); 
                mousePanel.dice_click_width =(int) ( event.getX()-100 )/50 ;
                mousePanel.dice_click_height =(int) ( event.getY()-250 )/50 ;
                mousePanel.trueChange();
                mousePanel.diceflg = true;
                mousePanel.isWon();
            }
            //FRONT OPTIONS
            else if( mousePanel.game_flag == false && mousePanel.opflg == false && event.getX()>70 && event.getX()<310 && event.getY()>380 && event.getY()<480)
            {
                statusBar.setText(String.format("Clicked inside box Options....!!!")); 
                mousePanel.opflg = true;
            }
            //OPTIONS FONT1
            else if( (mousePanel.game_flag == false && mousePanel.opflg == true) && event.getX()>70 && event.getX()<120 && event.getY()>241 && event.getY()<291)
            {
                statusBar.setText(String.format("Clicked inside box font1....!!!"));
                
                mousePanel.op_Page.fontflag=0;
                mousePanel.game_page.fontflag1 =0;
                mousePanel.op_Page.font1 = new filledRectangle(70, 50, 241, 50, Color.RED);
                mousePanel.op_Page.font2 = new filledRectangle(70, 50, 300, 50, Color.BLACK);
            }//OPTIONS font2
            if( (mousePanel.game_flag == false && mousePanel.opflg == true) && event.getX()>70 && event.getX()<120 && event.getY()>300 && event.getY()<350)
            {
                statusBar.setText(String.format("Clicked inside box font2....!!!"));
                
                mousePanel.game_page.fontflag1 = 1;
                mousePanel.op_Page.fontflag=1;
                mousePanel.op_Page.font2 = new filledRectangle(70, 50, 300, 50, Color.RED);
                mousePanel.op_Page.font1 = new filledRectangle(70, 50, 241, 50, Color.BLACK);
            }
            //OPTIONS BACK
            if( ( mousePanel.game_flag == true || mousePanel.opflg == true) && event.getX()>230 && event.getX()<380 && event.getY()>590 && event.getY()<640)
            {
                mousePanel.opflg = false;
                mousePanel.game_flag = false;
            }
            //OPTIONS MODE1
            if(  (mousePanel.game_flag == false && mousePanel.opflg == true) && event.getX()>70 && event.getX()<120 && event.getY()>450 && event.getY()<500)
            {
                statusBar.setText(String.format("Clicked inside box mode1....!!!"));
               
                mousePanel.op_Page.mode1 = new filledRectangle(70, 50, 450, 50, Color.RED);
                mousePanel.op_Page.mode2 = new filledRectangle(70, 50, 510, 50, Color.BLACK);
            }
            //OPTIONS MODE2
            if( (mousePanel.game_flag == false && mousePanel.opflg == true) && event.getX()>70 && event.getX()<120 && event.getY()>510 && event.getY()<560)
            {
                statusBar.setText(String.format("Clicked inside box mode2....!!!"));
               
                mousePanel.op_Page.mode2 = new filledRectangle(70, 50, 510, 50, Color.RED);
                mousePanel.op_Page.mode1 = new filledRectangle(70, 50, 450, 50, Color.BLACK);
            }
            else
                statusBar.setText(String.format("Clicked at [%d,%d]", event.getX(),event.getY()));
        }
        @Override
        public void mousePressed(MouseEvent event)
        {
            statusBar.setText(String.format("Pressed at [%d,%d]", event.getX(),event.getY()));
        }
        @Override
        public void mouseReleased(MouseEvent event)
        {
            statusBar.setText(String.format("Released at [%d,%d]", event.getX(),event.getY()));
        }
        @Override
        public void mouseEntered(MouseEvent event)
        {
            statusBar.setText(String.format("Entered at [%d,%d]", event.getX(),event.getY()));
            //mousePanel.setBackground(mousePanel.c1);
        }
        @Override
        public void mouseExited(MouseEvent event)
        {
            statusBar.setText(String.format("Mouse Outside JPanel"));
            //mousePanel.setBackground(Color.WHITE);
        }
        @Override
        public void mouseDragged(MouseEvent event)
        {
            statusBar.setText(String.format("Dragged at [%d,%d]", event.getX(),event.getY()));
        }
        @Override
        public void mouseMoved(MouseEvent event)
        {
                statusBar.setText(String.format("Moved at [%d,%d]", event.getX(),event.getY()));
        }
    }
}
