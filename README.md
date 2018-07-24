# Sudoku-Solver
Hi there, <br>
This is a simple sudoku solver program I originally created to solve Project Euler's problem 96. <br>
But then, tweaked it to solve any sudoku(As long as it's valid and has only one possible solution) <br>
Just a simple project for the weekend :) <br>
This program uses console input not a fancy GUI. <br>
So, to input a valid sudoku to the program use 0 instead of blank spaces<br>
Refer to sample folder of the project to view sample input and it's output<br>
# Sample Input:
java -jar "C:\SuDoku.jar" <br>
Enter your 9X9 Sudoku here :<br>
200080300<br>
060070084<br>
030500209<br>
000105408<br>
000000000<br>
402706000<br>
301007040<br>
720040060<br>
004010003<br>
# Sample Output: <br>
----- YOUR INPUT: ----- <br>
2 0 0 0 8 0 3 0 0 <br>
0 6 0 0 7 0 0 8 4 <br>
0 3 0 5 0 0 2 0 9 <br>
0 0 0 1 0 5 4 0 8 <br>
0 0 0 0 0 0 0 0 0 <br>
4 0 2 7 0 6 0 0 0 <br>
3 0 1 0 0 7 0 4 0 <br>
7 2 0 0 4 0 0 6 0 <br>
0 0 4 0 1 0 0 0 3 <br>
------ SOLUTION: ------ <br>
2 4 5 9 8 1 3 7 6 <br>
1 6 9 2 7 3 5 8 4 <br>
8 3 7 5 6 4 2 1 9 <br>
9 7 6 1 2 5 4 3 8 <br>
5 1 3 4 9 8 6 2 7 <br>
4 8 2 7 3 6 9 5 1 <br>
3 9 1 6 5 7 8 4 2 <br>
7 2 8 3 4 9 1 6 5 <br>
6 5 4 8 1 2 7 9 3 <br>
--------------------- <br>
SOLVED IN : 32 millisecond(s) <br>
