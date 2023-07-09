/*
Author's Name :  Ali Almadhagi
Project Name :  Project 1 Singed Integers
Submission Date :  2/17/2023
Description:  The code is a Java program that converts decimal numbers to signed integers in various formats including signed magnitude, one's complement, two's complement, and excess notation. The program prompts the user for a length of the signed integer in bits, and then generates a table of all possible values for that length in each of the four formats.
 */


import java.util.Scanner;

public class SignedIntegers {
	
	// a method that does a step by step conversion from decimal to binary
 	static String decimalToBinary(int i) {
 		int n = i;
 		String binary = "";
 		int remain;
 		
 		// if the integer equals 0 the method is going to return a string "0";
 		if (i == 0 ) {
 			return "0";
 		}
 		
 		// the function will keep dividing the integer value by two and storing the remainder until the integer value becomes 0;
 		while (n > 0) {
 			remain = n % 2;
 			n = n / 2;
 			if (remain == 0)
 				binary = '0' + binary;
 			else 
 				binary = '1' + binary;
 		}
 		return binary;
 	}
	
	// a method that does a step by step conversion from binary to decimal
 	static int binarytoDecimal(String binary) {
 	    int decimal = 0;
 	    int power = 0;
 	    
 	    // a for loop that starts from the end of the binary string until it gets to the most significant bit, and it multiplies each bit by 2 to the power of the position of the bit, and after that it adds it to the decimal value 
 	    for (int i = binary.length() - 1; i >= 0; i--) {
 	        int bit = binary.charAt(i) - '0'; // convert char to int (0 or 1)
 	        decimal += bit * Math.pow(2, power); 
 	        power++;
 	    }
 	    return decimal;
 	}
	
	// a method that changes the binary number to signed magnitude
	static int signedMagnitude(String binary) {
		// if the MSB is 0 then it converts the binary string to decimal, but if the MSB is 1 it reads the MSB as a negative sign and then it converts the binary to a decimal.
		if (binary.charAt(0) == '0')
			return binarytoDecimal(binary);
		else
			return -binarytoDecimal(binary.substring(1));
	}
	
	// a method that changes the binary string to one's complement
	static int onesComplement(String binary) {
		// if the MSB is 0 then it converts the binary string to decimal, but if the MSB is 1 it reads the MSB as a negative sign and then it converts the rest of the bits, and after that it converts the binary to a string
		int x;
		if (binary.charAt(0) == '0')
			return binarytoDecimal(binary);
		else
		{
			binary = binary.substring(1);
			StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < binary.length(); i++) {
		        sb.append(binary.charAt(i) == '0' ? '1' : '0');
		    }
		    String onesComplementBinary = sb.toString();
		    return -binarytoDecimal(onesComplementBinary);
		}
			
	}
	
	// a method that changes the binary string to two's complement
	static int twosComplement(String binary) {
		// if the MSB is 0 then it converts the binary string to decimal, but if the MSB is 1 It uses the (one's complement method - 1) which gives us the two's complement.
		if (binary.charAt(0) == '0')
			return binarytoDecimal(binary);
		else
			return onesComplement(binary) - 1 ;
	}
	
	// a method that changes the binary string to excess notation
	static int excessNotation(String binary) {
		return binarytoDecimal(binary) - (int) Math.pow(2, binary.length()-1);
	}

	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int length;
		
		
		// prompting the user to enter the length
		System.out.println("Length: ");
		length = input.nextInt();
		
		// check if the length is between 1 and 10
		while(length < 1 || length > 10) {
			System.out.println("the length must be between 1 and 10!!");
			System.out.println("Length");
			length = input.nextInt();
		}
		
		// getting the number of rows by doing 2 to the power of the length
		int rows = (int) Math.pow(2, length);
		
		// creating int variables to store the decimal values after conversions
		int  signMagnitude, onesComplement, twosComplement, excessNotation;
		
		// creating the table 
		System.out.println("|---------------|-------------------------------|-----------------------|-----------------------|-----------------------|");
		System.out.println("|\tBinary\t|\tSigned Magnitude\t|\t1s Complement\t|\t2s Complement\t|\tExcess Notation\t|");
		System.out.println("|---------------|-------------------------------|-----------------------|-----------------------|-----------------------|");

		
		for(int i = 0; i < rows; i++) {
			String binary = decimalToBinary(i);
			
			// a while loop that adds the rest of the zeros to the binary string if its less than the length entered by the user
			while (binary.length() < length) {
                binary = "0" + binary;
            }
			
			// assigning each variable to its conversion method
			signMagnitude = signedMagnitude(binary);
			onesComplement = onesComplement(binary);
			twosComplement = twosComplement(binary);
			excessNotation = excessNotation(binary);
			
			// printing table contents
            System.out.println("|\t"+ binary + "\t|\t\t" + signMagnitude + "\t\t|\t" + onesComplement + "\t\t|\t" + twosComplement + "\t\t|\t\t" + excessNotation +"\t|\t\t");
		}
	}
}



/*
	sample output
	
	Length: 
3
|-----------|-----------------------|-------------------|-------------------|-------------------|
|	Binary	|	Signed Magnitude	|	1s Complement	|	2s Complement	|	Excess Notation	|
|-----------|-----------------------|-------------------|-------------------|-------------------|
|	000		|			0			|		0			|		0			|			-4		|		
|	001		|			1			|		1			|		1			|			-3		|		
|	010		|			2			|		2			|		2			|			-2		|		
|	011		|			3			|		3			|		3			|			-1		|		
|	100		|			0			|		-3			|		-4			|			0		|		
|	101		|			-1			|		-2			|		-3			|			1		|		
|	110		|			-2			|		-1			|		-2			|			2		|		
|	111		|			-3			|		0			|		-1			|			3		|		

 */

