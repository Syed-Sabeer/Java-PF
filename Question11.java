import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Question11 {
    public static void main(String[] args) {

        // Create a HashMap to store sales amounts for each month
        // Key = month name (like "June"), Value = total sales amount for that month
        HashMap<String, Integer> monthSales = new HashMap<>();
        // it stores value in key and value pair for array

        try {
            // Open the file "sales.txt" to read data
            BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
            String line;

            // Skip the first line because it contains headers, not data
            reader.readLine();

            // Read the file line by line until no more lines
            while ((line = reader.readLine()) != null) {

                // Split the current line into parts using tab ("\t") as separator
                String[] fields = line.split("\t");

                // The first part is the date, for example "17-June-2019"
                String date = fields[0];

                // Get the quantity sold from the 5th part (index 4)
                int qty = Integer.parseInt(fields[4]);

                // Get the unit price from the 6th part (index 5)
                int unitPrice = Integer.parseInt(fields[5]);

                // Calculate total sales for this line = quantity * unit price
                int salesAmount = qty * unitPrice;

                // Extract the month part from the date by splitting at "-"
                // For "17-June-2019", month is "June"
                String month = date.split("-")[1];

                // Check if the month already has some sales recorded
                Integer oldSales = monthSales.get(month);  // Get old sales for this month

                if (oldSales == null) {
                    // If no sales recorded yet for this month, add a new entry
                    monthSales.put(month, salesAmount);
                } else {
                    // If sales already recorded, add the new sales amount to existing total
                    monthSales.put(month, oldSales + salesAmount);
                }
            }

            // Close the file after reading all lines
            reader.close();

            // Now print the total sales for each month

            System.out.println("Month-wise Sales:");

            // Get all month names as an array
            Object[] months = monthSales.keySet().toArray();

            // Loop through the array using a normal for loop (with index)
            for (int i = 0; i < months.length; i++) {
                // Convert Object to String because keys are strings
                String month = (String) months[i];

                // Get the sales amount for this month
                Integer sales = monthSales.get(month);

                // Print the month and its total sales amount
                System.out.println(month + " => " + sales);
            }

        } catch (IOException e) {
            // If any error happens during file reading, print this message
            System.out.println("Error reading the file.");
        }
    }
}
