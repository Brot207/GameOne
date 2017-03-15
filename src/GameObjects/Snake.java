package GameObjects;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	
	private final int startLength = 3;
	private int length = startLength;
	private int dotSize = 10;
	
	private List<Part> parts = null;
	
	public Snake(){
		parts = new ArrayList<Part>();
		
		for(int x = 0; x < startLength; x++){
			if(x == 0){
				parts.add(new Head(50, 50));
				continue;
			}
			
			parts.add(new Part(50 - x*dotSize, 50));
		}
	}

}
