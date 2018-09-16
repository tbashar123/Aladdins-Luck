import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;





@SuppressWarnings("serial")
public class Game extends Applet implements KeyListener, MouseListener,MouseMotionListener, Runnable {

	//screen size
	Image off_screen;
	Graphics off_g ;
	
	/*int enemyCount = 5;
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	Random rand = new Random();*/
	//Tank tank = new Tank();
	private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    public int counter;
    public double counter2 = 4;
    
    Line line1 = new Line(1000,650,300,0);
	Line line2 = new Line(623,0,623,724);
	Line line3 = new Line(400,0,400,724);
	Line floor = new Line(0,595,500,595);
	
	
	
	Rect ball = new Rect(10,10,10,10);
	Rect startBox = new Rect(988,309,500,151);
	//Rect dragBox = new Rect(50,50,50,50);
	static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	Font font3 = new Font("TimesRoman",Font.BOLD,100);
	//String [] action = {"rt","lt","up","dn"};
	//Sprite sprite = new Sprite(600, 600, "g_",action,16,4);
	//Sprite sprite2 = new Sprite(0,0,"BG.png", action, 0,0,0,0);
	
	Soldier [] soldier = new Soldier[1];
	Soldier2 [] soldier2 = new Soldier2[1];
	
	//Soldier[] soldier = new Soldier[10];
	boolean moving = false;
	boolean start = false;
	
	Image start_menu = Toolkit.getDefaultToolkit().getImage("C:/Users/Tanvir Bashar/workspace/Video game programming class/src/Startmenu/startscreen.png");
	
	
	//ImageLayer desert = new ImageLayer("C:/Users/Tanvir Bashar/workspace/Video game programming class/src/BG.png",0,0,1);
	ImageLayer desert = new ImageLayer("C:/Users/Tanvir Bashar/workspace/Video game programming class/src/Desertbackground.jpg",0,0,1);
	//C:/Users/Tanvir Bashar/workspace/Video game programming class/src/knightsword.png
	
	//ImageIcon icon = new ImageIcon("file:///C:/Users/Tanvir%20Bashar/Pictures/knightsword.png");
	//Image image = icon.getImage();
	
	//Animation anim = new Animation("g_rt_",12,4);
	//Animation anim2 = new Animation("g_lt_",12,4);
	//Animation anim3 = new Animation("g_up_",12,3);
	//Animation anim4 = new Animation("g_dn_",12,10);
	
	//Animation anim5 = new Animation("g_stillMove_",13,4);
	//Animation anim6 = new Animation("g_spc_",13,4);
	
	//at class scope
	Rect r = new Rect(200,200,400,400);
	
	//Rect enemy = new Rect(1100,1100,550,550);
	
	//Rect r1 = new Rect(400,400,300,200);
	
	PolygonModel [] tank = new PolygonModel[10];
	
	
	PolygonModel activeTank;
	
	Thread t; 
	
	boolean ltPressed = false;
	boolean rtPressed = false;
	//boolean upPressed = false;
	boolean dwnPressed = false;
	boolean spcPressed = false;
	boolean jmpPressed = false;
	
	boolean mouse_inside = false;
	boolean overlap = false;
	
	
	int mx;
	int my;
	
	
	
	
	public void init(){
		this.setSize(dim.width, dim.height);
		this.setBounds(0, 0, dim.width, dim.height);
		off_screen = this.createImage(1366, 768);
		off_g = off_screen.getGraphics();
		
		
		
			  
		
		
		
		
		
		
		
		for(int i = 0;i < soldier.length;i++){
			//soldier[i] = new Sprite(10,400,"g_",action,12,2);
			soldier[i] = new Soldier(10,450, "Aladdin");
			
			
		}
		
		for(int i =0; i<soldier2.length;i++){
			soldier2 [i] = new Soldier2(1100 - (i*90) ,450, "Enemies");
		}
		
		
		 
		
		/*for(int i = 0; i<enemy.length;i++){
			enemy[i] = new Enemy(10,1000);
		}*/
		/*for(int i = 0; i< enemyCount; i++){
			addEnemy(new Enemy(rand.nextInt(800), rand.nextInt(600)));
		}*/
		
		
		for(int i = 0; i < tank.length;i++){
			tank [i] = new Tank(500,100,90);
			activeTank = tank[0];
		}
		
		requestFocus(); //makes the program request focus from the operating system
		addKeyListener(this);
		//"this" means this program
		//this program is a keyListener itself
		//this == I
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		t = new Thread(this);// "This" parameter. This line creates a thread
		t.start();
		
		
		
		
	}
	
	
	@SuppressWarnings("static-access")
	public void run() {
		x = 100; 
		y = 100;
		//game loop
		//make the loop sleep
		//make it try to sleep
		//test.play(stream);
		
		while(!start){


			repaint();

			try{

				t.sleep(15);

			}catch(Exception x){}
		}
		
		
		
		
		
		while(start ){//dont stop
			/*if(y<=348){
				y+=10;
			}
			
			if(y >=348){
				y = 348;
			}*/
			
			
			
			for(int i =0; i<soldier2.length; i++){
				soldier2[i].follow(soldier[0]);
					
				}
			
			 
			
			
			
			for(int i =0; i<soldier2.length; i++){
				soldier2[i].attack(soldier2[0]);
			}
			
			
			/*
			if(ltPressed){
				
				
				//tankMoving.play(s);
				sprite.moveLeftBy(3);
				
				
			}
		
			if(rtPressed){
				sprite.moveRightBy(3);
				
				
			}
			if(upPressed){
				sprite.moveUpBy(5);
				
			}
			if(dwnPressed){
				sprite.moveDownBy(5);
				
			}
			*/
		for(int i =0;i<soldier.length;i++){
			
			//System.out.println(soldier[i].x);
			
			//desert.moveLeftBy(6);
			
			//soldier[i].stillAnimation();
			soldier[i].move1();
			if(soldier[i].selected) {
				
				//soldier[i].draw(off_g);
				//r.draw(off_g);
				
				double d1 = line2.distance(soldier[i].x, soldier[i].y);
				double d2 = line3.distance(soldier[i].x, soldier[i].y);
				
				if(soldier[i].w >d1){
					soldier[i].moveBy((int)((soldier[i].w - d1)*line2.xN),(int)((soldier[i].w-d1)*line2.yN));
					desert.moveLeftBy(4);
					off_g.drawString("d = " + d1,500,50);
				}
				
				
				
				for(int j=0; j<soldier2.length; ++j){
					   if((soldier[i].overlaps(soldier2[j]))){
						   System.out.println("");
					   int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to play another game?");
					   if(yesNo == 0){
						   init();
					   }
					   else{
						   JOptionPane.showMessageDialog(null, "BYE");
							System.exit(ABORT);
						}
						System.out.println(yesNo);
				   }
					   }
				
				
				
				/*if(soldier[i].y <= 536.0 && !jmpPressed){
	                   soldier[i].y=soldier[i].y+5;
	                   //randomBullets.get(i).y = randomBullets.get(i).y+5;
	                   //samus[i].pose = 2;
	               }*/
				
				
				
				
				if(jmpPressed){
					/*counter2 += 0.5;
					
					soldier[i].y = soldier[i].y + (int) ((Math.sin(counter2)+Math.cos(counter2)) * 5);
					if(counter2 >= 7){
						counter = 4;
					}*/
				//activeTank.moveForwardBy(5);
				
				soldier[i].jump(-1);
				jmpPressed = true;
				ltPressed = false;
				rtPressed = false;
				
				soldier[i].moveJumpBy(1);
				}
					   
			
				/*int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to play another game?");
				   if(yesNo == 0){
					   init();
				   }
				   else{
					   JOptionPane.showMessageDialog(null, "BYE");
						System.exit(ABORT);
					}
					System.out.println(yesNo);
				   }*/
				
			
				
				//jmpPressed = true;
				
				
				
			}
			if(dwnPressed){
				//activeTank.moveBackBy(-5);
				soldier[i].moveDownBy(5);
		
			}
			
			
			if(ltPressed){
				//soldier[i].rotateLeft(action);
				//tankMoving.play(s);
				//activeTank.rotateLeftBy(6);
				
				soldier[i].moveLeftBy(5);
				if(soldier[i].x>200){
					desert.moveLeftBy(1);
					
				}
				for(int j=0; j<soldier.length; ++j){
					   soldier2[i].overlaps2(soldier[j]);
				}
				//mountain.moveRightBy(2);
				
			}
		
			if(rtPressed){
				
				//activeTank.rotateRightBy(6);
				soldier[i].moveRightBy(5);
               
				
				if(soldier[i].x < 200) {
					desert.moveRightBy(1);
				}
				for(int j=0; j<soldier.length; ++j){
					   soldier2[i].overlaps2(soldier[j]);
				}
					//System.out.println("Overlap");
				//mountain.moveLeftBy(2);
				}
			
			if(spcPressed){
			   soldier[i].attackAnimation();
			   
			  
			   //for(int j=0; j<soldier2.length; ++j)
			   //{
				   /*if(soldier[i].punch(soldier2[j]))
					   System.out.println("Punch HIT");
				   else
					   System.out.println("Punch MISSED");
				   }*/
			   
			   /*for(int k =0; k<soldier.length; ++k){
				   if(soldier2[i].attack(soldier[k]))
					   System.out.println("attack");
				   else{
					   System.out.println("miss");
				   }
			   }*/
			}
			}
			repaint();
			
			try{
				t.sleep(15);
			}catch(Exception x){}
		}

		}

		
		
		
		

		
			
			
			
			
			
			
	
	
	public void update(Graphics g){
		off_g.clearRect(0, 0, 1366, 768);
		paint(off_g);
		g.drawImage(off_screen, 0, 0, null);
		
	}
	
	
	
	
	
	public void paint(Graphics g){
		//g.drawImage(jungle, 0, 100, 1366, 500, this);
		//ball.draw(g);
		
		//tank.draw(g);
		
		//g.drawImage(mountain,0,0,null);
		//g.drawImage(house,0,0,null);
		
		if(!start) {
			g.drawImage(start_menu, 0, 0, 1200,700,null);
			g.setFont(font3);
			g.setColor(Color.ORANGE);
			//g.drawString("Aladdin`s Luck", 380, 180);

			//startBox.draw(g);

		} 
		if(start){
			
			
	   
		desert.draw(g);
		
		floor.draw(g);
		
		line2.draw(g);
		line3.draw(g);
		
		//r.draw(g);
		//}
		
		for(int i = 0;i<soldier.length;i++){
			soldier[i].draw(g);
			r.draw(g);
			double d1 = line2.distance(soldier[i].x, soldier[i].y);
			double d2 = line3.distance(soldier[i].x, soldier[i].y);
		}
		
		for(int i =0; i<soldier2.length; i++){
			soldier2[i].draw(g);
		    r.draw(g);
		}
		
		
		/*for(int i = 0; i<enemies.size(); i++){
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g);
		}*/
		
		/*for(int i =0; i<enemy.length; i++){
			enemy[i].draw(g);
			r2.draw(g);
			//r.draw(g);
		}*/
		
		//g.drawImage(anim5.nextImage(),100,446,90,90,this);
		//g.drawImage(img2,-300,-200,this);
	    
		//g.drawImage(img, 300, 0 ,this);
	   
		
		
		
		
		
		//soldier.draw(g);
	
		//g.drawImage(anim.nextImage(),100,446,90,90,this);
		//g.drawImage(anim2.nextImage(),300,446,90,90,this);
		//g.drawImage(anim3.nextImage(),500,446,90,90,this);
		//g.drawImage(anim4.nextImage(),700,431,90,110,this);
		
		/*
		//g.drawImage(image,100,100,300,500,this);
		//g.drawImage(jungle, 0, 300, this);
		//g.drawImage(image, 100, 455,50,80,this);
		r.draw(g);
		r1.draw(g);
		
		for(int i = 0;i < tank.length;i++){
			tank[i].draw(g);
		}*/
		/*
		if(overlap){
			g.drawString("Overlap", mx, my);
		}
		else{
			g.drawString("-------", mx, my);
		}
		
	*/
	
	}
	}
	
	public void move(){
		x += dx;
		y += dy;
		
	}
	
	public void mouseMoved(MouseEvent e){
	/*	mx = e.getX();
		my = e.getY();
		
		mouse_inside = false;
		/*
		if(r.contains(mx, my)){
			mouse_inside = true;
		}
		else{
			mouse_inside = false;
		}
		*/
		
		/*
		for(int i = 0; i < tank.length;i++){
			mouse_inside = tank[i].contains(mx, my);
			
			if(mouse_inside){
				break; //break kills the loop
			}
		}
	*/
	}
public void mouseDragged(MouseEvent e){
		
		//these are not the same as the ones in mousePressed because these are not at class scope
		int mx = e.getX();
		int my = e.getY();
		
		
		
						//this.mx  and this.my is outside of area
		int dx = mx - this.mx;
		int dy = my - this.my;
		
		
		r.resizeBy(dx, dy);
		//dragBox.resizeBy(dx, dy);
		
		for(int i =0;i<soldier.length;i++){
			
			//This could be in an else
			soldier[i].selected = false;
			
			if(r.overlaps(soldier[i]))
			
				soldier[i].selected = true;
		}
		
		for(int i=0; i<soldier2.length;i++){
			
			soldier2[i].selected = false;
			if(r.overlaps(soldier2[i]))
				soldier2[i].selected = true;
		}
		
		
		
		
		this.mx = mx;
		this.my = my;
		
		
		
	}	
	
	/*public void addEnemy(Enemy e){
		enemies.add(e);
	}*/
	
	public void mousePressed(MouseEvent e){
		 mx = e.getX();
		 my = e.getY();
		 
		 r = new Rect(mx,my,0,0);
		 
		 if(startBox.contains(mx, my)) {
			 System.out.println("clicked in square");
			 this.start = true;
			 r = new Rect(mx,my,0,0);
		 }
		
		/* for(int i = 0;i < soldier.length;i++){
	
					soldier[i].selected = false;
			}*/
		 
		 
		 
		 
		 /*
		 if(r.contains(mx, my)){
			 r.grab();
		 }
		 */
		/*
		 for(int i = 0;i<tank.length;i++){ 
		 
		 if(tank[i].contains(mx, my)){
			 activeTank = tank[i];
		 }
		 
		}
		//*/
	}

	public void mouseReleased(MouseEvent e){
		
		r = new Rect(-100,0,0,0);
		//r.drop();
		
		
	}

	public void mouseClicked(MouseEvent e){
	
	}
	
	public void mouseEntered(MouseEvent e){
		
	}

	public void mouseExited(MouseEvent e){
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
int key = e.getKeyCode();


		
		if(key == KeyEvent.VK_SPACE){
			spcPressed = true;
			System.out.println("OK!!!!");
		}
		
		
	}

	
	
	
	


	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			
			ltPressed = true;
			System.out.print("Left");
			
		}
		 if (key == KeyEvent.VK_RIGHT) {
			 	rtPressed = true;
			 	System.out.print("Right");
	        }
		
		 if(key == KeyEvent.VK_SPACE){
	        	spcPressed = true;
	        	System.out.print("HIT");
	        }
		 if (key == KeyEvent.VK_UP) {
				dy -=2;
				jmpPressed = true;
				 
				/*if(e.getKeyCode() == 38){
			    	jmpPressed = true;
			    }*/
				//System.out.print("JUMP");
				
			    /*dy = 348;
			    if(dy ==348){
			    	dy = dy - 348;
			    }*/
			}

	        

	        if (key == KeyEvent.VK_DOWN) {
	        	
	            dy = -348;
	        }
	        
	        
	    }
	
	
	    public void keyReleased(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	        	ltPressed = false;
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        	rtPressed = false;
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_UP) {
	        	//jmpPressed = false;
	           // dy = 0;
	            //if(e.getKeyCode() == 38){
		        	jmpPressed = false;
		        	//counter2 = 4;
		        }
	        

	        if (key == KeyEvent.VK_DOWN) {
	        	
	            dy = 0;
	        }
	        if(key == KeyEvent.VK_SPACE){
	        	spcPressed = false;
	        	dx = 0;
	        }
	        
	    }
}
	
	
	

	
	
	
		




