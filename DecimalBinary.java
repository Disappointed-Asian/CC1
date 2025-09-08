import java.util.Scanner;

public class DecimalBinary{
	public static void main(String[] arg){

		Scanner scanner = new Scanner(System.in);
		
		while (true){
			//Ask for user input
			System.out.println("Write a number:");
			String decimal = scanner.nextLine();

			//Exits loop after typing STOP
			if (decimal.equalsIgnoreCase("STOP")) {
				break;
			}

			//converts string to int
			int input = Integer.parseInt(decimal);
			String binary = "";

			//converts decimal to binary
			while (input>0) {
				if (input%2 == 0) {
					binary = "0" + binary;
					input = input/2;
				}
				else if(input%2 ==1) {
					binary = "1" + binary;
					input = input/2;
				}
			}

			//Prints the result
			System.out.println("Input: " + decimal);
			System.out.println("Output: " + binary);
		}
		scanner.close(); 
	}
}