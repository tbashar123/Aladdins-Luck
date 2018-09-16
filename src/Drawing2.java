import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Drawing2 extends Applet {
	public void paint(Graphics g){
		g.setColor(Color.RED);
		drawHLine(100,200, 300, g);
		drawVLine(300, 100, 100, g);
		
		
		
		
		
	}
	

	public void drawPoint(int x, int y, Graphics g){
		g.drawLine(x, y, x, y);
		
	}
	public void drawHLine(int x1, int x2, int y, Graphics g){
		for(int x = x1; x< x2; x++){
			drawPoint(x, y ,g);
		}
	}
		
	public void drawVLine(int x, int y1, int y2, Graphics g){
		for(int y = y1; y< y2; y++){
			drawPoint(x,y,g);
		}
	}
	public void drawRect(int x, int y, int w, int h, Graphics g){
		drawHLine(x, x + w, y, g);
		drawVLine(x, y, y + h, g);
		drawHLine(x, x + w, y + h, g);
		drawVLine(x + w, y, y + h ,g);
	}
	public void drawLine(int x1, int x2, int y1, int y2, Graphics g){
		double m = (double) y2-y2/x2-x1;
		if(m<1){
			double y = y1;
			for(int x = x1; x < x2; y++){
			drawPoint(x,(int)y,  g);
			y+= m;
			
		}
	}
		else{
			double x = x1;
			for(int y = y1; y < y2; y++){
				drawPoint((int)x, y, g);
				x+= m;
			}
		}
	}
	
	}
	
	
	


