3. Alice and even values
   Save for later
   Problem Description

Alice is a librarian who is working on a project to organize a list of books. She has a linked list of books A, where each node represents a book with an integer value that indicates the number of pages in the book. She wants to remove all the books that have an odd number of pages from the linked list.

Help her by writing a function to remove all the nodes of the linked list with odd values and return the head of the updated linked list.



Problem Constraints

1 <= A.size() <= 105

1 <= Values of Linked list <= 109



Input Format

Only argument is a head of linked list A.


Output Format

Return the head of the updated linked list.



Example Input

Input 1:

A = 1 -> 4 -> 5 -> 6 -> 7
Input 2:

A = 2 -> 4 -> 9 -> 3 -> 4



Example Output

Output 1:

4 -> 6
Output 2:

2 -> 4 -> 4


Example Explanation

Explanation 1:

After removing the odd values the linked list looks like: 4 -> 6
Explanation 2:

After removing the odd values the linked list looks like: 2 -> 4 -> 4