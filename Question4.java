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
