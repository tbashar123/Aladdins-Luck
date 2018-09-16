import java.awt.Graphics;

public abstract class PolygonModel {

	double x;
	double y;
	double A;

	final int[][] structure = { { 35, 35, -35, -35 }, { -25, 25, 25, -25 }, { 5, 5, -5, -5 }, { -13, 13, 13, -13 },
			{ 30, 30, 5, 5 }, { -3, 3, 3, -3 }, { 28, 28, -28, -28 }, { 25, 33, 33, 25 }, { 28, 28, -28, -28 },
			{ -25, -33, -33, -25 } };
	final int[][] struct_x = struct_x();
	final int[][] struct_y = struct_y();

	// abstract has to be defined by the derived classes that are using it.
	public abstract int[][] struct_x();

	public abstract int[][] struct_y();

	static final double radius = 35;

	public PolygonModel(int x, int y, int A) {

		this.x = x;
		this.y = y;
		this.A = A;

	}

	public void draw(Graphics g) {

		int[] xp = new int[4];
		int[] yp = new int[4];

		double sinA = Lookup.sinA[(int) A];
		double cosA = Lookup.cosA[(int) A];
		for (int poly = 0; poly < 5; poly++) {

			for (int vert = 0; vert < 4; vert++) {
				xp[vert] = (int) (struct_x[poly][vert] * cosA - struct_y[poly][vert] * sinA + x);
				yp[vert] = (int) (struct_x[poly][vert] * sinA + struct_y[poly][vert] * cosA + y);
			}
			g.drawPolygon(xp, yp, 4);
		}

	}

	// Makes the tank able to move in the direction it is facing.
	public void moveForwardBy(int direction) {

		x += (direction * Math.cos(A * Math.PI / 180));
		y += (direction * Math.sin(A * Math.PI / 180));

	}

	public void moveBackwardBy(int direction) {

		x -= (direction * Math.cos(A * Math.PI / 180));
		y -= (direction * Math.sin(A * Math.PI / 180));

	}

	public boolean contains(int mx, int my) {

		int dist2 = (mx - (int) x) * (mx - (int) x) + (my - (int) y) * (my - (int) y);

		return dist2 < radius * radius;

	}

	// moves points in the tank equally
	public void moveBy(int dx, int dy) {

		x += dx;
		y += dy;

	}

	// rotates object by delta A
	public void rotateBy(int dA) {

		A += dA;

		if (A >= 360)
			A -= 360;
		if (A < 0)
			A += 360;

	}

	public void rotateLeftBy(int dA) {

		A -= dA;
		if (A < 0)
			A += 360;

	}

	public void rotateRightBy(int dA) {

		A += dA;

		if (A >= 360)
			A -= 360;

	}
}
