package algo;
/**
 * @author Bhavesh Prajapat & Jed Rutherford (& Joe)
 *
 */
public class Main {
	static boolean firstrun = true;
	// Sets the n in the Sn value to 2 (for a 2 dimensional array)
	static int n = 2;
	// Creates a new array for storing the current value (working on)
	public static double[] CurrentPoint = new double[n];
	// The start point
	public static double[] StartPoint = new double[n];
	// New arrays for upper and lower bounds
	static double[] lowerBound = new double[n];
	static double[] upperBound = new double[n];
	static double[] boundsLambda;
	// Create direction jagged 2 dimensional double array
	static double[][] S = new double[n][n];
	public static double lambda;
	public static double tolerance;
	public static String nIter = new String();

	public static void main(String[] args) {
		nIter = args[4];
		System.out.println("nIter is " + nIter);
		CurrentPoint = StartPoint;
		tolerance = Double.parseDouble(args[1]);
		// While i is less than the set dimensions

		for (int i = 0; i < n; i++) {
			// Sets the start point to 1
			StartPoint[i] = Double.parseDouble(args[0]);
			// Sets the lower bound to -10
			lowerBound[i] = Double.parseDouble(args[2]);
			// sets the upper bound to 10
			upperBound[i] = Double.parseDouble(args[3]);
		}
		// Prints outputs
		System.out.println("Initial point : " + StartPoint[0] + ","
				+ StartPoint[1]);
		System.out.println("Lower bound : " + lowerBound[0] + ","
				+ lowerBound[1]);
		System.out.println("Upper bound : " + upperBound[0] + ","
				+ upperBound[1]);

		// set directions
		for (int i = 0; i < n; i++) {
			S[i][i] = 1;
		}
		// 1-d optimisation to get lambda value
		boundsLambda = GetLambdaBounds.getLambdaBounds(StartPoint, S[n - 1],
				lowerBound, upperBound);
		lambda = FindLambda.findLambda(CurrentPoint, S[n - 1], boundsLambda);
		//System.out.println("optimal lambda =" + lambda);

		// update current point & save z
		double z[] = new double[n];
		for (int i = 0; i < n; i++) {
			CurrentPoint[i] = CurrentPoint[i] + lambda * S[1][i];
			z[i] = CurrentPoint[i];
		}
		System.out.println("current point = " + CurrentPoint[0] + ","
				+ CurrentPoint[1]);

		boolean stop = false; // initialise flag for stopping

		while (true) {
			// Set Z = X
			for (int i = 0; i < n; i++) {
				z[i] = CurrentPoint[i];
			}

			for (int I = 0; I < n; I++) {// loop through directions

				// 1-d optimisation to get lambda value
				 boundsLambda = GetLambdaBounds.getLambdaBounds(CurrentPoint,
						S[I], lowerBound, upperBound);

				 lambda = FindLambda
						.findLambda(CurrentPoint, S[I], boundsLambda);

				System.out.println("optimal lambda =" + lambda);

				// update current point
				for (int i = 0; i < n; i++) {
					CurrentPoint[i] = CurrentPoint[i] + lambda * S[I][i];
				}
				System.out.println("current point = " + CurrentPoint[0] + ","
						+ CurrentPoint[1]);

				// stop condition
				stop = StopCriteria.stop(EvaluateObjective.eobj(z),
						EvaluateObjective.eobj(CurrentPoint));

				if (stop) {
					break;
				}
			}
			// stop condition
			stop = StopCriteria.stop(EvaluateObjective.eobj(z),
					EvaluateObjective.eobj(CurrentPoint));
			if (stop) {
				break;
			}
			double[] newDirection = new double[n];
			for (int i = 0; i < n; i++) {
				newDirection[i] = CurrentPoint[i] - z[i];
			}
			System.out.println("New Direction is" + newDirection[0] + " & "
					+ newDirection[1]);
			// 1-d optimisation to get lambda value
			boundsLambda = GetLambdaBounds.getLambdaBounds(CurrentPoint,
					newDirection, lowerBound, upperBound);

			lambda = FindLambda.findLambda(CurrentPoint, newDirection,
					boundsLambda);
			// update current point
			for (int i = 0; i < n; i++) {
				CurrentPoint[i] = CurrentPoint[i] + lambda * newDirection[i];
			}
			System.out.println("Current points = " + CurrentPoint[0] + ","
					+ CurrentPoint[1]);
			//System.out.println("optimal lambda =" + lambda);
			// stop condition
			stop = StopCriteria.stop(EvaluateObjective.eobj(z),
					EvaluateObjective.eobj(CurrentPoint));
			if (stop) {
				break;
			} else {
				for (int i = 0; i < n - 1; i++) {
					for (int j = 0; j < n; j++) {
						S[i][j] = S[i + 1][j];
					}
				}
				for (int j = 0; j < n; j++) {
					S[n - 1][j] = newDirection[j];
				}

			}
		}
		System.out.println("Finished with:");
		System.out.println("X = " + CurrentPoint[0] + " Y = " + CurrentPoint[1]
				+ " Z = " + EvaluateObjective.eobj(CurrentPoint));
	}
}
