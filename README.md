DBInterviewICH
==============

Exercises for Consideration


Instructions:

1. Given a list of unsorted non-unique values, create an algorithm to remove all duplicates from 
the list to ensure uniqueness of all remaining values. Please implement the algorithm; do not 
simply demonstrate a string method.
/src/codingtest/dedupe.java

2. Given a string with a recurring delimiter character (eg. "one;two;three"), create an algorithm 
that will separate the string into parts and return an array of substrings (eg. ["one", "two", 
"three"]). Please implement the algorithm; do not simply demonstrate a string method.
/src/codingtest/delimiter.java

3. Create a class that is initialized with a string representing a Roman numeral. Provide 
methods for this class that a) return the numeric value of the Roman numeral as an integer 
and b) allows you to add another Roman numeral to the original value (starting from the string 
representation) and return either another Roman numeral, or an integer.
/src/codingtest/RomanNumeral.java

4. For your solution to #3, please provide a complete set of unit tests and/or a test harness that 
you feel would be adequate for testing the algorithm.
/src/usetests/RomanNumeralTest.java

5. Please provide a SQL query that would be a better version of the following:
SELECT * FROM EMPLOYEES WHERE ID IN (SELECT USER_ID FROM 
DEPARTMENT_MEMBERS WHERE DEPARTMENT_ID=7)
In addition, please comment on why you changed what you did, including any assumption you 
made about the tables referred to in the above SQL query.
/sql.txt
