package cipher;

import java.io.*;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Integer shift;
    public final String alphabet = "abcdefghijklmnopqrstuvwyxz";

    ROT13(Character cs, Character cf) {
        shift = alphabet.indexOf(cf) - alphabet.indexOf(cs);
    }

    ROT13() {
        shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder crypt = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isLowerCase(text.chaeAt(i))) {
                    crypt.append(alphabet.charAt((alphabet.indexOf(text.charAt(i)) + shift) % 26));
                } else {
                    crypt.append(alphabet.toUpperCase().charAt((alphabet.toUpperCase().indexOf(text.charAt(i)) + shift) % 26));
                }
            } else {
                crypt.append(text.charAt(i));
            }
        }
        return crypt.toString();
    }

    public String caesarShift(String stringToEncrypt) {
        shift = 3;
        return crypt(stringToEncrypt);
    }

    public void encrypt(String text) throws FileNotFoundExcpetion, UnsupportedEncodingException {

    }

    public String readFile(String fileName) {
        String fileContents;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fileContents = sb.toString();
        } catch (IO Exception e) {
            throw new RuntimeExcpetion(e);
        }
        return fileContents;
    }

    public void setEncryptedTextToFile(String textToSet, String fileName) throws FileNotFoundException, UnsupportedEncodingExcpetion {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        String[] allLines = textToSet.split("\n");
        for (String str : allLines) {
            writer.println(str);
        }
        writer.close();
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {
        int rotation = s.indexOf(c);
        return s.substring(rotation) + s.substring(0, rotation);
    }

}
