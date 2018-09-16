
public class Lookup {
	static final double[] cosA = cos();
	static final double[] sinA = sin();
	
	public static double[] cos(){
		double[] cosA = new double[360];
		
		for(int A = 0; A<360; A++){
			cos()[A] = Math.cos(A * Math.PI/180);
			
			
		}
		return cosA;
	
	}
	
	public static double[] sin(){
		double[] sinA = new double[360];
		
		for(int A = 0; A<360; A++){
			sin()[A] = Math.cos(A * Math.PI/180);
		}
		return sinA;
		
	}


}
