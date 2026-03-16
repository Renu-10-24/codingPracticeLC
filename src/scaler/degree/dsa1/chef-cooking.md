In a parallel universe, there exists a kingdom renowned for its unique culinary traditions. In this kingdom, a famous chef is celebrated for her delectable dishes. One day, the chef decided to create a new dish using a sequence of ingredients, each with a distinct weight. The chef wants to select a subarray of these ingredients where the weights are in strictly increasing order.

The chef's goal is to determine the maximum possible sum of the weights of the strictly increasing subarray. Can you assist the chef by writing a function that returns the maximum possible sum of an strictly increasing subarray from the given array of ingredient weights?

The array of ingredient weights is represented by the array A.


Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 109


Input Format
First argument A, is an array of integers.


Output Format
Return a Long Integer, denoting the maximum possible sum of the weights of the strictly increasing subarray.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
Input 2:
A = [9, 9, 4, 2]


Example Output
Output 1:
15
Output 2:
9


Example Explanation
For Input 1:
Consider 0-based indexing.
The subarray we select is [0, 4] with sum 15.
For Input 2:
Consider 0-based indexing.
The subarray [0, 1] which is 9, 9 is not an strictly increasing subarray.
The subarray we select is [0,0] with sum 9.
Thus the maximum possible sum of the weights is 9.