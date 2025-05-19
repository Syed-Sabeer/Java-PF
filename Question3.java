import java.io.BufferedReader;   // Helps read text line by line
import java.io.FileReader;       // Opens the file
import java.io.IOException;      // Handles input/output errors

public class Question3 {
    public static void main(String[] args) {
        try {
            // Open the file using FileReader
            FileReader fileReader = new FileReader("data.txt");

            // Wrap it with BufferedReader to read full lines easily
            BufferedReader reader = new BufferedReader(fileReader);

            //  Read ONE LINE from the file
            String line = reader.readLine();  // This will read the first line of the file

            // Check if line is not empty or null
            // this condion is optional I just added this condition to ensure everything work perfectly including
            // error handling
            if (line != null) {
                // Print the line to the screen
                System.out.println("First line from file: " + line);
            } else {
                System.out.println("File is empty.");
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {
            // If file is missing or there's an error, print this message
            System.out.println("Error reading the file.");
        }
    }


    // actually this program is same as Question 1 here we are not using split function to show every word separately
}
