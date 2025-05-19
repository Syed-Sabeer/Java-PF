import java.io.BufferedReader;   // This lets us read characters from a file
import java.io.FileNotFoundException;       // This lets us read lines easily
import java.io.FileReader; // This helps us catch if file is missing
import java.io.IOException;      // This handles input/output errors

public class Question2 {
    public static void main(String[] args) {
        
        // We will use try-catch to handle errors if the file is not found or can't be read
        try {
            // Create FileReader object to open and read the file "data.txt"
            FileReader fileReader = new FileReader("datsa.txt");

            // Wrap FileReader in BufferedReader to read whole lines easily
            BufferedReader reader = new BufferedReader(fileReader);

            // Read one line from the file
            String line = reader.readLine();  // Reads a whole line of text

            // Split the line into parts wherever there is a TAB character ("\t")
            // This creates an array of words separated by tabs
            String[] words = line.split("\t");

            int i = 0;  // Start from the first word (index 0)

            // Loop through the words using while loop
            while (i < words.length) {
                // Convert the current word to uppercase (capital letters)
                String upperWord = words[i].toUpperCase();

                // Print the uppercase word on the screen
                System.out.println(upperWord);

                i++;  // Move to the next word
                // increment everytime
            }

            // Close the file to free resources (always do this after reading a file)
            reader.close();
        } 
        
        //FileNotFoundException is java owns keyword
        catch (FileNotFoundException e) {
            // This block runs if the file is not found
            System.out.println("Error: The file 'data.txt' could not be opened.");
            // maybe file is missing or filename is wrong
        }

        
        catch (IOException e) {
            // This block runs if there is a problem while reading the file
            System.out.println("Error while reading the file.");
        }
    }
}
