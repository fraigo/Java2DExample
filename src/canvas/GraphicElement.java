package canvas;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface GraphicElement {
	
	public boolean isVisible();
	
	public void setPosition(int x,int y);
	
	public void moveBy(int dx,int dy);
	
	public Rectangle getBounds();
	
	public void paint(Graphics g);

}
