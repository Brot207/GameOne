package GameObjects;

import java.util.Observable;

import Controller.TimerEventHandler;

public class PowerUp extends Dot{
	
	private int eventTimer;

	public PowerUp(DotTyp p, int x, int y) {
		super(p, x, y);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if((int) arg % LTT == 0 || !isAlive){
			((TimerEventHandler) o).killDot(this);
		}	
	}
}