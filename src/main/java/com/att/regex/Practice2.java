package com.att.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice2 {
    public static void main(String[] args) {
        //Q1. Count uppercase letters
        String input = "Java IS FUN And EASY";
        // Expected output:
        // Uppercase letters: 9
        String ucRegex = "[A-Z]";
        Pattern ucPattern = Pattern.compile(ucRegex);
        Matcher ucMatcher = ucPattern.matcher(input);
        int counter = 0;
        while (ucMatcher.find()){
            counter++;
        }
        System.out.println("Uppercase letters: " +counter);

        //Remove special characters
        String input2 = "Java@2026#Spring!";
        //Expected Output: Java2026Spring
        String spRegex = "[^a-zA-Z0-9]";
        Pattern spPattern = Pattern.compile(spRegex);
        Matcher spMatcher = spPattern.matcher(input2);
        String spRemove = spMatcher.replaceAll("");
        System.out.println(spRemove);

        //Replace consecutive digits with *
        String input3 = "Order123Item456Price78";
        // Expected Output: Order*Item*Price*
        String digitRegex = "\\d+";
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher digitMatcher = digitPattern.matcher(input3);
        System.out.println(digitMatcher.replaceAll("*"));

//        Q4. Validate an alphanumeric username
        /*A valid username must:
        - Contain only letters and digits.
        - Be between 5 and 12 characters long.
        - Contain no spaces or special characters.*/

        //Expected output:
        /*Anu123 -> Valid
        anu@123 -> Invalid
        Ab12 -> Invalid
        Developer2026 -> Invalid*/

        String a = "Anu123";
        String b = "anu@123";
        String c = "Ab12";
        String d = "Developer2026";

        String userRegex = "[a-zA-Z0-9]{5,12}";
        Pattern userPattern = Pattern.compile(userRegex);
        validateUsername(userPattern, a);
        validateUsername(userPattern, b);
        validateUsername(userPattern, c);
        validateUsername(userPattern, d);

        //Q5. Extract decimal numbers
        String input5 = "Rice costs 45.50, milk costs 32.75, and bread costs 40";
        //Expected Output:
        /*45.50
        32.75
        40*/
        String decimalRegex = "\\d+\\.\\d+|\\d+";
        Pattern decimalPattern = Pattern.compile(decimalRegex);
        Matcher decimalMatcher = decimalPattern.matcher(input5);
        while (decimalMatcher.find()){
            System.out.println(decimalMatcher.group());
        }

        //Q6. Mask a phone number:Replace the first six digits with X, preserving the last four.
        String input6 = "My phone number is 9876543210";
        //expected output: My phone number is XXXXXX3210
        String maskRegex = "[0-9]{6}([0-9]{4})";
        Pattern maskPattern = Pattern.compile(maskRegex);
        Matcher maskMatcher = maskPattern.matcher(input6);
        System.out.println( maskMatcher.replaceAll("xxxxxx$1"));

        //Q7. Validate a password with additional rules
       /* A valid password must contain:
        - At least 10 characters.
        - At least two uppercase letters.
        - At least one lowercase letter.
        - At least two digits.
        - At least one special character.*/
        String p1 = "JAva@12345";
        String p2 = "Java@12345";
        String p3 = "JAVA@12345";
        String p4 = "JAva@123";
        //Expected Output:
        /*JAva@12345 -> Valid
        Java@12345 -> Invalid
        JAVA@12345 -> Invalid
        JAva@123 -> Invalid*/
        String pwRegex = "(?=.*[A-Z].*[A-Z])(?=.*[a-z])(?=.*[0-9].*[0-9])(?=.*[^A-Za-z0-9]).{10,}";
        Pattern pwPattern = Pattern.compile(pwRegex);
        validatePassword(pwPattern, p1);
        validatePassword(pwPattern, p2);
        validatePassword(pwPattern, p3);
        validatePassword(pwPattern, p4);

        String input10 = "Kavita has SSN 123-456, her card's CVV is 123 and her password is @1234";
        //output = Kavita has SSN xxx-xxx, her card's CVV is xxx and her password is xxxxx
        System.out.println(input10.replaceAll("\\d","x"));

//        String regex = "[.*SSN\\s+(\\d{3}-\\d{3})][.*CVV is\\s+(\\d{3})]";
//        Pattern pattern2 = Pattern.compile(regex);
//        Matcher matcher2 = pattern2.matcher(input10);
//        matcher2.re

        String input20 = "Kavita has an Ssn 123-456 and her cvv is 123, and her password is @123";
        String output20 = input20.replaceAll("(?i)(ssn\\sis\\s+)\\d{3}-\\d{3}","$1xxx-xxx")
                .replaceAll("(?i)(cvv\\sis\\s+)\\d{3}","$1xxx");
        String outRegex = "(?i)(password\\s+is\\s+)(\\S+)";
        Pattern outpattern = Pattern.compile(outRegex);
        Matcher matcher = outpattern.matcher(output20);
        String finalOut = matcher.replaceAll(m -> m.group(1) + "x".repeat(m.group(2).length()));
        System.out.println("final out: " + finalOut);


        String output = input20
                .replaceAll("(?i)(Ssn\\s+)\\d{3}-\\d{3}", "$1xxx-xxx")
                .replaceAll("(?i)(cvv\\s+is\\s+)\\d{3}", "$1xxx")
                .replaceAll("(?i)(password\\s+is\\s+)\\S+", "$1xxxx");

        System.out.println(output);

    }

    public static void validateUsername(Pattern pattern, String userName){
        Matcher userMatcher = pattern.matcher(userName);
        if (userMatcher.matches()){
            System.out.println(userName + " -> Valid");
        } else{
            System.out.println(userName + " -> Invalid");
        }
    }
    public static void validatePassword(Pattern pwPattern, String password){
        Matcher pwMatcher = pwPattern.matcher(password);
        if (pwMatcher.matches()){
            System.out.println(password + " -> Valid");
        } else {
            System.out.println(password + " -> Invalid");
        }
    }
}
