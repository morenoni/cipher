package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * A project for CSC-207 2024Fa.
 * Filename: Allcaesar.java
 * Author: Nicole Moreno Gonzalez
 * Description: Implements Caesar Cipher to
 * encrypt or decrypt a string using a letter.
 */
public class AllCaesar {
/**
 * alphabet array.
 */
  private static char[] alph = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
      'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
/**
 * encodeOrDecode prints the program depending on what the
 * first argument of args is.
 * @param args are the command-line arguments.
 */
  public static void encodeOrDecode(String[] args) {
    if (args[0].equals("encode")) {
      for (int i = 0; i < alph.length; i++) {
        System.out.printf("n = %c: %s\n", alph[i], CipherUtils.caesarEncrypt(args[1], alph[i]));
      } // for
    } else {
      for (int i = 0; i < alph.length; i++) {
        System.out.printf("n = %c: %s\n", alph[i], CipherUtils.caesarDecrypt(args[1], alph[i]));
      } // for
    } // else
  } // method encodeOrDecode
/**
 * isInvalidChar thows a boolean.
 * @param ch is a character of the input string.
 * @return false if the input char in in the alph array,
 * otherwise true.
 */
  public static boolean isInvalidChar(char ch) {
    for (int i = 0; i < alph.length; i++) {
      if (ch == alph[i]) {
        return false;
      } // if
    } // for
    return true;
  } // method isInvalidChar
/**
 * isInvalidInput thows true if any of the chacters in input string
 * is not a lowercase.
 * @param input is second argument in args.
 * @return thows true if the input string given that characters.
 * are lowercase.
 */
  public static boolean isInvalidInput(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (isInvalidChar(input.charAt(i))) {
        return true;
      } //if
    } // for
    return false;
  } //method isInvalidInput
/**
 * traverseString prints error message and stops the program
 * if the input is not valid.
 * @param args command-line arguments
 */
  public static void traverseString(String[] args) {
    if (isInvalidInput(args[1])) {
      System.err.println("Error: You should only include lowercase characters and no space");
      return;
    } // if
    encodeOrDecode(args);
  } // method traverseString
/**
 * firstArgValid assures that first arg is "encode" or "decode".
 * @param args command-line arguments.
 */
  public static void firstArgValid(String[] args) {
    if (args[0].equals("encode") || args[0].equals("decode")) {
      traverseString(args);
    } else {
      System.err.println("Error: invalid option: \"" + args[0]
          + "\" Valid options are \"encode\" or \"decode\"");
    } // else
  } // method firstArgValid
/**
 * Main method assures the correct number of command-line args.
 * @param args command-line arguments.
 */
  public static void main(String[] args) {
    if (args.length < 2 || args.length > 2) {
      System.err.println("Error: Incorrect number of parameters");
    } else {
      firstArgValid(args);
    } // else
  } // main
} // Class AllCaesar
