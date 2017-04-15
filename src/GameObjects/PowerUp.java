package GameObjects;

import java.util.Observable;

import Controller.TimerEventHandler;

public class PowerUp extends Dot{
	
	private int eventTimer;

	public PowerUp(DotTyp p, int x, int y) {
		super(p, x, y);

		hasKillTimer = true;
	}
	
	public boolean isAlive(){
		return this.isAlive;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(hasKillTimer){
			if((int) arg % LTT == 0){
				((TimerEventHandler) o).killDot(this);
			}
		}	
	}

}
