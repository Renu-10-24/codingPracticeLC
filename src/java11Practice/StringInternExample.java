class StringInternExample {
    public void internMethods(){
        String s = new String("Hello World!");
        s.intern();
        String s1 = "Hello World!";
        System.out.println(s==s1);

    }
    public static void main() {
        StringInternExample s = new StringInternExample();
        s.internMethods();
    }
}
