package canvas;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Shape implements GraphicElement {

	private boolean visible;
	private Rectangle bounds;
	private int velocityY, velocityX;
	
	public Shape(){
		visible=true;
		velocityX=0;
		velocityY=0;
		bounds=new Rectangle(0, 0, 0, 0);
	}
	
	@Override
	public boolean isVisible() {
		return this.visible;
	}
	
	public int getX(){
		return bounds.x;
	}

	public int getY(){
		return bounds.y;
	}
	
	public int getWidth(){
		return bounds.width;
	}

	public int getHeight(){
		return bounds.height;
	}
	
	public void setVelocity(int vx,int vy){
		this.velocityX=vx;
		this.velocityY=vy;
	}

	@Override
	public void setPosition(int x, int y) {
		bounds.x=x;
		bounds.y=y;
	}
	
	public void setVisible(boolean visible) {
		this.visible=visible;
	}
	
	
	public void setSize(int width, int height){
		bounds.width=width;
		bounds.height=height;
	}

	@Override
	public void moveBy(int dx, int dy) {
		bounds.x+=dx;
		bounds.y+=dy;
	}
	
	public void zoom(int factor){
		bounds.width*=factor;
		bounds.height*=factor;
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}
	
	@Override
	public void paint(Graphics g) {
		moveBy(velocityX, velocityY);
	}


}
