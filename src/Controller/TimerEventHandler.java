/**
 * 
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import GameObjects.Dot;
import GameObjects.PowerUp;

public class TimerEventHandler extends Observable {
	
	public TimerEventHandler(List<Dot> list){
		for(Dot d: list){
			this.addObserver(d);
		}
	}
	
	public void setObserver(List<Dot> list){
		for(Dot d: list){
			this.deleteObservers();
			this.addObserver(d);
		}
	}
	
	public void makeCall(int tick){
		setChanged();
		notifyObservers(tick);
	}
	
	public void killDot(Dot d){
		List<Dot> list = new ArrayList<Dot>();
		list = GameOne.getInstance().getOtherParts();
		list.remove(d);
		GameOne.getInstance().setOtherParts(list);
	}
}
