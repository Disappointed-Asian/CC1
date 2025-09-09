import java.util.Scanner;

public class RadixConverter {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        while(true){
            //Asks for original base
            System.out.println("\n\nType original base: ");
            String orig_base = scanner.nextLine();
            if(orig_base.equalsIgnoreCase("STOP")){
                break;
            }

            //Asks for a number to convert
            System.out.println("Type the number you want to convert: ");
            String number = scanner.nextLine();
            if(number.equalsIgnoreCase("STOP")){
                break;
            }

            System.out.println("\n===================================");
            System.out.println("Converted from radix 2 to 10");
            System.out.println("===================================");

            int origNumber = Integer.parseInt(number);
            int copyOrigNumber = origNumber;
            int origBase = Integer.parseInt(orig_base);
            int power = 0;
            int base10 = 0;

            //converts to base10
            while(origNumber > 0){ 
                    int digit = origNumber % 10;
                    int digit_conv = ((int)Math.round(Math.pow(origBase, power)))* digit;
                    base10 = base10 + digit_conv;
                    power++;
                    origNumber = origNumber / 10;
                }
            
            int x = 2;
            int base10_copy = base10;
            String answer = "";
            power = 0;
            origNumber = copyOrigNumber;
            
            //converts to any radix
            while (x != 17) {
                    while(base10 > 0){ 
                    int base = base10 % x;
                    if (base == 10){
                        answer = "A" + answer;
                    }
                    else if (base == 11) {
                        answer = "B" + answer;
                    }
                    else if (base == 12) {
                        answer = "C" + answer;
                    }
                    else if (base == 13) {
                        answer = "D" + answer;
                    }
                    else if (base == 14) {
                        answer = "E" + answer;
                    }
                    else if (base == 15) {
                        answer = "F" + answer;
                    }
                    else{
                        answer = Integer.toString(base) + answer;
                    }
                    power++;
                    base10 = base10 / x;
                }
                System.out.println(answer);
                answer = "";
                power = 0;
                base10 = base10_copy;
                x++;
            }
        }
        scanner.close();
    }
}