package GameObjects;

import GameWindow.Direction;

public class Bullet extends Dot {
	
	Direction movingDirection;

	public Bullet(DotTyp p, int x, int y) {
		super(p, x, y);
	}
	
	public Bullet(DotTyp p, int x, int y, Direction d){
		super(p, x, y);
		this.movingDirection = d;
	}
	
	public void moveBullet(){
		if (movingDirection == Direction.LEFT) {
		this.setLocX(this.getLocX() - 10);
        }

        if (movingDirection == Direction.RIGHT) {
    		this.setLocX(this.getLocX() + 10);
        }

        if (movingDirection == Direction.UP) {
    		this.setLocY(this.getLocY() - 10);
        }

        if (movingDirection == Direction.DOWN) {
    		this.setLocY(this.getLocY() + 10);
        }
	}


}
