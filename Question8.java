// Import for reading text from files efficiently
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;          

public class Question8 {
    public static void main(String[] args) {
        // Create a map to store total amount to pay for each ItemCode
        Map<String, Integer> amountByItemCode = new HashMap<>();

        try {
            // Open the sales.txt file for reading
            BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
            String line;

            // Read and skip the first line (header line with column names)
            line = reader.readLine();

            // Read the file line by line until there are no more lines
            while ((line = reader.readLine()) != null) {
                // Split the current line by tabs to get each field as a string
                String[] fields = line.split("\t");

                // Extract the ItemCode from the 3rd field (index 2)
                String itemCode = fields[2];  
                // Extract Quantity from the 5th field (index 4) and convert it to an integer
                int quantity = Integer.parseInt(fields[4]);
                // Extract Unit Price from the 6th field (index 5) and convert it to an integer
                int unitPrice = Integer.parseInt(fields[5]);

                // Calculate the amount to pay for this record (quantity * unitPrice)
                int amount = quantity * unitPrice;

                // If the itemCode is already in the map, add this amount to the existing total
                if (amountByItemCode.containsKey(itemCode)) {
                    int currentTotal = amountByItemCode.get(itemCode); // get current total
                    int newTotal = currentTotal + amount;               // add new amount
                    amountByItemCode.put(itemCode, newTotal);           // update map with new total
                } else {
                    // If itemCode is not in the map, add it with the current amount
                    amountByItemCode.put(itemCode, amount);
                }
            }

            // Close the file after reading all lines
            reader.close();

            // Convert map entries (key-value pairs) into a list for indexed access in a normal for loop
            // Here, the Set of entries is passed into the constructor of Array List to create a List of entries
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(amountByItemCode.entrySet());
            // use of amountByItemCode.entrySet()
            // amountByItemCode is a Map that stores pairs of ItemCode (String) and total amount (Integer) as i mentioned earlier
            // entrySet() is a method of Map that returns a set of entries each entry represents one key-value pair from the map
            //  example like key sabeer (string) has a value 6198 so when i call sabeer then it will return integer 6198
            // So, amountByItemCode.entrySet() returns a Set of Map.Entry objects, where each Map.Entry contains:
            // A key (in this case: the ItemCode string)
            // A value (in this case: the total amount integer)

            // Use a normal for loop to iterate through the list and print total amount for each ItemCode
            for (int i = 0; i < entries.size(); i++) {
                Map.Entry<String, Integer> entry = entries.get(i);
                System.out.println("Total amount to pay for ItemCode " + entry.getKey() + " is: " + entry.getValue());
                                                                        // sabeer                      // 6198
            }                                                             

        } catch (IOException e) {
            // This block runs if there's an error reading the file (e.g., file not found)
            System.out.println("Error reading the file.");
        } catch (NumberFormatException e) {
            // This block runs if there is a problem converting text to a number (e.g., invalid integer)
            System.out.println("Error parsing number in the file.");
        }
    }
}
