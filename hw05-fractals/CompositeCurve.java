import java.util.ArrayList;
/**
 * CompositeCurve is the composition of curves
 * @author lihongchen
 *
 */
public class CompositeCurve implements Curve{
	private ArrayList<Curve> list;
	
	/**
	 * constructor
	 */
	public CompositeCurve(){
		list = new ArrayList<Curve> ();
	}
	/**
	 * add a curve to CompositeCurve
	 * @param cur the added curve
	 */
	public void add(Curve cur){
		list.add(cur);
	}
	/**
	 * add a CompositeCurve object to this object
	 * @param obj the added object
	 */
	public void add(CompositeCurve obj){
		for(int i = 0; i < obj.list.size(); i++){
			list.add(obj.list.get(i));
		}
	}
	
	@Override
	public void draw(SketchPad pad){
		for(int i = 0; i < list.size(); i++){
			list.get(i).draw(pad);
		}
	}
	
	@Override
	public void translate(double tx, double ty){
		for(int i = 0; i < list.size(); i++){
			list.get(i).translate(tx, ty);
		}
	}
	
	@Override
	public void scale(double sx, double sy){
		for(int i = 0; i < list.size(); i++){
			list.get(i).scale(sx, sy);
		}
	}
	
	@Override
	public void rotate(double degrees){
		for(int i = 0; i < list.size(); i++){
			list.get(i).rotate(degrees);
		}
	}
	
	@Override
	public CompositeCurve copy(){
		CompositeCurve c = new CompositeCurve();
		for(int i = 0; i < list.size(); i++){
			c.list.add(list.get(i).copy());
		}
		return c;
	}
}
