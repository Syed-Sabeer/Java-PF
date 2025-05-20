import java.io.BufferedReader;   // To read text line by line
import java.io.FileReader;       // To open the file
import java.io.IOException;      // To handle file errors

public class Question7 {
    public static void main(String[] args) {
        try {
            // Open the file
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            // Read one line from the file
            String line = reader.readLine();

            // Check if the line is not empty
            if (line != null) {
                // Split the line into fields using TAB
                String[] fields = line.split("\t");

                // Loop to print each field
                for (int i = 0; i < fields.length; i++) {
                    System.out.println("Field " + (i + 1) + ": " + fields[i]);
                }
            } else {
                System.out.println("The file is empty.");
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}


//     Explanation
// 1. Import necessary classes:
// - FileReader: Opens the file for reading.
// - BufferedReader: Makes it easier to read full lines of text.
// - IOException: Handles errors that may happen while reading the file.

// 2. Start the program with a try-catch block to safely handle file reading.

// 3. In the try block:
// - Create a FileReader for the file "data.txt".
// - Wrap it with BufferedReader so you can read entire lines at once.

// 4. Read the first line from the file using reader.readLine().

// 5. Check if the line is not null (not empty):
// - If the file has some content, continue.
// - If not, print "The file is empty."

// 6. Split the line wherever there is a TAB (\t):
// - This creates an array called fields, with each item being one field of data.

// 7. Use a for loop to go through each field:
// - Start from index 0 to the end of the array.
// - Print each field with its position like: "Field 1: ...", "Field 2: ..." and so on.

// 8. Close the file after reading using reader.close() to avoid memory or file access issues.

// 9. Catch block:
// - If an error occurs (like the file not found), print an error message.
