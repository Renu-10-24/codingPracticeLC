package Recursion.BinaryTrees;

import com.sun.source.tree.Tree;

public class CountNodesGTAllAncestors {
    public static void main(String args[]){
        Sol1 sol1 = new Sol1();
        int x=0;
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
        rootNode.left.left.left.right = new TreeNode(15);
        x= sol1.solve(rootNode);
        System.out.println(x);
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
//
//        x= sol1.solve(root);
//        System.out.println(x);
    }
}
class Sol1 {
    int countNodes=0;

    public int solve(TreeNode A) {
        int count = countNodesGTAllAncestors(A,Integer.MIN_VALUE);
        return count;
    }
    public int countNodesGTAllAncestors(TreeNode A, int maxEle){
        if(A==null){
            return maxEle;
        }
        if(A.val>maxEle){
            maxEle = A.val;
            countNodes++;
        }
        countNodesGTAllAncestors(A.right,maxEle);
        countNodesGTAllAncestors(A.left,maxEle);
        return countNodes;
    }
}