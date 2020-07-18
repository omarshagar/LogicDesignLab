import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
// w ww.j  ava2  s .  co  m
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MyPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}

class MyPanel extends JPanel {
  Rectangle RECT = new Rectangle(450, 400, 100, 100);
  Dimension INNER_PANEL_SIZE = new Dimension(600, 800);
  Dimension SCROLLPANE_SIZE = new Dimension(250, 300);
  String NOT_VISIBLE = "Not Visible";
  String VISIBLE = "Visible";
  InnerPanel innerPanel = new InnerPanel();
  JViewport viewport = new JViewport();
  JLabel statusLabel = new JLabel(NOT_VISIBLE);

  MyPanel() {
    JScrollPane scrollpane = new JScrollPane();
    scrollpane.setViewport(viewport);
    viewport.add(innerPanel);
    scrollpane.setPreferredSize(SCROLLPANE_SIZE);
    viewport.addChangeListener(e->{
        Rectangle viewRect = viewport.getViewRect();
        if (viewRect.intersects(RECT)) {
          statusLabel.setText(VISIBLE);
        } else {
          statusLabel.setText(NOT_VISIBLE);
        }
    });

    setLayout(new BorderLayout());
    add(scrollpane, BorderLayout.CENTER);
   // add(statusLabel, BorderLayout.SOUTH);
  }

  class InnerPanel extends JPanel {
    InnerPanel() {
      setPreferredSize(INNER_PANEL_SIZE);
    }
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.red);
      g2.setStroke(new BasicStroke(4));
      g2.draw(RECT);
    }
  }
}