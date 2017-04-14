/**
 * 
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import GameObjects.Dot;
import GameObjects.PowerUp;

public class TimerEventHandler implements Observer {
	
	public TimerEventHandler(List<Dot> list){
		for(Dot d: list){
			d.addObserver(this);
		}
	}
	
	public void setObserver(List<Dot> list){
		for(Dot d: list){
			d.deleteObservers();
			d.addObserver(this);
		}
	}

	/**
	 * After an Observable calls, this method will be executed.
	 * @param o The object which made the call
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof PowerUp){
			if(!((PowerUp) o).isAlive()){
				List<Dot> list = new ArrayList<Dot>();
				list = GameOne.getInstance().getOtherParts();
				if(list.contains(o)){
					list.remove(o);
					GameOne.getInstance().setOtherParts(list);
				}
			}
		}
		
	}
}
