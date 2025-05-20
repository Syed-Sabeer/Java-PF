import java.io.BufferedReader;   // Helps read text line by line
import java.io.FileReader;       // Opens the file
import java.io.IOException;      // Handles input/output errors

public class Question6 {
    public static void main(String[] args) {
        try {
            // Open the file
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            // Read the first line from the file
            String line = reader.readLine();

            // Check if line is not null (file is not empty)
            if (line != null) {
                // Split the line into fields using TAB character ("\t")
                String[] fields = line.split("\t");

                // Loop through each field and print it
                for (int i = 0; i < fields.length; i++) {
                    System.out.println("Field " + (i + 1) + ": " + fields[i]);
                }
            } else {
                System.out.println("File is empty.");
            }

            // Close the file
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}


//     Explanation
// 1. Import required classes:
// - FileReader: To open the file.
// - BufferedReader: Makes it easy to read one full line at a time.
// - IOException: Handles any file reading errors (like file not found).

// 2. Inside the main method, we use a try-catch block to safely handle file operations.

// 3. Inside the try block:
// - Open the file "data.txt" using FileReader.
// - Wrap it with BufferedReader to read the full line.
// - Use readLine() to read the first line from the file.

// 4. Check if the line is not null:
// - If the file is not empty, go ahead and process the line.
// - If it’s empty, print "File is empty."

// 5. Split the line:
// - Use line.split("\t") to break the line into parts wherever a TAB (\t) is found.
// - This gives you an array of fields (pieces of data).

// 6. Use a loop to go through each field and print it:
// - for (int i = 0; i < fields.length; i++) means we are going over each item in the array.
// - Print each field with its number like: "Field 1: value"

// 7. Close the file after reading to free up resources using reader.close().

// 8. Catch block:
// - If there’s any error (like file not found), show a user-friendly error message.