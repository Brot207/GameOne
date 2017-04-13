package GameWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameOne;
import GameObjects.Snake;
//WALL
import GameObjects.Wall;

/**
 * This is the Game Panel
 * @author stang
 *
 */
public class GamePanel extends JPanel implements ActionListener {
	
	private Snake snake = null;
	
	//WALL
	private Wall wall = null;
	
	private int HEIGHT;
	private int WIDTH;
	
	private int DELAY = 100;
	
	private Direction direction = Direction.RIGHT;
    private boolean inGame = true;
	
    private Timer timer;
    private int timerTickCount = 0;
	
    public  Graphics gr;
    /**
     * The Panel in which the game is running.
     * @param s the snake on the panel
     */
	public GamePanel(int h, int w){
		this.HEIGHT = h;
		this.WIDTH = w;
		
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
		float pxs = (float) ((1000.0/(float)DELAY)*10.0);
		pxs = Math.round(pxs*1000.0);
		g.drawString((pxs/1000.0) / 2.0 + " px/s", 10, 50);
		
	}
	
	/**
	 * Drwas the snake and other things
	 * @param g
	 */
	private void doDrawing(Graphics g) {
	        
		if(inGame) {

			GameOne.getInstance().doDrawingOnGamePanel(g);
            Toolkit.getDefaultToolkit().sync();

        }else {
        	System.out.println("Game stopped");
    		System.out.println("*********************************************************************************");
            GameOne.getInstance().switchStartFrame();
        }        
	}
	
	
	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}


	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}


	/**
	 * @return the inGame
	 */
	public boolean isInGame() {
		return inGame;
	}


	/**
	 * @param inGame the inGame to set
	 */
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
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
			
			//makes the game faster over time 
			if(timerTickCount % 200 == 0 && DELAY > 87){
				timer.stop();
				this.DELAY -= 1;
				timer = new Timer(DELAY, this);
				timer.start();
				
			}
			
			System.out.println(timerTickCount + "    game is running");
			GameOne.getInstance().move(direction);
			
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
	        
	        if((key == KeyEvent.VK_F)) {
	        	System.out.println("*****   Try shooting a bullet");
	        	GameOne.getInstance().shoot();
	        }
	        
	        if(key == KeyEvent.VK_SPACE) {
	        
	        	if(timer.isRunning()) {
	        		timer.stop();
	        		System.out.println("*****   Game paused");
	        		Graphics g = getGraphics();
	        		g.setColor(Color.orange);
	        		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
	        		g.drawString("Game paused", (WIDTH/2) - 70, HEIGHT/2);
	        		GameOne.getInstance().showStart();
	        	}else {
	        		System.out.println("*****   Game restarted");
	        		GameOne.getInstance().showStart();
	        		timer.restart();
	        	}
	        }
	        
	        if(key == KeyEvent.VK_ESCAPE) {
	        	if(timer.isRunning()) {
	        		inGame = false;
	        	}
	        }
	    }
	}
}
