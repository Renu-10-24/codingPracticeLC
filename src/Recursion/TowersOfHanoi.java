package Recursion;

public class TowersOfHanoi {
    public static void main(String args[]){
        Soln s = new Soln();
        s.towersOfHanoi(3,1,2);
    }
}
class Soln{
    public void printMove(int n, int start, int end){
        System.out.println("Moving Disk "+n+ " from "+ start +"-->"+end);
    }
    public void towersOfHanoi(int n , int start, int end){
        if(n==1){
            printMove(1,1,2);
        }else{
            int other = 6-(start+end);
            towersOfHanoi(n-1,start,other);
            printMove(n,start,end);
            towersOfHanoi(n-1,other,end);
        }
    }
}
