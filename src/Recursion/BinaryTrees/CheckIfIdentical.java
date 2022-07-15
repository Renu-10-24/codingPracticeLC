package Recursion.BinaryTrees;


public class CheckIfIdentical {
    public static void main(String args[]){
        Identical i = new Identical();
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(20);
        root1.right = new TreeNode(30);
        root1.left.left = new TreeNode(40);
        root1.left.right = new TreeNode(50);
        root1.right.left = new TreeNode(60);
        root1.right.right = new TreeNode(70);
        TreeNode root2 = null;
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(20);
//        root2.right = new TreeNode(30);
//        root2.left.left = new TreeNode(40);
//        root2.left.right = new TreeNode(50);
//        root2.right.left = new TreeNode(60);
//        root2.right.right = new TreeNode(70);
        boolean x = i.solve(root1,root2);
        System.out.println(x);
    }
}
class Identical{
    public boolean solve(TreeNode A, TreeNode B){
        //do preorder and tell if the binary trees are identical
        boolean isIdentical = true;
        if(A==null && B == null){
            return true;// A is root TreeNode
        }else if(A == null && B != null){
            return false;
        }else if(A != null && B == null){
            return false;
        }
        if(A.val != B.val){
            isIdentical = false;
            return isIdentical;
        }
        solve(A.left,B.left);
        solve(A.right,B.right);
        return isIdentical;
    }
}