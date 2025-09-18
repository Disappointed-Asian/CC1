// package com.mycompany.bidec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadixConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // List of valid base numbers
        List<String> baseNumbers = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16");
        // List to store results for later printing
        List<String[]> results = new ArrayList<>();

        while (true) {
            // Ask user for base
            System.out.print("\nEnter the base or type 'STOP' to exit: ");
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

            // Prepare result list dynamically (skipping the input base representation)
            List<String> row = new ArrayList<>();
            row.add(number); // Always add the original input

            if (base != 2) row.add(RadixNumberConverter(decimalNumber, 2));
            if (base != 8) row.add(RadixNumberConverter(decimalNumber, 8));
            if (base != 10) row.add("" + decimalNumber);
            if (base != 16) row.add(RadixNumberConverter(decimalNumber, 16));

            results.add(row.toArray(new String[0]));
        }

        // After STOP, print all the results collected
        System.out.printf("%-25s%-25s%-25s%-25s\n", "Input", "Output1", "Output2", "Output3");
        for (String[] result : results) {
            // Print only up to 4 columns (input + 3 outputs max)
            for (int i = 0; i < 4; i++) {
                if (i < result.length) {
                    System.out.printf("%-25s", result[i]);
                } else {
                    System.out.printf("%-25s", ""); // Empty if fewer outputs
                }
            }
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }

    public static boolean checkForStop(String userType) {
        return userType.equalsIgnoreCase("STOP");
    }

    public static boolean isValidNumberForBase(String number, int base) {
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
        int decimalNumber = 0;
        int digitConv;
        int origBaseNumber = Integer.parseInt(origBase);

        for (int i = number.length() - 1, power = 0; i >= 0; i--, power++) {
            char currentDigit = number.charAt(i);
            int value;
            if (currentDigit >= 'A' && currentDigit <= 'F') {
                value = 10 + (currentDigit - 'A');
            } else {
                value = Character.getNumericValue(currentDigit);
            }
            digitConv = (int) Math.pow(origBaseNumber, power) * value;
            decimalNumber += digitConv;
        }
        return decimalNumber;
    }

    public static String RadixNumberConverter(int decimalNumber, int baseNumber) {
        if (decimalNumber == 0) return "0";
        String finalAnswer = "";
        while (decimalNumber > 0) {
            int remainder = decimalNumber % baseNumber;
            if (remainder >= 10) {
                finalAnswer = (char) ('A' + (remainder - 10)) + finalAnswer;
            } else {
                finalAnswer = remainder + finalAnswer;
            }
            decimalNumber /= baseNumber;
        }
        return finalAnswer;
    }
}
