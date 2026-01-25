
public class EnumDemo {
    enum Status{
        Running, Failed, Pending, Completed;
    }
    enum Laptop{
        MacBook(2000), XPS(2200), Surface, ThinkPad(1800);
        private int price;

        Laptop() {
            price = 900;
        }

        Laptop(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }


    }
    static void main() {
        Status s = Status.Running;
        System.out.println(s.ordinal());
        switch(s){
            case Running :
                System.out.println("All Good !");
                break;
            case Failed :
                System.out.println("Failed this time, try again !");
                break;
            case Pending:
                System.out.println("Pending arrival !");
                break;
            case Completed:
                System.out.println("Completed the Onboarding, welcome !");
            default:
                System.out.println("All the Best !");

        }

        for(Laptop laptop: Laptop.values()){
            System.out.println(laptop.getPrice());
            if(laptop.name().equals("MacBook")) {
                laptop.setPrice(500);
            }
            System.out.println(laptop.getPrice());
        }
    }
}
