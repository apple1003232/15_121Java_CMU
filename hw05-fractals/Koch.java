/**
 * Koch fractal class
 * @author lihongchen
 *
 */
public class Koch implements Fractal{
	private CompositeCurve koch;
	/**
	 * constructor
	 */
	public Koch(){
		koch = new CompositeCurve();
	}
	@Override
	public Curve step0() {
		koch.add(new Line(0, 0, 1, 0));
		koch.translate(0, 0.3);
		return koch;
	}
	@Override
	public Curve transform(Curve curve) {
		curve.translate(0, -0.3);
		Curve curve0 = curve.copy();
		curve0.scale((double)1/3, (double)1/3);
		Curve curve1 = curve0.copy();
		Curve curve2 = curve0.copy();
		Curve curve3 = curve0.copy();
		curve1.rotate((double)Math.PI/3);
		curve1.translate((double)1/3, 0);
		curve2.rotate(-(double)Math.PI/3);
		curve2.translate(0.5, Math.sqrt(3)/2/3);
		curve3.translate((double)2/3, 0);
		curve0.translate(0, 0.3);
		curve1.translate(0, 0.3);
		curve2.translate(0, 0.3);
		curve3.translate(0, 0.3);
		koch = new CompositeCurve();
		koch.add(curve0);
		koch.add(curve1);
		koch.add(curve2);
		koch.add(curve3);
		return koch;
	}
}
