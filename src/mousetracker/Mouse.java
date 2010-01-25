/*
 * Represents a mouse
 */

package mousetracker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author walle
 */
public class Mouse {

  /**
   * The location of the pointer
   */
  private Point location;

  /**
   * The color of the pointer
   */
  private Color color;

  /**
   * The radius of the pointer
   */
  private int radius;

  /**
   * The timer used to track the pointer
   */
  private Timer timer;

  /**
   * The private reference to the graphics
   */
  private Graphics g;


  public Mouse(Graphics g) {
    location = new Point();
    color = Color.black;
    radius = 1;
    timer = null;
    this.g = g;
  }

  private void startTimer() {
    timer = new Timer(20, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          update();
        }
    });
    timer.start();
  }

  private void update() {
    location = MouseInfo.getPointerInfo().getLocation();
  }

}
