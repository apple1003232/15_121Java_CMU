/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter] 
 *
 */

public interface Fractal {
	/**
	 * returns a new Curve representing step 0 of the fractal
	 * @return
	 */
	Curve step0(); 
	/**
	 * given a Curve representing step n of the fractal,
	 * uses it to return a new Curve representing step n+1 of the fractal
	 * @param curve
	 * @return
	 */
	Curve transform(Curve curve);

}