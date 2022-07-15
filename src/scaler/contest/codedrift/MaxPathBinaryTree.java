package scaler.contest.codedrift;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val =x;
        this.left = null;
        this.right = null;
    }
}
//calculate sum recursively..


public class MaxPathBinaryTree {
    public static void main(String args[]){
        MaxPathBinaryTree mPath = new MaxPathBinaryTree();
        System.out.println(mPath.sum(10));
        //form the tree
//              1
//            /   \
//           2     3

        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_1 = new TreeNode(1);
        node_1.left=node_2;
        node_1.right=node_3;
        int x=mPath.maxPathSum(node_1);
        System.out.println(x);
    }
    public int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode node) {
        TreeNode root = node;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if(root.val+max > max){
                max += root.val;
            }
            return max;
        }
        if (root.left != null) {
            int x = maxPathSum(root.left);
            return Math.max(x, x+root.val);
        }
        if (root.right != null) {
            int y = maxPathSum(root.right);
            return Math.max(y, y+root.val);
        }
        return 0;
    }
    }

