import java.awt.*;

public class Tank extends PolygonModel {

	public Tank(int x, int y, int A) {

		super(x, y, A);

	}

	public int[][] struct_x() {
		final int[][] struct_x = { { 35, 35, -35, -35 }, { 5, 5, -5, -5 }, { 30, 30, 5, 5 }, { 28, 28, -28, -28 },
				{ 28, 28, -28, -28 } };
		return struct_x;
	}

	public int[][] struct_y() {
		final int[][] struct_y = { { -25, 25, 25, -25 }, { -13, 13, 13, -13 }, { -3, 3, 3, -3 }, { 25, 33, 33, 25 },
				{ -25, -33, -33, -25 } };
		return struct_y;
	}

	public void shoot(Rect Shell) {
		double unit_vx = Math.cos(A * Math.PI / 180);
		double unit_vy = Math.sin(A * Math.PI / 180);
		Shell.setLocation(x + 30 * unit_vx, y + 30 * unit_vy);
		double vx = (10 * Math.cos(A * Math.PI / 180));
		double vy = (10 * Math.sin(A * Math.PI / 180));
		Shell.setVelocity(vx, vy);
	}

	/*
	 * public void draw(Graphics g){ int[] xp = new int[4]; int[] yp = new
	 * int[4];
	 * 
	 * for(int i = 0; i < 4; i++){ xp[i] = (int) ((bodyx[i]*cosA -
	 * bodyy[i]*sinA) + x); yp[i] = (int) (bodyx[i]*sinA + bodyy[i]*cosA) + y; }
	 * g.drawPolygon(xp,yp,4); for(int i = 0; i < 4; i++){ xp[i] = (int)
	 * ((turretx[i]*cosA - turrety[i]*sinA) + x); yp[i] = (int)
	 * ((turrety[i]*cosA - turretx[i]*sinA) + y); } g.drawPolygon(xp,yp,4);
	 * for(int i = 0; i < 4; i++){ xp[i] = (int) ((gunx[i]*cosA - guny[i]*sinA)
	 * + x); yp[i] = (int) ((guny[i]*cosA - gunx[i]*sinA) + y); }
	 * g.drawPolygon(xp,yp,4);
	 * 
	 * }
	 */
}
/*
 * public Tank(int x, int y){
 * 
 * moveBy(x,y);
 * 
 * }
 * 
 * Rect body = new Rect(-50,70,100,140); Rect turret = new Rect(-25,20,50,40);
 * Rect gun = new Rect(-5,60,10,40);
 * 
 * public void draw(Graphics g){ body.draw(g); turret.draw(g); gun.draw(g); }
 * 
 * public void moveBy(int dx, int dy){ body.moveBy(dx, dy); turret.moveBy(dx,
 * dy); gun.moveBy(dx, dy); }
 */
