class StringInternExample {
    public void internMethods(){
        String s = new String("Hello World!");
        s.intern();
        String s1 = "Hello World!";
        System.out.println("S  : "+s);
        System.out.println("S1 : "+s1);
        System.out.println(s==s1);

    }
    public void internMethods1(){
        String s = "Hello World!";
        s.intern();
        String s1 = new String("Hello World!"); //explicitly asking to allocate object in heap , so s and s1 are different, interning doesnt work here


        System.out.println("S in literal pool : "+s);
        System.out.println("S1 obj in heap    : "+s1);
        System.out.println(s==s1);

    }
    public void internMethods2(){
        String s = "Hello World!";
        s.intern();
        String s1 = "Hello World!"; //explicitly asking to allocate object in heap , so s and s1 are different, interning doesnt work here


        System.out.println("S in literal pool           : "+s);
        System.out.println("S1 also in literal pool     : "+s1);
        System.out.println(s==s1);
        s1 = s1+" lets see what happens in memory now";
        System.out.println("S in literal pool           : "+s);
        System.out.println("S1 also in literal pool     : "+s1);
        System.out.println(s==s1);

    }
    public void internMethods3(){
        String s = new String("Hello World!");
        s.intern();
        String s1 = "Hello World!"; //explicitly asking to allocate object in heap , so s and s1 are different, interning doesnt work here


        System.out.println("S in literal pool           : "+s);
        System.out.println("S1 also in literal pool     : "+s1);
        System.out.println(s==s1);
    }
    public void internMethods4(){
        String s = "Hello World!";
//        s.intern();
        String s1 = "Hello World!"; //explicitly asking to allocate object in heap , so s and s1 are different, interning doesnt work here


        System.out.println("S in literal pool           : "+s);
        System.out.println("S1 also in literal pool     : "+s1);
        System.out.println(s==s1);
        s1 = s1+" lets see what happens in memory now";
        System.out.println("S in literal pool           : "+s);
        System.out.println("S1 also in literal pool     : "+s1);
        System.out.println(s==s1);

    }
    public static void main(String args[]) {
        StringInternExample s = new StringInternExample();
        s.internMethods();
        s.internMethods1();
        s.internMethods2();
        s.internMethods3();
        s.internMethods4();
    }
}
