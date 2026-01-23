package concurrency.assignment.two;

public class Node {
    int data;
    Node right;
    Node left;
    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node right,Node left){
        this.data = data;
        this.right = right;
        this.left = left;
    }
}
