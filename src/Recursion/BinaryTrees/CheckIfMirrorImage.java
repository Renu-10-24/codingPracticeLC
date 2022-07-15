package Recursion.BinaryTrees;

public class CheckIfMirrorImage {
    public static void main(String args[]){
        Mirror mirror = new Mirror();
        boolean x = false;
        int y = 0;
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);
//        TreeNode root2 = null;
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(14);
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(20);
//        root2.right = new TreeNode(30);
//        root2.left.left = new TreeNode(40);
//        root2.left.right = new TreeNode(50);
//        root2.right.left = new TreeNode(60);
//        root2.right.right = new TreeNode(70);
        x = mirror.solve(root1,root2);
        System.out.println(x);
        TreeNode rootIsSym = new TreeNode(1);
        rootIsSym.left = new TreeNode(2);
        rootIsSym.right = new TreeNode(2);
        rootIsSym.left.left = new TreeNode(4);
        rootIsSym.left.right = new TreeNode(4);
        rootIsSym.right.right = new TreeNode(6);
        x = mirror.solveIfTreeIsSymmetric(rootIsSym);
        System.out.println(x);
        TreeNode rootIsSym1 = new TreeNode(1);
        rootIsSym1.left = new TreeNode(2);
        rootIsSym1.right = new TreeNode(2);
        rootIsSym1.left.left = new TreeNode(4);
        rootIsSym1.left.right = new TreeNode(4);
        rootIsSym1.right.right = new TreeNode(6);
        y= mirror.isSymmetric(rootIsSym1);
    }
}
class Mirror{
    public boolean solve(TreeNode root1, TreeNode root2){
        //do preorder and tell if the binary trees are identical
        boolean isSymmetric = true;
        if(root1==null && root2 == null){
            return true;// A is root TreeNode
        }else if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            isSymmetric = false;
            return isSymmetric;
        }
        solve(root1.left,root2.right);
        solve(root1.right,root2.left);

        return isSymmetric;
    }
    //check if a binary tree is symmetric
    public boolean solveIfTreeIsSymmetric(TreeNode root){
        //do preorder and tell if the binary trees are identical
        boolean isSymmetric = true;
        if(root==null){
            return true;// A is root TreeNode
        }
        if((root.left != null &&  root.right==null) || (root.left == null &&  root.right!=null)){
            isSymmetric = false;
            return isSymmetric;
        }
        if(root.left != null &&  root.right != null) {
            if (root.left.val != root.right.val) {
                return false;
            } else {
                boolean x = solveIfTreeIsSymmetric(root.left);
                boolean y=false;
                if(x){
                    y= solveIfTreeIsSymmetric(root.right);
                }
                return x&y;
            }
        }
        return isSymmetric;
    }
    public int isSymmetric(TreeNode A) {
        //do preorder and tell if the binary tree is symmetric around center, i.e., root A
        int isSymmetric = 0;
        if(A==null){
            return 1;// A is root TreeNode
        }
        if((A.left != null &&  A.right==null) || (A.left == null &&  A.right!=null)){
            isSymmetric = 0;
            return isSymmetric;
        }
        if(A.left != null &&  A.right != null) {
            if (A.left.val != A.right.val) {
                return 0;
            } else {
                int x = isSymmetric(A.left);
                int y = isSymmetric(A.right);
                return x&y;
            }
        }
        return isSymmetric;
    }
}