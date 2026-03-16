Sana is a chef who loves to experiment with different flavors. She has an array A of length N of spices in her kitchen. She wants to find the smallest subarray that contains all occurrences of the most frequent spice (There can be multiple most frequent spices).

She has noted down the occurrence of each spice in an array, and now she needs your help to find the length of the smallest subarray length that contains all occurrences of the most frequent spice.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First argument A is an array of integers.



Output Format
Return an integer denoting length of the smallest subarray length that contains all occurrences of the most frequent integer.



Example Input
Input 1:

A = [1, 2, 2, 3, 3]
Input 2:

A = [3, 2, 1, 2, 5, 6]


Example Output
Output 1:

4
Output 2:

3


Example Explanation
Explanation 1:

The most frequent elements are 2 and 3. The smallest subarray that contains all occurrences of the most frequent elements are [2, 2, 3, 3].

Explanation 2:

The most frequent element is 2. The smallest subarray that contains all occurrences of the most frequent element is [2, 1, 2].

public class Solution {
public int solve(int[] A) {
int left=0,right=0;
Map<Integer,Integer> map = new HashMap<>();
for(int i: A){
map.put(i,map.getOrDefault(i,0)+1);
}
int max = (int)(map.values().stream().max(Comparator.naturalOrder()));
for(int i=0;i<A.length;i++){
if(map.get(i)==max){
left =i;
break;
}
}
for(int j=A.length-1;j>=0;j--){
if(map.get(j)==max){
right =j;
break;
}
}
return j-i+1;
}
}