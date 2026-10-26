package com.att.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {

    public static void main(String[] args) {
        String input = "Kavita holds SSN 123-456, her CVV is 123 and her password is @1345";
        String output = input.replaceAll("(?i)(ssn\\s+)\\d{3}-\\d{3}", "$1xxx-xxx")
                             .replaceAll("(?i)(CVV\\s+is\\s+)\\d{3}", "$1xxx");
        System.out.println(output);
        String passRegex = "(?i)(password\\s+is\\s+)(\\S+)";
        Pattern passPattern = Pattern.compile(passRegex);
        Matcher passMatcher = passPattern.matcher(output);
        String finalOut = passMatcher.replaceAll(m -> m.group(1) + "x".repeat(m.group(2).length()));
        System.out.println(finalOut);

    }

}
