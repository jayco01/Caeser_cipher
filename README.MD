# Caesar Cipher

This is a command-line tool I built to encrypt and decrypt text files using the Caesar cipher. I developed this as my final project for Module 1 of my software development program. It demonstrates my understanding of core Java concepts, file handling, and basic cryptanalysis.

## Project Overview
I designed this program with a simple and interactive command-line interface to perform cryptographic operations on text files. It supports both encryption and several methods of decryption, including using a known key, brute-forcing all possibilities, and using statistical frequency analysis to crack the cipher.

Throughout the project, I focused on writing clean code with a good architecture, so I separated the program's logic into different classes for handling the user menu, file operations, input validation, and the cipher itself.

## Features
* **Encryption**: Encrypts a text file with a user-provided integer key.
* **Decryption**: Decrypts a text file using the corresponding key.
* **Brute-Force Cracking**: Automatically decrypts a file by trying every possible key and identifying the most plausible plaintext based on a dictionary of common English words.
* **Statistical Analysis Cracking**: Decrypts a file by analyzing the frequency of characters in the ciphertext to guess the most likely key.
* **Input Validation**: Ensures that files exist and that keys are valid before performing any operations.
* **File Creation**: If an input file doesn't exist, the program offers to create it on the fly.


## Usage
Upon running the program, you will be presented with the following menu:
```
Choose a Service:
1. Encryption
2. Decryption with key
3. Brute force
4. Statistical analysis
0. Exit
```
Simply enter the number corresponding to the service you wish to use.

### 1. Encrypt
-   **Function**: Encrypts a source file.
-   **Inputs**:
    1.  Source file name (e.g., `input.txt`).
    2.  An integer key for the cipher (e.g., `5`).
    3.  A destination file name (e.g., `encrypted.txt`).

### 2. Decrypt with Key
-   **Function**: Decrypts a file using a known key.
-   **Inputs**:
    1.  Source file name of the encrypted text.
    2.  The integer key that was used for encryption.
    3.  A destination file name for the decrypted text.

### 3. Decrypt with Brute Force
-   **Function**: Decrypts a file without a key by trying all possibilities.
-   **Inputs**:
    1.  Source file name of the encrypted text.
    2.  A destination file name.
-   **Process**: The program will iterate through every possible key, decrypt the text, and count how many common English words appear in the result. The decryption with the highest word count is chosen as the correct one.

### 4. Decrypt with Statistical Analysis
-   **Function**: Decrypts a file without a key using character frequency.
-   **Inputs**:
    1.  Source file name of the encrypted text.
    2.  A destination file name.
-   **Process**: The program finds the most frequently used character in the encrypted text and assumes it corresponds to one of the most common letters in English (like 'e', 't', 'a', or a space). Based on this assumption, it calculates the most likely keys and presents the decrypted results.

## Project Structure
I organized the project into the following classes to maintain a clean separation of concerns:
* `Main.java`: The entry point of the application. It contains the main loop and handles top-level user input.
* `MenuHelper.java`: Manages the user menu, prompts, and directs the program flow to the appropriate service.
* `Cipher.java`: Contains all core logic for encryption, decryption, brute-force analysis, and statistical analysis.
* `FileManager.java`: Handles all file I/O operations, including reading from source files and writing to destination files.
* `Validator.java`: A utility class for validating user input, such as checking if a key is valid or if a file exists.
