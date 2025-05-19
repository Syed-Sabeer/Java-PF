import java.io.BufferedReader;   // This lets us read characters from a file
import java.io.FileReader;       // This lets us read lines easily

public class Question1 {   
    public static void main(String[] args) throws Exception {
        
        // "throws Exception" means if something goes wrong, 
        // the program will stop and print the error.
        // It's like 'try catch' but simpler for now

        // Create FileReader object to open and read the file "data.txt"
        FileReader fileReader = new FileReader("data.txt");
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
}
