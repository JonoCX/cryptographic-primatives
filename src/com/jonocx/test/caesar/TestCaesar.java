package com.jonocx.test.caesar;

import com.jonocx.main.caesar.CaesarShift;

/**
 * Created by Jonathan on 28-Oct-15.
 */
public class TestCaesar {

    public static void main(String[] args) {
        CaesarShift cs = new CaesarShift();

        String plainText = "Every cloud has a silver lining";
        int key = 3;

        String encryptionResult = cs.encrypt(plainText, key);
        System.out.println(encryptionResult);

        String decryptionResult = cs.decrypt(encryptionResult, key);
        System.out.println(decryptionResult);
    }
}
