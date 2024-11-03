/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteenpuzzlestart;

import javax.swing.JFrame;

/**
 *
 * @author AshiK
 */
public class FifteenPuzzleStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frontPage fp = new frontPage();
        MouseActivities app = new MouseActivities();
        //app.add(fp);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400,700);
        app.setVisible(true);
    }
}
