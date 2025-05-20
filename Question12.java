import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Question12 {
    public static void main(String[] args) {

        // Create a list to store all records (each line of the file)
        // Each record is an array of strings (like [date, customer, product, ...])
        List<String[]> records = new ArrayList<>();
//         List<String[]>
// You are creating a list (like a resizable array).

// It will store many String[] (arrays of strings).

// Each String[] will hold one line from your sales.txt file, split into columns (e.g., date, customer, qty, unit price).

// example 
// String[] line1 = { "17-June-2019", "John", "Phone", "2", "30000" };
// String[] line2 = { "18-June-2019", "Sara", "Laptop", "1", "90000" };

// These arrays are stored inside the list like this:
// records = [line1, line2, ...]



        try {
            // Open the file named "sales.txt" for reading
            BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
            String line;

            // Read the first line (header), e.g. "Date\tCustomer\tProduct\t...\tQty\tUnitPrice"
            String header = reader.readLine();  // Save the header to print later

            // Read all remaining lines one by one
            while ((line = reader.readLine()) != null) {

                // Split the line into parts using tab (\t)
                // Example: "17-June-2019\tJohn\tPhone\t...\t2\t30000"
                String[] fields = line.split("\t");

                // Add this record (line) to the list
                records.add(fields);
            }

            // Close the file after reading is done
            reader.close();

            // Sort the list in descending order of sales amount
            // Sales amount = Quantity (field[4]) * Unit Price (field[5])
            records.sort((a, b) -> {
                int qtyA = Integer.parseInt(a[4]);       // Quantity from record A
                int priceA = Integer.parseInt(a[5]);     // Unit Price from record A
                int salesA = qtyA * priceA;              // Total sales amount of record A

                int qtyB = Integer.parseInt(b[4]);       // Quantity from record B
                int priceB = Integer.parseInt(b[5]);     // Unit Price from record B
                int salesB = qtyB * priceB;              // Total sales amount of record B

                return Integer.compare(salesB, salesA);  // Bigger amount first (descending order)
                
            // Integer.compare(a, b)	Ascending
            // Integer.compare(b, a)	Descending


            });

// Qty	Unit Price	Total Sale
// 2	30000	     60000
// 5	10000	      50000
// 1	100000	    100000


// Compare 1st and 2nd → 60000 vs 50000 → no swap (60000 is bigger)

// Compare 2nd and 3rd → 50000 vs 100000 → swap them

// Then 1st and 2nd again (now 60000 vs 100000) → swap

// Final order becomes:

// 1 x 100000 = 100000

// 2 x 30000 = 60000

// 5 x 10000 = 50000

            // Print the results
            System.out.println(header);  // First, print the header again

            // Now print each record in the sorted list
            //  as we use .length for array similarly we use .siez for list
           for (int i = 0; i < records.size(); i++) {
            // String[] means array of strings
    String[] record = records.get(i); // Get each record (array of fields)
    System.out.println(String.join("\t", record)); // Join and print
    
    // String.join("\t", record) takes all the strings inside the record array and combines them into one single string, putting the separator "\t" (a tab character) between each element.

//     Example:
// If I have an array:
// String[] record = { "17-June-2019", "John", "Phone", "2", "30000" };
// then 
// String joined = String.join("\t", record);
// will produce this string:
// "17-June-2019\tJohn\tPhone\t2\t30000"
// final result will be :  17-June-2019    John    Phone    2    30000



}


        } catch (IOException e) {
            // If there's any error reading the file, show a message
            System.out.println("Error reading the file.");
        }
    }
}
