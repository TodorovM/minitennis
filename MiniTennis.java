/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class MiniTennis extends JPanel {

    public MiniTennis() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
               //Do nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
               racquet.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
    }
Ball ball = new Ball(this);
Racquet racquet = new Racquet(this);


    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        ball.paint(g2d);
        racquet.paint(g2d);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(ball.c), 10, 30);
        g2d.drawString(String.valueOf(racquet.speed), 10, getWidth() - 50);

    }

    public int speed(){
        return ball.c + 1;
    }
    
    public static void main(String[] args) {
        MiniTennis game = new MiniTennis();
        game.InitUI();
    }

    public void Animation() {
        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ball.moveball();
                racquet.move();
                repaint();

            }
        };
        Timer timer = new Timer(10, action);
        timer.setInitialDelay(0);
        timer.start();
    }

    public void InitUI() {
        JFrame MainFrame = new JFrame();
        MiniTennis game = new MiniTennis();
        MainFrame.add(game);
        MainFrame.setSize(850, 850);
        MainFrame.setResizable(false);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game.Animation();
    }
    
    public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

}
