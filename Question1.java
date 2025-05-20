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



//                  Explanation of This Program

// 1. First, we import some built-in Java classes:
//    - FileReader: This is used to open and read the file.
//    - BufferedReader: This helps us read the file line by line easily.

// 2. Then we create a FileReader object like this:
//    FileReader fileReader = new FileReader("data.txt");
//    This line basically tells Java to open the file named "data.txt".

// 3. Now we wrap that FileReader inside a BufferedReader:
//    BufferedReader reader = new BufferedReader(fileReader);
//    This makes it easier to read one full line from the file at a time.

// 4. To read a line from the file, we write:
//    String line = reader.readLine();
//    This line reads the first line of text from the file and saves it into a variable called "line".

// 5. If the file has data separated by TABs (like This    Is    Sabeer), we can split it like this:
//    String[] words = line.split("\t");
//    Now each word (or field) is saved separately in an array called "words".

// 6. We can use a while loop to go through each word and do something with it:
//    For example, printing each word in capital letters using System.out.println().

// 7. Finally, we must close the file using:
//    reader.close();
//    This is very important. It closes the file and frees up memory so the file doesn’t stay open.
