package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.CipherUtils;
/**
 * A project for CSC-207 2024Fa.
 * Filename: Cipher.java
 * Author: Nicole Moreno Gonzalez
 * Description: Runs encription program given the desired arguments:
 *  str, key, cipher type, code or decode.
 */
public class Cipher {
/**
 * SET_LENGTH is the argument amount the program
 * should take.
 */
  private static final int SET_LENGTH = 4;
/**
 * Main takes the arguments and applies the desired method.
 * @param args are the command-line arguments.
 */
  public static void main(String[] args) {
    if (args.length != SET_LENGTH) {
      System.err.println("Error: Incorrect number of parameters");
      return;
    } // if
    // Makes sure arguments are valid
    for (String arg : args) {
      if (arg == null || arg.isEmpty()) {
        System.err.println("Error: Missing required arguments.");
        return;
      } // if
    } // for
    String encryptionType = "";
    String enOrDecrypt = "";
    String input = "";
    String key = "";

    for (String arg : args) {
      if (arg.charAt(0) == '-') {
        switch (arg) {
          case "-encode":
            enOrDecrypt = enOrDecrypt + "encode";
            break;
          case "-decode":
            enOrDecrypt = enOrDecrypt + "decode";
            break;
          case "-caesar":
            encryptionType = encryptionType + "caesar";
            break;
          case "-vigenere":
            encryptionType = encryptionType + "vigenere";
            break;
          default:
            System.err.println("Error: Invalid option");
            return;
        } // switch
      } else {
        if (input == "") {
          input = arg;
        } else {
          key = arg;
        } // if
      } // if
    } // for
    // Checks if caesar has valid key
    if (encryptionType.equals("caesar") && key.length() != 1) {
      System.err.println("Error: CaesarCipher key must be a single character.");
      return;
    } // if
    // Checks if input and key are valid strings
    if (AllCaesar.isInvalidInput(input) || AllCaesar.isInvalidInput(key)) {
      System.err.println("Error: You should only include lowercase characters and no space");
      return;
    } // else if
    // Assigning args to their corresponding method
    if (encryptionType.equals("caesar")) {
      if (enOrDecrypt.equals("encode")) {
        System.out.printf(CipherUtils.caesarEncrypt(input, key.charAt(0)));
        System.out.printf("\n");
      } else {
        System.out.printf(CipherUtils.caesarDecrypt(input, key.charAt(0)));
        System.out.printf("\n");
      } // else
    } else if (encryptionType.equals("vigenere")) {
      if (enOrDecrypt.equals("encode")) {
        System.out.printf(CipherUtils.vigenereEncrypt(input, key));
        System.out.printf("\n");
      } else {
        System.out.printf(CipherUtils.vigenereDecrypt(input, key));
        System.out.printf("\n");
      } // else
    } // else if
  } // main
} // class Cipher

