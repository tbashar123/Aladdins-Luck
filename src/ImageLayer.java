import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

public class ImageLayer {
	
	LinkedList<Integer> list = new LinkedList<Integer>() ;
	
	Image img;
	
	
	int x;
	int y;
	int z;
	
public void LinkedList() {
		
	
		//list.add(-3000);
		list.add(-2000);
		list.add(-1000);
		list.add(0);
		list.add(1000);
		list.add(2000);
		//list.add(3000);
		
		
		
	}
	
	public ImageLayer(String file, int x,int y,int z) {
		
		img = Toolkit.getDefaultToolkit().getImage(file);
		this.x = x;
		this.y = y;
		this.z = z;
		
		LinkedList();
	}
	
	public void moveLeftBy(int dx) {
		//x-=dx;
		for(int i =0; i<list.size(); ++i)
			list.set(i,list.get(i)+dx);
		
		if(list.peekLast()>2500){
			list.removeLast();
			int first = list.peekFirst();
			
			list.addFirst(first-1000);
		}
		
	}
	
	public void moveRightBy(int dx) {
		x+=dx;
		/*for(int i =0; i<list.size(); ++i)
			list.set(i,list.get(i)+dx);
		
		if(list.peekLast()>2500){
			list.removeLast();
			int first = list.peekFirst();
			
			list.addFirst(first-1000);
		}*/
		
	}
	
	
	
	public void draw(Graphics g) {
		for(int i = 0;i<list.size();i++) {
			//g.drawImage(img,x/z+720*i,y,1500,690,null);
			g.drawImage(img,list.get(i)/z,0,1500,690,null);
		}
	}

}
