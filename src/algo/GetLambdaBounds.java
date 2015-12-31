package algo;
public class GetLambdaBounds {
	/**
	 * @param startPoint
	 *            Start Co-ordinates
	 * @param direction
	 *            Direction as a vector in the form of a double array
	 * @param lowerBound
	 *            The lower bound as set
	 * @param upperBound
	 *            The upper bound as set
	 * @return Returns bounds for lambda
	 */
	public static double[] getLambdaBounds(double[] startPoint,
			double[] direction, double[] lowerBound, double[] upperBound) {
		double minUpper = 0;
		double maxLower = 0;
		for (int i = 0; i < startPoint.length; i++) {
			double upper = (upperBound[i] - startPoint[i]) / direction[i];
			double lower = (lowerBound[i] - startPoint[i]) / direction[i];
			if (i == 0 || upper < minUpper) {
				minUpper = upper;
			}
			if (i == 0 || lower > maxLower) {
				maxLower = lower;
			}
		}
		return new double[] { maxLower, minUpper };
	}

}
