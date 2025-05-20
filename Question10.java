import java.io.BufferedReader;  // For reading text from the file efficiently, line by line
import java.io.FileReader;      // For reading character files
import java.io.IOException;     // For handling input/output exceptions
import java.util.Scanner;       // For taking input from the user

public class Question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create Scanner object to read user input from console

        // Prompt the user to enter an item code whose total quantity purchased needs to be found
        System.out.print("Enter ItemCode to find total quantity purchased: ");
        String searchItemCode = scanner.nextLine().trim();  // Read input and remove any leading/trailing spaces
        // scanner.nextLine() It reads the entire line of input from the user (or input source) until the end of that line — meaning it captures everything typed until the user presses Enter (newline).
        // .trim() remove trailing spaces as also Sir badar explained

        int totalQuantity = 0;  // Variable to accumulate total quantity for the entered item code

        try {
            // Create BufferedReader to read from the file "sales.txt"
            BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
            String line;  // Variable to hold each line read from the file

            // Skip the first line since it contains the column headers (not data)
            reader.readLine();

            // Loop through each line of the file until the end is reached (null)
            while ((line = reader.readLine()) != null) {
                // Split the line into fields using tab as separator
                String[] fields = line.split("\t");

                // Extract the item code from the 3rd column (index 2), called Rep ID here
                String itemCode = fields[2];

                // Compare the extracted item code with the user input (case insensitive)
                if (itemCode.equalsIgnoreCase(searchItemCode)) {
                    // equalsIgnoreCase method: It compares two strings to check if they are equal, ignoring differences in uppercase or lowercase letters.
                    // If match found, parse the quantity (5th field, index 4) as integer 'qty'
                    int quantity = Integer.parseInt(fields[4]);

                    // Add the quantity to totalQuantity for all itms
                    totalQuantity += quantity;
                }
            }

            // Close the file reader after processing to release resources
            reader.close();

            // Print the total quantity of the entered item code purchased by all customers
            System.out.println("Total quantity purchased for ItemCode " + searchItemCode + " is: " + totalQuantity);

        } catch (IOException e) {
            // Handle errors related to file reading (e.g., file not found)
            System.out.println("Error reading the file.");
        } catch (NumberFormatException e) {
            // Handle errors related to parsing quantity as an integer
            System.out.println("Error parsing numbers from the file.");
        } finally {
            // Close the Scanner to free system resources
            scanner.close();
        }
    }
}
