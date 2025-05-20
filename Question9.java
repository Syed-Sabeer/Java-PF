import java.io.BufferedReader;  // To read text from input stream efficiently, line by line
import java.io.FileReader;      // To read data from a file
import java.io.IOException;     // To handle exceptions when file operations fail

public class Question9 {
    public static void main(String[] args) {
        int totalAmount = 0;  // Variable to keep track of the total amount for all items

        try {
            // Create BufferedReader object to read from "sales.txt" file
            BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
            String line;  // To hold each line read from the file

            // Read and skip the first line because it is the header (column names)
            reader.readLine();

            // Read each line from the file until there are no more lines (EOF)
            while ((line = reader.readLine()) != null) {
                // Split the line into fields using tab ("\t") as delimiter
                // This creates an array where each element is a field from the line
                String[] fields = line.split("\t");

                // Parse quantity from the 5th field (index 4) as integer
                int quantity = Integer.parseInt(fields[4]);

                // Parse unit price from the 6th field (index 5) as integer
                int unitPrice = Integer.parseInt(fields[5]);

                // Calculate total price for this line: quantity * unit price
                // Add this amount to the running totalAmount variable
                totalAmount += quantity * unitPrice;
            }

            // Close the file reader after processing all lines to free resources
            reader.close();

            // Print the total amount to pay for all items combined
            System.out.println("Total amount of all items purchased: " + totalAmount);

        } catch (IOException e) {
            // This block runs if there is an error while reading the file (e.g., file not found)
            System.out.println("Error reading the file.");
        } catch (NumberFormatException e) {
            // This block runs if there is an error parsing quantity or price as integers
            System.out.println("Error parsing numbers from the file.");
        }
    }
}
