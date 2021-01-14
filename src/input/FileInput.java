package input;

import java.io.File;
import java.util.Scanner;

public class FileInput {
    /**
     * getData method takes in user input and file input
     * @return file data as string
     */
    public String getData() {
        StringBuilder rawData = new StringBuilder();
        UserStringInput userIn = new UserStringInput();
        boolean satisfaction = false;
        int countFails = 0;
        File fileReadIt;
        Scanner scanIn;
        do{
            do {
                fileReadIt = new File(userIn.getStringInput("Please enter a filename.  Include .type"));
                try {
                    scanIn = new Scanner(fileReadIt);
                    while(scanIn.hasNextLine()) {
                        rawData.append(scanIn.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("String input expected, an error occurred. "
                            + "\nPlease try again.");
                    countFails++;
                }
            } while (rawData.toString().equals("") && countFails < 4);
            System.out.println();
            if(countFails > 3){
                System.out.println("Data from file failed.");
            }
            else{
                System.out.println("Data from file collected.");
                satisfaction = true;
            }
        }while(!satisfaction);
        return rawData.toString();
    }
}