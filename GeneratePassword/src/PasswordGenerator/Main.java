package PasswordGenerator;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
//save a password to the text file
import java.io.FileWriter;
import java.io.BufferedWriter;

import PasswordGenerator.PasswordGenerator.PasswordCharacterSet;

public class Main {

    public static void main(String[] args) {
        Set<PasswordCharacterSet> values = new HashSet<PasswordCharacterSet>(EnumSet.allOf(SummerCharacterSets.class));
        PasswordGenerator pwGenerator = new PasswordGenerator(values, 10, 10); // generate a random password consists of 10 characters
        for(int i=0; i < 1; ++i) {
            System.out.println(pwGenerator.generatePassword());
        }
    //this code is saving the password
    FileWriter file = null;
	BufferedWriter writer = null;
		try {
			file = new FileWriter("password.txt");
			writer = new BufferedWriter(file);
			writer.write(pwGenerator.generatePassword());
			writer.newLine();
			writer.close();
			System.err.println("your password " + pwGenerator.generatePassword() + " was saved.");
		} catch(Exception e) {
			System.out.println("ERROR!");
		}	
		
	}

    private static final char[] ALPHA_UPPER_CHARACTERS = { 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private static final char[] ALPHA_LOWER_CHARACTERS = { 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    private static final char[] NUMERIC_CHARACTERS = { '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9' };
    private static final char[] SPECIAL_CHARACTERS = { '~', '`', '!', '@', '#',
            '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', '{',
            ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/',
            '?' };

    private enum SummerCharacterSets implements PasswordCharacterSet {
        ALPHA_UPPER(ALPHA_UPPER_CHARACTERS, 1),
        ALPHA_LOWER(ALPHA_LOWER_CHARACTERS, 1),
        NUMERIC(NUMERIC_CHARACTERS, 1),
        SPECIAL(SPECIAL_CHARACTERS, 1);

        private final char[] chars;
        private final int minUsage;

        private SummerCharacterSets(char[] chars, int minUsage) {
            this.chars = chars;
            this.minUsage = minUsage;
        }

        @Override
        public char[] getCharacters() {
            return chars;
        }

        @Override
        public int getMinCharacters() {
            return minUsage;
        }
    }
}