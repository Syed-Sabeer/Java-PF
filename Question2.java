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




//         Explanation

// 1. First, we import some built-in Java classes:
//    - FileReader: To open the file.
//    - BufferedReader: To read the file line by line easily.
//    - FileNotFoundException: To handle error when file is missing or name is wrong.
//    - IOException: To catch any other errors while reading the file.

// 2. We use try-catch blocks here. Why?
//    Because something might go wrong (like file is missing).
//    try { } means "try this code"
//    catch (Exception e) { } means "if error happens, do this instead"

// 3. Inside the try block:
//    - We try to open the file using:
//      FileReader fileReader = new FileReader("datsa.txt");
//      Note: 'datsa.txt' has a typo, so it will throw an error (which is good for testing).

// 4. Then we wrap it in BufferedReader like this:
//    BufferedReader reader = new BufferedReader(fileReader);

// 5. After that, we read the first line:
//    String line = reader.readLine();
//    And split it using TAB:
//    String[] words = line.split("\t");

// 6. We go through each word using a while loop and print it in CAPITAL letters.

// 7. At the end, we close the file using:
//    reader.close();

// 8. Now the important part — catch blocks:

//    - If the file is NOT FOUND or has a wrong name:
//      catch (FileNotFoundException e) {
//          System.out.println("Error: The file 'data.txt' could not be opened.");
//      }
//      So this is how we know the file was NOT opened.

//    - If there’s some other problem while reading (maybe file got corrupted or unreadable):
//      catch (IOException e) {
//          System.out.println("Error while reading the file.");
//      }


// inshort We use try-catch block. If the file can't be opened, Java will jump into the catch (FileNotFoundException e) block, and print a message that the file couldn't be opened. That’s how we check if the file was not opened.