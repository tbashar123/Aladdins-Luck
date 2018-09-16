import java.awt.Color;
import java.awt.Graphics;

public class Sprite extends Rect {

	Animation[] animation;
	Animation[] attack;
	//Animation[] attack1;
	//Animation2 [] animation2;

	boolean selected = false;

	boolean moving = false;
	boolean punch = false;
	boolean dead = false;
	boolean attack1 = false;
	boolean attack2 = false;
	boolean attack3 = false;
	boolean attack4 = false;
	boolean attack5 = false;
	boolean attack6 = false;
	int count = 0;
    
	
	int dx = 0;
	int dy = 0;
	
	static final int LEFT = 0;
	static final int RIGHT = 1;
	//static final int UP = 2;
	//static final int DOWN = 3;
	static final int SPACE = 2;
	static final int STILL = 3;
	static final int UP = 4;

	
	
	int pose = LEFT;

	public Sprite(int x, int y, String file, String[] action,   int count, int duration, String name) {
		super(x, y, 45, 65);
        
		animation = new Animation[action.length];
		//attack = new Animation[3];
		//attack1 = new Animation[6];
		//animation2 = new Animation2[action.length];

		for (int i = 0; i < action.length; i++) {
			animation[i] = new Animation(file + action[i] + "_",count, duration, name);
			//animation2[i] = new Animation2(file + action[i] + "_",count,duration);
		}
		
		/*for(int i =0; i<attack.length; i++){
			attack[i] = new Animation(file + action[i] + "_", count, duration, name);
		}*/
		
		/*for(int i=0; i<=attack.length;i++){ 
			attack[i] = new Animation(file + attkAnim + "_", count, duration);
		}*/
		
	}

	public void moveJumpBy(int dy) {

		y -= dy;
		if( y<=5)
			y = 5;
		moving = true;
		//duration =10;
		pose = UP;
		//h = 65;
	}

	public void moveDownBy(int dy) {

		y += dy;
		moving = true;
				//pose = DOWN;
	}

	public void moveLeftBy(int dx) {
		x -= dx;
		if(x <= 50)
			x = 50;
		moving = true;
		//System.out.println(x);
		pose = LEFT;
		w = -45;
	}

	public void moveRightBy(int dx) {
		x += dx;
		if(x >= 1335)
			x = 1335;
		moving = true;
		pose = LEFT;
		w = 45;
	}

	public void stillAnimation(){
		pose = STILL;
		
	}
	public void attackAnimation(){
		moving = true;
		pose = SPACE;
	}
	
	/*
	 * public void rotateLeft(String[]action) { for(int i = 0; i <
	 * action.length; i++){ animation[i] = new Animation("g_" +
	 * action[i]+"_",3,2); } }
	 */

	public void draw(Graphics g) {

		if (moving){
			g.drawImage(animation[pose].nextImage(), (int)x,(int) y, w,65, null);
		   /* g.drawImage(attack[pose].nextImage(), (int)x, (int)y, w, 65, null);*/
		    }
		/*else if(punch){
			g.drawImage(attack[pose].nextImage(), (int)x, (int)y,w,65,null);
		}*/
		    //g.drawImage(animation2[pose].nextImage(), (int)x, (int)y, w, 65, null);}
		else if(attack1)
		{
			g.drawImage(animation[1].AttackImage(), (int)x,(int)y, w, 65,null);
		}
		
		else if(attack2)
		{
			g.drawImage(animation[1].AttackImage1(), (int)x, (int)y, w, 65,null);
		}
		else if(attack3){
			g.drawImage(animation[1].AttackImage2(), (int)x, (int)y, w, 65,null);
		}
		else if(attack4){
			g.drawImage(animation[1].AttackImage3(), (int)x, (int)y, w, 65,null);
		}
		else if(attack5){
			g.drawImage(animation[1].AttackImage4(), (int)x, (int)y, w, 65,null);
		}
		else if(attack6){
			g.drawImage(animation[1].AttackImage5(), (int)x, (int)y, w, 65,null);
		}
		
		else if (dead)
		{
			g.drawImage(animation[1].stillDeadImage(), (int)x,(int) y, w,65, null);
		}
		
		
		else{
			
				//g.drawImage(animation[pose].nextImage(),(int)x,(int)y,w,65,null);
			
			g.drawImage(animation[pose].stillImage(), (int)x, (int)y,w,65, null);
			/*g.drawImage(attack[pose].stillImage(), (int)x, (int)y, w, 65, null);*/
			}
		//g.drawImage(animation2[pose].stillImage(), (int)x, (int)y,w,65, null);
		// g.drawImage(animation[pose].stillImage(),x,y,null);
		moving = false;
		punch = false;
		//
		//super.draw(g);
		//g.setColor(Color.BLACK);
		//if (selected)
			//super.draw(g);
			//g.drawLine((int)x+8,(int) y, (int)x+(int)w-8, (int)y);
			 //g.setColor(Color.BLACK);

		}

}
