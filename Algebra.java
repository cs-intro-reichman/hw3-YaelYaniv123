// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(-2,-2));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(9,-3));  // 3 * 4 = 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(-3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(-12,-4));   // 25 / 7 = 4
		System.out.println(div(25,7));   // 25 / 7 = 4
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6 = 0 
   		System.out.println(sqrt(36));			// = 6
		System.out.println(sqrt(263169));		
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 < 0){
			for (int i = 0; i > x2; i--){
				result--;
			}
		}
		else {
			for (int i = 0; i <= x2 - 1; i++) {
				result++;
			}
		}
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
		if (x2 < 0){
			for (int i = 0; i > x2; i--) {
				result++;
			}
		}
		else {
			for (int i = 0; i <= x2 - 1; i++) {
			result--;
			}
		}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = x1;
		if (x1 < 0 && x2 < 0)
		{
			for (int i = 0; i > x2 + 1; i--) {
				result = plus(result, x1);
			}
			result = minus(0, result);
		}
		else if (x1 == 0 || x2 == 0) {
			result = 0;
		}
		else if (x1 > 0 && x2 < 0) {
			result = x2;
			for (int i = 0; i < x1 - 1; i++) {
				result = plus(result,x2);
			}
		}
		else {
			for (int i = 0; i < x2 - 1; i++) {
			result = plus(result, x1);
			}
		}

		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = x;
		if (n == 0) {
			result = 1;
		}
		else{
			for (int i = 0; i < n - 1; i++) {
			result = times(result, x);
			}
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
		int sum = x2;
		if (x1 == 0){
			result = 0;
		}
		else if (x1 < 0 && x2 > 0) {
			while (sum > x1) {
				result--;
				sum = times(x2, result);
			}
		}
		else if (x1 < 0 && x2 < 0){
			result = 1;
			while (sum > x1) {
				result++;
				sum = plus(sum, x2);
			}
		}
		else {
			result = 0;
			while (sum < x1) {
				result++;
				sum = times(x2, result);
			}
		}
		if (times(x2,result) > x1) {
			result--;
		}
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result = 1;
		int sum = x2;
		if (x1 == 0) {
			result = 0;
		}
		else {
			while (plus(sum, x2) <= x1) {
				if (x2 == 0){
					sum = x1;
					sum++;
				}
				else {
					sum = plus(sum, x2);
					result++;
				}
			}
		}
		result = result * x2;
		result = x1 - result;
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 1) {
			return 1;
		}
		double epsilon = 0.01;
		double g = div(x, 2);
		while (Math.abs (g * g - x) > epsilon) {
			g = g - (g * g - x) / (2 * g);
		}
		int intg = (int) g;
		return intg;
	}
	 	  
}