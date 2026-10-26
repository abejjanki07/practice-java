package com.att.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeRegex {
    public static void main(String[] args) {

        //1. Count the digits in a string
        String input = "Java123Spring45Boot6";
        //Expected Output: 6
        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while(matcher.find()){
            System.out.println("Found a digit: " + matcher.group(0));
            count++;
        }
        System.out.println("count of digits in a string: " + count);

        //2. Remove all digits
        String input2 = "Ja12va34Pro56";
        //output2 = JavaPro
        String regex2 = "\\d";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(input2);
        String noDigits = matcher2.replaceAll("");
        System.out.println("String with no digits: " + noDigits);

        //3. Replace multiple spaces with one space
        String input3 = "Java    Spring     Boot";
        // Output: Java Spring Boot
        String regex3 = "\\s+";
        Pattern pattern3 =Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(input3);

        String output3 = matcher3.replaceAll(" ");

        System.out.println("String with no extra spaces : " + output3);

        //4. Validate a String Contains Only Digits
        String inputx = "123456";
        String inputy = "123abc";
        String inputz = "";

        //Expected :
       /* 123456 -> Valid
        123abc -> Invalid
        ""     -> Invalid*/

        String regex4 = "[0-9]+";
        Pattern pattern4 = Pattern.compile(regex4);
        PracticeRegex.validateString(pattern4, inputx);
        PracticeRegex.validateString(pattern4, inputy);
        PracticeRegex.validateString(pattern4, inputz);

        // 5. Extract Numbers from a Sentence
        String input5 = "I have 2 laptops, 3 phones and 10 books";
        // Expected Output:
       /* 2
        3
        10*/
        String regex5 = "\\d+";
        Pattern pattern5 = Pattern.compile(regex5);
        Matcher matcher5 = pattern5.matcher(input5);
        while (matcher5.find()){
            System.out.println(matcher5.group());
        }

        //6: Validate an Indian Mobile Number
        //Task: Validate a 10-digit mobile number that starts with a digit from 6 to 9.
        String mobile1 = "9876543210";
        String mobile2 = "5876543210";
        String mobile3 = "987654321";

        //Expected Output:
        /*9876543210 -> Valid
        5876543210 -> Invalid
        987654321  -> Invalid*/
        String regex6 = "[6-9]\\d{9}" ;
        Pattern pattern6 = Pattern.compile(regex6);

        validateMobileNumber(pattern6, mobile1);
        validateMobileNumber(pattern6, mobile2);
        validateMobileNumber(pattern6, mobile3);

        // 7: Mask an SSN: Mask the first five digits of the SSN while keeping the last four digits visible.
        String input7 = "My SSN is 123-45-6789";
        //Expected output:
        //My SSN is XXX-XX-6789
        String regex7 = "\\d{3}-\\d{2}-(\\d{4})";
        Pattern pattern7 = Pattern.compile(regex7);
        Matcher matcher7 = pattern7.matcher(input7);
        String result = matcher7.replaceAll("xxx-xx-$1");
        System.out.println(result);

        //8: Validate Password Strength
        /*Validate a password that:
        - Has at least 8 characters.
                - Contains at least one uppercase letter.
                - Contains at least one lowercase letter.
                - Contains at least one digit.
        - Contains at least one special character.*/
        String inputp1 = "Java@123";
        String inputp2 = "java1234";
        String inputp3 = "JAVA@123";
        //ExpectedResults:
        /*Java@123 -> Valid
        java1234 -> Invalid
        JAVA@123 -> Invalid*/

        String regex8 = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}";
        Pattern pattern8 = Pattern.compile(regex8);
        validatePassword(pattern8,inputp1);
        validatePassword(pattern8,inputp2);
        validatePassword(pattern8,inputp3);


    }

    public static void validatePassword(Pattern pattern, String password){
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()){
            System.out.println(password + " -> Valid");
        } else{
            System.out.println(password + " -> Invalid");
        }
    }

    public static void validateMobileNumber(Pattern pattern, String mobileNumber){

        Matcher matcher = pattern.matcher(mobileNumber);
        if (matcher.matches()){
            System.out.println(mobileNumber + " -> Valid");
        }else {
            System.out.println(mobileNumber + " -> Invalid");
        }
    }

    public static void validateString(Pattern pattern, String inputString){
        Matcher stringMatcher = pattern.matcher(inputString);
        if (stringMatcher.matches()){
            System.out.println(inputString + " -> Valid");
        } else {
            System.out.println(inputString + " -> InValid");
        }
    }
}
