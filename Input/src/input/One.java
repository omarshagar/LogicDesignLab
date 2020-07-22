/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author omerh
 */
public class One extends InputWithMPin   {
    JFrame f=new JFrame();
     JPanel jp;
      JButton b;
    public One()
    {
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(2000, 1000);
    f.setLocationRelativeTo(null);
    f.setTitle("One");
    f.setResizable(false);
   this.draw(5,4);
    }
  public int  draw(int x,int y)
  {
    jp=new JPanel();
    jp.setLayout(null);
    ImageIcon ii = new ImageIcon("C:\\Users\\omerh\\Desktop\\inputt.png");
   b=new JButton(ii);
    b.setSize(30, 30);
    b.setLocation(x,y);
    b.setIcon(ii);
    jp.add(b);
    f.add(jp);          
  return 1;
  }
  
}
