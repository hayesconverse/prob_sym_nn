package prob_sym_nn;

import gov.nasa.jpf.symbc.Debug;


public class ExampleConcolicNN {

	public static void main(String[] args) {
		double[] data = AdultIncomeDataGenerator.popModel();
		F(data[1],data[2],data[3]);
		Debug.printPC("PC");
	}
/*
	def F():
	    N_age = ((age - 17.0) / 73.0  - 0.5) * 10 + 0.5
	    N_education_num = ((education_num - 3.0) / 13.0  - 0.5) * 10 + 0.5
	    N_capital_gain = ((capital_gain - 0.0) / 22040.0 - 0.5) * 10 + 0.5
	    h1 = -0.2277 * N_age +  0.6434 * N_education_num +  2.3643 * N_capital_gain +  3.7146
	    if h1 < 0:
	        h1 = 0
	    h2 = -0.0236 * N_age + -3.3556 * N_education_num + -1.8183 * N_capital_gain + -1.7810
	    if h2 < 0:
	        h2 = 0
	    o1 =  0.4865 * h1 +  1.0685 * h2 + -1.8079
	    if o1 < 0:
	        o1 = 0
	    o2 =  1.7044 * h1 + -1.3880 * h2 +  0.6830
	    if o2 < 0:
	        o2 = 0
	    return o1 < o2
	fairnessTarget(o1 < o2)
	*/
	// the code does not even use "sex"
	static boolean F(double age, double education_num, double capital_gain) {
		double N_age = ((age - 17.0) / 73.0  - 0.5) * 10 + 0.5;
		double N_education_num = ((education_num - 3.0) / 13.0  - 0.5) * 10 + 0.5;
		double N_capital_gain = ((capital_gain - 0.0) / 22040.0 - 0.5) * 10 + 0.5;
		double h1 = -0.2277 * N_age +  0.6434 * N_education_num +  2.3643 * N_capital_gain +  3.7146;
		if (h1 < 0)
			        h1 = 0;
		double h2 = -0.0236 * N_age + -3.3556 * N_education_num + -1.8183 * N_capital_gain + -1.7810;
		if (h2 < 0)
			        h2 = 0;
		double o1 =  0.4865 * h1 +  1.0685 * h2 + -1.8079;
		if (o1 < 0)
			        o1 = 0;
		double o2 =  1.7044 * h1 + -1.3880 * h2 +  0.6830;
		if (o2 < 0)
			        o2 = 0;
		return o1 < o2;
		
	}
}
