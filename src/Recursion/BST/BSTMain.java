package Recursion.BST;

public class BSTMain{
    public static void main(String args[]){
        BST bst = new BST();
        int target = 100;
        int  count=0;
//        TreeNode root = new TreeNode(20);
//        root.left = new TreeNode(10);
//        root.right = new TreeNode(30);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(15);
//        root.right.left = new TreeNode(25);
//        root.right.right = new TreeNode(35);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(9);
//        root.left.right.left = new TreeNode(12);
//        root.left.right.right = new TreeNode(17);
//        root.right.right.left = new TreeNode(32);
//        root.right.right.right = new TreeNode(40);
//        root.right.right.right.left = new TreeNode(42);
//        root.right.right.right.right = new TreeNode(49);
//        boolean x= bst.searchFor(root,target);
//        System.out.println(x);
//        count= bst.countNodesWithinRange(root,0,100);
//        System.out.println("count of node : "+count);
//        count= bst.countNodesWithinRange(root,30,100);
//        System.out.println("count of node : "+count);
//        count= bst.countNodesWithinRange(root,10,45);
//        System.out.println("count of node : "+count);
        TreeNode rootNode = new TreeNode(32);
        rootNode.left = new TreeNode(25);
        rootNode.right = new TreeNode(46);
        rootNode.left.left = new TreeNode(17);
        rootNode.left.right = new TreeNode(27);
        rootNode.right.left = new TreeNode(40);
        rootNode.right.right = new TreeNode(49);
        rootNode.left.left.left = new TreeNode(9);
        rootNode.left.left.left.right = new TreeNode(15);
        rootNode.left.left.left.left = new TreeNode(14);
//
//        count= bst.countNodesWithinRange(rootNode,11,26);
        int height = bst.height(rootNode);
        System.out.println("height : "+height);
    }
}
// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    boolean visited = false;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
        this.visited = false;
    }
}
//search in BST
class BST{
    int height = 0;
    public boolean searchFor(TreeNode root, int target){
        boolean isFound = false;
        if(target==root.val){
            isFound = true;
            return isFound;
        }
        if(target<=root.val){
            searchFor(root.left,target);
        }else{
            searchFor(root.right,target);
        }
        return false;
    }
//    count number of nodes within a given range.. [start,end]
int count = 0;
int x=0,y=0;
public int countNodesWithinRange(TreeNode root, int start,int end){
    if(root == null){
        return 0;
    }
    if(root.val>=start && root.val<=end){
        count +=1;
        x = countNodesWithinRange(root.left,start,end);
        y = countNodesWithinRange(root.right,start,end);
    }
    if(root.val<start) {
        y = countNodesWithinRange(root.right, start, end);
    }
    if(root.val>start && root.val>end){
        x = countNodesWithinRange(root.left,start,end);
    }
    return count;
}


public int height(TreeNode root){
    if(root==null) {
        return 0;
    }
        int x=height(root.left);
        int y=height(root.right);
        if(x>y){
            return x+1;
        }else{
            return y+1;
        }
    }



}
