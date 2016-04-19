/**
 * Sierpinski fractal class
 * @author lihongchen
 *
 */
public class Sierpinski implements Fractal{
	private CompositeCurve sier;
	/**
	 * constructor
	 */
	public Sierpinski(){
		sier = new CompositeCurve();
	}
	@Override
	public Curve step0(){
		sier.add(new Line(0, 0, 1, 0));
		sier.add(new Line(0, 0, 0.5, Math.sqrt(3)/2));
		sier.add(new Line(0.5, Math.sqrt(3)/2, 1, 0));
		return sier;
	}

	@Override
	public Curve transform(Curve curve) {
		Curve curve0 = curve.copy();
		curve0.scale(0.5, 0.5);
		Curve curve1 = curve0.copy();
		Curve curve2 = curve0.copy();
		curve1.translate(0.5, 0);
		curve2.translate(0.25, Math.sqrt(3)/4);
		sier = new CompositeCurve();
		sier.add(curve0);
		sier.add(curve1);
		sier.add(curve2);
		return sier;
	}
}
