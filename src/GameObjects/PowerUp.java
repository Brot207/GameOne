package GameObjects;

public class PowerUp extends Dot{
	
	private int eventTimer;
	private int LTT = 50; //LifeTimeTimer

	public PowerUp(DotTyp p, int x, int y) {
		super(p, x, y);

	}
	
	@Override
	public boolean checkEvent(int tick){
		if(tick % LTT == 0){
			System.out.println("************************** star killed");
			isAlive = false;
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
		
	}
	
	public boolean isAlive(){
		return this.isAlive;
	}

}
