package com.mycompany.bidec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // List of valid base numbers
        List<String> baseNumbers = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16");
        // List to store results for later printing
        List<String[]> results = new ArrayList<>();

        while (true) {
            // Ask user for base
            System.out.print("\nEnter the base (2-16) or type 'STOP' to exit: ");
            String origBase = scanner.nextLine();
            if (checkForStop(origBase)) {
                break;  // Break the loop if user types "STOP"
            }

            // Check if base is valid
            if (!baseNumbers.contains(origBase)) {
                System.out.println("Please type a number between 2 and 16");
                continue;
            }

            // Ask user for number in the given base
            System.out.print("Enter the number in base " + origBase + ": ");
            String number = scanner.nextLine();
            if (checkForStop(number)) {
                break;  // Break the loop if user types "STOP"
            }

            // Check if the number is valid for the specified base
            int base = Integer.parseInt(origBase);
            if (!isValidNumberForBase(number, base)) {
                System.out.println("Invalid number for base " + base + ". Please enter a valid number.");
                continue;
            }

            // Convert number to decimal
            int decimalNumber = DecimalNumberConverter(number, origBase);

            // Convert to Binary, Octal, Decimal, and Hexadecimal
            String binary = RadixNumberConverter(decimalNumber, 2);
            String octal = RadixNumberConverter(decimalNumber, 8);
            String hexadecimal = RadixNumberConverter(decimalNumber, 16);

            // Store the results in the list
            results.add(new String[] { number, binary, octal, String.valueOf(decimalNumber), hexadecimal });
        }

        // After STOP, print all the results collected
        System.out.println("\nConversion Results:");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Input", "Binary", "Octal", "Decimal", "Hexadecimal");
        for (String[] result : results) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", result[0], result[1], result[2], result[3], result[4]);
        }

        // Close the scanner
        scanner.close();
    }

    public static boolean checkForStop(String userType) {
        // Checks if user typed stop
        return userType.equalsIgnoreCase("STOP");
    }

    public static boolean isValidNumberForBase(String number, int base) {
        // Checks if user inputs a valid number for the chosen base
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

    public static int DecimalNumberConverter(String number, String origBase) {
        // Converts any radix to a decimal number
        int decimalNumber = 0;
        int digitConv;
        int origBaseNumber = Integer.parseInt(origBase);

        for (int i = number.length() - 1, power = 0; i >= 0; i--, power++) {
            char currentDigit = number.charAt(i);
            if (currentDigit == 'A') {
                digitConv = (int) Math.pow(origBaseNumber, power) * 10;
            } else if (currentDigit == 'B') {
                digitConv = (int) Math.pow(origBaseNumber, power) * 11;
            } else if (currentDigit == 'C') {
                digitConv = (int) Math.pow(origBaseNumber, power) * 12;
            } else if (currentDigit == 'D') {
                digitConv = (int) Math.pow(origBaseNumber, power) * 13;
            } else if (currentDigit == 'E') {
                digitConv = (int) Math.pow(origBaseNumber, power) * 14;
            } else if (currentDigit == 'F') {
                digitConv = (int) Math.pow(origBaseNumber, power) * 15;
            } else {
                digitConv = (int) Math.pow(origBaseNumber, power) * Character.getNumericValue(currentDigit);
            }
            decimalNumber = decimalNumber + digitConv;
        }
        return decimalNumber;
    }

    public static String RadixNumberConverter(int decimalNumber, int baseNumber) {
        // Converts decimal number to any radix
        int x = baseNumber;
        String finalAnswer = "";
        while (decimalNumber > 0) {
            int base = decimalNumber % x;
            if (base == 10) {
                finalAnswer = "A" + finalAnswer;
            } else if (base == 11) {
                finalAnswer = "B" + finalAnswer;
            } else if (base == 12) {
                finalAnswer = "C" + finalAnswer;
            } else if (base == 13) {
                finalAnswer = "D" + finalAnswer;
            } else if (base == 14) {
                finalAnswer = "E" + finalAnswer;
            } else if (base == 15) {
                finalAnswer = "F" + finalAnswer;
            } else {
                finalAnswer = Integer.toString(base) + finalAnswer;
            }
            decimalNumber = decimalNumber / baseNumber;
        }
        return finalAnswer;
    }
}
