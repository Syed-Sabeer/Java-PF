import java.io.BufferedReader;   // Helps read text line by line
import java.io.FileReader;       // Opens the file
import java.io.IOException;      // Handles input/output errors

public class Question5 {
    public static void main(String[] args) {
        BufferedReader reader = null;  // Start with null, means file not opened yet

        try {
            // Try to open the file
            FileReader fileReader = new FileReader("data.txt");
            reader = new BufferedReader(fileReader);

            // Just read and print the first line (optional step)
            String line = reader.readLine();
            System.out.println("File opened successfully. \nFirst line: " + line);

        } catch (IOException e) {
            // If file could not be opened or there was an error
            System.out.println("File could not be opened.");
        } finally {
            // This part runs no matter what (success or error)

            // If reader is not null, then the file was opened — so we can close it
            if (reader != null) {
                try {
                    reader.close();  // Close the file
                    System.out.println("File closed successfully.");
                } catch (IOException e) {
                    System.out.println("Error while closing the file.");
                }
            } else {
                // If reader was never assigned, file was not opened
                System.out.println("File was not opened.");
            }
        }
    }
}

//   Explanation

// 1. Import required classes:
//    - FileReader: to open the file.
//    - BufferedReader: to read text line by line easily.
//    - IOException: to handle input/output errors.

// 2. Start with BufferedReader variable "reader" set to null,
//    meaning the file is not opened yet.

// 3. Use try-catch-finally to safely open, read, and close the file:

//    Inside try block:
//    - Try to open the file using FileReader.
//    - Wrap FileReader with BufferedReader for easy reading.
//    - Read one line (optional) and print it to show file opened.

//    Inside catch block:
//    - If an error happens (like file missing), print "File could not be opened."

//    Inside finally block (this runs no matter what):
//    - Check if "reader" is not null (file opened successfully).
//      If yes, try to close the file and print "File closed successfully."
//    - If "reader" is still null (file never opened), print "File was not opened."
//    - Also handle any errors during file closing.

