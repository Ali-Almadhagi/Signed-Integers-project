Author's Name :  Ali Almadhagi
Project Name :  Project 1 Singed Integers
Submission Date :  2/17/2023
Description:  The code is a Java program that converts decimal numbers to signed integers in various formats including signed magnitude, one's complement, two's complement, and excess notation. The program prompts the user for a length of the signed integer in bits, and then generates a table of all possible values for that length in each of the four formats.

The code includes methods for converting binary strings to decimal values for each of the different signed integer representations. The methods use various mathematical operations to perform the conversions without using built-in functions.

The program is designed to be run from the command line or an IDE such as Eclipse, with user input provided through the console.


sample output

Length: 
3
|---------------|--------------------|-------------------|--------------------|-----------------------|
|	Binary    |	  Signed Magnitude |	1s Complement  |	  2s Complement	|	Excess Notation	|
|---------------|--------------------|-------------------|--------------------|-----------------------|
|	000	    |		  0		 |	    0		   |	      0		|		-4	      |		
|	001	    |		  1		 |	    1		   |	      1		|		-3	      |		
|	010	    |		  2		 |	    2		   |	      2		|		-2	      |		
|	011	    |		  3		 |	    3		   |	      3		|		-1	      |		
|	100	    |		  0		 |	   -3		   |	     -4		|		0	      |		
|	101	    |		 -1		 |	   -2		   |	     -3		|		1	      |		
|	110	    |		 -2		 |	   -1		   |       -2		|		2	      |		
|	111	    |		 -3		 |	    0		   |	     -1		|		3	      |			