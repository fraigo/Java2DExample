package elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import canvas.Shape;

public class Square extends Shape {

	public Square(int size) {
		this.setSize(size, size);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		Rectangle rect=this.getBounds();
		g.fillRect(rect.x,rect.y,rect.width,rect.height);

	}


	

}
