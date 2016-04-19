/**
 * Line is define by x1, y1, x2, y2
 * @author lihongchen
 *
 */
public class Line implements Curve{
	private double x1, y1, x2, y2;
	/**
	 * constructor
	 * @param a x1
	 * @param b y1
	 * @param c x2
	 * @param d y2
	 */
	public Line(double a, double b, double c, double d){
		x1 = a;
		y1 = b;
		x2 = c;
		y2 = d;
	}
	
	@Override
	public void draw(SketchPad pad){
		pad.drawLine(x1, y1, x2, y2);
	}
	
	@Override
	public void translate(double tx, double ty){
		x1 += tx;
		y1 += ty;
		x2 += tx;
		y2 += ty;
	}
	
	@Override
	public void scale(double sx, double sy){
		x1 *= sx;
		y1 *= sy;
		x2 *= sx;
		y2 *= sy;
	}
	
	@Override
	public void rotate(double degrees){
		double tx1, tx2, ty1, ty2;
		tx1 = x1 * Math.cos(degrees) - y1 * Math.sin(degrees);
		ty1 = x1 * Math.sin(degrees) + y1 * Math.cos(degrees);
		tx2 = x2 * Math.cos(degrees) - y2 * Math.sin(degrees);
		ty2 = x2 * Math.sin(degrees) + y2 * Math.cos(degrees);
		x1 = tx1;
		x2 = tx2;
		y1 = ty1;
		y2 = ty2;
	}
	
	@Override
	public Line copy(){
		Line l = new Line(x1, y1, x2, y2);
		return l;
	}
}
