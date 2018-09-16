import java.awt.Image;
import java.awt.Toolkit;

public class Animation  {
	Image []image;
	//Image [] image2;
	int current = 0;
	int delay;
	int duration;
	
	
	
	public Animation(String file, int count,int duration, String name){
		

		image = new Image[count];
		//image2 = new Image[count];
		
		
		for(int i = 0; i < count; i++){
			//image[i] = Toolkit.getDefaultToolkit().getImage("C:/Users/Tanvir Bashar/workspace/Video game programming class/src/Enemies/"+file+i+"png");
			image [i] = Toolkit.getDefaultToolkit().getImage("C:/Users/Tanvir Bashar/workspace/Video game programming class/src/"+name+"/"+file+i+".png");
			
			//image2[i] = Toolkit.getDefaultToolkit().getImage("C:/Users/Tanvir Bashar/workspace/Video game programming class/src/Action.png");
			//image [i] = Toolkit.getDefaultToolkit().getImage(file + i + ".png");
			System.out.println(file+i+".png");
		}
	
//System.out.println("/---------/");


		this.duration = duration;
		delay = duration;
}

	public Image stillImage(){
		return image[0];
	}
	
	public Image AttackImage(){
		return image[0];
	}
	public Image AttackImage1(){
		return image[1];
	}
	public Image AttackImage2(){
		return image[2];
	}
	public Image AttackImage3(){
		return image[3];
	}
	public Image AttackImage4(){
		return image[4];
	}
	public Image AttackImage5(){
		return image[5];
	}
	
	public Image stillDeadImage(){
		return image[3];
	}
	
	public Image nextImage(){
		if(delay == 0){
			current++;
			if(current == image.length){
				current = 1;
			}
			delay = duration; 
}
		else{
			delay--;
		}
		return image[current];
	}

}

