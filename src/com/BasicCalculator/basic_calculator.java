package com.BasicCalculator;

import java.util.Scanner;

public class basic_calculator {

	public static void main(String[] args) {
	Scanner scannerObj = new Scanner(System.in);
	System.out.println("Hello I'm Basic Java Calculator!!!");
	System.out.println("Please Enter The First Number");
	double firstNumber = scannerObj.nextDouble();
	
	System.out.println("Please Enter The Second Number");
	double secondNumber = scannerObj.nextDouble();
	
	System.out.println("Please Select The Operator To Be Performed");
	char operator = scannerObj.next().charAt(0);
	scannerObj.close();
	
/*By taking two numbers as inputs from the console and based upon the operator choosen,
 * the following switch case will execute */
	
	switch(operator) {
	case '+':
		System.out.println(firstNumber+secondNumber);
		break;
	case '-':
		System.out.println(firstNumber-secondNumber);
	    break;
	case '*':
		System.out.println(firstNumber*secondNumber);
		break;
	case '/':
		if(secondNumber>0) {
			System.out.println(firstNumber/secondNumber);
		}
		else {
			System.out.println("Can't divide by 0");
		}
		break;
	default:
		System.out.println("Invalid opeartor");
	}
	
	
	

	}

}
