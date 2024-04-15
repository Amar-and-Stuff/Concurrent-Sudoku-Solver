# Concurrent Sudoku Solver
 A Sudoku Solver is a program written to generate a solution to the given Sudoku Input using Multithreading in Java.
# Approach and Flow
Use of Multithreading in Java inorder to find the possible solution for each position.
- Initially, Each empty cell will be assigned with a thread and a state which contains all the possible numbers.
- Based on the rules of Sudoku, thread eliminates the numbers in the state until single number is remained.
- If a state consists of more than one possible numbers, thread will enter into a waiting state.
- When a thread narrows down the state to a single number, it achieves the solution to that cell, then it notifies all the waiting threads before terminating itself.
- When notified, all the waiting threads will re-evaluate their respective state.
- Finally, the solution will be found when all threads are terminated.
- This can only solve Easy level Sudoku Challenges.