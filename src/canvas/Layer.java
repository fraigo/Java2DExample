package canvas;

public enum Layer {
	
	BACKGROUND(0), FOREGROUND(1000), TOP(10000);
	
	private int level;

	private Layer(int level){
		this.level=level;
	}
	
	public int getLevel(){
		return this.level;
	}

}
