/**
 *  
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 *
 */

public class Fractals {
	public static Curve generateFractal(Fractal fractal, int step) {
	// write your constructor for generateFractal here
		return null; //remove this line when you are done
	}

	public static void main(String[] args) {
	// write your tests here
		SketchPad pad = new SketchPad();
		Koch koch = new Koch();
		Curve step0 = koch.step0();
//		step0.draw(pad);
		Curve step1 = koch.transform(step0);
		Curve step2 = koch.transform(step1);
//		step1.draw(pad);
		Curve step3 = koch.transform(step2);
		step3.draw(pad);
//		CompositeCurve smallGroup = new CompositeCurve();
//		smallGroup.add(new Line(0.1, 0.9, 0.9, 0.9));
//		smallGroup.add(new Line(0.5, 0, 0.5, 0.9));
//		smallGroup.add(new Line(0.1, 0.9, 0.1, 0.8));
////		smallGroup.draw(pad);
//		
//		CompositeCurve bigGroup = new CompositeCurve();
//		bigGroup.add(smallGroup);
//		bigGroup.add(new Line(0.9, 0.9, 0.9, 0.8));
////		bigGroup.draw(pad);
//		
//		bigGroup.scale(0.5, 0.2);
////		bigGroup.rotate(0.5);
////		bigGroup.draw(pad);
//		
//		Curve house2 = bigGroup.copy();
//		house2.rotate(0.5);
//		bigGroup.draw(pad);
////		house2.draw(pad);
//		
////		Curve line1 = new Line(0.1, 0.9, 0.9, 0.9);
////		line1.translate(0, -0.5);
////		Curve line2 = line1.copy();
////		line1.rotate(0.5);
////		line1.draw(pad);
////		line2.draw(pad);


	}
}