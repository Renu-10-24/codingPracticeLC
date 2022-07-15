package Recursion.BinaryTrees;
import java.util.List;
import java.util.ArrayList;
public class PathToGivenNode {
    public static void main(String args[]){
        Solution s = new Solution();

        TreeNode rootNode = new TreeNode(32);
        rootNode.left = new TreeNode(25);
        rootNode.right = new TreeNode(46);
        rootNode.left.left = new TreeNode(17);
        rootNode.left.right = new TreeNode(27);
        rootNode.left.right.left = new TreeNode(46);
        rootNode.left.right.left.left = new TreeNode(7);
        rootNode.left.right.left.right = new TreeNode(16);
        rootNode.right.left = new TreeNode(40);
        rootNode.right.left.left = new TreeNode(13);
        rootNode.right.left.right = new TreeNode(15);
        rootNode.right.left.right.left = new TreeNode(90);
        rootNode.right.left.right.right = new TreeNode(100);
        rootNode.right.right = new TreeNode(49);
        rootNode.right.right.left = new TreeNode(6);
        rootNode.right.right.right = new TreeNode(7);
        rootNode.left.left.left = new TreeNode(9);
        rootNode.left.left.left.left = new TreeNode(14);
        rootNode.left.left.left.right = new TreeNode(5);

        int[] x= s.solve(rootNode,15);
        for(int i: x) {
            System.out.println(i);
        }
        x= s.solve(rootNode,100);
        for(int i: x) {
            System.out.println(i);
        }
    }
}
class Solution {
    List<Integer> pathList = new ArrayList<>();
    List<Integer> pathList1 = null;
    List<Integer> pathList2 = null;
    public int[] solve(TreeNode A, int B) {
        boolean x = isPath(A,B,pathList);
        int output[] = new int[pathList.size()];
        for(int i=0;i<pathList.size();i++){
            output[i]=pathList.get(i);
        }
        return output;
    }

    public boolean isPath(TreeNode A, int B, List<Integer> pathList){
        //since its given that B is always present in tree A and path always exists,A initially cannot be null
        if(A==null){
          return false;
        }
        pathList.add(A.val);
        if(A.val!=B){
            if(isPath(A.left,B,pathList) || isPath(A.right,B,pathList)){
                return true;
            }
            pathList.remove(pathList.size()-1);
        }else {
            return true;
        }
        return false;
    }
}