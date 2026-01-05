package OOPs;

public class Main {
    int data;
    Main next;
    Main(int x){
        this.data = x;
        this.next = null;
    }
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        Main head = new Main(1);
        Main tail = new Main(2);
        head.next = tail;

        //Adding a new element in list of 2 above
        Main temp2;
        temp2 = new Main(3);
        tail.next = temp2;
        tail = temp2;

        //Adding another element:
        addElement(4,tail);

        //Adding another element: (Checking if tail is updated in function)
        addElement(5,tail);

        //Ans: It is not which is as expected. Proof below where tail remains at 3 and add function of 4 and 5 has not updated tail:
        System.out.println("Current tail.d value: "+tail.data);

        Main ob1 = new Main(5);
        int len1 = ob1.getLength(head);
        System.out.println("Len 1 = "+len1);
        Main object = new Main(45);
        head = object;
        int len2 = ob1.getLength(head);
        System.out.println("Len 2 = "+len2);
    }
    static void addElement(int x, Main tail){
        Main temp2;
        temp2 = new Main(x);
        tail.next = temp2;
        tail = temp2;
    }
    int getLength(Main head){
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }

}