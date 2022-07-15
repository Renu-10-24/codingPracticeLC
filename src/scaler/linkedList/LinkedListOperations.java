package scaler.linkedList;

import java.util.Scanner;

public class LinkedListOperations {
    public static Node head_linkedList = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node newNode = new Node(value);
        if (head_linkedList == null || position == 1) {
            head_linkedList = newNode;
        } else {
            int i = 1;
            Node currNode = head_linkedList;
            while (i < position - 1 && currNode !=null) {
                currNode = currNode.next;
                i++;
            }
            if(currNode!=null) {
                newNode.next = currNode.next;
                currNode.next = newNode;
            }else{
                System.out.println("NULL HERE .................");
            }
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        int i = 1;
        if (position >= 1 && position<= head_linkedList.size()) {


            Node currNode = head_linkedList;
            if (position == 1) {
                head_linkedList = currNode.next;
            } else {
                while (i < position - 1 && currNode != null) {
                    currNode = currNode.next;
                    i++;
                }
                if (currNode != null) {
                    if (currNode.next != null) {
                        currNode.next = currNode.next.next;
                    } else {
                        currNode.next = null;
                    }
                }
            }
            System.out.println("Deleted node at position : "+position);
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        System.out.println("Printing list here : "+ head_linkedList.size()+ " ..... ");
        Node currNode = head_linkedList;
        int i=0;
        while (currNode != null) {
            System.out.printf("%3d  ", currNode.value);
            currNode = currNode.next;
            i++;
            if(i%10==0){
                System.out.println("....................");
            }
        }
        System.out.println("....................");
    }

    static class Node {
        int value;
        Node next;
        int size;
        public int size(){
            Node temp = this;
            int i=0;
            while(temp!=null){
                temp = temp.next;
                i++;
            }
            return i;
        }
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        int T = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            //no of testcases.
            T = scanner.nextInt();
            for (int i = 0; i <=T; i++) {
                char c = scanner.next().charAt(0);
                if (c == 'i') {
                    int position = Integer.parseInt(scanner.next());
                    int value = Integer.parseInt(scanner.next());
                    insert_node(position, value);
                } else if (c == 'p') {
                    print_ll();
                } else if (c == 'd') {
                    int position = Integer.parseInt(scanner.next());
                    delete_node(position);
                }
            }
        }
    }
}

