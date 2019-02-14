package mygui;

public class CalculatorDriver {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		int num1 = 8;
		int num2 = 4;
		
		System.out.println("addition      : " + calculator.add(num1, num2));
		System.out.println("subtraction   : " + calculator.subtract(num1, num2));
		System.out.println("multiplication: " + calculator.multiply(num1, num2));
		System.out.println("division      : " + calculator.divide(num1, num2));
	}

}
