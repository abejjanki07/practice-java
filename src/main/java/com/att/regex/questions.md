# Java Regex Practice — 15 Coding Questions

**Goal:** Practice Java Regex using `Pattern`, `Matcher`, `find()`, `group()`, and `replaceAll()`.

## 🟢 Easy Level

### Question 1: Count Digits
**Input:**
```java
String input = "Java123Spring45Boot6";
```
**Expected output:**
```text
Total digits: 6
```
**Task:** Use Regex to count all digits in the string.

### Question 2: Remove All Digits
**Input:**
```java
String input = "Ja12va34Pro56";
```
**Expected output:**
```text
JavaPro
```
**Task:** Remove every digit from the string using Regex.

### Question 3: Replace Multiple Spaces with One Space
**Input:**
```java
String input = "Java    Spring     Boot";
```
**Expected output:**
```text
Java Spring Boot
```
**Task:** Replace multiple consecutive spaces with a single space.

### Question 4: Validate a String Contains Only Digits
**Input examples:**
```java
String input1 = "123456";
String input2 = "123abc";
String input3 = "";
```
**Expected results:**
```text
123456 -> Valid
123abc -> Invalid
""     -> Invalid
```
**Task:** Validate that the string is non-empty and contains only digits.

### Question 5: Extract Numbers from a Sentence
**Input:**
```java
String input = "I have 2 laptops, 3 phones and 10 books";
```
**Expected output:**
```text
2
3
10
```
**Task:** Extract and print every complete number from the sentence.

## 🟡 Medium Level

### Question 6: Validate an Indian Mobile Number
**Input examples:**
```java
String input1 = "9876543210";
String input2 = "5876543210";
String input3 = "987654321";
```
**Expected results:**
```text
9876543210 -> Valid
5876543210 -> Invalid
987654321  -> Invalid
```
**Task:** Validate a 10-digit mobile number that starts with a digit from 6 to 9.

### Question 7: Mask an SSN
**Input:**
```java
String input = "My SSN is 123-45-6789";
```
**Expected output:**
```text
My SSN is XXX-XX-6789
```
**Task:** Mask the first five digits of the SSN while keeping the last four digits visible.

### Question 8: Validate Password Strength
**Input examples:**
```java
String input1 = "Java@123";
String input2 = "java1234";
String input3 = "JAVA@123";
```
**Expected results:**
```text
Java@123 -> Valid
java1234 -> Invalid
JAVA@123 -> Invalid
```
**Task:** Validate a password that:
- Has at least 8 characters.
- Contains at least one uppercase letter.
- Contains at least one lowercase letter.
- Contains at least one digit.
- Contains at least one special character.

### Question 9: Extract Email Addresses
**Input:**
```java
String input = "Contact me at anu@gmail.com or test123@yahoo.com";
```
**Expected output:**
```text
anu@gmail.com
test123@yahoo.com
```
**Task:** Extract all email addresses from the sentence.

### Question 10: Mask CVV and Password Values
**Input:**
```java
String input = "CVV: 123, Password: Java@123";
```
**Expected output:**
```text
CVV: XXX, Password: XXXXXXXX
```
**Task:** Mask the values after `CVV:` and `Password:` with `X` characters of the same length.

## 🔴 Interview Level

### Question 11: Mask Sensitive Information in a Sentence
**Input:**
```java
String input = "SSN: 123-45-6789, CVV: 456, Password: Java@123";
```
**Expected output:**
```text
SSN: XXX-XX-6789, CVV: XXX, Password: XXXXXXXX
```
**Task:** Use Regex to mask the sensitive values while preserving the SSN's last four digits.

### Question 12: Find Duplicate Words
**Input:**
```java
String input = "Java is great and java is powerful";
```
**Expected output:**
```text
java
is
```
**Task:** Find words that appear more than once, ignoring uppercase and lowercase differences. Print each duplicate word only once.

### Question 13: Validate a Date
**Input examples:**
```java
String input1 = "25-12-2026";
String input2 = "31-02-2026";
String input3 = "2026-12-25";
```
**Expected results:**
```text
25-12-2026 -> Valid
31-02-2026 -> Invalid
2026-12-25 -> Invalid
```
**Task:** Require the format `dd-MM-yyyy`. Use Regex for the format and Java's date API to check whether the date actually exists.

### Question 14: Normalize Whitespace
**Input:**
```java
String input = "Java   Spring\tBoot\nDeveloper";
```
**Expected output:**
```text
Java Spring Boot Developer
```
**Task:** Remove leading and trailing whitespace and replace consecutive spaces, tabs, or newlines with a single space.

### Question 15: Dynamically Mask Values After Labels
**Input:**
```java
String input = "Name: Anu, Password: Java123, CVV: 456";
```
**Expected output:**
```text
Name: Anu, Password: XXXXXXX, CVV: XXX
```
**Task:** Mask values after `Password:` and `CVV:` with `X` characters matching each value's length. Leave the name unchanged.

---

## Practice Rules

1. Attempt each question before checking a solution.
2. Start with `Pattern.compile(regex)`.
3. Create a `Matcher` using `pattern.matcher(input)`.
4. Use `find()` when searching for multiple matches.
5. Use `group()` to retrieve the current match.
6. Use `replaceAll()` when replacing every match.
7. Test both valid and invalid inputs.

**Progress tracker**

- [ ] Q1 — Count digits
- [ ] Q2 — Remove digits
- [ ] Q3 — Collapse spaces
- [ ] Q4 — Digits-only validation
- [ ] Q5 — Extract numbers
- [ ] Q6 — Mobile validation
- [ ] Q7 — Mask SSN
- [ ] Q8 — Password validation
- [ ] Q9 — Extract emails
- [ ] Q10 — Mask CVV and password
- [ ] Q11 — Mask sensitive information
- [ ] Q12 — Find duplicate words
- [ ] Q13 — Validate dates
- [ ] Q14 — Normalize whitespace
- [ ] Q15 — Dynamically mask values