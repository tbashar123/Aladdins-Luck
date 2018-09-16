import java.awt.*;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Soldier extends Sprite {
	float vy; 
		
	
	
	static String [] action = {"rt","lt","spc","stillMove","jmp"};
	//static String attkAnim = "spc";
	
	public Soldier(int x, int y, String name){
		
	
		super(x, y, "g_", action,  13, 3, name);
		
		
	}
	
	/*public boolean punch(Soldier2 enemy){
		if(overlaps(enemy)){
			System.out.println("Overlapping");
			enemy.dead = true;
			
			return true;
		}
		return false;
	}*/
	
	public void move1(){
		vy += 0.2;  
		y+= vy;
		if(y > 450)      // To prevent aladdin from going through the floor
			   y = 450;
		if(y < 0)  {    // To prevent aladdin from going through the ceiling
            y = 0;
		    vy = 0;
		}
		
	}
	
	
	public void jump(float vy){
		pose = 4;
		this.vy += vy;
			    y+= this.vy;
	}
	
public boolean overlaps1(Soldier2 enemy){
	
	double dx=(x+w/2)-(enemy.x+enemy.w/2);
	    double dy=(y+h/2)-(enemy.y+enemy.h/2);
	    double width=(w+enemy.w)/2;
	    double height=(h+enemy.h)/2;
	    double crossWidth=width*dy;
	    double crossHeight=height*dx;
	    
	    // With respect to the car, detection collision side
	    if(Math.abs(dx)<=width && Math.abs(dy)<=height){
	        if(crossWidth>crossHeight){
	            if (overlaps(enemy)){
	            	//System.out.println("bottom");
	            	y+= enemy.y+enemy.h - y;
	            	enemy.dead=true;
	            	
	            }
	            else{
	            	System.out.println("left");
	            	x-= x+w - enemy.x;
	            }
	        }else{
	            if(crossWidth>-(crossHeight)){
	            	System.out.println("right");
	                x+= enemy.x+enemy.w - x;
	            }
	            else{ 
	            	System.out.println("top");
	            	y-= y+h - enemy.y;
	            }
	        }
	    }
		return attack1;
}
}
