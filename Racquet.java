/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

/**
 *
 * @author Mihail Todorov
 */
import java.awt.*;
import java.awt.event.*;

public class Racquet {

    public Racquet(MiniTennis game) {
        this.game = game;
    }
    private static final int Y = 750;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 20;
    int x = 0;
    int xa = 0;
    int speed = 10;
    private MiniTennis game;

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - 60) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g2d) {
        g2d.fillRect(x, Y, 60, 20);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            if (speed >20){
                
            }else{
                speed++;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            if (speed <1){
                
            }else{
                speed--;
            }
            
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }
}
