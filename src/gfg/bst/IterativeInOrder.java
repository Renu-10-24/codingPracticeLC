package gfg.bst;

import java.util.ArrayList;
import java.util.List;



public class IterativeInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<Integer>();
        TreeNode currParent = root,currLeft=null,currRight=null;
        if(root==null) {
        	return null;
        }else {
        currLeft = currParent.left;
        currRight =currParent.right;
        }
        while(currLeft.left !=null) {
        	currParent = currLeft;
        	currLeft = currLeft.left;
        }
//        inorderList.add(currLeft.val);
        inorderList.add(currLeft .val);
        
        while(currRight !=null) {
        	currParent = currRight;
        	currRight = currRight.right;
        }
        return null;
    }
}