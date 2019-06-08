package prob_sym_nn;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.lang.Double;

public class AdultIncomeDataGenerator { 
	
	private static int step_(double[] massDist) {
		double randRoll = Math.random();
		double sum = 0;
		int result = 1;
		for(double mass: massDist) {
			sum += mass;
			if(randRoll < sum) {
				return result;
			}
			result++;
		}
		return result;
	}
	
	private static double step(double[][] l) {
		double[] massDist = new double[l.length];
		int i;
		for(i = 0; i < l.length; i++) {
			if(l[i].length != 3){
				System.out.println("error, step function requires arrays of length 3");
				return -1;
			}
			massDist[i] = l[i][2];
		}
		i = AdultIncomeDataGenerator.step_(massDist);
		double result = Double.valueOf(l[i-1][1]) - ( (Double.valueOf(l[i-1][1]) - Double.valueOf(l[i-1][0])) / 2.0 );
		return result;
	}
	
	//This is based on the FairSquare example at https://github.com/sedrews/fairsquare/blob/master/oopsla/noqual/M_BNc_F_NN_V2_H1.fr
	//Returns data in the form [sex, capital_gain, age, education_num]
	public static double[] popModel() {
		double[] retvals = new double[4];
		Random r = new Random();
		//double sex = sexDist.get(r.nextInt(sexDist.size()));
		double[][] distrib = {{0.0,1.0,0.3307}, {1.0,2.0,0.6693}};
		double sex = AdultIncomeDataGenerator.step(distrib);
		retvals[0] = sex;
		if(sex < 1) {
			retvals[1] = r.nextGaussian() * Math.pow(24248365.5428, 0.5) + 568.4105;
			if(retvals[1] < 7298) {
				retvals[2] = r.nextGaussian() * Math.pow(184.9151, 0.5) + 38.4208;
				retvals[3] = r.nextGaussian() * Math.pow(6.5096, 0.5) + 10.0827;
			}else{
				retvals[2] = r.nextGaussian() * Math.pow(193.4918, 0.5) + 38.8125;
				retvals[3] = r.nextGaussian() * Math.pow(6.1522, 0.5) + 10.1041;
			}
		}else{
			retvals[1] = r.nextGaussian() * Math.pow(69327473.1006, 0.5) + 1329.3700;
			if(retvals[1] < 5178) {
				retvals[2] = r.nextGaussian() * Math.pow(187.2435, 0.5) + 38.6361;
				retvals[3] = r.nextGaussian() * Math.pow(6.4841, 0.5) + 10.0817;
			}else{
				retvals[2] = r.nextGaussian() * Math.pow(187.2747, 0.5) + 38.2668;
				retvals[3] = r.nextGaussian() * Math.pow(7.1793, 0.5) + 10.0974;
			}
		}
		if(retvals[3] > retvals[2]) {
			retvals[2] = retvals[3];
		}
		return retvals;
	}
	
	public static void main(String args[]) {
		double[] vals = AdultIncomeDataGenerator.popModel();
		for(double val: vals) {
			System.out.println(val);
		}
	}
	
}