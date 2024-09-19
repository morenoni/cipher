package edu.grinnell.csc207.util;
/**
 * A project for CSC-207 2024Fa.
 * Filename: CipherUtils.java
 * Author: Nicole Moreno Gonzalez
 * Description: Contains the auxiliary functions
 * implemented in AllCaesar and Cipher files.
 */
public class CipherUtils {
/**
 * ALPH_LENGTH is the length of the alphabet.
 */
  private static final int ALPH_LENGTH = 26;
/**
 * LOWER_ASCII is the ASCII of 'a'.
 */
  private static final int LOWER_ASCII = 97;
/**
 * mod26 is a modulo that wraps negative numbers around.
 * @param number is alphabet letter position.
 * @return remainder of number/26.
 */
  public static int mod26(int number) {
    int result = number % ALPH_LENGTH;
    if (result < 0) {
      result += ALPH_LENGTH;
    } // if
    return result;
  } // method mod26
/**
 * letter2int converts letter to int.
 * @param letter lowercase.
 * @return conversion.
 */
  private static int letter2int(char letter) {
    int conversion = (int) letter;
    return conversion - LOWER_ASCII;
  } // method letter2int
/**
 * int2letter converts an integer to a letter.
 * @param i alphabet letter position.
 * @return ASCII number.
 */
  private static char int2letter(int i) {
    int conversion = i + LOWER_ASCII;
    return (char) conversion;
  } // method int2letter
/**
 * keySum is an aux method that sums the int conversion
 * of the key to each character of str.
 * @param str input string.
 * @param key int of a single character.
 * @return Encrypted string.
 */
  public static String keySum(String str, int key) {
    String newString = "";
    for (int i = 0; i < str.length(); i++) {
      int newInt = letter2int(str.charAt(i)) + key;
      int newChar = mod26(newInt);
      newString = newString + int2letter(newChar);
    } // for
    return newString;
  } // method keySum
/**
 * caesarEncrypt converts letter to int and uses keySum.
 * @param str input string.
 * @param letter single character
 * @return Encrypted string.
 */
  public static String caesarEncrypt(String str, char letter) {
    int key = letter2int(letter);
    return keySum(str, key);
  } // method caesarEncrypt
/**
 * caesarDecrypt converts letter to negative int and uses keySum.
 * @param str input string.
 * @param letter single character/
 * @return Decrypted string.
 */
  public static String caesarDecrypt(String str, char letter) {
    int key = letter2int(letter) * -1;
    return keySum(str, key);
  } // method caesarDecrypt
/**
 * keyString creates a string of the length of str
 * with repeated keys.
 * @param str input string to encrypt
 * @param key string key
 * @return new key string
 */
  public static String keyString(String str, String key) {
    String keyString = "";
    for (int i = 0; i < str.length(); i++) {
      int mod2 = i % key.length();
      keyString = keyString + key.charAt(mod2); //
    } // for
    return keyString;
  } // method keyString
/**
 * encrypt adds/substracts key string int values to input str.
 * @param str string to encrypt.
 * @param key key string.
 * @param codeOrDecode to tell if you want to code or decode.
 * @return encrypted string.
 */
  public static String encrypt(String str, String key, int codeOrDecode) {
    String keyString = keyString(str, key);
    String newString = "";
    for (int i = 0; i < str.length(); i++) {
      int newInt = 0;
      if (codeOrDecode == 0) {
        newInt = letter2int(str.charAt(i)) + letter2int(keyString.charAt(i));
      } else {
        newInt = letter2int(str.charAt(i)) - letter2int(keyString.charAt(i));
      } // else
      int newChar = mod26(newInt);
      newString = newString + int2letter(newChar);
    } // for
    return newString;
  } // method encrypt
/**
 *  Tells the method encrypt to add key string int values.
 * @param str str to encrypt.
 * @param key key string.
 * @return encrypted string.
 */
  public static String vigenereEncrypt(String str, String key) {
    return encrypt(str, key, 0);
  } // method vigenereEncrypt
/**
 *  Tells the method encrypt to substract key string int values.
 * @param str str to encrypt.
 * @param key key string.
 * @return decrypted string.
 */
  public static String vigenereDecrypt(String str, String key) {
    return encrypt(str, key, 1);
  } // method vigenereDecrypt
} // Class CipherUtils
