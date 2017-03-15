package Controller;

public class GameController {
	
	GameController instance = null;
	
	
	private GameController(){
		
	}
	
	public GameController getInstance(){
		if(instance == null){
			instance = new GameController();
		}
		
		return instance;
	}
	
	public void gameLoop(){
		
	}
}