import java.util.Scanner;

public class DecimalBinary{
	public static void main(String[] arg){

		Scanner scanner = new Scanner(System.in);

		while (true){
			//Ask for user input
			System.out.print("\n\nType a number:");
			String decimal = scanner.nextLine();

			//Exits loop after typing STOP
			if (decimal.equalsIgnoreCase("STOP")) {
				break;
			}
			if (!isValidNumberForBase(decimal, 10)) {
                System.out.println("Please enter a number.");
                continue;
            }
			if (decimal.equalsIgnoreCase("0")) {
				System.out.println("Input: 0");
				System.out.println("Output: 0");
				continue;
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
	    public static boolean isValidNumberForBase(String number, int base) {
        //Checks if user inputs a valid number after choosing a base
        String validDigits = "0123456789";
        number = number.toUpperCase();

        for (char digit : number.toCharArray()) {
            int digitValue = validDigits.indexOf(digit);
            if (digitValue == -1 || digitValue >= base) {
                return false;
            }
        }
        return true;
    }
}
