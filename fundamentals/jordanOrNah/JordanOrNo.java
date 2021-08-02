

public class JordanOrNo {
    //create a method that accepts a number an an input, and if the number is divisible by 2, it will say "Call me number 2", if its divisible by 3, it will say "Three is for Three ingredients in robs smoothie", if its divisible by BOTH 2 AND 3, it will say "both two and three? thats like 23, thats jordan! Hes not retiring no more", and for everything else, just output the number
    

    public static void jordanCalculator(int someNum){
        if(someNum % 2 == 0 && someNum % 3 == 0){
            System.out.println("both two and three? thats like 23, thats jordan! Hes not retiring no more");
        }else if(someNum % 2== 0){
            System.out.println("Call me number 2");
        }else if(someNum % 3== 0){
            System.out.println("Three is for Three ingredients in robs smoothie");
        }else{
            System.out.println(someNum);
        }
    }

    //method overloading
    public static void jordanCalculator(int someNum, String result1Msg, String result2Msg, String result3Msg){
        if(someNum % 2 == 0 && someNum % 3 == 0){
            System.out.println(result1Msg);
        }else if(someNum % 2== 0){
            System.out.println(result2Msg);
        }else if(someNum % 3== 0){
            System.out.println(result3Msg);
        }else{
            System.out.println(someNum);
        }
    }
    
}
