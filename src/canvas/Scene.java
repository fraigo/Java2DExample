package canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Scene extends JPanel {
	
	int baseWidth;
	int baseHeight;
	int currentWidth;
	int currentHeight;
	Image img;
	ArrayList<GraphicElement> elements;
	

	public Scene(int width,int height){
		super();
		this.baseWidth=width;
		this.baseHeight=height;
		this.elements=new ArrayList<GraphicElement>();
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					Scene.this.repaint();
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						System.out.println("Thread terminated");
						break;
					}
					
				}
			}
		});
		
		t.start();

	}
	
	@Override
	public void paint(final Graphics g) {
		
		
		double factor1=(double)getWidth()/baseWidth;
		double factor2=(double)getHeight()/baseHeight;
		double factor=Math.min(factor1,factor2);
		currentWidth=(int)Math.round(baseWidth*factor);
		currentHeight=(int)Math.round(baseHeight*factor);
		int marginWidth=(getWidth()-currentWidth);
		int marginHeight=(getHeight()-currentHeight);
		
		if (img==null){
			img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		}
		if (img!=null && img.getWidth(this)!=getWidth()){
			img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		}
		Graphics gc=img.getGraphics();
		
		gc.setColor(Color.BLACK);
		gc.fillRect(0,0,getWidth(),getHeight());
		
		gc.translate(marginWidth/2,marginHeight/2);
		gc.setClip(0,0,currentWidth+1,currentHeight+1);

		gc.setColor(Color.WHITE);
		gc.fillRect(0,0,currentWidth,currentHeight);
		
		updateScene();
		paintScene(gc);
		g.drawImage(img, 0, 0, this);
	}
	
	private void updateScene(){

	}

	private void paintScene(Graphics g) {
		for (int i = 0; i < elements.size(); i++) {
			GraphicElement e=elements.get(i);
			if (e.isVisible()){
				e.paint(g);
			}
		}
	}
	
	public void addElement(GraphicElement e){
		elements.add(e);
	}
	
	
	
}
