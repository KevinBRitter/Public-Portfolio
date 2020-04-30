package LibraryIO.input;

import java.util.Scanner;

public class UserStringInput {
    /**
     * getData method returns a new string by user
     * @return string
     */
    public String getStringInput(String inputMessage) {
        String rawString = "";
        boolean satisfaction = false;
        Scanner strIn = new Scanner(System.in);
        do {
            do {
                try {
                    System.out.println();
                    System.out.println(inputMessage);
                    rawString = strIn.nextLine();

                } catch (Exception e) {
                    System.out.println("String input expected, an error occurred. " +
                            "\nPlease try again.");
                }
            } while (rawString.equals(""));
            System.out.println();
            System.out.println("Would you like to re-enter string?");
            if(strIn.nextLine().toUpperCase().charAt(0)=='N'){satisfaction = true;}
            else{System.out.println("Additional attempt requested...");}
        }while(!satisfaction);
        return rawString;
    }
}