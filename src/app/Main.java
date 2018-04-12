package app;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import canvas.GraphicElement;
import canvas.Scene;
import elements.Image;
import elements.Square;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//Main Window
		JFrame f=new JFrame("MyGame");
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.add(new JButton("Hello"),BorderLayout.NORTH);
		
		//Main Scene
		final Scene s=new Scene(320, 480);
		f.add(s);
		f.setVisible(true);

		
		final Image spaceship=new Image(new File("/home/francisco/Downloads/ship.png"),s);
		spaceship.setPosition(40,250);
		s.addElement(spaceship);
		
		final int size=3;
		f.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent event) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode()==KeyEvent.VK_SPACE){
					
					Square square= new Square(6);
					square.setPosition(spaceship.getX()+spaceship.getWidth()/2-3,spaceship.getY()-10);
					square.setVelocity(0, -2);
					s.addElement(square);
				}
				if(event.getKeyCode()==KeyEvent.VK_RIGHT){
					spaceship.moveBy(size, 0);
				}
				if(event.getKeyCode()==KeyEvent.VK_LEFT){
					spaceship.moveBy(-size, 0);
				}
				if(event.getKeyCode()==KeyEvent.VK_UP){
					spaceship.moveBy(0, -size);
				}
				if(event.getKeyCode()==KeyEvent.VK_DOWN){
					spaceship.moveBy(0, size);
				}
				if(event.getKeyCode()==KeyEvent.VK_PAGE_UP){
					spaceship.moveBy(0, -size*10);
				}
			}
		});
		
		
	}
	

}
