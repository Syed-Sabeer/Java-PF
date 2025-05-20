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

//                      Explanation

// 1. Import the built-in Java classes:
//    - FileReader: Opens the file from your computer.
//    - BufferedReader: Helps read the file line by line (very useful).
//    - IOException: Handles any input/output error that might happen.

// 2. Inside the main method, we use try-catch block:
//    - try { } contains the code we *want* to run.
//    - catch (IOException e) { } will run *if something goes wrong* (like missing file).

// 3. In the try block:
//    - First, we open the file using:
//      FileReader fileReader = new FileReader("data.txt");

// 4. Then we wrap it with BufferedReader:
//    - BufferedReader reader = new BufferedReader(fileReader);
//    - This lets us read full lines easily using `.readLine()`.

// 5. Now we read ONE line using:
//    - String line = reader.readLine();
//    - This will only read the first line of the file (not the whole file).

// 6. We check if the line is NOT null:
//    - That means the file is not empty, so we print it on the screen.
//    - If the file is empty (line is null), we show "File is empty."

// 7. Then we close the file using:
//    - reader.close();  → Always close the file after you're done.

// 8. If anything goes wrong (like file missing or error while reading):
//    - The catch block will run and print: "Error reading the file."

