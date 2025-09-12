import java.util.List;
import java.util.Scanner;

public class RadixConverter {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        //List of valid base numbers
        List<String> baseNumbers = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16");

        while (true) {
            //Asks user for base 
            System.out.print("\n\nType a base: ");
            String origBase = scanner.nextLine();
            if (checkForStop(origBase) == true){
                break;
            }
            //checks if base is valid
            else if (!baseNumbers.contains(origBase)) {
                System.out.println("Please type a number between 2 to 16");
            }

            //Asks user for number within a base
            System.out.print("Type a number: ");
            String number = scanner.nextLine();
            if (checkForStop(number) == true){
                break;
            }
            //Return to selecting base
            else if(number.equalsIgnoreCase("BASE")){
            }
            //checks if number is valid
            int base = Integer.parseInt(origBase);
            if (!isValidNumberForBase(number, base)) {
                System.out.println("Invalid number for base " + base + ". Please enter a valid number.");
                continue;
            }

            //Convert number to any radix
            int decimalNumber =  decimalNumberConverter(number, origBase);
            int baseNumber = 2;
            while (baseNumber <= 16){
                String finalAnswer = radixNumberConverter(decimalNumber, baseNumber);
                System.out.println("Base " + baseNumber + ": " + finalAnswer);
                baseNumber++;
            }
            
            baseNumber = 2;
        }
    
    scanner.close();
    }

    public static boolean checkForStop(String userType){
        //Checks if user typed stop
        return userType.equalsIgnoreCase("STOP");
    }

    public static boolean isValidNumberForBase(String number, int base) {
        //Checks if user inputs a valid number after choosing a base
        String validDigits = "0123456789ABCDEF";
        number = number.toUpperCase();

        for (char digit : number.toCharArray()) {
            int digitValue = validDigits.indexOf(digit);
            if (digitValue == -1 || digitValue >= base) {
                return false;
            }
        }
        return true;
    }

    public static int decimalNumberConverter(String number, String origBase){
        ///Converts any radix to a decimal number
        int decimalNumber = 0;
        int digitConv;
        int origBaseNumber = Integer.parseInt(origBase);

        for (int i=number.length() - 1, power=0; i >= 0; i--, power++){
            char currentDigit = number.charAt(i);
            if (currentDigit == 'A'){
                digitConv = (int)Math.pow(origBaseNumber, power) * 10;
            }
            else if (currentDigit == 'B'){
                digitConv = (int)Math.pow(origBaseNumber, power) * 11;
            }
            else if (currentDigit == 'C'){
                digitConv = (int)Math.pow(origBaseNumber, power) * 12;
            }
            else if (currentDigit == 'D'){
                digitConv = (int)Math.pow(origBaseNumber, power) * 13;
            }
            else if (currentDigit == 'E'){
                digitConv = (int)Math.pow(origBaseNumber, power) * 14;
            }
            else if (currentDigit == 'F'){
                digitConv = (int)Math.pow(origBaseNumber, power) * 15;
            }
            else{
                digitConv = (int)Math.pow(origBaseNumber, power) * Character.getNumericValue(currentDigit);
            }
            decimalNumber = decimalNumber + digitConv;
        }
        return decimalNumber;
    }

    public static String radixNumberConverter(int decimalNumber, int baseNumber){
        //Converts decimal number to any radix
        int x = baseNumber;
        String finalAnswer = "";
        while(decimalNumber > 0){ 
                int base = decimalNumber % x;
                if (base == 10){
                    finalAnswer = "A" + finalAnswer;
                }
                else if (base == 11) {
                    finalAnswer = "B" + finalAnswer;
                }
                else if (base == 12) {
                    finalAnswer = "C" + finalAnswer;
                }
                else if (base == 13) {
                    finalAnswer = "D" + finalAnswer;
                }
                else if (base == 14) {
                    finalAnswer = "E" + finalAnswer;
                }
                else if (base == 15) {
                finalAnswer = "F" + finalAnswer;
                }
                else{
                finalAnswer = Integer.toString(base) + finalAnswer;
                }
                decimalNumber = decimalNumber/baseNumber;
            }
            return finalAnswer; 
    }
}

