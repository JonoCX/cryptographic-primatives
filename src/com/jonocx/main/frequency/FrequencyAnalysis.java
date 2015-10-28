package com.jonocx.main.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * Frequency Analysis on a given text, whether plain
 * or encrypted, perform frequency analysis on said
 * text.
 *
 * Works for the English language.
 *
 * @author Jonathan Carlton
 */
public class FrequencyAnalysis {

    /**
     * Defined by the user, preferably
     * the English alphabet
     */
    private String alphabet;

    /**
     * Character map, populated by the alphabet.
     * A single character in the alphabet maps
     * to a value (how many times it occurs in
     * the plain text / cipher text)
     */
    private static Map<Character, Integer> characterMap;

    /**
     * Default constructor
     */
    public FrequencyAnalysis() {
        setAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        characterMap = new HashMap<>();

        populateMap();
    }

    /**
     * Object constructor with a given
     * alphabet (english)
     * @param alphabet  english alphabet
    */
    public FrequencyAnalysis(String alphabet) {
        setAlphabet(alphabet);
        characterMap = new HashMap<>();

        populateMap();
    }

    /**
     * Setter will only be used within the
     * scope of this class
     * @param alphabet  String alphabet
     */
    private void setAlphabet(String alphabet) {
        // TODO add check in for english alphabet
        this.alphabet = alphabet;
    }

    /**
     * Immutable getter method for the
     * private member variable alphabet
     * @return  String alphabet
     */
    public String getAlphabet() {
        return alphabet;
    }

    /**
     * Populate the character map with
     * the alphabet in the class
     */
    private void populateMap() {
        char[] arr = alphabet.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            characterMap.put(arr[i], 0);
        }
    }

    /**
     * Sum the frequency of characters in the given
     * text parameter
     * @param text  text to be analysed
     * @param print print map after it's process or
     *              not. Map is still returned
     * @return      character map containing the
     *              frequency of characters
     */
    public Map<Character, Integer> getFrequency(String text, boolean print) {
        for (int i = 0; i < text.length(); i++) {
            // if the text.char(i) is present, increment value by 1
            characterMap.computeIfPresent(text.charAt(i), (k, v) -> v + 1);
        }
        if (print) {
            printMap();
            return characterMap;
        }
        else
            return characterMap;
    }

    /**
     * Print the contents of the map
     * to the console
     */
    public void printMap() {
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }


}
