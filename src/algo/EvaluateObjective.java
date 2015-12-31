package algo;
public class EvaluateObjective {

	/**
	 * @param CurrentPoint
	 *            X and Y values to find a Z value for
	 * @return Returns Z as a double
	 */
	public static double eobj(double[] CurrentPoint) {
		// return (CurrentPoint[0] * CurrentPoint[0])
		// + (CurrentPoint[1] * CurrentPoint[1])
		// - (CurrentPoint[0] * CurrentPoint[1]) + (12 * CurrentPoint[0])
		// - (10 * CurrentPoint[1]);
		double x = CurrentPoint[0];
		double y = CurrentPoint[1];
		
		return(
				//(4-2.1*pow(x,2) + (pow(x,4)/4)*((pow(x,2)+x*y+(-4+pow(y,2)))*pow(y,2))) 
				//Math.pow((x+(2*y)-7),2)+Math.pow(((2*x)+y-5),5)
				Math.pow((x-10), 2)+Math.pow((y+5), 2)
				
				);
	}
	public static double pow(double a, double b){
		return(Math.pow(a,b));
		
	}
}
