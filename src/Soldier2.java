import java.awt.*;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Soldier2 extends Sprite {
	
	static String[] action = {"attk", "death"};
	
	public Soldier2(int x, int y, String name){
		super(x,y,"g_",action, 12,1,name);
	}
	
	public void follow(Soldier Aladdin){
		if(Aladdin.x>x){
			x+=1;
			
		}
		
		else{
			x-=1;
		}
	}
	
	public boolean attack(Soldier2 Enemy){
	       if(moving){
			//Aladdin.dead = true;
			Enemy.attack1 = true;
			Enemy.attack2 = true;
			Enemy.attack3 = true;
			Enemy.attack4 = true;
			Enemy.attack5 = true;
			Enemy.attack6 = true;
			return true;
	}
	       return false;
	}
	
public boolean overlaps2(Soldier Aladdin){
		
		double dx=(x+w/2)-(Aladdin.x+Aladdin.w/2);
	    double dy=(y+h/2)-(Aladdin.y+Aladdin.h/2);
	    double width=(w+Aladdin.w)/2;
	    double height=(h+Aladdin.h)/2;
	    double crossWidth=width*dy;
	    double crossHeight=height*dx;
	    
	    // With respect to the car, detection collision side
	    if(Math.abs(dx)<=width && Math.abs(dy)<=height){
	        if(crossWidth>crossHeight){
	            if (crossWidth > (-crossHeight)){
	            	System.out.println("bottom");
	            	y+= Aladdin.y+Aladdin.h - y;
	            }
	            else if(overlaps(Aladdin)){
	            	//System.out.println("left");
	            	x-= x+w - Aladdin.x;
	            	Aladdin.dead = true;
	            	
	            }
	        }else{
	            if(overlaps(Aladdin)){
	            	//System.out.println("right");
	                x+= Aladdin.x+Aladdin.w - x;
	                Aladdin.dead = true;
	                
				}
	            
	            else{ 
	            	System.out.println("top");
	            	y-= y+h - Aladdin.y;
	            }
	        
		return attack1;
}
		return attack1;
	
}
		return attack1;
}
}



