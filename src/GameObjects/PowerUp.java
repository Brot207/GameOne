package GameObjects;

public class PowerUp extends Dot{
	
	private int eventTimer;
	private int LTT = 500; //LifeTimeTimer
	private boolean isAlive = true;

	public PowerUp(DotTyp p, int x, int y) {
		super(p, x, y);

		this.hasEvent = true;
	}
	
	@Override
	public void checkEvent(int tick){
		if(tick % LTT == 0) isAlive = false;
		
	}

}
