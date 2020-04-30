package LibraryIO.input;

import java.util.Scanner;

/**
 * The UserNumberInput class is used to filter integer number entries.
 */
public class UserNumberInput {
    private final Scanner intIn = new Scanner(System.in);

    /**
     * getInputNum method loops with a try catch
     * @param lower bound for range
     * @param upper bound for range
     * @return valid integer value
     */
    public int getInputNum(int lower, int upper){
        int userChoice = -1;
        do{
            try{
                userChoice = Integer.parseInt(intIn.nextLine());
            }catch(Exception e){System.out.println("Invalid entry: integer expected between "
                    + lower + " and " + upper);}
        }while(!(userChoice >= lower && userChoice <= upper));
        return userChoice;
    }
}