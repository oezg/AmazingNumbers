#Amazing Numbers

We use numbers every day. But do you know how many different properties they have? Let's take a look at some of the amazing properties of numbers. 

Would you like to know how to determine whether a number is Palindromic or Gapful, or how to distinguish Spy numbers from others. Numbers can be fascinating!

Number theory is a branch of mathematics devoted primarily to the study of the properties of integers. Let's make a program that indicates the properties of the numbers taken from the input.

Even and odd are common sense but what are Buzz numbers? They are numbers that are either divisible by 7 or end with 7. For example, the number 14 is a buzz number, since it is divisible by 7 without a remainder; the number 17 ends with 7, so it is also a buzz number. However, the number 75 is not a Buzz number, since it is neither divisible by 7 nor does it end with 7. The number 7 is a Buzz number too.

A Duck number is a positive number that contains zeroes. For example, 3210, 8050896, 70709 are Duck numbers. Note that a number with a leading 0 is not a Duck number. So, numbers like 035 or 0212 are not Duck numbers. Although, 01203 is a Duck, since it has a trailing 0.

A Palindromic number is symmetrical; in other words, it stays the same regardless of whether we read it from left or right. For example, 17371 is a palindromic number. 5 is also a palindromic number. 1234 is not. If read it from right, it becomes 4321.

A Gapful number is a number that contains at least 3 digits and is divisible by the concatenation of its first and last digit without a remainder. 12 is not a Gapful number, as it has only two digits. 132 is a Gapful number, as 132 % 12 == 0. Another good example of a Gapful number is 7881, as 7881 % 71 == 0.

A number is said to be Spy if the sum of all digits is equal to the product of all digits.

N is a Sunny number if N+1 is a perfect Square number. In mathematics, a Square number is an integer that is the square of an integer; in other words, it is the product of an integer with itself. For example, 9 is a square number, since it equals 32 and can be written as 3×3.

A number is a Jumping number if the adjacent digits inside the number differ by 1. The difference between 9 and 0 is not considered as 1. Single-digit numbers are considered Jumping numbers. For example, 78987, and 4343456 are Jumping numbers, but 796 and 89098 are not.

In number theory, a Happy number is a number that reaches 1 after a sequence during which the number is replaced by the sum of each digit squares. For example, 13 is a happy number, as 1^2 + 3^2 = 10 which leads to 1^2 + 0^2 = 1. On the other hand, 4 is not a happy number because the sequence starts with 4^2 = 16, 1^2 + 6^2 = 37, and finally reaches 2^2 + 0^2 = 4. This is the number that started the sequence, so the process goes on in an infinite cycle. A number that is not happy is called Sad (or Unhappy).

This program follows the following steps:
1. Welcome users;
2. Display the instructions;
3. Ask for a request;
4. If the user enters an empty request, print the instructions again;
5. If the user enters zero, terminate the program;
6. If numbers are not natural, print an error message;
7. If an incorrect property is specified, print the error message and the list of available properties;
8. For one number, print the properties of the number;
9. For two numbers, print the properties of all numbers beginning with the first number, the second number is the length of the list;
10. For two numbers and two properties, print the list of numbers that contain the specified properties;
11. If a property is preceded by a minus, this property should not be present in a number;
12. If the user specifies mutually exclusive properties, abort the request and warn the user.
13. Once the request is processed, continue execution from step 3.

Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameter shows how many consecutive numbers are to be printed;
- two natural numbers and properties to search for;
- a property preceded by minus must not be present in numbers;
- separate the parameters with one space;
- enter 0 to exit.

The property names include even, odd, buzz, duck, palindromic, gapful, spy, sunny, square, jumping, sad, and happy. Mutually exclusive properties are even/odd, duck/spy, sunny/square, sad/happy pairs, as well as direct opposites (property and -property).
