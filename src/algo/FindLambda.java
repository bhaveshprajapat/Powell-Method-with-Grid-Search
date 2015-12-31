package algo;
public class FindLambda {

	static double minobj;

	/**
	 * @param startPoint
	 *            The starting co-ordinates
	 * @param direction
	 *            The direction as a vector in the form of a double array
	 * @param boundsLambda
	 *            The bounds of lambda as a double array
	 * @return Returns the optimal lambda value
	 */
	public static double findLambda(double[] startPoint, double[] direction,
			double[] boundsLambda) {
		
		double[] currentPoint = new double[startPoint.length];
		double lambda = boundsLambda[0];
		double bestLambda = lambda;
		for (int j = 0; j < startPoint.length; j++) {
			currentPoint[j] = startPoint[j] + lambda * direction[j];
		}
		double minObjective = EvaluateObjective.eobj(currentPoint);
		int nIter = Integer.parseInt(Main.nIter);
		for (int i = 0; i <= nIter; i++) {
			lambda += (boundsLambda[1] - boundsLambda[0]) / nIter;
			for (int j = 0; j < startPoint.length; j++) {
				currentPoint[j] = startPoint[j] + lambda * direction[j];
			}
			double currentObjective = EvaluateObjective.eobj(currentPoint);
			if (currentObjective < minObjective) {
				minObjective = currentObjective;
				minobj = minObjective;
				bestLambda = lambda;
				System.out.println("Lamba value improved to: " + bestLambda);
			}
		}
		return bestLambda;
	}

	public double minimumobjective() {
		return minobj;
	}
}
