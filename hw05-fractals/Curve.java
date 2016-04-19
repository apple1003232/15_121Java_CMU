/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter] 
 *
 */

public interface Curve {
	/**
	 * draw lines
	 * @param pad
	 */
	public void draw(SketchPad pad);
	/**
	 * translates to the right by tx and up by ty
	 * @param tx
	 * @param ty
	 */
	void translate(double tx, double ty); 
	/**
	 * scales width by sx and height by of sy
	 * @param sx
	 * @param sy
	 */
	void scale(double sx, double sy); 
	/**
	 * rotates counter-clockwise by degrees (about the origin)
	 * @param degrees
	 */
	void rotate(double degrees);
	/**
	 * returns a deep copy of this Curve
	 * @return
	 */
	Curve copy(); 

}