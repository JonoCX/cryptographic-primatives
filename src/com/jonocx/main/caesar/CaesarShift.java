package com.jonocx.main.caesar;

import com.jonocx.main.frequency.FrequencyAnalysis;

/**
 * Created by Jonathan on 28-Oct-15.
 */
public class CaesarShift {

    private FrequencyAnalysis frequencyAnalysis;

    private String alphabet;

    public CaesarShift() {
        frequencyAnalysis = new FrequencyAnalysis();
        alphabet = frequencyAnalysis.getAlphabet();
    }

    public String decrypt(String cipherText, int key) {
        cipherText = cipherText.toUpperCase();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            if (cipherText.charAt(i) >= 'A' && cipherText.charAt(i) <= 'Z') {
                int position = alphabet.indexOf(cipherText.charAt(i));

                int value = Math.abs(position - key) % 26;
                char replace = alphabet.charAt(value);

                builder.append(replace);
            } else {
                builder.append(cipherText.charAt(i));
            }
        }

        return builder.toString();
    }

    public String encrypt(String plainText, int key) {
        plainText = plainText.toUpperCase();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) >= 'A' && plainText.charAt(i) <= 'Z') {
                int position = alphabet.indexOf(plainText.charAt(i));

                int value = Math.abs(position + key) % 26;
                char replace = alphabet.charAt(value);

                builder.append(replace);
            } else {
                builder.append(plainText.charAt(i));
            }
        }

        return builder.toString();
    }
}
