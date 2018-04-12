package elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import canvas.Shape;

public class Image extends Shape {

	java.awt.Image internalImage;
	ImageObserver observer;
	
	public Image(File source,ImageObserver obs) throws Exception{
		ImageIcon img=new ImageIcon(source.getAbsolutePath());
		internalImage = img.getImage();
		setSize(internalImage.getWidth(obs), internalImage.getHeight(obs));
		this.observer=obs;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(internalImage, getX(), getY(), observer );
		System.out.println("Drawing "+internalImage.getWidth(observer));

	}
	


}
