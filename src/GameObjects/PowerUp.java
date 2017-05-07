package GameObjects;

import java.util.Observable;

import Controller.TimerEventHandler;

public class PowerUp extends Dot{
	
	private int eventTimer;

	public PowerUp(PowerUpTyp p, int x, int y) {
		//super(p, x, y);
		super(DotTyp.STAR, x, y); //all PowerUps are stars
		//setLTT(p);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if((int) arg % LTT == 0 || !isAlive){
			((TimerEventHandler) o).killDot(this);
		}	
	}
	
//	public void setLTT(PowerUpTyp pTyp){
//		switch(pTyp) {
//		    case SHOOT: this.LTT = 70; break;
//		    default: this.LTT = 50;
//		}
//	}
}