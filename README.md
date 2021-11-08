# FizzBuzzDetector

Write an algorithm that replaces every third word in the string to Fizz, and every fifth word in the string to Buzz.
Constraints: 
Length of the input string: 7 ≤ |s| ≤ 100
Input string cannot be null
Algorithm processes only alphanumeric words (other symbols and whitespaces are skipped) 

Functional Description:
Application should utilize class FizzBuzzDetector and method getOverlappings that has input 
string and provides result as an object that contains output string with replaced words and number of coincidences of Fizz, 
Buzz and FizzBuzz words within the output string. 
During the calculation of the number of coincidences please take into account the following rules: Fizz = 1, Buzz = 1, FizzBuzz = 1. 

It is not allowed to use built-in programming utilities or third-party libraries provided by a specific programming language for FizzBuzz detection logic.

Example:
Input 
Mary had a little lamb
Little lamb, little lamb
Mary had a little lamb
It's fleece was white as snow

Result
output string: 
Mary had Fizz little Buzz
Fizz lamb, little Fizz
Buzz had Fizz little lamb
FizzBuzz fleece was Fizz as Buzz
