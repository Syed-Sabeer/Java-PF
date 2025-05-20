import java.io.BufferedReader;   // Helps read text line by line
import java.io.FileReader;       // Opens the file
import java.io.IOException;      // Handles input/output errors

public class Question4 {
    public static void main(String[] args) {
        try {
            // Open the file using FileReader
            FileReader fileReader = new FileReader("data.txt");
            // FileReader reads one character at a time, which is:
            // Harder to work with if you want to read a whole line of text

            // Wrap it with BufferedReader to read full lines easily
            BufferedReader reader = new BufferedReader(fileReader);
            // Reads text from a file efficiently
            // Reads line by line, not character by character


            String line;  // This will store each line from the file

            //  Keep reading lines one by one until end of file is reached (null)
            while ((line = reader.readLine()) != null) {
                // Print the current line
                System.out.println(line);
            }
                
            //  After all lines are read, print this message
            System.out.println("END OF THE FILE HAS REACHED");

            // Close the reader
            reader.close();

        } catch (IOException e) {
            // If there's any error (like file not found), show this
            System.out.println("Error reading the file.");
        }
    }
}


//   Explanation
// 1. Import the Java classes needed:
//    - FileReader: To open the file.
//    - BufferedReader: To read text line by line easily.
//    - IOException: To handle any errors during file operations.

// 2. Inside main method, use try-catch to handle possible errors.

// 3. In try block:
//    - Open the file using FileReader.
//    - Wrap it with BufferedReader for easy line-by-line reading.

// 4. Create a String variable "line" to store each line read.

// 5. Use a while loop:
//    - The condition (line = reader.readLine()) != null means:
//      Keep reading a new line and assign it to "line".
//      If the line is not null (file not ended), continue the loop.
//    - Inside the loop, print the current line.

// 6. When no more lines to read (readLine returns null), exit the loop.

// 7. Print the message "END OF THE FILE HAS REACHED".

// 8. Close the BufferedReader to free resources.

// 9. In catch block, print an error message if reading fails.
