package GameWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameOne;
import GameObjects.Part;
import GameObjects.Snake;

/**
 * This is the Game Panel
 * @author stang
 *
 */
public class GamePanel extends JPanel implements ActionListener {
	
	private Snake snake = null;
	
	private int HEIGHT = 600;
	private int WIDTH = 800;
	
	private int dotSize = 10;
	private int DELAY = 140;
	private int dotCount = 0;
	
	private final int ALLDOTS = (HEIGHT*WIDTH)/(dotSize*dotSize);
	
	private Direction direction = Direction.RIGHT;
    private boolean inGame = true;
	
    private Timer timer;
    private Image part;
	
    /**
     * The Panel in which the game is running.
     * @param s the snake on the panel
     */
	public GamePanel(Snake s){
		this.snake = s;
		
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		timer = new Timer(DELAY, this);
        timer.start();
	}

	
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		doDrawing(g);
	}
	
	/**
	 * Drwas the snake and other things
	 * @param g
	 */
	private void doDrawing(Graphics g) {
	        
		if(inGame) {

			this.dotCount = snake.getLength();

            for (int z = 0; z < this.dotCount; z++) {
                Part p = snake.getPart_i(z);
                part = p.getImage();
                g.drawImage(part, p.getLocX(), p.getLocY(), this);
            }

            Toolkit.getDefaultToolkit().sync();

        }else {

            GameOne.getInstance().switchStartFrame();
        }        
	}
	
	/**
	 * Moves the Gameobjects on the panel.
	 * The snake gets the current direction because it has to move constantly.
	 */
	private void move(){
		this.snake.moveSnake(direction);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame){
			this.move();
			System.out.println("game is running");
		}
		
		repaint();
		
	}
	
	/**
	 * The key listener of the panel
	 * @author stang
	 *
	 */
	private class TAdapter extends KeyAdapter{
		
		@Override
	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if ((key == KeyEvent.VK_LEFT) && (direction != Direction.RIGHT)) {
	            direction = Direction.LEFT;
	        }

	        if ((key == KeyEvent.VK_RIGHT) && (direction != Direction.LEFT)) {
	        	direction = Direction.RIGHT;
	        }

	        if ((key == KeyEvent.VK_UP) && (direction != Direction.DOWN)) {
	        	direction = Direction.UP;
	        }

	        if ((key == KeyEvent.VK_DOWN) && (direction != Direction.UP)) {
	        	direction = Direction.DOWN;
	        }
	        
	        if(key == KeyEvent.VK_SPACE){
	        	inGame = false;
	        }
	    }
	}
}
