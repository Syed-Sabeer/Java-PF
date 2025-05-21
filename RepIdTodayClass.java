
    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//  this code is same as file reader which i coded 
public class RepIdTodayClass {
    public static void main(String[] args) {
        String targetItemCode = "E011";  // Hardcoded to filter only E011
        int totalQuantity = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
            String line;

            reader.readLine(); // Skip header line

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");

                if (fields.length >= 5) {
                    String itemCode = fields[2];  // Assuming 3rd column is ItemCode

                    // Use equalsIgnoreCase or equals for content comparison
                    if (itemCode.equalsIgnoreCase(targetItemCode)) {
                        int quantity = Integer.parseInt(fields[4]);
                        totalQuantity += quantity;
                        System.out.println(line);  // Show matching line
                    }
                }
            }

            reader.close();
            System.out.println("Total quantity purchased for ItemCode E011 is: " + totalQuantity);

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers from the file.");
        }
    }
}

