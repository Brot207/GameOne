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
import GameObjects.Dot;
import GameObjects.DotTyp;
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
    private int timerTickCount = 0;
    private Image part;
	
    /**
     * The Panel in which the game is running.
     * @param s the snake on the panel
     */
	public GamePanel(Snake s){
		this.snake = s;
		this.snake.setpWIDTH(this.WIDTH);
		this.snake.setpHEIGHT(this.HEIGHT);
		
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
			
			g.drawImage(new Dot(DotTyp.HEAD, 100, 100).getImage(), 100, 100, this);

            for (int z = 0; z < this.dotCount; z++) {
                Dot p = snake.getPart_i(z);
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
	
	
	
	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}


	/**
	 * @return the wIDTH
	 */
	public int getWIDTH() {
		return WIDTH;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame){
			timerTickCount += 1;
			this.move();
			System.out.println(timerTickCount + "   game is running");
		}
		
		repaint();
		
	}
	
	/**
	 * The key listener of the panel
	 */
	private class TAdapter extends KeyAdapter{
		
		@Override
	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if ((key == KeyEvent.VK_LEFT) && (direction != Direction.RIGHT)) {
	            if(timer.isRunning()) direction = Direction.LEFT;
	        }

	        if ((key == KeyEvent.VK_RIGHT) && (direction != Direction.LEFT)) {
	        	if(timer.isRunning()) direction = Direction.RIGHT;
	        }

	        if ((key == KeyEvent.VK_UP) && (direction != Direction.DOWN)) {
	        	if(timer.isRunning()) direction = Direction.UP;
	        }

	        if ((key == KeyEvent.VK_DOWN) && (direction != Direction.UP)) {
	        	if(timer.isRunning()) direction = Direction.DOWN;
	        }
	        
	        if(key == KeyEvent.VK_SPACE) {
	        
	        	if(timer.isRunning()) {
	        		timer.stop();
	        		System.out.println("*****   Game paused");
	        	}else {
	        		System.out.println("*****   Game restarted");
	        		timer.restart();
	        	}
	        }
	        
	        if(key == KeyEvent.VK_ESCAPE) {
	        	if(timer.isRunning()) {
	        		System.out.println("Game stopped");
	        		System.out.println("*********************************************************************************");
	        		inGame = false;
	        	}
	        }
	    }
	}
}
