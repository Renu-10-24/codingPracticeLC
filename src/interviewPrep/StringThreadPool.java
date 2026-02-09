package interviewPrep;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class StringThreadPool implements Callable<String> {
    private static final String MASK_CHAR = "9";
    private static final int MASK_LENGTH = 5;
    ExecutorService executorService;
    String s;

    public StringThreadPool(String string, ExecutorService executorService) {
        this.executorService = executorService;
        this.s = string;
    }

    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        String mask = MASK_CHAR.repeat(MASK_LENGTH);
//
//        if(s.length()<16){
//            return s;
//        }
//        s.substring(s.length()-5);
//        s=s.substring(0, s.length()-5) + "99999";
//        System.out.println("thread name : "+name +" " +s);
//        return s;

        //implement using java streams
        StringBuilder sb = new StringBuilder();
        try {
            Optional<StringBuilder> optionalString = Optional.ofNullable(new StringBuilder(s.substring(0, s.length() - MASK_LENGTH)));
            //.orElseThrow(Exception::new);
            sb = optionalString.orElseThrow(() -> new RuntimeException("Invalid Input")).append(mask);

            //if you dont want to pass String to RuntimeException in constructor, we can do it the functional style
            return Optional.ofNullable(new StringBuilder(s.substring(0, s.length() - MASK_LENGTH))).orElseThrow(() -> new RuntimeException("Invalid Input")).append(mask).toString();


        } catch (Exception e) {
            e.getCause();
        }
        return null;
    }


    // This calls the Exception(String message) constructor automatically
    public void validate(String input) {
        String str = Optional.ofNullable(input)
                .filter(strA -> !strA.isBlank())
                .orElseThrow(() -> new RuntimeException("Invalid input"));
        System.out.println(str);//orElseThrow supplies an Exception - a RuntimeException in this case

        //alternate way of using functional way of writing a simple if else throw logic
        if(!input.isBlank()){
            String s = Optional.ofNullable(input).get();
            System.out.println(s);
        }else{
            throw new RuntimeException("Invalid Input");
        }
    }
}
