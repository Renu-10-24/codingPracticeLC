package Recursion.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    public static void main(String args[]) {
        SolInorder s = new SolInorder();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        int x[]=s.inOrderTraversal(root);
        System.out.println("Inorder Traversal: ");
        for(int i : x){
            System.out.println(i);
        }
        //preorder traversal
        x=s.preOrderTraversal(root);
        System.out.println("Preorder Traversal: ");
        for(int i : x){
            System.out.println(i);
        }
        //postorder traversal
        x=s.postOrderTraversal(root);
        System.out.println("Postorder Traversal: ");
        for(int i : x){
            System.out.println(i);
        }
    }
}

//// Definition for binary tree
//  class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) {
//       val = x;
//       left=null;
//       right=null;
//      }
//  }
class SolInorder {
    int[] traversalArr;
    List<Integer> inOrderList = new ArrayList<Integer>();
    List<Integer> preOrderList = new ArrayList<Integer>();
    List<Integer> postOrderList = new ArrayList<Integer>();
    int i=0;
    public void inOrder(TreeNode A ){
        if(A==null){
            return ;// A is root of binary tree. Type : TreeNode
        }
        if (A != null) {
            inOrder(A.left);
            inOrderList.add(A.val);
            inOrder(A.right);
        }
    }
    public void preOrder(TreeNode A ){
        if(A==null){
            return;// A is root
        }
        if (A != null) {
            preOrderList.add(A.val);
            preOrder(A.left);
            preOrder(A.right);
        }
    }
    public void postOrder(TreeNode A ){
        if(A==null){
            return;// A is root
        }
        if (A != null) {
            postOrderList.add(A.val);
            postOrder(A.left);
            postOrder(A.right);
        }
    }
    public int[] inOrderTraversal(TreeNode A) {
        inOrder(A);
        traversalArr = new int[inOrderList.size()];
        for (;i< inOrderList.size();i++) {
            traversalArr[i] = inOrderList.get(i);
        }
        return traversalArr;
    }
    public int[] preOrderTraversal(TreeNode A) {
        preOrder(A);
        traversalArr = new int[preOrderList.size()];
        for (;i< preOrderList.size();i++) {
            traversalArr[i] = preOrderList.get(i);
        }
        return traversalArr;
    }
    public int[] postOrderTraversal(TreeNode A) {
        postOrder(A);
        traversalArr = new int[postOrderList.size()];
        for (;i< postOrderList.size();i++) {
            traversalArr[i] = postOrderList.get(i);
        }
        return traversalArr;
    }
}
