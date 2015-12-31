package algo;

public class OneDOptimiser {

	/**
	 * @param StartPoint
	 * @param direction
	 * @param lowerBound
	 * @param upperBound
	 * @return Returns the bounds at which we should test values
	 */
	public static double[] boundsLambda(double[] StartPoint,
			double[] direction, double[] lowerBound, double[] upperBound) {

		return (GetLambdaBounds.getLambdaBounds(StartPoint, direction,
				lowerBound, upperBound));
	}

	/**
	 * @param CurrentPoint
	 * @param S
	 * @param boundsLambda
	 * @return Calls FindLambda to find the optimal value of lambda
	 */
	public static double lambda(double[] CurrentPoint, double[] S,
			double[] boundsLambda) {
		return (FindLambda.findLambda(CurrentPoint, S, boundsLambda));

	}

}
