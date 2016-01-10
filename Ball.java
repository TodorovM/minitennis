package minitennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Mihail Todorov
 */
public class Ball {

    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    int c = 0;
    private MiniTennis game;

    public Ball(MiniTennis game) {
        this.game = game;
    }

    protected void moveball() {
        if (x + xa < 0) {
            xa = game.speed();
        }
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed();
        }
        if (y + ya < 0) {
            ya = game.speed();
        }
        if (y + ya > game.getHeight() - DIAMETER) {
            game.gameOver();
        }
        if (collision()){
			ya = -game.speed();
			y = game.racquet.getTopY() - DIAMETER;
                        c += 1;
		}

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
    
}
