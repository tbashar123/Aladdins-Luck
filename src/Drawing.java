import java.applet.Applet;
import java.awt.*;

public class Drawing extends Applet {
	public void paint(Graphics g){
		g.setColor(Color.RED);
		int[] xp = {50,80,120,50};
		int[] yp = {20,30,70,80};
		//drawPoly(xp,yp,4,g);
		g.drawPolygon(xp,yp,4);
		
		/*g.setColor(Color.red);
		drawLine(10,10,200,100,g);
		drawLine(10,10,250,100,g);
		drawLine(10,10,300,300,g);
		drawLine(10,10,200,500,g);
		drawLine(10,10,100,700,g);
		*/
		/*  g.drawLine(10, 10, 80, 10);
		int y = 200;
		for(int x = 0; x <1367; x++){
		drawPoint(x,y,g);
		}
		*/
		/*
		drawHLine(350,850,6,g);
		drawHLine(400,999,37,g);
		drawVLine(999,50,699,g);
		drawRect(200,200,600,150,g);
		drawRect(300,300,200,200,g);
		*/
		}
	
	public void drawPoly(int[] xp, int[] yp, int n, Graphics g){
		for(int i = 0; i<n-1; i++){
			
			g.drawLine(xp[i], yp[i], xp[i+1], yp[i+1]);
			
		}
		g.drawLine(xp[0], yp[0], xp[n-1], yp[n-1]);
	}
		
	
	public void drawPoint(int x,int y,Graphics g){
		g.drawLine(x, y, x, y);
		//g.drawLine(1000, x, 1000, x);
		}
		public void drawHLine(int x1,int x2,int y,Graphics g){ 
		for(int x = x1; x < x2; x++){ //draw line according to variables passed in 
		drawPoint(x,y,g);
		}
		}
		public void drawVLine(int y1,int y2,int x, Graphics g){
		for(int y = y1; y < y2; y++){
		drawPoint(x,y,g);
		}
		}
		public void drawRect(int x,int y,int w, int h, Graphics g){
		drawHLine(x, x + w , y, g);
		drawVLine(x, y , y + h, g);
		drawHLine(x,x + w, y + h, g);
		drawVLine(x + w, y, y + h, g);
		}
		public void drawLine(int x1,int y1,int x2,int y2,Graphics g){
		double m = (double)(y2-y1)/(x2-x1);
		if(m<1){
		double y = y1;
		for(int x = x1; x < x2; x++){
		drawPoint(x, (int)y, g);
		y+= m;
	
		}
		}
		else{
			double x = x1;
			for(int y = y1; y<y2; y++){
				drawPoint((int)x, y, g);
				x += 1/m;
			}
		}
		
		
		
		
	}
		
		
		}

		
		



