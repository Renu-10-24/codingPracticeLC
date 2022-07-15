package scaler.contest.intermediate;

public class BST {
    public static void main(String args[]){
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(5);



    }
    public int isValidBST(TreeNode A){

        return 0;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}